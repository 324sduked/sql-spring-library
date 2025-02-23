package usbDevice;

public class MemoryStick extends AbstractUSBDevice {
    private boolean ejected = false;

    public MemoryStick(String name) {
        super(name);
    }

    @Override
    public boolean connect() {
        System.out.println("Memory stick connected");
        return true;
    }

    @Override
    public boolean disconnect() {

        if (!ejected) {
            System.out.println("PLease eject memory stick");
        } else {
            System.out.println("Memory strick disconnected");
        }
        return true;
    }

    public void eject() {
        System.out.println("Ejecting memory stick");
        ejected = true;
    }

}
