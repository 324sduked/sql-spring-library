import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
    private String title;
    private int isbn;
    private  boolean isAvailable;

    public Book() {
    }

    public Book(String title, int isbn, boolean isAvailable) {
        this.title = title;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }
    @XmlElement
    public String getTitle() {
        return title;
    }
    @XmlElement
    public int getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @XmlElement
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setToAvailable(){
        isAvailable = true;
    }
    public void setToNotAvailable(){
        isAvailable = false;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
