package mm.com.cinematrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class CinematrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinematrixApplication.class, args);
    }

}
