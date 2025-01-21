package pl.komputer.file.imagefile;
public class JPEGImageFile extends AbstractImageFIle {

    private int compression;

    public JPEGImageFile(String name, int size, int compression) {
      super(name, size);
      this.compression = compression;
    }


    public int getCompression() {
        return compression;
    }
    public void displayImage(){
        System.out.println("displaying JPG");
    }
}
