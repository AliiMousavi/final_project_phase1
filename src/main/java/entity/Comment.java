package entity;

import base.entity.BaseEntity;
import entity.users.Expert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment extends BaseEntity<Long> {
    int score;
    String Comment;
    @ManyToOne
    Expert expert;

}
