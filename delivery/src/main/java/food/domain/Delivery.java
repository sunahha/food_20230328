package food.domain;

import food.DeliveryApplication;
import food.domain.FoodDeliveriedConfirm;
import food.domain.FoodPicked;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Long address;

    private Long deliveryState;

    @PostPersist
    public void onPostPersist() {
        FoodDeliveriedConfirm foodDeliveriedConfirm = new FoodDeliveriedConfirm(
            this
        );
        foodDeliveriedConfirm.publishAfterCommit();

        FoodPicked foodPicked = new FoodPicked(this);
        foodPicked.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public static void receiveADelivery(CookStarted cookStarted) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        FoodPicked foodPicked = new FoodPicked(delivery);
        foodPicked.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            FoodPicked foodPicked = new FoodPicked(delivery);
            foodPicked.publishAfterCommit();

         });
        */

    }

    public static void receiveADelivery(OrderedMenu orderedMenu) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        FoodPicked foodPicked = new FoodPicked(delivery);
        foodPicked.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderedMenu.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            FoodPicked foodPicked = new FoodPicked(delivery);
            foodPicked.publishAfterCommit();

         });
        */

    }
}
