package stellarbytestudios.springdatajdbctesting;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import stellarbytestudios.springdatajdbctesting.DTOs.Adress;
import stellarbytestudios.springdatajdbctesting.DTOs.User;
import stellarbytestudios.springdatajdbctesting.Repositories.UserRepo;

@SpringBootApplication
public class SpringDataJdbcTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcTestingApplication.class, args);
    }

}
