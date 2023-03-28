package food.common;

import food.CqrsApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CqrsApplication.class })
public class CucumberSpingConfiguration {}
