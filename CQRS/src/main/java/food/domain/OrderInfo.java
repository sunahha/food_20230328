package food.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderInfo_table")
@Data
public class OrderInfo {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
