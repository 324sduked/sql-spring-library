package usbDevice;

public abstract class AbstractUSBDevice implements USBDevice {
    private String name;

    public AbstractUSBDevice(String name) {
        this.name = name;
    }
    public boolean connect() {
        return false;
    }
    public boolean disconnect() {
        return false;
    }
    public String getName() {
        return name;
    }
}
