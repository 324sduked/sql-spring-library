import java.util.Random;
import java.util.Scanner;

public class UsersInterface {
    public UsersInterface() {

    }

    private boolean isStarted = true;

    private Random random = new Random();

    private Scanner scanner = new Scanner(System.in);
    private Scanner scannerForStrings = new Scanner(System.in);

    public void start(Library library) {
        while (isStarted) {
            System.out.println("kliknij 6 by wyświetlić menu");
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    addBook(library);
                    break;

                case "2":
                    removeBook(library);
                    break;
                case "3":
                    System.out.println("Dostępne książki: ");
                    library.listAvailableBooks();
                    break;
                case "4":
                    library.convertToXML(library);
                    break;
                case "5":
                    findBook(library);
                    break;
                case "6":
                    printMenu();
                    break;
                case "q":
                    isStarted = false;
                    // method exit() zapisz xml

            }
        }
    }

    public void printMenu() {
        System.out.println("Wybierz operację: ");
        System.out.println("1. Dodaj nową książkę do biblioteki");
        System.out.println("2. Usuń książke z biblioteki");
        System.out.println("3. Wyświetl dostępne książki");
        System.out.println("4. Eksportuj do XML");
        System.out.println("5. Sprawdź dostępność książki");
        System.out.println("Kliknij q by wyjść z programu");
    }

    public void removeBook(Library library) {
        System.out.println("Tytuł książki którą chcesz usunąć: ");
        String title2 = scannerForStrings.nextLine();
        if (Library.doesBookExists(title2)) {
            library.removeBook(library.findBookByTitle(title2));
            System.out.println("Książka: " + title2 + " została usunięta z biblioteki");
        } else {
            System.out.println("tej książki nie ma w biliotece");
        }
    }

    public void addBook(Library library) {
        System.out.println("Tytuł książki którą chcesz dodać: ");
        String title = scannerForStrings.nextLine();
        int isbn = random.nextInt(1000);
        boolean isAvailable = true;
        Book book = new Book(title, isbn, isAvailable);
        library.getBooks().add(book);
        book.setToAvailable();
        System.out.println("Książka zatytułowana: " + title + " została dodana do biblioteki");
    }
    public void findBook(Library library){
        System.out.println("Podaj tytuł: ");
        String title2 = scannerForStrings.nextLine();
        if (library.findBookByTitle(title2).equals(null)){
            System.out.println("Ksiażka niedostępna");
        }else {
            System.out.println("Książka dostępna");
        }

    }
}


