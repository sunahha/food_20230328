package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FoodDeliveriedConfirm extends AbstractEvent {

    private Long id;

    public FoodDeliveriedConfirm(Delivery aggregate) {
        super(aggregate);
    }

    public FoodDeliveriedConfirm() {
        super();
    }
}
