package pl.komputer.drive;

import pl.komputer.file.File;

public interface Drive {
    void addFile(File file);
    void listFiles();
    File findFile(String name);
}
