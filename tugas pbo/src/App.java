import java.util.Scanner;

public class App {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Tambah Barang");
            System.out.println("2. Tampilkan Item Transaksi");
            System.out.println("3. Tampilkan Total dan Pembayaran");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    String addCode = scanner.next();
                    System.out.print("Masukkan nama barang: ");
                    String addName = scanner.next();
                    System.out.print("Masukkan harga barang: ");
                    double addPrice = scanner.nextDouble();
                    System.out.print("Masukkan jumlah barang: ");
                    int quantity = scanner.nextInt();
                    cashier.addItem(addPrice, addCode, addName, quantity);
                    break;
                case 2:
                    cashier.displayItems();
                    break;
                case 3:
                    System.out.println("Total belanja: " + cashier.getTotalPrice());

                    System.out.print("Masukkan jumlah uang yang dibayar: ");
                    double payment = scanner.nextDouble();
                    double total = cashier.getTotalPrice();
                    if (payment >= total) {
                        double change = payment - total;
                        System.out.println("Kembali: " + change);
                        cashier.reset(); // Reset transaksi setelah pembayaran
                    } else {
                        System.out.println("Uang yang dibayar tidak cukup.");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan kode barang yang akan dihapus: ");
                    String removeCode = scanner.next();
                    cashier.removeItem(removeCode);
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem kasir kami!");
                    return;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }
}
