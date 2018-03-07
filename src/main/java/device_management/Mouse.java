package device_management;

public class Mouse implements IInputDevice{


    private ConnectionType connectType;
    private int buttons;
    private double position;

    public Mouse(ConnectionType connectType, int buttons) {
        this.connectType = connectType;
        this.buttons = buttons;
//        initalise position as nothing,
//        is an XY value
        this.position = 00.00;
    }

    public String click() {
        return "Click!";
    }


    public double getPosition() {
        return position;
    }

    public void move(double position) {
        this.position = position;
    }

    @Override
    public String sendData(String data) {
        return data;
    }
}
