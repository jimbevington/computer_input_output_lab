package device_management;

import behaviours.IInput;

public class Keyboard implements IInput {

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
