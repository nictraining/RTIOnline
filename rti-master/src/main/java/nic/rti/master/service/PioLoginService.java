package nic.rti.master.service;


import nic.rti.master.dto.PioLoginRequest;
import nic.rti.master.dto.PioLoginResponse;
import nic.rti.master.entity.PioUser;
import nic.rti.master.repository.PioUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PioLoginService {

    @Autowired
    private PioUserRepository userRepository;

    public PioLoginResponse authenticate(PioLoginRequest loginRequest) {
        PioUser user = userRepository.findByUsername(loginRequest.getUsername()).orElse(null);

        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return new PioLoginResponse(loginRequest.getUsername(), "InValidUser", null, null);
        }

        if ("N".equalsIgnoreCase(user.getActiveIdle())) {
            return new PioLoginResponse(user.getUsername(), "AlreadyActive", user.getRole(), user.getUcode());
        }

        if ("BLOCKED".equalsIgnoreCase(user.getRole())) {
            return new PioLoginResponse(user.getUsername(), "BlockUser", user.getRole(), user.getUcode());
        }

        if ("TEMPBLOCK".equalsIgnoreCase(user.getRole())) {
            return new PioLoginResponse(user.getUsername(), "BlockPass", user.getRole(), user.getUcode());
        }

        if ("CHANGEPASS".equalsIgnoreCase(user.getRole())) {
            return new PioLoginResponse(user.getUsername(), "ChangePass", user.getRole(), user.getUcode());
        }

        return new PioLoginResponse(user.getUsername(), "Active", user.getRole(), user.getUcode());
    }
}
