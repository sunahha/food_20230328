package food.common;

import food.DeliveryApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { DeliveryApplication.class })
public class CucumberSpingConfiguration {}
