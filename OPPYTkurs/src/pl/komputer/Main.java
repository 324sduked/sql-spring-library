package pl.komputer;

import pl.komputer.Computer;
import pl.komputer.drive.HDDDrive;
import pl.komputer.drive.SSDDrive;
import pl.komputer.file.File;
import pl.komputer.file.imagefile.GIFImageFile;
import pl.komputer.file.imagefile.JPEGImageFile;
import pl.komputer.file.musicfile.MP3MusicFile;
import pl.komputer.usbdevice.MemoryStick;
import pl.komputer.usbdevice.Mouse;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        File jpg1 = new JPEGImageFile("nazwa1.jpg", 200, 80);
        GIFImageFile gif1 = new GIFImageFile("nazwa1.gif", 100);

        List<File> files = new ArrayList<>();
        files.add(jpg1);
        files.add(gif1);
        for (File file : files){
            if (file instanceof JPEGImageFile){
                 System.out.println("To plik jpg");
            } else if (file instanceof GIFImageFile) {
                System.out.println("To plik gif");
            }
        }
//
//
//        MP3MusicFile mp3file = new MP3MusicFile(100, "plik1.mp3", 4000, "Marilyn Manson",
//                "Broken Needle");
//
//        System.out.println(mp3file);

         }
}