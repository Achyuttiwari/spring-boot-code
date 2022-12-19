package com.springBootCode.springbootcode.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data                   //@Data annotation is going to add getter,setter,hash code and toString for us.
//You can also use @Getter @Setter @ToString annotation individually if you want.

@NoArgsConstructor      //This annotation is for default constructor or args Constructor.
@AllArgsConstructor     //From this all argument of Constructor created
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // From this departmentId will auto generated and unique.(which become Primary Key)
    private long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentEmployeeCode;

}
