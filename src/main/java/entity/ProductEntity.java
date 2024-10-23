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
public class ProductEntity {
    @Id
    private String proId;
    private String proCategory;
    private String proName;
    private String proSize;
    private Integer proQuantity;
    private Double proPrice;
}
