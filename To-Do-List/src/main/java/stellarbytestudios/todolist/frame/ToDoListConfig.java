package stellarbytestudios.todolist.frame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import stellarbytestudios.todolist.frame.databankcommunication.DBSchnittstelle;
import stellarbytestudios.todolist.services.UserHandlingService;

@Configuration
public class ToDoListConfig {

    @Bean
    public UserHandlingService createService(DBSchnittstelle repository){
        return new UserHandlingService(repository);
    }
}
