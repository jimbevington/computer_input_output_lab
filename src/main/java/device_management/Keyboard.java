package device_management;

public class Keyboard implements IInputDevice{

    private ConnectionType connectionType;

    public Keyboard(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public String press(String key) {
        return key;
    }

    @Override
    public String sendData(String data) {
        return data;
    }
}
