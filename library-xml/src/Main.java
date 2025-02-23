import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class Main {

    private static final String FILE_NAME = "library.xml";

    public static void main(String[] args) {
        Library loadedLibrary = loadLibraryFromFile();
        UsersInterface usersInterface = new UsersInterface();
        usersInterface.start(loadedLibrary);

    }


    private static Library loadLibraryFromFile() {
        try {

            File xmlFile = new File("library.xml");
            // Utworzenie kontekstu JAXB i instancji unmarshallera
            JAXBContext context = JAXBContext.newInstance(Library.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Odczytanie obiektu biblioteki z pliku
            Library library = (Library) unmarshaller.unmarshal(xmlFile);
            for(Book book : library.getBooks()){
                book.setToAvailable();
            }
            return library;
        } catch (JAXBException e) {
            System.err.println("Error occurred while loading library from file: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}

