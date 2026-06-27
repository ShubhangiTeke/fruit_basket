package fruit_management_system;

public class Mango extends Fruit {

    public Mango(String name, double weight, String color) {
        super(name, color, weight, true);
    }

    @Override
    public String taste() {
        return "Sweet";
    }
}