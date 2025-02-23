package pl.komputer.file.imagefile;

import pl.komputer.file.AbstractFile;
import pl.komputer.file.File;
import pl.komputer.file.FileType;

public abstract class AbstractImageFIle extends AbstractFile {
    protected String name;
    protected int size;

    protected AbstractImageFIle(String name, int size) {
        super(name, size);
    }

    @Override
    public FileType getType() {
        return FileType.IMAGE;
    }
}
