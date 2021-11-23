package tictactoe.web;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tictactoe.game.Game;
import tictactoe.service.GameService;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
        assertThat(startHTML).contains("""
                <button class="btn btn-primary">Neues Spiel starten</button>
                """);
    }

    @Test
    @DisplayName("Redirect funktioniert auf /game")
    void test_3() throws Exception {
        mvc.perform(post("/starten")
                        .param("gameID","1")
                        .param("player","X"))
                        .andExpect(status()
                        .is3xxRedirection());

    }

    @Test
    @Disabled
    @DisplayName("Das game Objekt wird an das Model übergeben")
    void test_4() throws Exception {
        Game gameMock = mock(Game.class);
        when(service.getGame("1")).thenReturn(gameMock);
        when(gameMock.id()).thenReturn("1");
        when(gameMock.active("X")).thenReturn(true);
//        Game game = new Game();
        mvc.perform(get("/game")
                        .param("gameID", "1")
                        .param("player","X"))
                .andExpect(model().attribute("game", gameMock));

    }

    @Test
    @Disabled
    @DisplayName("Wenn das Spiel gewonnen wurde wird dies auch angezeigt")
    void test_5() throws Exception{


    }
}
