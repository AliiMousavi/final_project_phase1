package entity.users;

import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Users")
public abstract class User extends BaseEntity<Long>{
    String firstName;
    String lastName;
    @Column(unique = true)
    String email;
    @Column(length = 8)
    String password;
    Date dateOfRegistration;
    @Lob
    @Column(name = "image")
    private byte[] image;
}
