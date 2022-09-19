package model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class AccountEntity extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @Length(max = 10, min = 10)
    private String accountNumber;
    private double balance;

}
