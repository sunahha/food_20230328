package food.domain;

import food.OrderApplication;
import food.domain.CanceledMenu;
import food.domain.OrderedMenu;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerid;

    private String foodid;

    private String orderAcceptyn;

    private String deliveryState;

    private Long cookId;

    private String option;

    @PostPersist
    public void onPostPersist() {
        OrderedMenu orderedMenu = new OrderedMenu(this);
        orderedMenu.publishAfterCommit();

        CanceledMenu canceledMenu = new CanceledMenu(this);
        canceledMenu.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void selectMenu() {}

    public static void changeOrderInformation(AgreedOrder agreedOrder) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(agreedOrder.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void changeOrderInformation(DisagreedOrder disagreedOrder) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(disagreedOrder.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void changeOrderInformation(
        FoodDeliveriedConfirm foodDeliveriedConfirm
    ) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(foodDeliveriedConfirm.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void changeOrderInformation(CookStarted cookStarted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void changeOrderInformation(CookFinished cookFinished) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookFinished.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void changeOrderInformation(FoodPicked foodPicked) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(foodPicked.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
