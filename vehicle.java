abstract class vehicle {
    protected String name;
    protected int maxSpeed;

    vehicle(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public abstract void move();

    public void displayInfo() {
        System.out.println("Vehicle: " + name + ", Max Speed: " + maxSpeed);
    }

    public static void main(String[] args) {
        vehicle car = new Car("Sedan", 180);
        vehicle boat = new Boat("Yacht", 80);

        car.displayInfo();
        car.move();

        boat.displayInfo();
        boat.move();
    }
}

class Car extends vehicle {
    Car(String name, int maxSpeed) {
        super(name, maxSpeed);
    }

    public void move() {
        System.out.println("The car drives on roads.");
    }
}

class Boat extends vehicle {
    Boat(String name, int maxSpeed) {
        super(name, maxSpeed);
    }

    public void move() {
        System.out.println("The boat sails on water.");
    }
}
