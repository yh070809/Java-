import java.util.ArrayList;

/**
 * Created by acer on 6/3/2017.
 */
class Mobilephone {

    private String my_number;
    private ArrayList<Contact> my_contacts ;

    public Mobilephone(String my_number) {
        this.my_number = my_number;
        this.my_contacts = new ArrayList<>();// we wan to star of a clean status;
    }

    public boolean add_new_contact (Contact contact){
        if (find_contact(contact.getName())>=0){
            System.out.println("Contact is already on the file");
            return false;
        } else {
            my_contacts.add(contact);
            return true;
        }
    }
    // this find contact index method set to private to keep others access and modify it ;
    private int find_contact(Contact contact){
        return this.my_contacts.indexOf(contact);
    }

    // then overload other method called the same name:
    private int find_contact (String contactname){
        for (int i=0; i < my_contacts.size();i++){
            Contact contact = my_contacts.get(i);
            if(contact.getName().equals(contactname)){
                return i;
            }
        }
        return -1;
    }

    public boolean update_contact (Contact old_contact, Contact new_contact){
        int findposition = find_contact(old_contact);
        if (findposition < 0 ){
            System.out.println(old_contact.getName()+ " Not Found");
            return false;
        }
        this.my_contacts.set(findposition,new_contact);
        System.out.println("Your new COntact " + new_contact.getName()+ "has been updated");
        return true;
    }


    public String query_contact (Contact contact){
        if (find_contact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }

    public Contact querContacct (String name){
        int position = find_contact(name);
        if (position >= 0){
            return this.my_contacts.get(position);
        }

        return null;
    }

    public boolean remove_contact(Contact contact){
        int findposition = find_contact(contact);
        if (findposition < 0 ){
            System.out.println(contact.getName()+ " Not Found");
            return false;
        }
        this.my_contacts.remove(findposition);
        System.out.println(contact.getName()+" has been deleted");
        return true;
    }

    public void print_contacts(){
        System.out.println("Conatct List");
        for (int i =0; i < my_contacts.size();i++){
            System.out.println((i+1) +"i"+ this.my_contacts.get(i).getName()+ "  " + this.my_contacts.get(i).getContactNumber());
            //System.out.println((i+1) +"i"+ this.my_contacts.get(i));
        }
    }
}
/**
 * Created by acer on 6/3/2017.
 */
 class Contact {
    private String name;
    private String ContactNumber;

    public Contact(String name, String contactNumber) {
        this.name = name;
        ContactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public static Contact CreatContact (String name , String contactnumber){
        return  new Contact(name,contactnumber);
    }
}

import java.util.Scanner;

/**
 * Created by acer on 1/3/2017.
 */
public class Hello {

    private static Scanner scanner = new Scanner(System.in);
    private static Mobilephone myphone = new Mobilephone("1234 5678");

    public static void main (String [] args){
        boolean quit = false;
        startphone();
        printaction();
        while(!quit){
            System.out.println("\n" +"Enter your choice");
            int action =scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Shutting down...");
                    quit =true;
                    break;
                case  1:
                   myphone.print_contacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printaction();
                    break;

            }
        }

    }

    private static void addNewContact(){
        System.out.println("Enter new contact name ....");
        String name = scanner.nextLine();
        System.out.println("Enter phone number...");
        String phone =scanner.nextLine();
        Contact newContact  = Contact.CreatContact(name,phone);
        if (myphone.add_new_contact(newContact)){
            System.out.println(name +" new Contact has been added");
        }else {
            System.out.println("Can not add " + name + " already exist");
        }
    }

    private static void updateContact(){
        System.out.println("Please enter the contact person name ...");
        String name  = scanner.nextLine();
        Contact exsistingContact = myphone.querContacct(name);
        if (exsistingContact ==null){
            System.out.println("Contact can not found ");
            return;
        }
        System.out.println("Enter new name ....");
        String newname  = scanner.nextLine();
        System.out.println("Enter new number ....");
        String new_number = scanner.nextLine();

        Contact new_contact = Contact.CreatContact(newname,new_number);
        if(myphone.update_contact(exsistingContact,new_contact)){
            System.out.println("Successfully update ");
        }else {
            System.out.println("Fail to update ......");
        }
    }

    private static void removeContact() {
        System.out.println("Please enter the contact person name ...");
        String name = scanner.nextLine();
        Contact exsistingContact = myphone.querContacct(name);
        if (exsistingContact == null) {
            System.out.println("Contact can not found ");
            return;
        }
        if (myphone.remove_contact(exsistingContact)){
            System.out.println("successfully remove.....");
        }else{
            System.out.println("Failed to remove ....");
        }
    }

    private static void queryContact() {
        System.out.println("Please enter the contact person name ...");
        String name = scanner.nextLine();
        Contact exsistingContact = myphone.querContacct(name);
        if (exsistingContact == null) {
            System.out.println("Contact can not found ");
            return;
        }
        System.out.println("Contact name: " + exsistingContact.getName()+ "  phonenumber : " + exsistingContact.getContactNumber() );
    }



    private static void startphone(){
        System.out.println("Phone Starting ....");
    }

    private static void printaction(){
        System.out.println("\n"+"Press");
        System.out.println("\n" + "0 -- shut down"
                           + "\n" +"1 -- print contact "
                           + "\n" + "2 -- add contact"
                           + "\n" + "3 -- update exsiting contact"
                           + "\n" + "4 -- remove exsiting contact"
                           + "\n" + "5 -- enqury exsiting contact"
                           + "\n" + "6 -- print action");
    }

}