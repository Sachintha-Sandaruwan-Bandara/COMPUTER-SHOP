package lk.ijse.computerShop.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    @author Sachi_S_Bandara
    @created 11/5/2023 - 2:01 PM 
*/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeTm {
    private String id;
    private String name;
    private String address;

    private String email;
    private String mobile;

    private String position;
}
