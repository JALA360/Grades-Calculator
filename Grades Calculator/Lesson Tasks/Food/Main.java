import java.time.LocalDateTime;

// Base Class: FoodItem
class FoodItem {
    private int itemId;
    private String itemName;

    public FoodItem(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }
}

// Subclass: FreshFood extending FoodItem
class FreshFood extends FoodItem {
    private LocalDateTime bbe; // Best Before End
    private boolean eatRaw;
    private String storage; // How to store it?

    // Constructor for FreshFood
    public FreshFood(int itemId, String itemName, LocalDateTime bbe, boolean eatRaw, String storage) {
        super(itemId, itemName);
        this.bbe = bbe;
        this.eatRaw = eatRaw;
        this.storage = storage;
    }

    // Getter for bbe
    public LocalDateTime getBBE() {
        return bbe;
    }

    // Getter for eatRaw
    public boolean getEatRaw() {
        return eatRaw;
    }

    // Getter for storage
    public String getStorage() {
        return storage;
    }
}

// Subclass: FrozenFood extending FoodItem
class FrozenFood extends FoodItem {
    private LocalDateTime useBefore; // Use Before date
    private boolean eatRaw;
    private boolean mustDefrost;
    private int storage; // Storage temp

    // Constructor for FrozenFood
    public FrozenFood(int itemId, String itemName, LocalDateTime useBefore, boolean eatRaw, boolean mustDefrost, int storage) {
        super(itemId, itemName);
        this.useBefore = useBefore;
        this.eatRaw = eatRaw;
        this.mustDefrost = mustDefrost;
        this.storage = storage;
    }

    // Getter for useBefore
    public LocalDateTime getUseBefore() {
        return useBefore;
    }

    // Getter for eatRaw
    public boolean getEatRaw() {
        return eatRaw;
    }

    // Getter for mustDefrost
    public boolean getMustDefrost() {
        return mustDefrost;
    }

    // Getter for storage (could represent temperature in degrees)
    public int getStorage() {
        return storage;
    }
}

// Subclass: CannedFood extending FoodItem
class CannedFood extends FoodItem {
    private LocalDateTime expiryDate; // Expiry date
    private boolean needRefrigeration; // Does it need refrigeration after opening?

    // Constructor for CannedFood
    public CannedFood(int itemId, String itemName, LocalDateTime expiryDate, boolean needRefrigeration) {
        super(itemId, itemName);
        this.expiryDate = expiryDate;
        this.needRefrigeration = needRefrigeration;
    }

    // Getter for expiryDate
    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    // Getter for needRefrigeration
    public boolean getNeedRefrigeration() {
        return needRefrigeration;
    }
}

// Subclass: DryFood extending FoodItem
class DryFood extends FoodItem {
    private String storageConditions; // Storage conditions

    // Constructor for DryFood
    public DryFood(int itemId, String itemName, String storageConditions) {
        super(itemId, itemName);
        this.storageConditions = storageConditions;
    }

    // Getter for storageConditions
    public String getStorageConditions() {
        return storageConditions;
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        // Example of creating a FreshFood object
        FreshFood apple = new FreshFood(1, "Apple", LocalDateTime.now().plusDays(10), true, "Refrigerate");
        System.out.println("FreshFood: " + apple.getItemName() + ", BBE: " + apple.getBBE());

        // Example of creating a FrozenFood object
        FrozenFood pizza = new FrozenFood(2, "Pizza", LocalDateTime.now().plusMonths(6), false, true, -18);
        System.out.println("FrozenFood: " + pizza.getItemName() + ", Use Before: " + pizza.getUseBefore());

        // Create an instance of CannedFood
        CannedFood soup = new CannedFood(3, "Tomato Soup", LocalDateTime.now().plusYears(2), true);
        System.out.println("CannedFood: " + soup.getItemName() + ", Expiry Date: " + soup.getExpiryDate() + ", Needs Refrigeration After Opening: " + soup.getNeedRefrigeration());

        // Create an instance of DryFood
        DryFood rice = new DryFood(4, "Rice", "Store in a cool, dry place");
        System.out.println("DryFood: " + rice.getItemName() + ", Storage Conditions: " + rice.getStorageConditions());

        // Create additional instances of FreshFood and FrozenFood for more demonstration
        FreshFood freshFood = new FreshFood(5, "Fresh Carrots", LocalDateTime.now().plusDays(7), true, "Store in a cool place");
        FrozenFood frozenFood = new FrozenFood(6, "Frozen Chicken", LocalDateTime.now().plusMonths(4), false, true, -20);

        // Display information about FreshFood
        System.out.println("\nFresh Food Item:");
        System.out.println("Item ID: " + freshFood.getItemId());
        System.out.println("Item Name: " + freshFood.getItemName());
        System.out.println("Best Before End: " + freshFood.getBBE());
        System.out.println("Can Eat Raw: " + freshFood.getEatRaw());
        System.out.println("Storage Instructions: " + freshFood.getStorage());
        System.out.println();

        // Display information about FrozenFood
        System.out.println("Frozen Food Item:");
        System.out.println("Item ID: " + frozenFood.getItemId());
        System.out.println("Item Name: " + frozenFood.getItemName());
        System.out.println("Use Before: " + frozenFood.getUseBefore());
        System.out.println("Can Eat Raw: " + frozenFood.getEatRaw());
        System.out.println("Must Defrost: " + frozenFood.getMustDefrost());
        System.out.println("Storage Temperature: " + frozenFood.getStorage() + "°C");
        System.out.println();

        // Display information about CannedFood
        System.out.println("Canned Food Item:");
        System.out.println("Item ID: " + soup.getItemId());
        System.out.println("Item Name: " + soup.getItemName());
        System.out.println("Expiry Date: " + soup.getExpiryDate());
        System.out.println("Needs Refrigeration After Opening: " + soup.getNeedRefrigeration());
        System.out.println();

        // Display information about DryFood
        System.out.println("Dry Food Item:");
        System.out.println("Item ID: " + rice.getItemId());
        System.out.println("Item Name: " + rice.getItemName());
        System.out.println("Storage Conditions: " + rice.getStorageConditions());
    }
}