package file.imageFile;

import file.AbstractFile;
import file.FileType;

public abstract class AbstractImageFile extends AbstractFile {
    protected AbstractImageFile(String name, int size) {
        super(name,size);
    }
    @Override
    public FileType getType() {
        return FileType.IMAGE;
    }
}
