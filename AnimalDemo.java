
abstract class Animals {
    // Common features shared by all animals
    protected String speciesName;
    protected double typicalSize;    // Size in meters
    protected double typicalWeight;  // Weight in kilograms
    protected boolean predator;
    protected String habitat;

    // Constructor
    public Animals(String speciesName, double typicalSize,
                   double typicalWeight, boolean predator,
                   String habitat) {
        this.speciesName = speciesName;
        this.typicalSize = typicalSize;
        this.typicalWeight = typicalWeight;
        this.predator = predator;
        this.habitat = habitat;
    }

    // Common method
    public void displayInfo() {
        System.out.println("Species: " + speciesName);
        System.out.println("Typical Size: " + typicalSize + " meters");
        System.out.println("Typical Weight: " + typicalWeight + " kg");
        System.out.println("Diet: " + (predator ? "Predator" : "Vegetarian"));
        System.out.println("Habitat: " + habitat);
    }

    // Abstract method implemented by subclasses
    public abstract void makeSound();
}

// Bird class inherits from Animals
class Bird extends Animals {
    private double wingspan; // In meters
    private boolean canFly;

    public Bird(String speciesName, double typicalSize,
                double typicalWeight, boolean predator,
                String habitat, double wingspan, boolean canFly) {
        super(speciesName, typicalSize, typicalWeight, predator, habitat);
        this.wingspan = wingspan;
        this.canFly = canFly;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Bird Information ===");
        super.displayInfo();
        System.out.println("Wingspan: " + wingspan + " meters");
        System.out.println("Can Fly: " + canFly);
    }

    @Override
    public void makeSound() {
        System.out.println(speciesName + " makes a bird call.");
    }
}

// LandAnimal class inherits from Animals
class LandAnimal extends Animals {
    private int numberOfLegs;
    private boolean vegetarian;

    public LandAnimal(String speciesName, double typicalSize,
                      double typicalWeight, boolean predator,
                      String habitat, int numberOfLegs,
                      boolean vegetarian) {
        super(speciesName, typicalSize, typicalWeight, predator, habitat);
        this.numberOfLegs = numberOfLegs;
        this.vegetarian = vegetarian;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Land Animal Information ===");
        super.displayInfo();
        System.out.println("Number of Legs: " + numberOfLegs);
        System.out.println("Vegetarian: " + vegetarian);
    }

    @Override
    public void makeSound() {
        System.out.println(speciesName + " makes a land animal sound.");
    }
}

// Fish class inherits from Animals
class Fish extends Animals {
    private int numberOfFins;
    private boolean freshwater;

    public Fish(String speciesName, double typicalSize,
                double typicalWeight, boolean predator,
                String habitat, int numberOfFins,
                boolean freshwater) {
        super(speciesName, typicalSize, typicalWeight, predator, habitat);
        this.numberOfFins = numberOfFins;
        this.freshwater = freshwater;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Fish Information ===");
        super.displayInfo();
        System.out.println("Number of Fins: " + numberOfFins);
        System.out.println("Freshwater: " + freshwater);
    }

    @Override
    public void makeSound() {
        System.out.println(speciesName + " makes no typical audible call.");
    }
}

// Main class
public class AnimalDemo {
    public static void main(String[] args) {
        // Create different animal objects
        Animals bird = new Bird(
                "Eagle", 0.9, 5.0, true,
                "Mountains", 2.1, true
        );

        Animals landAnimal = new LandAnimal(
                "Elephant", 3.0, 5000.0, false,
                "Grasslands", 4, true
        );

        Animals fish = new Fish(
                "Salmon", 0.8, 4.5, true,
                "Rivers and oceans", 8, false
        );

        // Store different subclasses in an Animals array
        Animals[] animals = {bird, landAnimal, fish};

        // Demonstrate polymorphism
        for (Animals animal : animals) {
            animal.displayInfo();
            animal.makeSound();
            System.out.println();
        }
    }
}
