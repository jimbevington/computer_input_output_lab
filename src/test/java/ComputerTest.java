import behaviours.IOutput;
import device_management.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        Speaker speaker = new Speaker("Bowers & Wilkins", 100);
        computer = new Computer(14, 20, speaker, keyboard);
        assertEquals("Bowers & Wilkins is playing: Beep!", computer.outputData("Beep!"));
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

    @Test
    public void canOutputDataStream() {
        computer.inputData("Sandwiches");
        assertEquals("Sandwiches is now on screen", computer.outputDataStream());
    }

    @Test
    public void hasNoSoundDevices() {
        assertEquals(0, computer.listSoundDevices().size());
    }

    @Test
    public void canAddSoundDevices() {
        Speaker speaker1 = new Speaker("D&B", 100);
        computer.addSoundDevice(speaker1);
        ArrayList<SoundDevice> deviceList = computer.listSoundDevices();
        assertEquals(1, deviceList.size());
        assert(deviceList.get(0) instanceof Speaker);
    }

    @Test
    public void hasNullOutputDeviceOnSetup() {
        assertNull(computer.getOutputSoundDevice());
    }

    @Test
    public void canSetOutputSoundDevice() {
        Speaker speaker1 = new Speaker("Bose", 100);
        computer.addSoundDevice(speaker1);
        computer.setOutputSoundDevice(1);
        assertEquals(speaker1, computer.getOutputSoundDevice());
    }

    @Test
    public void cantSetOutputSoundDeviceIfNotPresent() {
        computer.setOutputSoundDevice(1);
        assertNull(computer.getOutputSoundDevice());
    }

    @Test
    public void cantSetOutputSoundDeviceIfNotEnough() {
        Speaker speaker1 = new Speaker("Bose", 100);
        computer.addSoundDevice(speaker1);
//        set an initial Sound Device
        computer.setOutputSoundDevice(1);
//        try set another Sound Device that isn't there
        computer.setOutputSoundDevice(2);
        assertEquals(speaker1, computer.getOutputSoundDevice());
    }

    @Test
    public void canResetOutputSoundDevice() {
        Speaker speaker1 = new Speaker("Bose", 100);
        Speaker speaker2 = new Speaker("D&B", 150);
        computer.addSoundDevice(speaker1);
        computer.addSoundDevice(speaker2);
        computer.setOutputSoundDevice(1);
        computer.setOutputSoundDevice(2);
        assertEquals(speaker2, computer.getOutputSoundDevice());
    }

//    @Test
//    public void canPlaySound() {
//        Speaker speaker1 = new Speaker(100);
//        computer.addSoundDevice(speaker1);
//        computer.
//    }
}
