/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package View;

/**
 *
 * @author Lenovo
 */

import java.util.ArrayList;
import Model.PesananJastip;
import Model.JastipFashion;
import Model.JastipSkincare;
import Model.JastipElektronik;

public class PesananView {

    // ==========================================
    // DATA PESANAN
    // ==========================================

    public void tampilkanDataPesanan(
            PesananJastip pesanan) {

        System.out.println("------------------------------------------");

        System.out.println("ID Pesanan        : "
                + pesanan.getIdPesanan());

        System.out.println("Jenis Pesanan     : "
                + pesanan.getJenisPesanan());

        System.out.println("Nama Pelanggan    : "
                + pesanan.getPelanggan()
                        .getNamaPelanggan());

        System.out.println("No. Telepon       : "
                + pesanan.getPelanggan()
                        .getNomorTelepon());

        System.out.println("Nama Barang       : "
                + pesanan.getBarang()
                        .getNamaBarang());

        System.out.println("Negara Asal       : "
                + pesanan.getBarang()
                        .getNegaraAsal());

        System.out.println("Harga Barang      : Rp "
                + String.format(
                        "%,.0f",
                        pesanan.getBarang().getHarga()
                ));

        System.out.println("Berat Barang      : "
                + pesanan.getBarang().getBerat()
                + " kg");

        System.out.println("Jumlah            : "
                + pesanan.getJumlah());

        System.out.println("Request Khusus    : "
                + pesanan.getRequestKhusus());

        System.out.println("Biaya Jastip      : Rp "
                + String.format(
                        "%,.0f",
                        pesanan.getBiayaJastip()
                ));

        System.out.println("Total Pembayaran  : Rp "
                + String.format(
                        "%,.0f",
                        pesanan.getTotalPembayaran()
                ));

        System.out.println("Metode Pembayaran : "
                + pesanan.getPembayaran()
                        .getMetodePembayaran());

        System.out.println("Status Pesanan    : "
                + pesanan.getStatusPesanan());

        // ==========================================
        // DATA BATCH
        // ==========================================

        if (pesanan.getBatch() != null) {

            System.out.println("ID Batch          : "
                    + pesanan.getBatch()
                            .getIdBatch());

            System.out.println("Negara Tujuan     : "
                    + pesanan.getBatch()
                            .getNegaraTujuan());

            System.out.println("Tanggal Berangkat : "
                    + pesanan.getBatch()
                            .getTanggalBerangkat());

            System.out.println("Status Batch      : "
                    + pesanan.getBatch()
                            .getStatusBatch());
        }

        // ==========================================
        // DATA FASHION
        // ==========================================

        if (pesanan instanceof JastipFashion) {

            JastipFashion fashion =
                    (JastipFashion) pesanan;

            System.out.println("Ukuran            : "
                    + fashion.getUkuran());

            System.out.println("Warna             : "
                    + fashion.getWarna());
        }

        // ==========================================
        // DATA SKINCARE
        // ==========================================

        if (pesanan instanceof JastipSkincare) {

            JastipSkincare skincare =
                    (JastipSkincare) pesanan;

            System.out.println("Jenis Kulit       : "
                    + skincare.getJenisKulit());

            System.out.println("Ukuran Produk     : "
                    + skincare.getUkuranProduk()
                    + " ml");
        }

        // ==========================================
        // DATA ELEKTRONIK
        // ==========================================

        if (pesanan instanceof JastipElektronik) {

            JastipElektronik elektronik =
                    (JastipElektronik) pesanan;

            System.out.println("Merek             : "
                    + elektronik.getMerek());

            System.out.println("Garansi           : "
                    + elektronik.getGaransi()
                    + " bulan");
        }
    }

    // ==========================================
    // SEMUA PESANAN
    // ==========================================

    public void tampilkanSemuaPesanan(
            ArrayList<PesananJastip> daftarPesanan) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("             SEMUA PESANAN");
        System.out.println("==========================================");

        if (daftarPesanan.isEmpty()) {

            System.out.println("Belum ada pesanan.");

        } else {

            for (PesananJastip pesanan : daftarPesanan) {
                tampilkanDataPesanan(pesanan);
            }
        }

