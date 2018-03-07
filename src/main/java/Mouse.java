public class Mouse {


    private ConnectionType connectType;
    private int buttons;

    public Mouse(ConnectionType connectType, int buttons) {
        this.connectType = connectType;
        this.buttons = buttons;
    }

    public String click() {
        return "Click!";
    }
}
