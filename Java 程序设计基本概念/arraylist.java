import java.util.Scanner;

/**
 * Created by acer on 1/3/2017.
 */
public class Hello {
    private static Scanner scanner  =  new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();//why mus be static ?

    public static void main (String [] args) {

        printtheInstrction();
        boolean quit = false;
        int choi = 0;

        while(!quit){
            System.out.println("Please Entry your Choice : ");
            choi = scanner.nextInt();
            scanner.nextLine();//this line is to clear the input buffer;

            switch (choi){
                case 0:
                    printtheInstrction();
                    break;

                case 1:
                    groceryList.print_grocery_list();
                    break;
                case 2:
                    addItems();
                    break;
                case 3:
                    modifyItems();
                    break;
                case 4:
                    removeItmes();
                    break;
                case 5:
                    serach_Items();
                    break;
                case 6:
                    ArraylistProcess();// copy the arraylist 
                case 7:
                    quit = true;
                    break;
            }
        }
    }
    public static void  printtheInstrction(){
        System.out.println("\n"+"Press");
        System.out.println("\t"+ "choice 0 Print out all the choices");
        System.out.println("\t"+ "Choice 1 for print Items");
        System.out.println("\t"+ "Choice 2 for add Items");
        System.out.println("\t"+ "Choice 3 for modify Items");
        System.out.println("\t"+ "Choice 4 for remove Items");
        System.out.println("\t"+ "Choice 5 for serach Items");
        System.out.println("\t"+ "Choice 6 for quit");
    }

    public static void addItems(){
        System.out.println("Please enter the items you wan to add...");
        groceryList.add_grocery_items(scanner.nextLine());
    }


    public static void modifyItems() {
        System.out.println(" Please enter the index of items");
        int item_index = scanner.nextInt();
        scanner.nextLine();
        System.out.println("please enter new items");
        String new_items = scanner.nextLine();
        groceryList.modify_grocer_list(item_index-1, new_items);
    }

    public static void removeItmes(){
        System.out.println(" Please enter the index of items that you wan to remove");
        int item_index = scanner.nextInt();
        groceryList.remove_grocery_list(item_index-1);
    }

    public static  void serach_Items(){
        System.out.println(" Please enter the items that you want to search");
        String serch_items =  scanner.nextLine();
        if(groceryList.find_Items(serch_items) != null){
            System.out.println("Found " +serch_items +" in your list");
        } else {
            System.out.println(serch_items+" is not in your list");
        }
    }

    public static void ArraylistProcess(){
        ArrayList<String> new_array = new ArrayList<>();
        new_array.addAll(groceryList.getGrocerylist());

        ArrayList<String> next_array = new ArrayList<>(groceryList.getGrocerylist());


        String [] myarray = new String[groceryList.getGrocerylist().size()];
        myarray = groceryList.getGrocerylist().toArray(myarray);
        //be careful that we build the getter first!!!
    }
}

import java.util.ArrayList;

/**
 * Created by acer on 6/3/2017.
 */
public class GroceryList {

    private ArrayList<String> grocerylist =  new ArrayList<>();//the reason has "()" :
    //array list is a class,it can has constrctor;
    //in this case , we are ging to calling an empty constrctor;

    public ArrayList<String> getGrocerylist() {
        return grocerylist;
    } // add get is easy for user to copy the array list;

    public void add_grocery_items (String itmes){
        grocerylist.add(itmes);//".add" is the function from arraylist class;
    }

    public void print_grocery_list (){
        System.out.println("You have " + grocerylist.size()+ "Items");

        for (int i=0;i < grocerylist.size(); i++){
            System.out.println((i+1)+ ". "+ grocerylist.get(i));
        }
    }

    public void modify_grocer_list(int position, String new_items){
        grocerylist.set(position,new_items);
        System.out.println("The Items in " + (position+1) + "has been modified as " + new_items);
    }

    public void  remove_grocery_list (int position){
        String theItems =  grocerylist.get(position);
        grocerylist.remove(position);
        System.out.println("The items "+ theItems + " has been deleted from grocery list");
    }

    public String find_Items (String serach_Items){
        //boolean extis =  grocerylist.contains(serach_Items);
        int position = grocerylist.indexOf(serach_Items);
        if (position >= 0){
            return grocerylist.get(position);
        }
        return  null;

       }
   }

