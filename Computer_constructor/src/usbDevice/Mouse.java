package usbDevice;

public class Mouse extends AbstractUSBDevice {
    public Mouse(String name) {
        super(name);
    }

    @Override
    public boolean connect() {
        System.out.println("Mouse connected");
        return true;
    }

    @Override
    public boolean disconnect() {
        System.out.println("Mouse disconnected");
        return true;
    }
}
