package tictactoe.web;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tictactoe.service.GameService;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class GameControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    GameService service;

    @Test
    @DisplayName("Die Startseite wird richtig angezeigt")
    void test_01() throws Exception{
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Teste Redirect von Postmapping auf 'starten'")
    void test_02() throws Exception{
        mvc.perform(post("/starten"))
                        .andExpect(status().is3xxRedirection());
    }

    @Test
    @DisplayName("Teste Redirect von Getmapping auf 'beitreten'")
    void test_03() throws Exception{
        mvc.perform(get("/beitreten")
                        .param("gameId", "1"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @DisplayName("Teste Redirect für das Ziehen")
    void test_04() throws Exception{
        mvc.perform(post("/ziehen")
                        .param("gameId", "1")
                        .param("player", "O")
                        .param("row", "1")
                        .param("column", "1"))
                .andExpect(status().is3xxRedirection());
    }

    // Hier wird der Aufruf der Services getestet

    @Test
    @DisplayName("Verify ob die Geschäftslogik aufgerufen wird")
    void test_05() throws Exception{
        mvc.perform(post("/ziehen")
                        .param("gameId", "fünfzig")
                        .param("player", "O")
                        .param("row", "1")
                        .param("column", "2"));

        verify(service).makeAMove("fünfzig",1,2);
    }


}