// Programmer: Nam Le & James Chen
// Date: 10/20/22
// Class: CS 145
// Assignment: Phone Book
// Purpose: Create a phone book program that allows the user to
//          add, modify, delete, and print entries of names, addresses,
//          city, and phone number.
//          
// Extra Credit: Usage of Package, Switch/Case, User interface thats crash resistant

package PhoneBook;

import java.util.Scanner;

// extends allows you to use listNode class's fields
public class menuManager extends listNode {

    private String response;
    private String newLastName;
    private String newFirstName;
    private String newAddress;
    private String newCity;
    private String newNumber;
    private listNode entryFound;


    //CONSTRUCTOR METHOD
    // super retrieves superclass's fields
    public menuManager(String firstName, String lastName, 
    String address, String city, String number) {
        super(firstName, lastName, address, city, number);
        response = "";
    }

    
    // MAIN MENU METHOD, uses phonebookManager class as parameter
    public void mainMenu(phonebookManager entry) {

        while (!response.equalsIgnoreCase("C")) { 
        response = menu(response);
            switch(response.toUpperCase()) {
                case "A":
                    caseA(entry);
                break;
                case "D":
                    caseD(entry);
                break;
                case "M":
                    caseM(entry);
                break;
                case "P":
                    caseP(entry);
                break;
                case "C":
                    System.out.println("You closed the program!");
                break;
                default:
                    System.out.println("Please enter a valid command!");
            } // end of switch
        }
    } // end of mainMenu


    // MENU METHOD
    public String menu(String response) {
        Scanner input = new Scanner(System.in);
            System.out.println("\nPlease enter one of the following commands:");
            System.out.println("'add' to add a entry ");
            System.out.println("'delete' to delete an entry ");
            System.out.println("'modify' to modify an entry ");
            System.out.println("'print' to print the phonebook ");
            System.out.println("'close' to close the program ");
            response = input.next();
        response = response.substring(0,1);
        return response;
    }


    // CASE A METHOD, uses the paramater phonebookManager class,
    // allows you to use the add method               
    public void caseA(phonebookManager entry) throws NullPointerException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the first name: ");
        newFirstName = input.next();
        System.out.println("Please enter the last name: ");
        newLastName = input.next();
        System.out.println("Please enter the address: ");
        newAddress = input.next();
        System.out.println("Please enter the city: ");
        newCity = input.next();
        System.out.println("Please enter the phone number: ");
        newNumber = input.next();
        entry.add(newFirstName, newLastName, newAddress, newCity, newNumber);
        System.out.println("Entry successfull!");
    }


    // CASE D METHOD, paramater: phonebookManager to use delete method
    public void caseD(phonebookManager entry) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the phone number of the entry" +
        " you wish to delete");
        number = input.next();

        entryFound = entry.contains(number);
        if (entryFound.getNumber().equalsIgnoreCase(number)) {
            entry.delete(number);
            System.out.println("Entry succesfully deleted!");
        }
        else {
            System.out.println("Entry not found!");
        }
    }


    // CASE M METHOD, paramater: phonebookManager to use delete method
    public void caseM(phonebookManager entry) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the phone number of the entry" +
        " you wish to modify");
        number = input.next();

        entryFound = entry.contains(number);
        if (entryFound.getNumber().equalsIgnoreCase(number)) {
            modifyFirstName(entry, entryFound, number);
            modifyLastName(entry, entryFound, number);
            modifyAddress(entry, entryFound, number);
            modifyCity(entry, entryFound, number);
            modifyNumber(entry, entryFound, number);
            System.out.println("Successfully modified!");
        }
        else {
            System.out.println("Entry not found!");
        }
        }

    
    // CASE P METHOD
    public void caseP(phonebookManager entry) {
        entry.print();
    }



    // MODIFY METHODS
    // all modify methods uses phonebookManager class as a parameter,
    // to use use modify methods inside the phonebookManager class



    // MODIFY FIRST NAME METHOD,
    public void modifyFirstName(phonebookManager entry, listNode entryFound,
    String number) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the new first name: ");
        newFirstName = input.next();
        firstName = entryFound.getFirstName();
        entry.modifyFirstName(firstName, newFirstName, number);
    }


    // MODIFY LAST NAME METHOD
    public void modifyLastName(phonebookManager entry, listNode entryFound,
    String number) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the new last name: ");
        newLastName = input.next();
        lastName = entryFound.getLastName();
        entry.modifyLastName(lastName, newLastName, number);
    }


    // MODIFY ADDRESS METHOD
    public void modifyAddress(phonebookManager entry, listNode entryFound,
    String number) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the new address: ");
        newAddress = input.next();
        address = entryFound.getAddress();
        entry.modifyAddress(address, newAddress, number);
    }


    // MODIFY CITY METHOD
    public void modifyCity(phonebookManager entry, listNode entryFound,
    String number) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the new city: ");
        newCity = input.next();
        city = entryFound.getCity();
        entry.modifyCity(city, newCity, number);
    }


    // MODIFY NUMBER METHOD
    public void modifyNumber(phonebookManager entry, listNode entryFound,
    String number) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the new number: ");
        newNumber = input.next();
        city = entryFound.getCity();
        entry.modifyNumber(number, newNumber);
    }

} // end of class

