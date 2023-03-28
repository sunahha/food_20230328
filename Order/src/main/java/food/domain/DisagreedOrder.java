package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DisagreedOrder extends AbstractEvent {

    private Long id;
}
