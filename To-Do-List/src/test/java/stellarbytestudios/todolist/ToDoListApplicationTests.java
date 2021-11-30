package stellarbytestudios.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import stellarbytestudios.todolist.frame.webcontroller.StartPageController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class ToDoListApplicationTests {

    private final StartPageController startController;

    @Autowired
    public ToDoListApplicationTests(StartPageController startController) {
        this.startController = startController;
    }

    @Test
    void contextLoads() {
        assertThat(startController).isNotNull();
    }

}
