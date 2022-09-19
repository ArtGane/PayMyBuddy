package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_users")
@Data
@NoArgsConstructor
public class UserEntity extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Model creationDate;

    @Length(max = 100)
    private String lastname;

    @Length(max = 100)
    private String firstname;

    @Column(unique = true)
    private String mail;

    @Length(min = 8)
    private String password;

    @ManyToMany
    private List<UserEntity> friends = new ArrayList<>();

    @OneToOne
    private AccountEntity account;

}
