import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    Number number;
    @BeforeEach
    void setUp() {
        number = new Number();
    }

    @Test
    void ans() {
        int min,max;
        min = 0;
        max = 20;
        assertTrue(min <= number.ans && max >= number.ans);
    }
}