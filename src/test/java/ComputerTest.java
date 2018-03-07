import behaviours.IOutput;
import device_management.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ComputerTest {
    Computer computer;
    Monitor monitor;
    Keyboard keyboard;

    @Before
    public void before() {
        monitor = new Monitor(22, 786432);
        keyboard = new Keyboard(ConnectionType.BLUETOOTH);
        computer = new Computer(8, 512, monitor, keyboard);
    }

    @Test
    public void hasRam() {
        assertEquals(8, computer.getRam());
    }

    @Test
    public void hasHddSize() {
        assertEquals(512, computer.getHddSize());
    }

    @Test
    public void hasOutputDevice() {
        IOutput outputDevice = computer.getDevice();
        assertNotNull(outputDevice);
    }

    @Test
    public void canOutputData() {
        assertEquals("space invaders is now on screen", computer.outputData("space invaders"));
    }

    @Test
    public void canOutputPrinterData() {
        Printer printer = new Printer("Epson", "Stylus", 120, 4);
        computer = new Computer(16, 250, printer, keyboard);
        assertEquals("printing: space invaders", computer.outputData("space invaders"));
    }

    @Test
    public void canOutputDataViaSpeaker() {
        Speaker speaker = new Speaker(100);
        computer = new Computer(14, 20, speaker, keyboard);
        assertEquals("playing: Beep!", computer.outputData("Beep!"));
    }

    @Test
    public void canSetOutputDevice() {
        Printer printer = new Printer("Epson", "Stylus", 120, 5);
        computer.setOutputDevice(printer);
        assertEquals("printing: space invaders", computer.outputData("space invaders"));
    }

    @Test
    public void canInputDataFromKeyboard() {
        assertEquals("k", computer.inputData("k"));
    }

    @Test
    public void canInputDataFromMouse() {
        Mouse mouse = new Mouse(ConnectionType.BLUETOOTH, 3);
        computer = new Computer(56, 345, monitor, mouse);
        assertEquals("Click!", computer.inputData("anything"));
    }

    @Test
    public void canSetInputDevice() {
        Mouse mouse = new Mouse(ConnectionType.BLUETOOTH, 3);
        computer.setInputDevice(mouse);
        assertEquals("Click!", computer.inputData("anything"));
    }

    @Test
    public void dataStreamStartsAtNull() {
        assertNull(computer.getDataStream());
    }

    @Test
    public void getInputUpdatesDataStream() {
        computer.inputData("twelve");
        assertEquals("twelve", computer.getDataStream());
    }
}
