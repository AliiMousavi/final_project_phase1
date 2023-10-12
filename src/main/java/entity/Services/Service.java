package entity.Services;

import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Service extends BaseEntity<Long> {
    String name;
    @OneToMany(mappedBy = "service")
    List<SubService> subServices;
}
