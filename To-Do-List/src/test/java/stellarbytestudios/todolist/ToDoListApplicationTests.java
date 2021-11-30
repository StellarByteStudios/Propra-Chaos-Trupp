package stellarbytestudios.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import stellarbytestudios.todolist.frame.webcontroller.AnmeldungsController;
import stellarbytestudios.todolist.frame.webcontroller.RegistrierungsController;
import stellarbytestudios.todolist.frame.webcontroller.StartPageController;
import stellarbytestudios.todolist.frame.webcontroller.UserPageController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class ToDoListApplicationTests {

    private final StartPageController startController;
    private final AnmeldungsController anmeldungController;
    private final RegistrierungsController registrierungController;
    private final UserPageController userController;

    @Autowired
    ToDoListApplicationTests(StartPageController startController,
                                    AnmeldungsController anmeldungController,
                                    RegistrierungsController registrierungController,
                                    UserPageController userController) {
        this.startController = startController;
        this.anmeldungController = anmeldungController;
        this.registrierungController = registrierungController;
        this.userController = userController;
    }




    @Test
    void contextLoads() {
        assertThat(startController).isNotNull();
    }

}
