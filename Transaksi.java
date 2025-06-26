import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Transaksi {
    private String      nama, alamat, unit, noWA;
    private int         hariSewa, hargaSewa, hargaTotal, diskon;
    private LocalDate   tanggalSelesai;

    public Transaksi(String unit, int hariSewa, String nama, String alamat, String noWA) {
        this.hariSewa   = hariSewa;
        this.nama       = nama;
        this.alamat     = alamat;
        this.noWA       = noWA;

        if (unit.equals("1")) {
            this.unit = "Playstation 3";
            this.hargaSewa = 60000;
        } else if (unit.equals("2")) {
            this.unit = "Playstation 4";
            this.hargaSewa = 100000;
        } else {
            this.unit = "Playstation 5";
            this.hargaSewa = 300000;
        }

        this.diskon = (hariSewa >= 7) ? 25 : (hariSewa >= 3) ? 15 : 0;

        int hargaSebelumDiskon  = this.hargaSewa * hariSewa;
        this.hargaTotal         = hargaSebelumDiskon - (hargaSebelumDiskon * this.diskon / 100);
        this.tanggalSelesai     = LocalDate.now().plusDays(hariSewa);

        CekStock.tambahPenyewa(this);
    }

    public void dataDiri() {
        System.out.println("Nama         : " + this.nama);
        System.out.println("Alamat       : " + this.alamat);
        System.out.println("No. Whatsapp : " + this.noWA);
        System.out.println("Unit         : " + this.unit);
        System.out.println("Harga Rental : " + formatRupiah(this.hargaSewa));
        System.out.println("Jumlah Hari  : " + this.hariSewa);
        System.out.println("Diskon       : " + this.diskon + "%");
        System.out.println("Total Harga  : " + formatRupiah(this.hargaTotal));
    }

    private String formatRupiah(int amount) {
        Locale localeID = new Locale("id", "ID");
        NumberFormat formatRupiah = NumberFormat.getInstance(localeID);
        return "Rp. " + formatRupiah.format(amount);
    }

    public int          getHargaTotal()     { return hargaTotal; }
    public String       getUnit()           { return unit; }
    public LocalDate    getTanggalSelesai() { return tanggalSelesai; }
    public String       getNama()           { return nama; }
    public String       getNoWA()           { return noWA; }
}
