package stellarbytestudios.todolist.frame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import stellarbytestudios.todolist.services.ToDoListService;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest
public class StartPageContTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    ToDoListService service;

    @Test
    @DisplayName("Die Startseite wird korrekt aufgerufen")
    void test_1() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/")).andReturn();
        String htmlPage = result.getResponse().getContentAsString();
        assertThat(htmlPage).contains("Registrierung abschließen");
        assertThat(htmlPage).contains("Willkommen");
        assertThat(htmlPage).contains("Schon einen Accound");
        assertThat(htmlPage).contains("To-Do-Liste");
    }

}
