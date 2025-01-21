import drive.HDDDrive;
import usbDevice.Mouse;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        HDDDrive drive = new HDDDrive();
        Computer computer = new Computer(monitor, drive);

        Monitor monitor1 = new Monitor();
        HDDDrive drive1 = new HDDDrive();
        Computer computer1 = new Computer(monitor1, drive1);

        Mouse mysz = new Mouse("mysz");

        computer1.addUSBDevice(mysz);
        computer.getUsbDevices();
    }

    }
