// File: Pembayaran.java
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Pembayaran {
    public void PembayaranTransfer(Transaksi trx, Scanner scanner) {
        NumberFormat nf = NumberFormat.getInstance(new Locale("id", "ID"));
        System.out.println("Transfer ke BCA 123 a/n Wazgeming.Playstation sebesar Rp " + nf.format(trx.getHargaTotal()));
        System.out.println("Note: Nominal yang kelebihan tidak bisa dikembalikan!");
        System.out.print("Masukkan jumlah transfer : ");
        int bayar = scanner.nextInt();

        if (bayar < trx.getHargaTotal()) {
            System.out.println("Pembayaran gagal: jumlah kurang.");
            System.out.println("===============================================================");
        } else {
            System.out.println("===============================================================");
            System.out.println("Pembayaran berhasil. Terima kasih!");
            System.out.println("Pesanan anda sudah terkirim!");
            System.out.println("===============================================================");

        }
    }

    public void PembayaranCOD(Transaksi trx) {
        NumberFormat nf = NumberFormat.getInstance(new Locale("id", "ID"));
        System.out.println("Pesanan anda sudah terkirim!");
        System.out.println("Siapkan uang Rp " + nf.format(trx.getHargaTotal()) + " saat kurir tiba.");
        System.out.println("===============================================================");

    }
    
}