/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java
 */
package Main;

import Controller.PesananController;
import DAO.PelangganHibernateDAO;

import Model.BatchJastip;
import Model.Barang;
import Model.BisaDivalidasi;
import Model.JastipFashion;
import Model.JastipSkincare;
import Model.JastipElektronik;
import Model.Pelanggan;
import Model.Pembayaran;
import Model.PesananJastip;

import View.BatchView;
import View.MenuView;
import View.PesananView;
import View.ValidasiInput;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class SistemJastip_Minpro4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PesananController controller =
                new PesananController();

        MenuView menuView =
                new MenuView();

        PesananView pesananView =
                new PesananView();

        BatchView batchView =
                new BatchView();

        ValidasiInput input =
                new ValidasiInput(scanner);

        // ==========================================
        // DEMONSTRASI HIBERNATE ORM
        // ==========================================

        tampilkanDataPelangganORM();

        boolean berjalan = true;

        while (berjalan) {

            menuView.tampilkanMenuUtama();

            System.out.println(
                    "Ketik 0 untuk keluar dari program."
            );

            int pilihan =
                    input.inputInteger(
                            "Pilih menu: ",
                            0,
                            9
                    );

            switch (pilihan) {

                case 0:
                case 9:
                    berjalan = false;
                    menuView.tampilkanProgramSelesai();
                    break;

                case 1:
                    tambahPesanan(
                            controller,
                            input,
                            menuView,
                            pesananView
                    );
                    break;

                case 2:
                    lihatPesanan(
                            controller,
                            input,
                            menuView,
                            pesananView
                    );
                    break;

                case 3:
                    ubahPesanan(
                            controller,
                            input,
                            pesananView
                    );
                    break;

                case 4:
                    hapusPesanan(
                            controller,
                            input,
                            pesananView
                    );
                    break;

                case 5:
                    lihatStruk(
                            controller,
                            input
                    );
                    break;

                case 6:
                    ubahStatus(
                            controller,
                            input,
                            menuView
                    );
                    break;

                case 7:
                    controller.tampilkanRingkasan();
                    break;

                case 8:
                    kelolaBatch(
                            controller,
                            input,
                            menuView,
                            batchView
                    );
                    break;

                default:
                    menuView.tampilkanPesanError(
                            "Pilihan tidak tersedia"
                    );
            }
        }

        scanner.close();
    }

    // ==================================================
    // DEMONSTRASI HIBERNATE ORM
    // ==================================================

    public static void tampilkanDataPelangganORM() {

        PelangganHibernateDAO pelangganDAO =
                new PelangganHibernateDAO();

        ArrayList<Pelanggan> daftarPelanggan =
                new ArrayList<>(
                        pelangganDAO.getAllPelanggan()
                );

        System.out.println();
        System.out.println("==========================================");
        System.out.println("       DATA PELANGGAN - HIBERNATE ORM");
        System.out.println("==========================================");

        if (daftarPelanggan.isEmpty()) {

            System.out.println(
                    "Belum ada data pelanggan."
            );

        } else {

            for (Pelanggan pelanggan :
                    daftarPelanggan) {

                System.out.println(
                        "ID Pelanggan : "
                        + pelanggan.getIdPelanggan()
                );

                System.out.println(
                        "Nama         : "
                        + pelanggan.getNamaPelanggan()
                );

                System.out.println(
                        "No. Telepon  : "
                        + pelanggan.getNomorTelepon()
                );

                System.out.println("------------------------------------------");
            }
        }

        System.out.println(
                "Data di atas dibaca menggunakan Hibernate ORM."
        );

        System.out.println("==========================================");
        System.out.println();
    }

    // ==================================================
    // TAMBAH PESANAN
    // ==================================================

    public static void tambahPesanan(
            PesananController controller,
            ValidasiInput input,
            MenuView menuView,
            PesananView pesananView) {

        menuView.tampilkanMenuJenisJastip();

        System.out.println(
                "Ketik 0 untuk membatalkan proses."
        );

        int jenis =
                input.inputIntegerBisaBatal(
                        "Pilih jenis: ",
                        1,
                        3
                );

        if (jenis == 0) {
            System.out.println(
                    "Penambahan pesanan dibatalkan."
            );
            return;
        }

        // ----------------------------------------------
        // PILIH BATCH
        // ----------------------------------------------

        System.out.println();
        System.out.println("==========================================");
        System.out.println("             PILIH BATCH JASTIP");
        System.out.println("==========================================");

        ArrayList<BatchJastip> daftarBatch =
                controller.getDaftarBatch();

        ArrayList<BatchJastip> batchTerbuka =
                new ArrayList<>();

        for (BatchJastip batch : daftarBatch) {

            if (batch.getStatusBatch()
                    .equalsIgnoreCase("Dibuka")) {

                batchTerbuka.add(batch);

                System.out.println(
                        (batchTerbuka.size())
                        + ". "
                        + batch.getIdBatch()
                        + " - "
                        + batch.getNegaraTujuan()
                        + " | Berangkat: "
                        + batch.getTanggalBerangkat()
                );
            }
        }

        if (batchTerbuka.isEmpty()) {

            System.out.println(
                    "Tidak ada batch yang sedang dibuka."
            );

            return;
        }

        System.out.println(
                "=========================================="
        );

        int pilihanBatch =
                input.inputIntegerBisaBatal(
                        "Pilih batch: ",
                        1,
                        batchTerbuka.size()
                );

        if (pilihanBatch == 0) {
            System.out.println(
                    "Penambahan pesanan dibatalkan."
            );
            return;
        }

        BatchJastip batchDipilih =
                batchTerbuka.get(
                        pilihanBatch - 1
                );

        // ----------------------------------------------
        // ID OTOMATIS
        // ----------------------------------------------

        String idPelanggan =
                controller.generateIdPelanggan();

        String idPesanan;

        if (jenis == 1) {

            idPesanan =
                    controller.generateIdFashion();

        } else if (jenis == 2) {

            idPesanan =
                    controller.generateIdSkincare();

        } else {

            idPesanan =
                    controller.generateIdElektronik();
        }

        // ----------------------------------------------
        // DATA PELANGGAN
        // ----------------------------------------------

        System.out.println();
        System.out.println("==========================================");
        System.out.println("             DATA PELANGGAN");
        System.out.println("==========================================");

        System.out.println(
                "ID Pelanggan : "
                + idPelanggan
        );

        String namaPelanggan =
                input.inputNamaBisaBatal(
                        "Nama pelanggan: "
                );

        if (namaPelanggan == null) {
            System.out.println(
                    "Penambahan pesanan dibatalkan."
            );
            return;
        }

        String nomorTelepon =
                input.inputNomorTeleponBisaBatal(
                        "Nomor telepon: "
                );

        if (nomorTelepon == null) {
            System.out.println(
                    "Penambahan pesanan dibatalkan."
            );
            return;
        }

        Pelanggan pelanggan =
                new Pelanggan(
                        idPelanggan,
                        namaPelanggan,
                        nomorTelepon
                );

        // ----------------------------------------------
        // DATA BARANG
        // ----------------------------------------------

        System.out.println();
        System.out.println("==========================================");
        System.out.println("               DATA BARANG");
        System.out.println("==========================================");

        String namaBarang =
                input.inputStringBisaBatal(
                        "Nama barang: "
                );

        if (namaBarang == null) {
            System.out.println(
                    "Penambahan pesanan dibatalkan."
            );
            return;
        }

        double harga =
                input.inputDoubleBisaBatal(
                        "Harga barang: ",
                        1,
                        1000000000
                );

        if (harga == 0) {
            System.out.println(
                    "Penambahan pesanan dibatalkan."
            );
            return;
        }

        double berat =
                input.inputDoubleBisaBatal(
                        "Berat barang (kg): ",
                        0.1,
                        1000
                );

        if (berat == 0) {
            System.out.println(
                    "Penambahan pesanan dibatalkan."
            );
            return;
        }

        Barang barang =
                new Barang(
                        namaBarang,
                        batchDipilih.getNegaraTujuan(),
                        harga,
                        berat
                );

        int jumlah =
                input.inputIntegerBisaBatal(
                        "Jumlah barang: ",
                        1,
                        100
                );

        if (jumlah == 0) {
            System.out.println(
                    "Penambahan pesanan dibatalkan."
            );
            return;
        }

        String requestKhusus =
                input.inputStringBisaBatal(
                        "Request khusus: "
                );

        if (requestKhusus == null) {
            System.out.println(
                    "Penambahan pesanan dibatalkan."
            );
            return;
        }

        // ----------------------------------------------
        // PEMBAYARAN
        // ----------------------------------------------

        menuView.tampilkanMenuPembayaran();

        int pilihanPembayaran =
                input.inputIntegerBisaBatal(
                        "Pilih metode pembayaran: ",
                        1,
                        2
                );

        if (pilihanPembayaran == 0) {
            System.out.println(
                    "Penambahan pesanan dibatalkan."
            );
            return;
        }

        String metodePembayaran;

        if (pilihanPembayaran == 1) {

            metodePembayaran =
                    "Transfer Bank";

        } else {

            metodePembayaran =
                    "E-Wallet";
        }

        Pembayaran pembayaran =
                new Pembayaran(
                        metodePembayaran
                );

        // ----------------------------------------------
        // DATA JASTIP
        // ----------------------------------------------

        double biayaJastip;

        PesananJastip pesanan;

        if (jenis == 1) {

            // ==========================================
            // FASHION
            // ==========================================

            String ukuran =
                    input.inputStringBisaBatal(
                            "Ukuran fashion: "
                    );

            if (ukuran == null) {
                System.out.println(
                        "Penambahan pesanan dibatalkan."
                );
                return;
            }

            String warna =
                    input.inputStringBisaBatal(
                            "Warna fashion: "
                    );

            if (warna == null) {
                System.out.println(
                        "Penambahan pesanan dibatalkan."
                );
                return;
            }

            biayaJastip = 100000;

            JastipFashion fashion =
                    new JastipFashion(
                            idPesanan,
                            pelanggan,
                            barang,
                            jumlah,
                            pembayaran,
                            "Menunggu Pembayaran",
                            biayaJastip,
                            batchDipilih,
                            requestKhusus,
                            ukuran,
                            warna
                    );

            pesanan = fashion;

        } else if (jenis == 2) {

            // ==========================================
            // SKINCARE
            // ==========================================

            String jenisKulit =
                    input.inputStringBisaBatal(
                            "Jenis kulit: "
                    );

            if (jenisKulit == null) {
                System.out.println(
                        "Penambahan pesanan dibatalkan."
                );
                return;
            }

            int ukuranProduk =
                    input.inputIntegerBisaBatal(
                            "Ukuran produk (ml): ",
                            1,
                            5000
                    );

            if (ukuranProduk == 0) {
                System.out.println(
                        "Penambahan pesanan dibatalkan."
                );
                return;
            }

            biayaJastip = 50000;

            JastipSkincare skincare =
                    new JastipSkincare(
                            idPesanan,
                            pelanggan,
                            barang,
                            jumlah,
                            pembayaran,
                            "Menunggu Pembayaran",
                            biayaJastip,
                            batchDipilih,
                            requestKhusus,
                            jenisKulit,
                            ukuranProduk
                    );

            pesanan = skincare;

        } else {

            // ==========================================
            // ELEKTRONIK
            // ==========================================

            String merek =
                    input.inputStringBisaBatal(
                            "Merek elektronik: "
                    );

            if (merek == null) {
                System.out.println(
                        "Penambahan pesanan dibatalkan."
                );
                return;
            }

            /*
             * Garansi tetap menggunakan inputInteger biasa
             * karena nilai 0 merupakan data yang valid.
             */
            int garansi =
                    input.inputInteger(
                            "Garansi (bulan): ",
                            0,
                            120
                    );

            biayaJastip = 75000;

            JastipElektronik elektronik =
                    new JastipElektronik(
                            idPesanan,
                            pelanggan,
                            barang,
                            jumlah,
                            pembayaran,
                            "Menunggu Pembayaran",
                            biayaJastip,
                            batchDipilih,
                            requestKhusus,
                            merek,
                            garansi
                    );

            pesanan = elektronik;
        }

        // ----------------------------------------------
        // HITUNG TOTAL
        // ----------------------------------------------

        double subtotal =
                pesanan.hitungTotal();

        double totalPembayaran =
                pesanan.hitungTotal(
                        biayaJastip
                );

        // ----------------------------------------------
        // TAMPILKAN HASIL PERHITUNGAN
        // ----------------------------------------------

        System.out.println();
        System.out.println("==========================================");
        System.out.println("          RINGKASAN PEMBAYARAN");
        System.out.println("==========================================");

        System.out.println(
                "Subtotal barang : Rp "
                + String.format(
                        "%,.0f",
                        subtotal
                )
        );

        System.out.println(
                "Biaya jastip    : Rp "
                + String.format(
                        "%,.0f",
                        biayaJastip
                )
        );

        System.out.println("------------------------------------------");

        System.out.println(
                "Total pembayaran: Rp "
                + String.format(
                        "%,.0f",
                        totalPembayaran
                )
        );

        System.out.println("==========================================");

        // ----------------------------------------------
        // VALIDASI DETAIL PESANAN
        // ----------------------------------------------

        BisaDivalidasi validasi =
                (BisaDivalidasi) pesanan;

        if (!validasi.validasiDetailPesanan()) {

            menuView.tampilkanPesanError(
                    "Detail pesanan tidak valid."
            );

            return;
        }

        // ----------------------------------------------
        // SIMPAN PESANAN
        // ----------------------------------------------

        boolean berhasil =
                controller.tambahPesanan(
                        pesanan
                );

        if (berhasil) {

            menuView.tampilkanPesanBerhasil(
                    "Pesanan berhasil dibuat dengan ID "
                    + pesanan.getIdPesanan()
            );

        } else {

            menuView.tampilkanPesanError(
                    "Pesanan gagal disimpan ke database."
            );

            return;
        }

        // ----------------------------------------------
        // MENU SETELAH TAMBAH
        // ----------------------------------------------

        boolean kembali = false;

        while (!kembali) {

            menuView.tampilkanMenuSetelahTambah();

            int pilihan =
                    input.inputIntegerBisaBatal(
                            "Pilih menu: ",
                            1,
                            3
                    );

            if (pilihan == 0) {
                kembali = true;
                continue;
            }

            switch (pilihan) {

                case 1:

                    pesananView.tampilkanDataPesanan(
                            pesanan
                    );

                    break;

                case 2:

                    pesananView.tampilkanStruk(
                            pesanan
                    );

                    break;

                case 3:

                    kembali = true;
                    break;
            }
        }
    }

    // ==================================================
    // LIHAT PESANAN
    // ==================================================

    public static void lihatPesanan(
            PesananController controller,
            ValidasiInput input,
            MenuView menuView,
            PesananView pesananView) {

        boolean kembali = false;

        while (!kembali) {

            menuView.tampilkanMenuLihatPesanan();

            int pilihan =
                    input.inputIntegerBisaBatal(
                            "Pilih menu: ",
                            1,
                            8
                    );

            if (pilihan == 0) {
                kembali = true;
                continue;
            }

            switch (pilihan) {

                case 1:

                    controller.tampilkanPesanan();
                    break;

                case 2:

                    controller.tampilkanPesananFashion();
                    break;

                case 3:

                    controller.tampilkanPesananSkincare();
                    break;

                case 4:

                    controller.tampilkanPesananElektronik();
                    break;

                case 5:

                    menuView.tampilkanMenuStatus();

                    int pilihanStatus =
                            input.inputIntegerBisaBatal(
                                    "Pilih status: ",
                                    1,
                                    5
                            );

                    if (pilihanStatus == 0) {
                        break;
                    }

                    String status =
                            getStatus(
                                    pilihanStatus
                            );

                    controller
                            .tampilkanPesananBerdasarkanStatus(
                                    status
                            );

                    break;

                case 6:

                    cariPesanan(
                            controller,
                            input,
                            pesananView
                    );

                    break;

                case 7:

                    String idRiwayat =
                            input.inputStringBisaBatal(
                                    "Masukkan ID pesanan: "
                            );

                    if (idRiwayat == null) {
                        break;
                    }

                    controller
                            .tampilkanRiwayatStatus(
                                    idRiwayat
                            );

                    break;

                case 8:

                    kembali = true;
                    break;
            }
        }
    }

    // ==================================================
    // CARI PESANAN
    // ==================================================

    public static void cariPesanan(
            PesananController controller,
            ValidasiInput input,
            PesananView pesananView) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("             CARI PESANAN");
        System.out.println("==========================================");
        System.out.println("1. Cari berdasarkan ID");
        System.out.println("2. Cari berdasarkan nama pelanggan");
        System.out.println("==========================================");

        int pilihan =
                input.inputIntegerBisaBatal(
                        "Pilih metode pencarian: ",
                        1,
                        2
                );

        if (pilihan == 0) {
            return;
        }

        if (pilihan == 1) {

            String id =
                    input.inputStringBisaBatal(
                            "Masukkan ID pesanan: "
                    );

            if (id == null) {
                return;
            }

            PesananJastip pesanan =
                    controller.cariPesanan(id);

            if (pesanan == null) {

                System.out.println();
                System.out.println(
                        "Pesanan tidak ditemukan."
                );

            } else {

                pesananView.tampilkanDataPesanan(
                        pesanan
                );
            }

        } else {

            String nama =
                    input.inputNamaBisaBatal(
                            "Masukkan nama pelanggan: "
                    );

            if (nama == null) {
                return;
            }

            ArrayList<PesananJastip> hasil =
                    controller.cariPesananNama(
                            nama
                    );

            pesananView.tampilkanHasilPencarian(
                    hasil
            );
        }
    }

    // ==================================================
    // UBAH PESANAN
    // ==================================================

    public static void ubahPesanan(
            PesananController controller,
            ValidasiInput input,
            PesananView pesananView) {

        String id =
                input.inputStringBisaBatal(
                        "Masukkan ID pesanan yang ingin diubah: "
                );

        if (id == null) {
            System.out.println(
                    "Perubahan pesanan dibatalkan."
            );
            return;
        }

        PesananJastip pesanan =
                controller.cariPesanan(id);

        if (pesanan == null) {

            System.out.println();
            System.out.println(
                    "Pesanan tidak ditemukan."
            );

            return;
        }

        System.out.println();
        System.out.println("DATA PESANAN SAAT INI");

        pesananView.tampilkanDataPesanan(
                pesanan
        );

        System.out.println();
        System.out.println("Masukkan data baru.");

        String namaPelanggan =
                input.inputNamaBisaBatal(
                        "Nama pelanggan: "
                );

        if (namaPelanggan == null) {
            System.out.println(
                    "Perubahan pesanan dibatalkan."
            );
            return;
        }

        String nomorTelepon =
                input.inputNomorTeleponBisaBatal(
                        "Nomor telepon: "
                );

        if (nomorTelepon == null) {
            System.out.println(
                    "Perubahan pesanan dibatalkan."
            );
            return;
        }

        String namaBarang =
                input.inputStringBisaBatal(
                        "Nama barang: "
                );

        if (namaBarang == null) {
            System.out.println(
                    "Perubahan pesanan dibatalkan."
            );
            return;
        }

        double harga =
                input.inputDoubleBisaBatal(
                        "Harga barang: ",
                        1,
                        1000000000
                );

        if (harga == 0) {
            System.out.println(
                    "Perubahan pesanan dibatalkan."
            );
            return;
        }

        double berat =
                input.inputDoubleBisaBatal(
                        "Berat barang (kg): ",
                        0.1,
                        1000
                );

        if (berat == 0) {
            System.out.println(
                    "Perubahan pesanan dibatalkan."
            );
            return;
        }

        int jumlah =
                input.inputIntegerBisaBatal(
                        "Jumlah barang: ",
                        1,
                        100
                );

        if (jumlah == 0) {
            System.out.println(
                    "Perubahan pesanan dibatalkan."
            );
            return;
        }

        String requestKhusus =
                input.inputStringBisaBatal(
                        "Request khusus: "
                );

        if (requestKhusus == null) {
            System.out.println(
                    "Perubahan pesanan dibatalkan."
            );
            return;
        }

        boolean berhasil =
                controller.ubahPesanan(
                        id,
                        namaPelanggan,
                        nomorTelepon,
                        namaBarang,
                        harga,
                        berat,
                        jumlah,
                        requestKhusus
                );

        if (berhasil) {

            System.out.println();
            System.out.println(
                    "Pesanan berhasil diubah."
            );

        } else {

            System.out.println();
            System.out.println(
                    "Pesanan gagal diubah."
            );
        }
    }

    // ==================================================
    // HAPUS PESANAN
    // ==================================================

    public static void hapusPesanan(
            PesananController controller,
            ValidasiInput input,
            PesananView pesananView) {

        String id =
                input.inputStringBisaBatal(
                        "Masukkan ID pesanan yang ingin dihapus: "
                );

        if (id == null) {
            System.out.println(
                    "Penghapusan dibatalkan."
            );
            return;
        }

        PesananJastip pesanan =
                controller.cariPesanan(id);

        if (pesanan == null) {

            System.out.println();
            System.out.println(
                    "Pesanan tidak ditemukan."
            );

            return;
        }

        pesananView.tampilkanDataPesanan(
                pesanan
        );

        String konfirmasi =
                input.inputStringBisaBatal(
                        "Yakin ingin menghapus? (ya/tidak): "
                );

        if (konfirmasi == null) {
            System.out.println(
                    "Penghapusan dibatalkan."
            );
            return;
        }

        if (konfirmasi.equalsIgnoreCase("ya")) {

            boolean berhasil =
                    controller.hapusPesanan(id);

            if (berhasil) {

                System.out.println();
                System.out.println(
                        "Pesanan berhasil dihapus."
                );

            } else {

                System.out.println();
                System.out.println(
                        "Pesanan gagal dihapus."
                );
            }

        } else {

            System.out.println();
            System.out.println(
                    "Penghapusan dibatalkan."
            );
        }
    }

    // ==================================================
    // LIHAT STRUK
    // ==================================================

    public static void lihatStruk(
            PesananController controller,
            ValidasiInput input) {

        String id =
                input.inputStringBisaBatal(
                        "Masukkan ID pesanan: "
                );

        if (id == null) {
            return;
        }

        controller.tampilkanStruk(
                id
        );
    }

    // ==================================================
    // UBAH STATUS
    // ==================================================

    public static void ubahStatus(
            PesananController controller,
            ValidasiInput input,
            MenuView menuView) {

        String id =
                input.inputStringBisaBatal(
                        "Masukkan ID pesanan: "
                );

        if (id == null) {
            return;
        }

        PesananJastip pesanan =
                controller.cariPesanan(id);

        if (pesanan == null) {

            System.out.println();
            System.out.println(
                    "Pesanan tidak ditemukan."
            );

            return;
        }

        System.out.println();
        System.out.println(
                "Status saat ini: "
                + pesanan.getStatusPesanan()
        );

        menuView.tampilkanMenuStatus();

        int pilihan =
                input.inputIntegerBisaBatal(
                        "Pilih status baru: ",
                        1,
                        5
                );

        if (pilihan == 0) {
            return;
        }

        String statusBaru =
                getStatus(pilihan);

        boolean berhasil =
                controller.ubahStatusPesanan(
                        id,
                        statusBaru
                );

        if (berhasil) {

            System.out.println();
            System.out.println(
                    "Status pesanan berhasil diubah."
            );

            System.out.println(
                    "Status baru: "
                    + statusBaru
            );

        } else {

            System.out.println();
            System.out.println(
                    "Status pesanan gagal diubah."
            );
        }
    }

    // ==================================================
    // KELOLA BATCH
    // ==================================================

    public static void kelolaBatch(
            PesananController controller,
            ValidasiInput input,
            MenuView menuView,
            BatchView batchView) {

        boolean kembali = false;

        while (!kembali) {

            menuView.tampilkanMenuBatch();

            int pilihan =
                    input.inputIntegerBisaBatal(
                            "Pilih menu: ",
                            1,
                            4
                    );

            if (pilihan == 0) {
                kembali = true;
                continue;
            }

            switch (pilihan) {

                case 1:

                    batchView.tampilkanSemuaBatch(
                            controller.getDaftarBatch()
                    );

                    break;

                case 2:

                    String idBatch =
                            input.inputStringBisaBatal(
                                    "Masukkan ID batch: "
                            );

                    if (idBatch == null) {
                        break;
                    }

                    BatchJastip batch =
                            controller.cariBatch(
                                    idBatch
                            );

                    batchView.tampilkanDetailBatch(
                            batch
                    );

                    break;

                case 3:

                    tambahBatch(
                            controller,
                            input,
                            batchView
                    );

                    break;

                case 4:

                    kembali = true;
                    break;
            }
        }
    }

    // ==================================================
    // TAMBAH BATCH
    // ==================================================

    public static void tambahBatch(
            PesananController controller,
            ValidasiInput input,
            BatchView batchView) {

        String idBatch =
                controller.generateIdBatch();

        System.out.println();
        System.out.println(
                "ID Batch otomatis: "
                + idBatch
        );

        System.out.println(
                "Ketik 0 untuk membatalkan proses."
        );

        String negaraTujuan =
                input.inputStringBisaBatal(
                        "Negara tujuan: "
                );

        if (negaraTujuan == null) {
            System.out.println(
                    "Penambahan batch dibatalkan."
            );
            return;
        }

        String tanggalBuka =
                input.inputStringBisaBatal(
                        "Tanggal buka: "
                );

        if (tanggalBuka == null) {
            System.out.println(
                    "Penambahan batch dibatalkan."
            );
            return;
        }

        String batasOrder =
                input.inputStringBisaBatal(
                        "Batas order: "
                );

        if (batasOrder == null) {
            System.out.println(
                    "Penambahan batch dibatalkan."
            );
            return;
        }

        String tanggalBerangkat =
                input.inputStringBisaBatal(
                        "Tanggal berangkat: "
                );

        if (tanggalBerangkat == null) {
            System.out.println(
                    "Penambahan batch dibatalkan."
            );
            return;
        }

        BatchJastip batch =
                new BatchJastip(
                        idBatch,
                        negaraTujuan,
                        tanggalBuka,
                        batasOrder,
                        tanggalBerangkat,
                        "Dibuka"
                );

        // ----------------------------------------------
        // SIMPAN BATCH KE DATABASE
        // ----------------------------------------------

        boolean berhasil =
                controller.tambahBatch(
                        batch
                );

        System.out.println();

        if (berhasil) {

            System.out.println(
                    "Batch berhasil ditambahkan."
            );

            batchView.tampilkanDetailBatch(
                    batch
            );

        } else {

            System.out.println(
                    "Batch gagal ditambahkan ke database."
            );
        }
    }

    // ==================================================
    // KONVERSI PILIHAN STATUS
    // ==================================================

    public static String getStatus(
            int pilihan) {

        switch (pilihan) {

            case 1:
                return "Menunggu Pembayaran";

            case 2:
                return "Pembayaran Berhasil";

            case 3:
                return "Sedang Dibeli";

            case 4:
                return "Dalam Pengiriman";

            case 5:
                return "Pesanan Selesai";

            default:
                return "Menunggu Pembayaran";
        }
    }
}