package stellarbytestudios.springdatajdbctesting.DTOs;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("Benutzer")
public class User {

    @Id
    private Long id;
    @Column("vorname")
    private String prename;
    @Column("nachname")
    private String surname;
    private Set<Adress> adresses;

    public void setId(long id) {
        this.id = id;
    }

    public User(Long id, String prename, String surname, Set<Adress> adresses) {
        this.id = id;
        this.prename = prename;
        this.surname = surname;
        this.adresses = adresses;
    }

    public static User create(String vorname, String nachname, Set<Adress> adresses){
        return new User(null, vorname, nachname, adresses);
    }

    void addAddress(Adress newAdress){
        this.adresses.add(newAdress);
    }

    @Override
    public String toString() {
        return "User{" +
                "id: " + id +
                ", Vorname: '" + prename  + '\'' +
                ", Nachname:'" + surname  + '\'' +
                ", Adresse: '" + adresses + '\'' +
                '}';
    }

    public void setPrename(String s) {
        this.prename = s;
    }
}
