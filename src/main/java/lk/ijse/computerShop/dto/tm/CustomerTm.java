package lk.ijse.computerShop.dto.tm;
/* 
    @author Sachi_S_Bandara
    @created 11/3/2023 - 10:23 PM 
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerTm {
        private String id;
        private String name;
        private String address;

        private String email;
        private int mobile;


}
