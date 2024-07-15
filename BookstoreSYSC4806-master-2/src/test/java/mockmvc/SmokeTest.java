package mockmvc;

import static org.assertj.core.api.Assertions.assertThat;

import controller.CustomerController;
import controller.OwnerController;
import model.AccessingDataJpaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootTest uses AccessingDataJpaApplication.class to start a Spring application context
//To prove the context is creating the controllers, assertions are made for the controllers
@SpringBootTest(classes = AccessingDataJpaApplication.class)
@ComponentScan(basePackages = {"model", "controller", "repository", "entity"})
public class SmokeTest {

    @Autowired
    private OwnerController ownercontroller;

    @Autowired
    private CustomerController customerController;

    @Test
    public void contextLoadsOwnerController() throws Exception {
        assertThat(ownercontroller).isNotNull();
    }

    @Test
    public void contextLoadsCustomerController() throws Exception {
        assertThat(customerController).isNotNull();
    }

}
