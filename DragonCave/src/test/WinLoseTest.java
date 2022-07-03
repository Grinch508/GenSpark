import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinLoseTest {
    WinLose winLose;
    @BeforeEach
    void setUp() {
        winLose = new WinLose();
    }

    @Test
    void getWinLine() {
        assertEquals("\n\nYou approach the cave...\n"+
                "It is dark and spooky...\n"+
                "A large treasure appears in front of you!\n"+
                "YOU WIN!!!", winLose.winLine, "Error getting win line");
    }

    @Test
    void getLoseLine() {
        assertEquals("\n\nYou approach the cave...\n"+
                "It is dark and spooky...\n"+
                "A large treasure appears in front of you!\n"+
                "YOU LOSE!!!\n", winLose.loseLine, "Error getting lose line");
    }
}