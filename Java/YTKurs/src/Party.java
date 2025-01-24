import java.util.*;

public class Party {
    private List<Guest> guests = new ArrayList<>();
    private Set<String> meals = new HashSet<>();
    private Map<Integer, Guest> phoneToGuest = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    public void addGuest(){
        System.out.println("podaj imie gościa");
        String name = scanner.nextLine();
        System.out.println("podaj preferowany posiłek");
        String meal = scanner.nextLine();
        System.out.println("podaj numer telefonu");
        int phoneNumber = Integer.valueOf(scanner.nextLine());
        checkPhoneNumber(phoneNumber);
        System.out.println("czy weganin? (Y/N)");
        String isVeganString = scanner.nextLine();
        boolean isVegan;
        if (isVeganString.equals("Y")){
            isVegan = true;
        }else{
            isVegan = false;
        }
        Guest guest = new Guest(name, meal, phoneNumber, isVegan);
        meals.add(meal);
        phoneToGuest.put(phoneNumber, guest);
        guests.add(guest);
    }
    public void displayMeals() {
        for (String meal : meals) {
            System.out.println(meal);
        }
    }
        public void displayGuestByPhoneNumber() {
            System.out.println("podaj numer telefonu: ");
            Integer phoneNumber = Integer.valueOf(scanner.nextLine());
            Guest guest = phoneToGuest.get(phoneNumber);
            guest.displayGuestInformation();
        }
    public void   displayGuests(){
       for (Guest guest : guests){
           guest.displayGuestInformation();
       }
    }
    public void checkPhoneNumber(int phoneNumber){
        try {
            phoneNumber = scanner.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Entered value is not a number");
        }
        boolean isPhoneNumberWrong = true;
        while (isPhoneNumberWrong){
            if ( phoneNumber < 0 ){
                System.out.println("błąd");
                System.out.println("podaj numer telefonu");
                phoneNumber = Integer.valueOf(scanner.nextLine());
            }else {
                isPhoneNumberWrong = false;
            }

        }
    }
}
