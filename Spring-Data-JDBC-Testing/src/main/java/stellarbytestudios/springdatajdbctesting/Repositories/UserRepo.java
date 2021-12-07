package stellarbytestudios.springdatajdbctesting.Repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import stellarbytestudios.springdatajdbctesting.DTOs.User;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

    @Query("select * from Benutzer where vorname = :parameter")
    List<User> findUserByPrename(@Param("parameter") String vorname);
}
