import java.util.Scanner;

public class MenuPemesanan {
    private Pembayaran pembayaran = new Pembayaran();

    public void Pemesanan(Scanner scanner) {
        boolean ulangTransaksi;
        do {
            System.out.println("\n======================= UNIT PLAYSTATION ======================");
            System.out.println("1. Playstation 3 (Rp.  60.000/Hari)");
            System.out.println("2. Playstation 4 (Rp. 100.000/Hari)");
            System.out.println("3. Playstation 5 (Rp. 300.000/Hari)");
            System.out.print("Pilihan : ");
            String unit = scanner.next();
            System.out.println("===============================================================");

            if (!unit.equals("1") && !unit.equals("2") && !unit.equals("3")) {
                System.out.println("Unit tidak tersedia.");
                ulangTransaksi = konfirmasiUlang(scanner);
                continue;
            }

            if (!CekStock.cekKetersediaan(unit)) {
                System.out.println("Unit sedang tidak tersedia.");
                ulangTransaksi = konfirmasiUlang(scanner);
                continue;
            }
            System.out.println("======================== SPECIAL DISKON =======================");
            System.out.println("(15%) Untuk penyewaan 3 hari dan seterusnya!");
            System.out.println("(25%) Untuk penyewaan 7 hari dan seterusnya!");
            System.out.println("===============================================================");

            System.out.print("Masukkan jumlah hari sewa   : ");
            int hariSewa = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Masukkan nama lengkap       : ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan alamat lengkap     : ");
            String alamat = scanner.nextLine();
            System.out.print("Masukkan No. Whatsapp aktif : ");
            String noWA = scanner.nextLine();

            Transaksi trx = new Transaksi(unit, hariSewa, nama, alamat, noWA);
            System.out.println("===============================================================");
            System.out.println("\n====================== RINCIAN TRANSAKSI ======================");
            trx.dataDiri();
            System.out.println("==============================================================");

            String konfirmasi = konfirmasiYorN(scanner, "Konfirmasi transaksi (y/t): ");
            if (!konfirmasi.equals("y")) {
                ulangTransaksi = konfirmasiUlang(scanner);
                continue;
            }

            System.out.println("\n======================= METODE PEMBAYARAN =====================");
            System.out.println("1. Transfer");
            System.out.println("2. COD");
            System.out.print("Pilihan : ");
            int pilBayar = scanner.nextInt();
            System.out.println("==============================================================");

            if      (pilBayar == 1) pembayaran.PembayaranTransfer(trx, scanner);
            else if (pilBayar == 2) pembayaran.PembayaranCOD(trx);
            else System.out.println("Metode tidak valid.");

            ulangTransaksi = konfirmasiUlang(scanner);
        } while (ulangTransaksi);
    }

    private boolean konfirmasiUlang(Scanner scanner) {
        String ulang = konfirmasiYorN(scanner, "\nIngin mengulangi transaksi? (y/t): ");
        return ulang.equals("y");
    }

    private String konfirmasiYorN(Scanner scanner, String prompt) {
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
