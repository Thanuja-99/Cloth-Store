package dto;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {


    private String empId;
    private String empTitle;
    private String empName;
    private String empNic;
    private String empEmail;
    private LocalDate empBirthday;
    private String empContact;
    private String empAddress;



}
