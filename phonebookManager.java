

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

// extends allows you to use listNode class's fields
public class phonebookManager extends listNode {

    private static int size;

    public phonebookManager(String firstName, String lastName,
     String address, String city, String number) {
        super(firstName, lastName, address, city, number);
    }

    // SIZE METHOD, returns size of the list node
    public int size() {
        size = 0;
        current = head;

        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }


    // GET METHOD, returns the current list node
    public listNode get(int index) throws NullPointerException {

        current = head;
        
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    // FIND ENTRY METHOD, finds the listnode that equals
    // the String, number, returns that listnode
    public listNode contains(String number) {

        listNode entryFound;
        current = head;
        while (current != null) {
            if (current.getNumber().equalsIgnoreCase(number)) {
                entryFound = current;
                return entryFound;
            }
            else if (current.next == null) {
                return current;
            }
            current = current.next;
        }
        return current;
    }
    
    
    // PRINT METHOD, prints all the listnode 
    // using get method
    public void print() {
        current = head;
        System.out.println();
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }
    

    // MODIFY METHODS


    // ADD METHOD, creates a new list node using the Strings from the parameter
    public void add(String firstName, String lastName, String address,
    String city, String number) {

        listNode node = new listNode(firstName, lastName, address, city, number);
        if (head == null) {
            head = node;
        }
        else {
            current = head;
            while (current.next != null 
            && node.getLastName().compareToIgnoreCase(current.next.getLastName()) >= 0 ) {
                current = current.next;
            } 
            if (current == head // replaces head with node shifting node list down.
            && node.getLastName().compareToIgnoreCase(current.getLastName()) <= 0) {
                node.next = head;
                head = node;
            }
            else {
                node.next = current.next; 
                current.next = node;
            }
        }
    } // end of add method


        
    // DELETE METHOD, finds the node equal to the number,
    // sets node to null, or skips over node
    public void delete(String number) throws NullPointerException {
        
        current = head;
        if (current.next == null) {
            head = null;
        }
        else if (current.next != null) {

            for (int i = 0; i < size(); i++) {
                current = get(i);
                if (current == head && current.getNumber().equalsIgnoreCase(number)) {
                    head = head.next;
                }
                else if (current.next == null && 
                current.getNumber().equalsIgnoreCase(number)) {
                    current = get(i-1);
                    current.next = null;
                }
                else if (current.getNumber().equalsIgnoreCase(number)) {
                    current = get(i-1);
                    current.next = current.next.next;
                }
            } // end of for loop
        } // end of else if
    }// end


        //MODIFY METHODS, sets the original value to new value


    //MODIFY LAST NAME
    public void modifyLastName(String lastName, String newLastName,
    String number) {
        current = head;
        while (current != null) {
            if (current.getLastName().equalsIgnoreCase(lastName) &&
            current.getNumber().equalsIgnoreCase(number)) {
                current.setLastName(newLastName);
            }
            current = current.next;
        }
    }

    //MODIFY FIRST NAME
    public void modifyFirstName(String firstName, String newFirstName,
    String number) {
        current = head;
        while (current != null) {
            if (current.getFirstName().equalsIgnoreCase(firstName) &&
            current.getNumber().equalsIgnoreCase(number)) {
                current.setFirstName(newFirstName);
            }
            current = current.next;
        }
    }

    //MODIFY ADDRESS
    public void modifyAddress(String address, String newAddress,
     String number) {
        
        current = head;
        while (current != null) {
            if (current.getAddress().equalsIgnoreCase(address) &&
            current.getNumber().equalsIgnoreCase(number)) {
                current.setAddress(newAddress);
            }
            current = current.next;
        }
    }

    //MODIFY CITY
    public void modifyCity(String city, String newCity, String number) {
        current = head;
        while (current != null) {
            if (current.getCity().equalsIgnoreCase(city) &&
            current.getNumber().equalsIgnoreCase(number)) {
                current.setCity(newCity);
            }
            current = current.next;
        }
    }

    //MODIFY NUMBER
    public void modifyNumber(String number, String newNumber) {
        current = head;
        while (current != null) {
            if (current.getNumber().equalsIgnoreCase(number)) {
                current.setNumber(newNumber);
            }
            current = current.next;
        }
    }
}// end of class

