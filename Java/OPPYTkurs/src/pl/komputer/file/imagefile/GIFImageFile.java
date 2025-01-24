package pl.komputer.file.imagefile;

public class GIFImageFile extends AbstractImageFIle {
    public GIFImageFile(String name, int size) {
      super(name, size);

    }

    public void showAnimation(){
        System.out.println("showing funny gif");
    }
}
