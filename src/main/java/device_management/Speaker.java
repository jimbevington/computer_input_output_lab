package device_management;

import behaviours.IOutput;

public class Speaker extends SoundDevice implements IOutput{
    public Speaker(String name, int maxVolume) {
        super(name, maxVolume);
    }

    public String outputData(String data) {
        return playSound(data);
    }
}
