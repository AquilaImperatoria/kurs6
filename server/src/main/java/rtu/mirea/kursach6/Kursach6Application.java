package rtu.mirea.kursach6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Kursach6Application {

    public static void main(String[] args) throws IOException {
        DatabaseConfig dbconf = new DatabaseConfig();
        dbconf.dataSource();
        SpringApplication.run(Kursach6Application.class, args);

    }

}
