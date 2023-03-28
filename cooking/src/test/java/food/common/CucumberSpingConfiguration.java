package food.common;

import food.CookingApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CookingApplication.class })
public class CucumberSpingConfiguration {}
