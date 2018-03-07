import device_management.ConnectionType;
import device_management.Keyboard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeyboardTest {

//    needs a Connection type
//    can press a button

    Keyboard keyboard;

    @Before
    public void setUp() throws Exception {
        keyboard = new Keyboard(ConnectionType.WIRED);
    }

    @Test
    public void canPushButton() {
        assertEquals("k", keyboard.press("k"));
    }

    @Test
    public void canSendData() {
        assertEquals("jim", keyboard.sendDatqa("jim"));
    }
}
