/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package View;

/**
 *
 * @author Lenovo
 */

public class MenuView {

    // ==========================================
    // MENU UTAMA
    // ==========================================

    public void tampilkanMenuUtama() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("       SISTEM JASA TITIP LUAR NEGERI");
        System.out.println("==========================================");
        System.out.println("1. Tambah Pesanan");
        System.out.println("2. Lihat Pesanan");
        System.out.println("3. Ubah Pesanan");
        System.out.println("4. Hapus Pesanan");
        System.out.println("5. Lihat Struk");
        System.out.println("6. Ubah Status");
        System.out.println("7. Ringkasan Pesanan");
        System.out.println("8. Batch Jastip");
        System.out.println("9. Keluar");
        System.out.println("==========================================");
    }

    // ==========================================
    // MENU JENIS JASTIP
    // ==========================================

    public void tampilkanMenuJenisJastip() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("             JENIS JASTIP");
        System.out.println("==========================================");
        System.out.println("1. Jastip Fashion");
        System.out.println("2. Jastip Skincare");
        System.out.println("3. Jastip Elektronik");
        System.out.println("==========================================");
    }

    // ==========================================
    // MENU LIHAT PESANAN
    // ==========================================

    public void tampilkanMenuLihatPesanan() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("              LIHAT PESANAN");
        System.out.println("==========================================");
        System.out.println("1. Semua Pesanan");
        System.out.println("2. Jastip Fashion");
        System.out.println("3. Jastip Skincare");
        System.out.println("4. Jastip Elektronik");
        System.out.println("5. Berdasarkan Status");
        System.out.println("6. Cari Pesanan");
        System.out.println("7. Riwayat Status");
        System.out.println("8. Kembali");
        System.out.println("==========================================");
    }

    // ==========================================
    // MENU SETELAH TAMBAH PESANAN
    // ==========================================

    public void tampilkanMenuSetelahTambah() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("         PESANAN BERHASIL DIBUAT");
        System.out.println("==========================================");
        System.out.println("1. Lihat Detail Pesanan");
        System.out.println("2. Cetak Struk");
        System.out.println("3. Kembali ke Menu Utama");
        System.out.println("==========================================");
    }

    // ==========================================
    // MENU METODE PEMBAYARAN
    // ==========================================

    public void tampilkanMenuPembayaran() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("           METODE PEMBAYARAN");
        System.out.println("==========================================");
        System.out.println("1. Transfer Bank");
        System.out.println("2. E-Wallet");
        System.out.println("==========================================");
    }

    // ==========================================
    // MENU STATUS
    // ==========================================

    public void tampilkanMenuStatus() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("             STATUS PESANAN");
        System.out.println("==========================================");
        System.out.println("1. Menunggu Pembayaran");
        System.out.println("2. Pembayaran Berhasil");
        System.out.println("3. Sedang Dibeli");
        System.out.println("4. Dalam Pengiriman");
        System.out.println("5. Pesanan Selesai");
        System.out.println("==========================================");
    }

    // ==========================================
    // MENU BATCH
    // ==========================================

    public void tampilkanMenuBatch() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("              BATCH JASTIP");
        System.out.println("==========================================");
        System.out.println("1. Lihat Semua Batch");
        System.out.println("2. Cari Batch");
        System.out.println("3. Tambah Batch");
        System.out.println("4. Kembali");
        System.out.println("==========================================");
    }

    // ==========================================
    // PESAN BERHASIL
    // ==========================================

    public void tampilkanPesanBerhasil(String pesan) {

        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println(pesan);
        System.out.println("------------------------------------------");
    }

    // ==========================================
    // PESAN ERROR
    // ==========================================

    public void tampilkanPesanError(String pesan) {

        System.out.println();
        System.out.println("!!! " + pesan + " !!!");
    }

    // ==========================================
    // PESAN KEMBALI
    // ==========================================

    public void tampilkanPesanKembali() {

        System.out.println();
        System.out.println("Kembali ke menu utama...");
    }

    // ==========================================
    // PROGRAM SELESAI
    // ==========================================

    public void tampilkanProgramSelesai() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("       PROGRAM SELESAI");
        System.out.println("   Terima kasih telah menggunakan");
        System.out.println("    Sistem Jasa Titip Luar Negeri");
        System.out.println("==========================================");
    }
}