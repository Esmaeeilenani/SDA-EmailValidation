package emailvalidation;

import java.util.ArrayList;
import java.util.Scanner;

public class EmailValidation {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> EmailList = new ArrayList<>();
        System.out.println("Welcome to Email Validation and storing");

        while (true) {
            Menu();
            String UserIn = in.next();
            if (UserIn.equals("1")) {

                System.out.print("Enter Email to save: ");
                String Email = in.next();
                if (EmailIsValid(Email)) {
                    System.out.println("Email (" + Email + ") is Added Thank you !");
                    EmailList.add(Email);
                    continue;
                }

                System.out.println("\nWrong Email Format Try Again Please\n");

            } else if (UserIn.equals("2")) {
                System.out.print("Enter Email to Search for: ");
                String SearchFor = in.next();

                String reasult = EmailList.stream()
                        .filter(Email -> Email.equals(SearchFor))
                        .findFirst()
                        .orElse("Email Not Found!!");

                System.out.println("\nEmail you are Searching for:");
                System.out.println(reasult + "\n");

            } else if (UserIn.equals("3")) {
                System.out.println("\n\nthank you for Using our System goodbye.....\n");
                System.exit(0);
            } else {
                System.out.println("Wrong input try Again Please!!!");

            }
        }

    }

    public static void Menu() {
        System.out.println("1.  Add new Email");
        System.out.println("2.  Search for an Email");
        System.out.println("3.  Exit");
        System.out.print("Choice: ");
    }

    public static boolean EmailIsValid(String Email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return Email.matches(regex);
    }

}
