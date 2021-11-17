package kraechz.app;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KraechzService {

  private final KraechzRepository repository;

  public KraechzService(KraechzRepository repository) {
    this.repository = repository;
  }
  public List<Kraechz> kraechzeAnzeigen(String filter) {
    if (filter == null) {
      return repository.alle();
    }
    return repository.filtereNachHandle(filter);
  }

  public void kraechze(Kraechz kraechz) {
    repository.save(kraechz);
  }
}
