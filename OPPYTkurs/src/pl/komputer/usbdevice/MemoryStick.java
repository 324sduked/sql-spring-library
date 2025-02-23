package pl.komputer.usbdevice;

public class MemoryStick implements USBDevice {

    private String name;
    private boolean ejected = false;

    public MemoryStick(String name) {
        this.name = name;
    }

    @Override
    public boolean connected() {
        System.out.println("Conneceted Memory Stick ");
        return true;
    }

    @Override
    public boolean disconnected() {
        if (!ejected) {
            System.out.println("please eject memory stick first");
            return false;
        } else {
            System.out.println("memory stick disconnected");
        }
        return true;
    }
    public void eject(){
         System.out.println("ejecting memory stick");
        ejected = true;
    }

    @Override
    public String getName() {
        return name;
    }
}
