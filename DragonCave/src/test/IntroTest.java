import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntroTest {
    Intro intro;
    @BeforeEach
    void setUp() {
        intro = new Intro();
    }

    @Test
    void intro() {
        assertEquals("\n\nYou are in a land full of dragon. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "and will share his treasure with you. The other dragon\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into?(1 or 2)", intro.intro, "Error getting intro");
    }

    @AfterEach
    void tearDown() {
    }
}