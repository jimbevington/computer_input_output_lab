package device_management;

import behaviours.IInput;
import behaviours.IOutput;

import java.util.ArrayList;

public class Computer {
    private int ram;
    private int hddSize;

    private IOutput outputDevice;
    private IInput inputDevice;
    private String dataStream;

    private ArrayList<SoundDevice> soundDevices;
    public SoundDevice outputSoundDevice;

    public Computer(int ram, int hddSize, IOutput outputDevice, IInput inputDevice) {
        this.ram = ram;
        this.hddSize = hddSize;
        this.outputDevice = outputDevice;
        this.inputDevice = inputDevice;
        this.dataStream = null;
        this.soundDevices = new ArrayList<>();
        this.outputSoundDevice = null;

    }

    public int getRam() {
        return this.ram;
    }

    public int getHddSize() {
        return this.hddSize;
    }

    public IOutput getDevice() {
        return this.outputDevice;
    }

    public String outputData(String data) {
        return this.outputDevice.outputData(data);
    }

    public void setOutputDevice(IOutput outputDevice) {
        this.outputDevice = outputDevice;
    }

    public String inputData(String data) {
        this.dataStream = data
;        return this.inputDevice.inputData(data);
    }

    public void setInputDevice(IInput inputDevice) {
        this.inputDevice = inputDevice;
    }

    public String getDataStream() {
        return dataStream;
    }

    public String outputDataStream() {
        return outputData(dataStream);
    }

    public ArrayList<SoundDevice> listSoundDevices() {
        return soundDevices;
    }

    public void addSoundDevice(SoundDevice device) {
        soundDevices.add(device);
    }

    public SoundDevice getOutputSoundDevice() {
        return outputSoundDevice;
    }
}
