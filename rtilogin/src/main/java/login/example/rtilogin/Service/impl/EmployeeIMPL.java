package login.example.rtilogin.Service.impl;

import login.example.rtilogin.Dto.LoginResponseDTO;
import login.example.rtilogin.Dto.Logindto;
import login.example.rtilogin.Dto.EmployeeDTO;
import login.example.rtilogin.Entity.Employee;
import login.example.rtilogin.Repo.EmployeeRepo;
import login.example.rtilogin.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeIMPL implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getEmployeeId(),
                employeeDTO.getUcode(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),
                employeeDTO.getUsername(),
                this.passwordEncoder.encode(employeeDTO.getPassword()),
                employeeDTO.getStatus(),
                employeeDTO.getRole()


        );

        employeeRepo.save(employee);

        return employee.getUsername();
    }

    @Override
    public LoginResponseDTO loginEmployee(Logindto logindto) {
        Employee employee1 = employeeRepo.findByUsername(logindto.getUsername());
        if (employee1 != null) {
            String password = logindto.getPassword();
            String encodedpassword = employee1.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedpassword);
            if (isPwdRight) {
                String userStatus = evaluateUserStatus(employee1);

                return new LoginResponseDTO(
                        employee1.getUsername(),
                        employee1.getPassword(),   // Or null if you don’t want to expose hash
                        employee1.getRole(),
                        employee1.getUcode(),
                        userStatus
                );
            } else {
                return new LoginResponseDTO(
                        null, null, null, 0, "BlockPass"
                );
            }
        } else {
            return new LoginResponseDTO(
                    null, null, null, 0, "InValidUser"
            );
        }
    }

    // ✅ FIX: This is OUTSIDE the loginEmployee() method
    private String evaluateUserStatus(Employee employee) {
        if ("BLOCKED".equalsIgnoreCase(employee.getStatus())) {
            return "BlockUser";
        } else if ("TEMP_BLOCKED".equalsIgnoreCase(employee.getStatus())) {
            return "BlockPass";
        } else if ("RESET".equalsIgnoreCase(employee.getStatus())) {
            return "ChangePass";
        } else if ("ACTIVE".equalsIgnoreCase(employee.getStatus())) {
            return "Active";
        } else {
            return "InValidUser";
        }
    }
}
