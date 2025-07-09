package nic.rti.master.controller;

import nic.rti.master.dto.PioLoginRequest;
import nic.rti.master.dto.PioLoginResponse;
import nic.rti.master.service.PioLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rti-pio")
public class PioLoginController {

    @Autowired
    private PioLoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<PioLoginResponse> login(@RequestBody PioLoginRequest loginRequest) {
        PioLoginResponse response = loginService.authenticate(loginRequest);

        switch (response.getLogin_active()) {
            case "Active":
                return ResponseEntity.ok(response);
            case "AlreadyActive":
            case "ChangePass":
            case "BlockUser":
            case "BlockPass":
                return ResponseEntity.status(403).body(response);
            case "InValidUser":
                return ResponseEntity.status(401).body(response);
            default:
                return ResponseEntity.status(500).body(
                        new PioLoginResponse(loginRequest.getUsername(), "SystemError", null, null)
                );
        }
    }
}
