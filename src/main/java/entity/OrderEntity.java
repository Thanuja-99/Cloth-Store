package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class OrderEntity {

    @Id
    private String itemId;
    private String itemName;
    private Double itemPrice;
    private Integer itemQuantity;
    private Double itemTotalPrice;
}
