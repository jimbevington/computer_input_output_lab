package device_management;

public class SoundDevice {

    private String name;
    int maxVolume;

    public SoundDevice(String name, int maxVolume) {
        this.name = name;
        this.maxVolume = maxVolume;
    }

    public int getMaxVolume() {
        return this.maxVolume;
    }

    public String playSound(String sound) {
        return name + " is playing: " + sound;
    }
}
