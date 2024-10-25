package entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supId;
    private String supName;
    private String supTitle;
    private String supCompany;
    private String supEmail;
    private String supItem;
    private String supContact;
    private String supAddress;
}
