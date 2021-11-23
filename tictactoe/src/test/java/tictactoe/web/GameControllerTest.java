package tictactoe.web;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import tictactoe.service.GameService;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class GameControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    GameService service;

    @Test
    @DisplayName("Bei einem / Aufruf wird die Startseite gezeigt")
    void test_1() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Die richtige Seite wird angezeigt mit Button")
    void test_2() throws Exception {
        MvcResult startseite = mvc.perform(get("/"))
                .andReturn();

        String startHTML = startseite.getResponse().getContentAsString();
        assertThat(startHTML).contains("<button class=\"btn btn-primary\">Neues Spiel starten</button>");
    }

    @Test
    @Disabled
    @DisplayName("Die richtige Seite wird angezeigt mit Button")
    void test_3() throws Exception {
        MvcResult startseite = mvc.perform(get("/"))
                .andReturn();

        String startHTML = startseite.getResponse().getContentAsString();
        assertThat(startHTML).contains("<button class=\"btn btn-primary\">Neues Spiel starten</button>");
    }

}