package device_management;

public class Radio extends SoundDevice {

    public Radio(String name, int maxVolume) {
        super(name, maxVolume);
    }

    public String tune(String station) {
        return playSound(station);
    };
}
