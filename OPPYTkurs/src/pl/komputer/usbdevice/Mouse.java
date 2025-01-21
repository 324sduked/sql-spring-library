package pl.komputer.usbdevice;

public class Mouse implements USBDevice {
        private String name;
        public Mouse(String name){
            this.name = name;
        }


    @Override
    public boolean connected() {
        System.out.println("mouse connected");
        return true;
    }

    @Override
    public boolean disconnected() {
        System.out.println("mouse disconnected");
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
