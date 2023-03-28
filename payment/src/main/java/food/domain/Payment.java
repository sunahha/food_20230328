package food.domain;

import food.PaymentApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    public static void payAOrder(OrderedMenu orderedMenu) {
        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderedMenu.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

    }

    public static void payAOrder(CanceledMenu canceledMenu) {
        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(canceledMenu.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

    }
}
