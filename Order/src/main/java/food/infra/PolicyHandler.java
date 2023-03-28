package food.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.config.kafka.KafkaProcessor;
import food.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AgreedOrder'"
    )
    public void wheneverAgreedOrder_ChangeOrderInformation(
        @Payload AgreedOrder agreedOrder
    ) {
        AgreedOrder event = agreedOrder;
        System.out.println(
            "\n\n##### listener ChangeOrderInformation : " +
            agreedOrder +
            "\n\n"
        );

        // Sample Logic //
        Order.changeOrderInformation(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DisagreedOrder'"
    )
    public void wheneverDisagreedOrder_ChangeOrderInformation(
        @Payload DisagreedOrder disagreedOrder
    ) {
        DisagreedOrder event = disagreedOrder;
        System.out.println(
            "\n\n##### listener ChangeOrderInformation : " +
            disagreedOrder +
            "\n\n"
        );

        // Sample Logic //
        Order.changeOrderInformation(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FoodDeliveriedConfirm'"
    )
    public void wheneverFoodDeliveriedConfirm_ChangeOrderInformation(
        @Payload FoodDeliveriedConfirm foodDeliveriedConfirm
    ) {
        FoodDeliveriedConfirm event = foodDeliveriedConfirm;
        System.out.println(
            "\n\n##### listener ChangeOrderInformation : " +
            foodDeliveriedConfirm +
            "\n\n"
        );

        // Sample Logic //
        Order.changeOrderInformation(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_ChangeOrderInformation(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener ChangeOrderInformation : " +
            cookStarted +
            "\n\n"
        );

        // Sample Logic //
        Order.changeOrderInformation(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookFinished'"
    )
    public void wheneverCookFinished_ChangeOrderInformation(
        @Payload CookFinished cookFinished
    ) {
        CookFinished event = cookFinished;
        System.out.println(
            "\n\n##### listener ChangeOrderInformation : " +
            cookFinished +
            "\n\n"
        );

        // Sample Logic //
        Order.changeOrderInformation(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FoodPicked'"
    )
    public void wheneverFoodPicked_ChangeOrderInformation(
        @Payload FoodPicked foodPicked
    ) {
        FoodPicked event = foodPicked;
        System.out.println(
            "\n\n##### listener ChangeOrderInformation : " + foodPicked + "\n\n"
        );

        // Sample Logic //
        Order.changeOrderInformation(event);
    }
}
