Aplikasi ini merupakan sistem pemesanan dan pengecekan unit Rental Playstation Harian berbasis Java. 

Berikut sedikit penjelasan mengenai aplikasi ini:

==Fitur Utama==

Pemesanan unit PS3, PS4, dan PS5 dengan tarif per hari.

Diskon otomatis:

-15% untuk penyewaan ≥ 3 hari

-25% untuk penyewaan ≥ 7 hari

Pilihan metode pembayaran: Transfer Bank dan Cash On Delivery (COD).

Pengecekan ketersediaan unit secara real-time.

Informasi penyewa disensor untuk menjaga privasi (nama dan nomor WhatsApp).

Sistem pengulangan (loop) jika pengguna ingin kembali ke menu utama atau mengulangi transaksi.



==Struktur Kode==

Index.java         — Kelas utama yang menampilkan menu dan menangani navigasi aplikasi.

MenuPemesanan.java — Mengatur proses pemesanan, pengisian data penyewa, dan pemilihan metode pembayaran.

Transaksi.java     — Menyimpan informasi transaksi, menghitung diskon dan total harga, serta tanggal selesai sewa.

Pembayaran.java    — Menangani logika pembayaran melalui transfer atau COD.

CekStock.java      — Menyimpan data penyewa aktif dan mengecek ketersediaan unit PS.

--Putra Islamy Pasha (11224044)--
