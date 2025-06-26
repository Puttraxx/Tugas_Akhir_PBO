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

            ulang = konfirmasiYorN(scanner, "\nIngin kembali ke menu utama? (y/t): ");
        } while (ulang.equals("y"));

        System.out.println("Terima kasih telah menggunakan layanan kami!");
        scanner.close();
    }

    private static String konfirmasiYorN(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.next().trim().toLowerCase();
            if (!input.equals("y") && !input.equals("t")) {
                System.out.println("Input tidak valid. Masukkan hanya 'y' atau 't'.");
            }
        } while (!input.equals("y") && !input.equals("t"));
        return input;
    }
}
