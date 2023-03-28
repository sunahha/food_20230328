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
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_ReceiveADelivery(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener ReceiveADelivery : " + cookStarted + "\n\n"
        );

        // Sample Logic //
        Delivery.receiveADelivery(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderedMenu'"
    )
    public void wheneverOrderedMenu_ReceiveADelivery(
        @Payload OrderedMenu orderedMenu
    ) {
        OrderedMenu event = orderedMenu;
        System.out.println(
            "\n\n##### listener ReceiveADelivery : " + orderedMenu + "\n\n"
        );

        // Sample Logic //
        Delivery.receiveADelivery(event);
    }
}
