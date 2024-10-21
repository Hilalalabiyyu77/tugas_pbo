import java.util.ArrayList;

public class Cashier {
    private ArrayList<Item> items;
    private double totalPrice;

    public Cashier() {
        items = new ArrayList<>();
        totalPrice = 0.0;
    }

    public void addItem(double price, String code, String name, int quantity) {
        Item newItem = new Item(code, name, price, quantity);
        items.add(newItem);
        totalPrice += newItem.calculateSubtotal(quantity); // Tambah subtotal ke total
        System.out.println("Barang ditambahkan.");
    }

    public void removeItem(String code) {
        for (Item item : items) {
            if (item.getCode().equals(code)) {
                totalPrice -= item.calculateSubtotal(item.getStock()); // Kurangi total
                items.remove(item);
                System.out.println("Barang dihapus.");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    public void displayItems() {
        System.out.println("Daftar Item Transaksi:");
        System.out.printf("%-10s %-20s %-10s %-10s %-10s%n", "Kode", "Nama", "Harga", "Jumlah", "Subtotal");
        for (Item item : items) {
            double subtotal = item.calculateSubtotal(item.getStock());
            System.out.printf("%-10s %-20s %-10.2f %-10d %-10.2f%n", item.getCode(), item.getName(), item.getPrice(), item.getStock(), subtotal);
        }
        System.out.println("Total belanja: " + totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void reset() {
        items.clear();
        totalPrice = 0.0; // Reset total
    }
}
