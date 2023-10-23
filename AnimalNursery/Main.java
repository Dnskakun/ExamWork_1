package AnimalNursery;

public class Main {
    public static void main(String[] args) {
        AnimalsDB animalsDB = new AnimalsDB();
        Menu menu = new Menu(animalsDB);
        menu.showMenu();
    }
}
