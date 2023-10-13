package entity.users;

import entity.Comment;
import entity.Services.SubServiceCollection;
import entity.enums.ExpertStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class Expert extends User {
    ExpertStatus expertStatus;

    @ManyToMany(mappedBy = "Experts" , cascade = CascadeType.PERSIST)
    List<SubServiceCollection> subServiceCollections;

    @OneToMany(mappedBy = "expert")
    List<Comment> comments;

    @Override
    public String toString() {
        return "Expert{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    public Expert(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }
}
