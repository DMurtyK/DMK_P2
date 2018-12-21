package imagehosting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class ImageHostingApplication {
    public static void main(String [] args){


        SpringApplication.run(ImageHostingApplication.class,args);
    }
}
