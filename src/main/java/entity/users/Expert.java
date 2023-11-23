package entity.users;

import entity.Comment;
import entity.Services.SubServiceCollection;
import entity.enums.ExpertStatus;
import lombok.*;

import javax.persistence.*;
import java.io.IOException;
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

    public Expert(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        this.expertStatus = ExpertStatus.NEW;
    }

    public Expert(String firstName, String lastName, String email, byte[] image) throws IOException {
        super(firstName, lastName, email, image);
    }

    @Override
    public String toString() {
        return id + "." +
                firstName + " " + lastName + "\t" +expertStatus +
                '}';
    }
}
