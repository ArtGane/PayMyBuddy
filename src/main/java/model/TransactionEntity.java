package model;

import com.sun.istack.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="tb_transaction")
@Data
@NoArgsConstructor
public class TransactionEntity extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double amount;
    private TransactionType transactionType;
    @ManyToOne
    private UserEntity user;
    @Nullable
    @ManyToOne
    private UserEntity friend;

}
