package food.domain;

import food.CookingApplication;
import food.domain.AgreedOrder;
import food.domain.CookFinished;
import food.domain.CookStarted;
import food.domain.DisagreedOrder;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cook_table")
@Data
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String foodid;

    private String orderId;

    private String foodstate;

    @PostPersist
    public void onPostPersist() {
        AgreedOrder agreedOrder = new AgreedOrder(this);
        agreedOrder.publishAfterCommit();

        DisagreedOrder disagreedOrder = new DisagreedOrder(this);
        disagreedOrder.publishAfterCommit();

        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();

        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
    }

    public static CookRepository repository() {
        CookRepository cookRepository = CookingApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    public void acceptOrReject() {}

    public void start() {}

    public static void receiveAOrder(OrderedMenu orderedMenu) {
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        AgreedOrder agreedOrder = new AgreedOrder(cook);
        agreedOrder.publishAfterCommit();
        DisagreedOrder disagreedOrder = new DisagreedOrder(cook);
        disagreedOrder.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderedMenu.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);

            AgreedOrder agreedOrder = new AgreedOrder(cook);
            agreedOrder.publishAfterCommit();
            DisagreedOrder disagreedOrder = new DisagreedOrder(cook);
            disagreedOrder.publishAfterCommit();

         });
        */

    }

    public static void receiveAOrder(CanceledMenu canceledMenu) {
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        AgreedOrder agreedOrder = new AgreedOrder(cook);
        agreedOrder.publishAfterCommit();
        DisagreedOrder disagreedOrder = new DisagreedOrder(cook);
        disagreedOrder.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(canceledMenu.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);

            AgreedOrder agreedOrder = new AgreedOrder(cook);
            agreedOrder.publishAfterCommit();
            DisagreedOrder disagreedOrder = new DisagreedOrder(cook);
            disagreedOrder.publishAfterCommit();

         });
        */

    }
}
