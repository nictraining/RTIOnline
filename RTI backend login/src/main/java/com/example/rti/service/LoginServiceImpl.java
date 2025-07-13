package com.example.rti.service;

import com.example.rti.dto.LoginRequest;
import com.example.rti.dto.LoginResponse;
import com.example.rti.entity.LoginHistory;
import com.example.rti.entity.NetUser;
import com.example.rti.repository.LoginHistoryRepository;
import com.example.rti.repository.NetUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final NetUserRepository userRepo;
    private final LoginHistoryRepository historyRepo;

    public LoginServiceImpl(NetUserRepository userRepo,
                            LoginHistoryRepository historyRepo) {
        this.userRepo = userRepo;
        this.historyRepo = historyRepo;
    }

    @Override
    @Transactional
    public LoginResponse authenticate(LoginRequest req) {
        String u = req.getUsername();
        String p = req.getPassword();
        LocalDateTime now = LocalDateTime.now();

        Optional<NetUser> opt = userRepo.findByUserName(u);
        if (opt.isEmpty()) {
            return new LoginResponse("7", "InActive", null, null);
        }
        NetUser user = opt.get();

        // 6. Block check
        if (user.getLastUnSuccessfulLogin() != null &&
            user.getLastUnSuccessfulLogin().isAfter(now)) {
            return new LoginResponse("6", "BlockUser", null, null);
        }

        boolean matchPw = user.getMobile().equals(p);
        boolean active  = "Y".equalsIgnoreCase(user.getActiveIdle());
        String key      = user.getActivationKey();
        String keyConf  = user.getActivationKeyConf();

        // 1. Fully Active
        if (matchPw && active &&
            key != null && key.equals(keyConf) &&
            (user.getLastUnSuccessfulLogin() == null ||
             user.getLastUnSuccessfulLogin().isBefore(now))) {

            user.setLoginAttempts(0);
            user.setLastSuccessfulLogin(now);
            userRepo.save(user);

            LoginHistory h = new LoginHistory();
            h.setLoginDateTime(now);
            h.setIp(req.getIpAddress());
            h.setBrowser(req.getBrowser());
            h.setOs(req.getSystem());
            h.setPa(req.getSystem());
            h.setUCode(user.getUserCode());
            h.setUserName(u);
            historyRepo.save(h);

            return new LoginResponse("1", "Active",
                                     user.getUserCode(), user.getUserType());
        }

        // 2–4: Activation flows
        if (matchPw && !active && keyConf == null) {
            return new LoginResponse("2", "EnterKey", null, null);
        }
        if (matchPw && !active &&
            keyConf != null && !key.equals(keyConf)) {
            return new LoginResponse("3", "InActiveEnterKey", null, null);
        }
        if (matchPw && active &&
            keyConf != null && !key.equals(keyConf)) {
            return new LoginResponse("4", "ActiveEnterKey", null, null);
        }

        // 5: Invalid credentials
        int at = Optional.ofNullable(user.getLoginAttempts()).orElse(0) + 1;
        user.setLoginAttempts(at);
        if (at < 4) {
            user.setLastUnSuccessfulLogin(now);
            userRepo.save(user);
            return new LoginResponse("5", "InvalidPass", null, null);
        } else {
            user.setLastUnSuccessfulLogin(now.plusMinutes(30));
            userRepo.save(user);
            return new LoginResponse("5", "PassIsBlock", null, null);
        }
    }
}
