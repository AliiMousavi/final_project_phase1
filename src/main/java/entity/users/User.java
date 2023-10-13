package entity.users;

import base.entity.BaseEntity;
import lombok.*;
import util.PasswordGenerator;
import util.Validator;

import javax.persistence.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "Users")
public abstract class User extends BaseEntity<Long> {
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
    int credit;

    public User(String firstName, String lastName, String email, byte[] image) throws IOException {
        this.firstName = firstName;
        this.lastName = lastName;
        if (Validator.isValidEmail(email))
            this.email = email;
        else
            throw new RuntimeException("email is not valid!");
        this.password = PasswordGenerator.generatePassword();
        this.dateOfRegistration = Date.valueOf(LocalDate.now());
        this.credit = 0;

        if (Validator.isValidImage(convertByteArrayToFile(image)))
            this.image = image;

    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (Validator.isValidEmail(email))
            this.email = email;
        else
            throw new RuntimeException("email is not valid!");
        this.password = PasswordGenerator.generatePassword();
        this.dateOfRegistration = Date.valueOf(LocalDate.now());
        this.credit = 0;
    }

    private static File convertByteArrayToFile(byte[] byteArray) throws IOException {
        File file = new File("\\Desktop");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(byteArray);
        fos.close();
        return file;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
