import java.util.*;

public class Main {
    public static void main(String[] args) {

        Party party = new Party();

        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        while (shouldContinue){
            System.out.println("1. wyświetl gości");
            System.out.println("2. dodaj gościa");
            System.out.println("3. wyświetl potrawy");
            System.out.println("4. Znajdź po numerze telefonu");
            System.out.println("5. wyjście");
            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1 :
                    party.displayGuests();
                    break;
                case 2 : party.addGuest();
                    break;
                case 3 : party.displayMeals();
                    break;
                case 4 : party.displayGuestByPhoneNumber();
                    break;

                case 5 : shouldContinue = false;
            }
        }






    }
}