package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderedMenu extends AbstractEvent {

    private Long id;
    private Long foodid;
    private String option;
    private String address;
}
