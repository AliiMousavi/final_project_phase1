package entity.users;

import entity.enums.ExpertStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Expert extends User {
    ExpertStatus exportStatus;
}
