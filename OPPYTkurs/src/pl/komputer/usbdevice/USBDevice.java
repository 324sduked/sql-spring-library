package pl.komputer.usbdevice;

public interface USBDevice {
    boolean connected();
    boolean disconnected();
    String getName();
}
