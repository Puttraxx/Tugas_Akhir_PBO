import java.util.Scanner;

public class Index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuPemesanan menu = new MenuPemesanan();
        CekStock cekStock = new CekStock();

        System.out.println("======================= RENTAL PS HARIAN ======================");
        System.out.println("==================== @wazgeming.playstation ===================");

        String ulang;
        do {
            System.out.println("\n========================== MENU UTAMA =========================");
            System.out.println("1. Pesan Playstation");
            System.out.println("2. Cek Ketersediaan Unit");
            System.out.print("Pilihan : ");
            int pilMenu = scanner.nextInt();

            if (pilMenu == 1) {
                menu.Pemesanan(scanner);
            } else if (pilMenu == 2) {
                cekStock.showUnit();
            } else {
                System.out.println("Input tidak valid.");
            }

            System.out.print("\nIngin kembali ke menu utama? (y/n): ");
            ulang = scanner.next();
        } while (ulang.equalsIgnoreCase("y"));

        System.out.println("Terima kasih telah menggunakan layanan kami!");
        scanner.close();
    }
}
