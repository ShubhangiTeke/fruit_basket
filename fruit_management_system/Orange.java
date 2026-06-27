package fruit_management_system;

public class Orange extends Fruit {

    public Orange(String name, double weight, String color) {
        super(name, color, weight, true);
    }

    @Override
    public String taste() {
        return "Sour";
    }
}