        System.out.println("==========================================");
    }

    // ==========================================
    // FASHION
    // ==========================================

    public void tampilkanPesananFashion(
            ArrayList<PesananJastip> daftarPesanan) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("          PESANAN JASTIP FASHION");
        System.out.println("==========================================");

        boolean ditemukan = false;

        for (PesananJastip pesanan : daftarPesanan) {

            if (pesanan instanceof JastipFashion) {

                tampilkanDataPesanan(pesanan);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Belum ada pesanan fashion.");
        }

        System.out.println("==========================================");
    }

    // ==========================================
    // SKINCARE
    // ==========================================

    public void tampilkanPesananSkincare(
            ArrayList<PesananJastip> daftarPesanan) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("         PESANAN JASTIP SKINCARE");
        System.out.println("==========================================");

        boolean ditemukan = false;

        for (PesananJastip pesanan : daftarPesanan) {

            if (pesanan instanceof JastipSkincare) {

                tampilkanDataPesanan(pesanan);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Belum ada pesanan skincare.");
        }

        System.out.println("==========================================");
    }

    // ==========================================
    // ELEKTRONIK
    // ==========================================

    public void tampilkanPesananElektronik(
            ArrayList<PesananJastip> daftarPesanan) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("        PESANAN JASTIP ELEKTRONIK");
        System.out.println("==========================================");

        boolean ditemukan = false;

        for (PesananJastip pesanan : daftarPesanan) {

            if (pesanan instanceof JastipElektronik) {

                tampilkanDataPesanan(pesanan);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Belum ada pesanan elektronik.");
        }

        System.out.println("==========================================");
    }

    // ==========================================
    // BERDASARKAN STATUS
    // ==========================================

    public void tampilkanPesananBerdasarkanStatus(
            ArrayList<PesananJastip> daftarPesanan,
            String status) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("         PESANAN BERDASARKAN STATUS");
        System.out.println("==========================================");

        boolean ditemukan = false;

        for (PesananJastip pesanan : daftarPesanan) {

            if (pesanan.getStatusPesanan()
                    .equalsIgnoreCase(status)) {

                tampilkanDataPesanan(pesanan);
                ditemukan = true;
            }
        }

        if (!ditemukan) {

            System.out.println(
                    "Tidak ada pesanan dengan status: "
                    + status
            );
        }

        System.out.println("==========================================");
    }

    // ==========================================
    // HASIL PENCARIAN
    // ==========================================

    public void tampilkanHasilPencarian(
            ArrayList<PesananJastip> hasil) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("          HASIL PENCARIAN PESANAN");
        System.out.println("==========================================");

        if (hasil.isEmpty()) {

            System.out.println(
                    "Pesanan yang dicari tidak ditemukan."
            );

        } else {

            for (PesananJastip pesanan : hasil) {
                tampilkanDataPesanan(pesanan);
            }
        }

        System.out.println("==========================================");
    }

    // ==========================================
    // STRUK
    // ==========================================

    public void tampilkanStruk(
            PesananJastip pesanan) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("              STRUK JASTIP");
        System.out.println("==========================================");

        System.out.println("ID Pesanan        : "
                + pesanan.getIdPesanan());

        System.out.println("Jenis Pesanan     : "
                + pesanan.getJenisPesanan());

        System.out.println("Pelanggan         : "
                + pesanan.getPelanggan()
                        .getNamaPelanggan());

        System.out.println("Barang            : "
                + pesanan.getBarang()
                        .getNamaBarang());

        System.out.println("Jumlah            : "
                + pesanan.getJumlah());

        System.out.println("Harga Barang      : Rp "
                + String.format(
                        "%,.0f",
                        pesanan.getBarang().getHarga()
                ));

        System.out.println("Request Khusus    : "
                + pesanan.getRequestKhusus());

        System.out.println("Biaya Jastip      : Rp "
                + String.format(
                        "%,.0f",
                        pesanan.getBiayaJastip()
                ));

        System.out.println("Total Pembayaran  : Rp "
                + String.format(
                        "%,.0f",
                        pesanan.getTotalPembayaran()
                ));

        System.out.println("Pembayaran        : "
                + pesanan.getPembayaran()
                        .getMetodePembayaran());

        System.out.println("Status            : "
                + pesanan.getStatusPesanan());

        // ==========================================
        // DETAIL KHUSUS
        // ==========================================

        if (pesanan instanceof JastipFashion) {

            JastipFashion fashion =
                    (JastipFashion) pesanan;

            System.out.println("Ukuran            : "
                    + fashion.getUkuran());

            System.out.println("Warna             : "
                    + fashion.getWarna());
        }

        if (pesanan instanceof JastipSkincare) {

            JastipSkincare skincare =
                    (JastipSkincare) pesanan;

            System.out.println("Jenis Kulit       : "
                    + skincare.getJenisKulit());

            System.out.println("Ukuran Produk     : "
                    + skincare.getUkuranProduk()
                    + " ml");
        }

        if (pesanan instanceof JastipElektronik) {

            JastipElektronik elektronik =
                    (JastipElektronik) pesanan;

            System.out.println("Merek             : "
                    + elektronik.getMerek());

            System.out.println("Garansi           : "
                    + elektronik.getGaransi()
                    + " bulan");
        }

        // ==========================================
        // DATA BATCH
        // ==========================================

        if (pesanan.getBatch() != null) {

            System.out.println("ID Batch          : "
                    + pesanan.getBatch()
                            .getIdBatch());

            System.out.println("Negara Tujuan     : "
                    + pesanan.getBatch()
                            .getNegaraTujuan());

            System.out.println("Berangkat         : "
                    + pesanan.getBatch()
                            .getTanggalBerangkat());
        }

        System.out.println("==========================================");
    }

    // ==========================================
    // RINGKASAN
    // ==========================================

    public void tampilkanRingkasan(
            ArrayList<PesananJastip> daftarPesanan) {

        int total = daftarPesanan.size();
        int fashion = 0;
        int skincare = 0;
        int elektronik = 0;

        double totalPendapatan = 0;

        for (PesananJastip pesanan : daftarPesanan) {

            if (pesanan instanceof JastipFashion) {
                fashion++;
            }

            if (pesanan instanceof JastipSkincare) {
                skincare++;
            }

            if (pesanan instanceof JastipElektronik) {
                elektronik++;
            }

            totalPendapatan +=
                    pesanan.getTotalPembayaran();
        }

        System.out.println();
        System.out.println("==========================================");
        System.out.println("            RINGKASAN PESANAN");
        System.out.println("==========================================");
        System.out.println("Total Pesanan     : " + total);
        System.out.println("Jastip Fashion    : " + fashion);
        System.out.println("Jastip Skincare   : " + skincare);
        System.out.println("Jastip Elektronik : " + elektronik);

        System.out.println("Total Pembayaran  : Rp "
                + String.format(
                        "%,.0f",
                        totalPendapatan
                ));

        System.out.println("==========================================");
    }
}