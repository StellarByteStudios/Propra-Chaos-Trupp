package stellarbytestudios.springdatajdbctesting.DTOs;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Adress {
//    @Id
//    private Long id;
    @Column("adress_line")
    private String adressline;

    public Adress(String adressline) {
        this.adressline = adressline;
    }

    @Override
    public String toString() {
        return "Adress{" +
//                "id=" + id +
                ", adressline='" + adressline + '\'' +
                '}';
    }
}
