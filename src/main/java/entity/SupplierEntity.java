package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "supplier")
@Table(name ="supplier")
public class SupplierEntity {

    @Id
    private String supId;
    private String supName;
    private String supTitle;
    private String supCompany;
    private String supEmail;
    private String supItem;
    private String supContact;
    private String supAddress;
}
