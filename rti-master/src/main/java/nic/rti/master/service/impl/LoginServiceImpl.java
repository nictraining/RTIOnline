package nic.rti.master.service.impl;

import nic.rti.master.dao.UserListRepository;
import nic.rti.master.dto.LoginDTO;
import nic.rti.master.dto.LoginResponseDTO;
import nic.rti.master.entity.UserList;
import nic.rti.master.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserListRepository userListRepository;

    @Override
    public LoginResponseDTO login(LoginDTO loginDTO) {
        LoginResponseDTO response = new LoginResponseDTO();
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        UserList user = userListRepository.findByUserName(username);
        System.out.println("user Fetched: "+user); // logging fetched user
        if (user == null) {
            response.setLogin_active("InValidUser");
            response.setMessage("User does not exist");
            return response;
        }

        if (!user.getPassword().equals(password)) {
            response.setLogin_active("InValidUser");
            response.setMessage("Invalid username or password");
            return response;
        }

        if (user.getFlage() == 1) {
            response.setLogin_active("BlockUser");
            response.setMessage("User is blocked");
            return response;
        }

        if ("N".equalsIgnoreCase(user.getActive_idle())) {
            response.setLogin_active("AlreadyActive");
            response.setMessage("User is already online");
            return response;
        }

        if ("Y".equalsIgnoreCase(user.getPassword_change())) {
            response.setLogin_active("ChangePass");
            response.setMessage("Password reset required");
            return response;
        }

        
        response.setLogin_active("Active");
        response.setMessage("Login Successful");
        response.setUsername(user.getUserName());
        response.setRole(user.getRole());
        response.setUcode(user.getUcode());
        return response;
    }
}
