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
    CookRepository cookRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderedMenu'"
    )
    public void wheneverOrderedMenu_ReceiveAOrder(
        @Payload OrderedMenu orderedMenu
    ) {
        OrderedMenu event = orderedMenu;
        System.out.println(
            "\n\n##### listener ReceiveAOrder : " + orderedMenu + "\n\n"
        );

        // Sample Logic //
        Cook.receiveAOrder(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CanceledMenu'"
    )
    public void wheneverCanceledMenu_ReceiveAOrder(
        @Payload CanceledMenu canceledMenu
    ) {
        CanceledMenu event = canceledMenu;
        System.out.println(
            "\n\n##### listener ReceiveAOrder : " + canceledMenu + "\n\n"
        );

        // Sample Logic //
        Cook.receiveAOrder(event);
    }
}
