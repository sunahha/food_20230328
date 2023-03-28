package food.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MenuInformation_table")
@Data
public class MenuInformation {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
