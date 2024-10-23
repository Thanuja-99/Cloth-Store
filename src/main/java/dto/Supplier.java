package dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Supplier {
    private String supId;
    private String supName;
    private String supTitle;
    private String supCompany;
    private String supEmail;
    private String supItem;
    private String supContact;
    private String supAddress;
}
