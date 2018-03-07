package device_management;

import behaviours.IInputDevice;

public class Keyboard implements IInputDevice {

    private ConnectionType connectionType;

    public Keyboard(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public String press(String key) {
        return key;
    }

    @Override
    public String inputData(String data) {
        return data;
    }
}
