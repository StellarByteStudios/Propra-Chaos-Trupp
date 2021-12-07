package stellarbytestudios.springdatajdbctesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import stellarbytestudios.springdatajdbctesting.DTOs.Adress;
import stellarbytestudios.springdatajdbctesting.DTOs.User;
import stellarbytestudios.springdatajdbctesting.Repositories.UserRepo;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class SpringDataJdbcTestingApplicationTests {

    @Autowired
    private UserRepo userRepo;

    @Test
    void contextLoads() {


//        Set<Adress> adresses1 = new HashSet<Adress>();
//        adresses1.add(new Adress("Mirkelsbachstr 48"));
//        adresses1.add(new Adress("Ikanuramstr 78"));
//        adresses1.add(new Adress("Postfachstr 13"));
        Set<Adress> adresses2 = new HashSet<Adress>();
        adresses2.add(new Adress("Anatistr 489"));
        adresses2.add(new Adress("Geroldsteinerstr 111"));
        adresses2.add(new Adress("Nummerstr 68"));
//        Set<Adress> adresses3 = new HashSet<Adress>();
//        adresses3.add(new Adress("Neichenstr 78"));
//        adresses3.add(new Adress("Leichenbergerstr 36"));
//        adresses3.add(new Adress("Canidostr 56"));

//        User benutzer1 = User.create("Mattias", "Mariko", adresses1);
        User benutzer2 = User.create("Alina", "Markmann", adresses2);
//        User benutzer3 = User.create("Jenny", "Linndemann", adresses3);

//        System.out.println(userRepo.save(benutzer1));
        System.out.println(userRepo.save(benutzer2));
//        System.out.println(userRepo.save(benutzer3));

        benutzer2.setPrename("Alina-Marie");

        userRepo.save(benutzer2);

        System.out.println(userRepo.findAll());
    }

}
