package nic.rti.master.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardMetricsDTO {
    private int appealsPending10Days;
    private int newAppeals;
    private int appealUnderProcess;
    private int commentsFromPIO;

    private String publicAuthorityName;
    private String role;
    private String username;

    // blank constructor    // doesnt need any argu

    

}
