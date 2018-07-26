public class dimension {
    private int width;
    private int height;
    private int length;

    public dimension(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
}

public class Table {
    private String manufacturer;
    private dimension table_dimension;

    public Table(String manufacturer, dimension table_dimension) {
        this.manufacturer = manufacturer;
        this.table_dimension = table_dimension;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public dimension getTable_dimension() {
        return table_dimension;
    }

    private void move (int number){
        System.out.println("Move the table " + number + "steps");
    }

    public void table_move(int number){
        this.move(number);
        System.out.println("call private move in Table class....");
    }

}

public class Bed {
    private boolean pillow;
    private int id;

    public Bed(boolean pillow, int id) {
        this.pillow = pillow;
        this.id = id;
    }

    public void setPillow(){
        if (pillow = true){
            System.out.println("Has pillow already");
        } else{
            System.out.println("Need pillow");
        }
    }
    public boolean isPillow() {
        return pillow;
    }

    public int getId() {
        return id;
    }
}
public class Room {
    private Table table;
    private Bed bed;

    public Room(Table table, Bed bed) {
        this.table = table;
        this.bed = bed;
    }

    public Table getTable() {
        return table;
    }

    public Bed getBed() {
        return bed;
    }

    public void move (int number){
        System.out.println("move towards "+ number);
    }
}

public class Hello {


    public static void main(String[] args) {
        dimension table_dimension = new dimension(23,233,2333);
        Table xiaobin_table = new Table("IKEA",table_dimension);

        Bed xiaobin_bed = new Bed(false,666);

        Room xiaobin_room = new Room (xiaobin_table,xiaobin_bed);

        System.out.println("Xiao's Room : \n" +
                           "Table manufacturer :" + xiaobin_table.getManufacturer()+ "\n"+
                           "Table dimension : " + table_dimension.getHeight()+table_dimension.getLength()+table_dimension.getWidth()+"\n"+
                            "Pillow Id: "+ xiaobin_bed.getId());

        xiaobin_bed.setPillow();

        xiaobin_room.move(5);

        xiaobin_table.table_move(666);

        xiaobin_room.move(777);
