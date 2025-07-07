package nic.rti.master.service;

import nic.rti.master.dto.LoginDTO;
import nic.rti.master.dto.LoginResponseDTO;

public interface LoginService {
    LoginResponseDTO login(LoginDTO loginDTO);
}
