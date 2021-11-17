package kraechz.app;

import static java.util.stream.Collectors.toList;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class KraechzRepository {
  private final JdbcTemplate db;
  List<Kraechz> kraechze = new ArrayList<>();

  public KraechzRepository(JdbcTemplate db) {
    this.db = db;
  }

  private static Kraechz mapKraechz(ResultSet rs, int b) throws SQLException {
    String handle = rs.getString(1);
    String text = rs.getString(2);
    Kraechz k = new Kraechz(handle, text);
    return k;
  }


  public List<Kraechz> alle() {
    String sqlGetAll = """
            SELECT handle, text
            FROM Kraechz
            """;
    List<Kraechz> kraechzList = db.query(sqlGetAll, KraechzRepository::mapKraechz);
    return kraechzList;
  }


  public List<Kraechz> filtereNachHandle(String name) {
    // Nur die Objekte holen, deren Handle-Name übergeben wurde
    // Muss ein passendes SQL Statement verwenden!
    // Darf nicht alle Objekte holen und dann filtern!
    String sql = """
            SELECT handle, text FROM Kraechz WHERE handle = ?
            """;
    return db.query(sql,KraechzRepository::mapKraechz,name);
  }

  public void save(Kraechz k) {
    String sqlSave = """
            INSERT INTO Kraechz (handle, text)
            Values(?,?)
            """;
    db.update(sqlSave, k.handle(), k.text());
  }

}
