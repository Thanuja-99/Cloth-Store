package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Product {
    private String proId;
    private String proCategory;
    private String proName;
    private String proSize;
    private Integer proQuantity;
    private Double proPrice;
}
