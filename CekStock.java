import java.time.LocalDate;
import java.util.ArrayList;

public class CekStock {
    private static ArrayList<Transaksi> listPenyewa = new ArrayList<>();

    public static void tambahPenyewa(Transaksi trx) {
        listPenyewa.add(trx);
    }

    public static boolean cekKetersediaan(String unit) {
        int total = unit.equals("1") ? 3 : unit.equals("2") ? 2 : 1;
        int sedangDisewa = 0;
        LocalDate hariIni = LocalDate.now();

        for (Transaksi t : listPenyewa) {
            if (getKodeUnit(t.getUnit()).equals(unit) && t.getTanggalSelesai().isAfter(hariIni)) {
                sedangDisewa++;
            }
        }
        return sedangDisewa < total;
    }

    public void showUnit() {
        System.out.println("\n================== Status Ketersediaan ===================");
        tampilUnit("1", "Playstation 3", 3);
        tampilUnit("2", "Playstation 4", 2);
        tampilUnit("3", "Playstation 5", 1);
        System.out.println("===============================================================");
        
    }

    private void tampilUnit(String kode, String nama, int total) {
        int disewa = 0;
        LocalDate hariIni = LocalDate.now();
        for (Transaksi t : listPenyewa) {
            if (getKodeUnit(t.getUnit()).equals(kode) && t.getTanggalSelesai().isAfter(hariIni)) {
                disewa++;
            }
        }
        System.out.println(nama + " | Tersedia: " + (total - disewa) + "/" + total);
    }

    private static String getKodeUnit(String namaUnit) {
        if (namaUnit.contains("3")) return "1";
        if (namaUnit.contains("4")) return "2";
        if (namaUnit.contains("5")) return "3";
        return "";
    }
} 
