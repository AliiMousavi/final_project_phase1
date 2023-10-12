package entity.Services;

import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "SubServices")
public class SubService extends BaseEntity<Long> {
    String name;
    @ManyToOne
    Service service;
    int basePrice;
    String caption;
}
