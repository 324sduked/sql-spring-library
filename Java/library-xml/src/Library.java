import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "library")
public class Library {
    public Library() {
    }


    public static List<Book> getBooks() {
        return books;
    }
    @XmlElement(name = "book")
    private static List<Book> books = new ArrayList<>();


    public static boolean doesBookExists(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }
    public void removeBook(Book book) {
       getBooks().remove(book);
        book.setToNotAvailable();
    }

    public void listAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) {
                int index = books.indexOf(book);
                index++;
                System.out.print(index + " Tytuł: ");
                System.out.println(book.getTitle());
                System.out.print("ISBN: ");
                System.out.println(book.getIsbn());

            }
        }

    }
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }


//    public void listUsers() {
//        for (User user : users.keySet()) {
//            List value = user.getBorrowedBooks();
//            System.out.println("Użytkownik: " + user.getName() + ", Pożyczone książki: " + value);
//        }
//    }

    public static void convertToXML(Library library) {
        try {
            // Create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Library.class);
            Marshaller marshaller = context.createMarshaller();

            // Optional: format the output
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Marshal the library object to a file
            marshaller.marshal(library, new File("library.xml"));

            // Also marshal to System.out for debugging purposes
            marshaller.marshal(library, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
