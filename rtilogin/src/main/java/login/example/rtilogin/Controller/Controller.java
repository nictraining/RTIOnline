package login.example.rtilogin.Controller;


import login.example.rtilogin.Dto.LoginResponseDTO;
import login.example.rtilogin.Dto.Logindto;
import login.example.rtilogin.Dto.EmployeeDTO;
import login.example.rtilogin.PlayloadResponse.LoginMessage;
import login.example.rtilogin.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
@CrossOrigin


public class Controller {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        String id= employeeService.addEmployee(employeeDTO);
        return id;
    }

  @PostMapping(path="/rti-nodal/login")
    public ResponseEntity<?> loginEmployee(@RequestBody Logindto logindto){
        LoginResponseDTO loginResponse= employeeService.loginEmployee(logindto);
        return ResponseEntity.ok(loginResponse);
  }








}
