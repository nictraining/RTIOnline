package nic.rti.master.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String username;
    private String role;
    private String login_active;
    private int ucode;
    private String message;

}
