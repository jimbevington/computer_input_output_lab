package device_management;

import behaviours.IInputDevice;
import behaviours.IOutput;

public class Computer {
    private int ram;
    private int hddSize;

    private IOutput outputDevice;
    private IInputDevice inputDevice;
    private String dataStream;

    public Computer(int ram, int hddSize, IOutput outputDevice, IInputDevice inputDevice) {
        this.ram = ram;
        this.hddSize = hddSize;
        this.outputDevice = outputDevice;
        this.inputDevice = inputDevice;
        this.dataStream = null;
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

    public void setInputDevice(IInputDevice inputDevice) {
        this.inputDevice = inputDevice;
    }

    public String getDataStream() {
        return dataStream;
    }


    public String outputDataStream() {
        return outputData(dataStream);
    }
}
