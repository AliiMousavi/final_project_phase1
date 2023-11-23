package entity;

import base.entity.BaseEntity;
import entity.users.Expert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "offers")
public class Offer extends BaseEntity<Long> {
    Date DateOfTheOffer;
    int offeredprice;
    Date offeredDate;
    int Duration;
    @OneToOne(mappedBy = "offer")
    Order order;
    @OneToOne
    Expert expert;



}
