package entity;

import base.entity.BaseEntity;
import entity.Services.SubServiceCollection;
import entity.enums.OrderStatus;
import entity.users.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders")
public class Order extends BaseEntity<Long> {
    int offerPrice;
    String workToDo;
    Date DateOfExecution;
    String address;
    OrderStatus orderStatus;
    @OneToOne
    Customer customer;
    @OneToOne
    SubServiceCollection subServiceCollection;
    @OneToOne
    Offer offer;

//    public Order(int offerPrice, String workToDo, Date dateOfExecution, String address, SubServiceCollection subServiceCollection) {
//        if (offerPrice > subServiceCollection.getBasePrice())
//            this.offerPrice = offerPrice;
//        else
//            throw new RuntimeException("offer PRice should bigger than basePrice");
//
//        this.workToDo = workToDo;
//        DateOfExecution = dateOfExecution;
//        this.address = address;
//        this.orderStatus = OrderStatus.WAITING_FOR_THE_SUGGESTION_OF_EXPERTS;
//        this.subServiceCollection = subServiceCollection;
//    }
}
