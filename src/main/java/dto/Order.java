package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    private Long itemId;
    private String itemName;
    private Double itemPrice;
    private Integer itemQuantity;
    private Double itemTotalPrice;
}
