package login.example.rtilogin.Service;

import login.example.rtilogin.Dto.LoginResponseDTO;
import login.example.rtilogin.Dto.Logindto;
import login.example.rtilogin.Dto.EmployeeDTO;
import login.example.rtilogin.PlayloadResponse.LoginMessage;
import org.springframework.stereotype.Service;
@Service

public interface EmployeeService {


    String addEmployee(EmployeeDTO employeeDTO);
    LoginResponseDTO loginEmployee(Logindto logindto);

}
