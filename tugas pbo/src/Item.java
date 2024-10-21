public class Item {
    private double itemPrice;
    private String itemName;
    private String itemCode;
    private int itemStock;

    // Default constructor
    public Item() {
        this.itemStock = 0; // Inisialisasi stok ke 0
    }

    public Item(String code, String name, double price, int stock) {
        this.itemCode = code;
        this.itemName = name;
        this.itemPrice = price;
        this.itemStock = stock; // Inisialisasi stok
    }

    public double getPrice() {
        return itemPrice;
    }

    public String getCode() {
        return itemCode;
    }

    public String getName() {
        return itemName;
    }

    public int getStock() {
        return itemStock;
    }

    public double calculateSubtotal(int quantity) {
        return itemPrice * quantity; // Menghitung subtotal
    }
}
