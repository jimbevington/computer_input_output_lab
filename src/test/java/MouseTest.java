import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MouseTest {

    Mouse mouse;

    @Before
    public void setUp() throws Exception {
        mouse = new Mouse(ConnectionType.BLUETOOTH, 3);
    }

//    have type, no. of buttons, position
//    be able to click, move, etc.

    @Test
    public void canClick() {
        assertEquals("Click", mouse.click());
    }
}
