package entity.users;


import javax.persistence.Entity;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Admin extends User{
    private static Admin instance;

    protected Admin() {
        super();
    }

    public Admin(String firstName, String lastName, String email, String password, Date dateOfRegistration, byte[] image) {
        super(firstName, lastName, email, password, dateOfRegistration, image);
    }

    public static synchronized Admin getInstance() {
        if (instance == null) {
            instance = new Admin("Ali" , "Mousavi" , "AliMousavi1234@gmail.com" , "1234",Date.valueOf(LocalDate.now()),null);
        }
        return instance;
    }
}
