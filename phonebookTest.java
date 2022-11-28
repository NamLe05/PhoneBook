

// Programmer: Nam Le & James Chen
// Date: 10/20/22
// Class: CS 145
// Assignment: Phone Book
// Purpose: Create a phone book program that allows the user to
//          add, modify, delete, and print entries of names, addresses,
//          city, and phone number.
//          
// Extra Credit: Usage of Package, Switch/Case, User interface thats crash resistant,

package PhoneBook;

public class phonebookTest {

    public static void main (String[] args) {

        phonebookManager phonebook = new phonebookManager(null, null, null, null, null);
        menuManager menu = new menuManager(null, null, null, null, null);
        menu.mainMenu(phonebook);
    }       
} // end of class