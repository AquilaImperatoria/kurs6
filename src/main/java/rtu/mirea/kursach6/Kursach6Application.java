package rtu.mirea.kursach6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Kursach6Application {

    public static void main(String[] args) throws IOException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        System.out.println(dbUrl);
        SpringApplication.run(Kursach6Application.class, args);

    }

}
