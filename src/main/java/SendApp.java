import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2017/10/20.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com"})
//@Controller
public class SendApp {
    public static void main(String[] args) {
        SpringApplication.run(SendApp.class,args);
    }
}
