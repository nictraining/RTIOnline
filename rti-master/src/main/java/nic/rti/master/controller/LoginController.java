package nic.rti.master.controller;

import nic.rti.master.dto.LoginDTO;
import nic.rti.master.dto.LoginResponseDTO;
import nic.rti.master.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rti-faa")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}
