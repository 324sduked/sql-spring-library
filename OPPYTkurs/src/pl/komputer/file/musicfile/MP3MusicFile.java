package pl.komputer.file.musicfile;

public class MP3MusicFile extends AbstractMusicFile{

    private int quality;



    public MP3MusicFile(int quality, String name, int size, String bandName, String title) {
        super(name, size, bandName, title);
        this.quality = quality;
    }

    @Override
    public void play() {
        System.out.println("playing MP3 File");

    }

    @Override
    public String getName() {
        return "plik nazywa się " + super.getName();
    }

    @Override
    public String toString() {
        return "MP3MusicFile{" +
                "bandName='" + bandName + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public int getQuality() {
        return quality;


    }
}
