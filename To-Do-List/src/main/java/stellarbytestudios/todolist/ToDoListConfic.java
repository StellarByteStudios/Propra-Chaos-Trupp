package stellarbytestudios.todolist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import stellarbytestudios.todolist.frame.databankcommunication.DBSchnittstelle;
import stellarbytestudios.todolist.services.ToDoListService;

@Configuration
public class ToDoListConfic {

    @Bean
    public ToDoListService createService(DBSchnittstelle db) {
        return new ToDoListService(db);
    }
}
