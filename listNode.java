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

public class listNode {
    
    protected listNode head;
    protected listNode next;
    protected listNode current;
    protected String firstName;
    protected String lastName;
    protected String number;
    protected String city;
    protected String address;

    // constructor method
    public listNode(String firstName, String lastName, String address, 
    String city, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.number = number;
    } // end of ListNode constructor


    // TO STRING METHOD
    public String toString() {
        return "| "+ lastName + " " + firstName + " ---- " +
        address + ", " + city + " ---- " + number + " |";

    }

    
    // GET METHODS
    public String getLastName(){
        return this.lastName;
    }
    
    public String getFirstName(){
        return this.firstName;
    }

    public String getAddress(){
        return this.address;
    }

    public String getCity(){
        return this.city;
    }

    public String getNumber(){
        return this.number;
    }


    // SET METHODS
    public void setLastName(String setLastName) {
        this.lastName = setLastName;
    }

    public void setFirstName(String setFirstName) {
        this.firstName = setFirstName;
    }

    public void setAddress(String setAddress) {
        this.address = setAddress;
    }

    public void setCity(String setCity) {
        this.city = setCity;
    }

    public void setNumber(String number) {
        this.number = number;
    }

} // end of class
