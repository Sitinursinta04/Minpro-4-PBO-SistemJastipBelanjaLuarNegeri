/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.PesananDAO;
import DAO.PesananDAOImpl;

import Model.BatchJastip;
import Model.JastipElektronik;
import Model.JastipFashion;
import Model.JastipSkincare;
import Model.PesananJastip;
import View.PesananView;

import java.sql.SQLException;
import java.util.ArrayList;

public class PesananController {

    private ArrayList<PesananJastip> daftarPesanan;
    private ArrayList<BatchJastip> daftarBatch;
    private PesananView view;

    private PesananDAO pesananDAO;

    // ==========================================
    // CONSTRUCTOR
    // ==========================================

    public PesananController() {

        daftarPesanan = new ArrayList<>();
        daftarBatch = new ArrayList<>();
        view = new PesananView();

        pesananDAO = new PesananDAOImpl();

        // Memuat data pesanan dari database
        muatDataPesanan();

        System.out.println(
                "Data pesanan berhasil dimuat dari database."
        );

        // ==========================================
        // DATA AWAL BATCH
        // ==========================================

        BatchJastip batch1 =
                new BatchJastip(
                        "B001",
                        "Korea Selatan",
                        "1 Oktober 2026",
                        "15 Oktober 2026",
                        "20 Oktober 2026",
                        "Dibuka"
                );

        daftarBatch.add(batch1);
    }

    // ==========================================
    // MUAT DATA PESANAN DARI DATABASE
    // ==========================================

    private void muatDataPesanan() {

        try {

            daftarPesanan.clear();

            daftarPesanan.addAll(
                    pesananDAO.getAllPesanan()
            );

        } catch (SQLException e) {

            System.out.println(
                    "Gagal memuat data pesanan: "
                    + e.getMessage()
            );
        }
    }

    // ==========================================
    // GENERATE ID FASHION
    // ==========================================

    public String generateIdFashion() {

        int nomor = 1;

        for (PesananJastip pesanan :
                daftarPesanan) {

            String id =
                    pesanan.getIdPesanan();

            if (id != null &&
                    id.startsWith("FSH-")) {

                try {

                    int nomorPesanan =
                            Integer.parseInt(
                                    id.substring(4)
                            );

                    if (nomorPesanan >= nomor) {
                        nomor = nomorPesanan + 1;
                    }

                } catch (NumberFormatException e) {
                    // Abaikan jika format ID tidak sesuai
                }
            }
        }

        return String.format(
                "FSH-%03d",
                nomor
        );
    }

    // ==========================================
    // GENERATE ID SKINCARE
    // ==========================================

    public String generateIdSkincare() {

        int nomor = 1;

        for (PesananJastip pesanan :
                daftarPesanan) {

            String id =
                    pesanan.getIdPesanan();

            if (id != null &&
                    id.startsWith("SKN-")) {

                try {

                    int nomorPesanan =
                            Integer.parseInt(
                                    id.substring(4)
                            );

                    if (nomorPesanan >= nomor) {
                        nomor = nomorPesanan + 1;
                    }

                } catch (NumberFormatException e) {
                    // Abaikan jika format ID tidak sesuai
                }
            }
        }

        return String.format(
                "SKN-%03d",
                nomor
        );
    }

    // ==========================================
    // GENERATE ID ELEKTRONIK
    // ==========================================

    public String generateIdElektronik() {

        int nomor = 1;

        for (PesananJastip pesanan :
                daftarPesanan) {

            String id =
                    pesanan.getIdPesanan();

            if (id != null &&
                    id.startsWith("ELK-")) {

                try {

                    int nomorPesanan =
                            Integer.parseInt(
                                    id.substring(4)
                            );

                    if (nomorPesanan >= nomor) {
                        nomor = nomorPesanan + 1;
                    }

                } catch (NumberFormatException e) {
                    // Abaikan jika format ID tidak sesuai
                }
            }
        }

        return String.format(
                "ELK-%03d",
                nomor
        );
    }

    // ==========================================
    // GENERATE ID BATCH
    // ==========================================

    public String generateIdBatch() {

        int nomor = 1;

        for (BatchJastip batch :
                daftarBatch) {

            String id =
                    batch.getIdBatch();

            if (id != null &&
                    id.startsWith("B")) {

                try {

                    int nomorBatch =
                            Integer.parseInt(
                                    id.substring(1)
                            );

                    if (nomorBatch >= nomor) {
                        nomor = nomorBatch + 1;
                    }

                } catch (NumberFormatException e) {
                    // Abaikan jika format ID tidak sesuai
                }
            }
        }

        return String.format(
                "B%03d",
                nomor
        );
    }

    // ==========================================
    // GENERATE ID PELANGGAN
    // ==========================================

    public String generateIdPelanggan() {

        int nomor = 1;

        for (PesananJastip pesanan :
                daftarPesanan) {

            String id =
                    pesanan.getPelanggan()
                            .getIdPelanggan();

            if (id != null &&
                    id.startsWith("P")) {

                try {

                    int nomorPelanggan =
                            Integer.parseInt(
                                    id.substring(1)
                            );

                    if (nomorPelanggan >= nomor) {
                        nomor = nomorPelanggan + 1;
                    }

                } catch (NumberFormatException e) {
                    // Abaikan jika format ID tidak sesuai
                }
            }
        }

        return String.format(
                "P%03d",
                nomor
        );
    }

    // ==========================================
    // TAMBAH PESANAN
    // ==========================================

    public boolean tambahPesanan(
            PesananJastip pesanan) {

        if (pesanan == null) {
            return false;
        }

        try {

            boolean berhasil =
                    pesananDAO.tambahPesanan(
                            pesanan
                    );

            if (berhasil) {

                daftarPesanan.add(
                        pesanan
                );

                return true;
            }

        } catch (SQLException e) {

            System.out.println(
                    "Gagal menambahkan pesanan ke database: "
                    + e.getMessage()
            );
        }

        return false;
    }

    // ==========================================
    // TAMPILKAN SEMUA PESANAN
    // ==========================================

    public void tampilkanPesanan() {

        view.tampilkanSemuaPesanan(
                daftarPesanan
        );
    }

    // ==========================================
    // TAMPILKAN PESANAN FASHION
    // ==========================================

    public void tampilkanPesananFashion() {

        ArrayList<PesananJastip> hasil =
                new ArrayList<>();

        for (PesananJastip pesanan :
                daftarPesanan) {

            if (pesanan instanceof JastipFashion) {
                hasil.add(pesanan);
            }
        }

        view.tampilkanPesananFashion(
                hasil
        );
    }

    // ==========================================
    // TAMPILKAN PESANAN SKINCARE
    // ==========================================

    public void tampilkanPesananSkincare() {

        ArrayList<PesananJastip> hasil =
                new ArrayList<>();

        for (PesananJastip pesanan :
                daftarPesanan) {

            if (pesanan instanceof JastipSkincare) {
                hasil.add(pesanan);
            }
        }

        view.tampilkanPesananSkincare(
                hasil
        );
    }

    // ==========================================
    // TAMPILKAN PESANAN ELEKTRONIK
    // ==========================================

    public void tampilkanPesananElektronik() {

        ArrayList<PesananJastip> hasil =
                new ArrayList<>();

        for (PesananJastip pesanan :
                daftarPesanan) {

            if (pesanan instanceof JastipElektronik) {
                hasil.add(pesanan);
            }
        }

        view.tampilkanPesananElektronik(
                hasil
        );
    }

    // ==========================================
    // CARI PESANAN BERDASARKAN ID
    // ==========================================

    public PesananJastip cariPesanan(
            String idPesanan) {

        if (idPesanan == null) {
            return null;
        }

        for (PesananJastip pesanan :
                daftarPesanan) {

            if (pesanan.getIdPesanan()
                    .equalsIgnoreCase(idPesanan)) {

                return pesanan;
            }
        }

        return null;
    }

    // ==========================================
    // CARI PESANAN BERDASARKAN NAMA
    // ==========================================

    public ArrayList<PesananJastip> cariPesananNama(
            String nama) {

        ArrayList<PesananJastip> hasil =
                new ArrayList<>();

        if (nama == null) {
            return hasil;
        }

        for (PesananJastip pesanan :
                daftarPesanan) {

            if (pesanan.getPelanggan()
                    .getNamaPelanggan()
                    .equalsIgnoreCase(nama)) {

                hasil.add(pesanan);
            }
        }

        return hasil;
    }

    // ==========================================
    // TAMPILKAN PESANAN BERDASARKAN STATUS
    // ==========================================

    public void tampilkanPesananBerdasarkanStatus(
            String status) {

        ArrayList<PesananJastip> hasil =
                new ArrayList<>();

        if (status == null) {
            return;
        }

        for (PesananJastip pesanan :
                daftarPesanan) {

            if (pesanan.getStatusPesanan()
                    .equalsIgnoreCase(status)) {

                hasil.add(pesanan);
            }
        }

        view.tampilkanPesananBerdasarkanStatus(
                hasil,
                status
        );
    }

    // ==========================================
    // UBAH PESANAN
    // ==========================================

    public boolean ubahPesanan(
            String idPesanan,
            String namaPelanggan,
            String nomorTelepon,
            String namaBarang,
            double harga,
            double berat,
            int jumlah,
            String requestKhusus) {

        PesananJastip pesanan =
                cariPesanan(idPesanan);

        if (pesanan == null) {
            return false;
        }

        pesanan.getPelanggan()
                .setNamaPelanggan(namaPelanggan);

        pesanan.getPelanggan()
                .setNomorTelepon(nomorTelepon);

        pesanan.getBarang()
                .setNamaBarang(namaBarang);

        pesanan.getBarang()
                .setHarga(harga);

        pesanan.getBarang()
                .setBerat(berat);

        pesanan.setJumlah(jumlah);

        pesanan.setRequestKhusus(
                requestKhusus
        );

        try {

            boolean berhasil =
                    pesananDAO.ubahPesanan(
                            pesanan
                    );

            if (berhasil) {
                return true;
            }

            muatDataPesanan();

        } catch (SQLException e) {

            System.out.println(
                    "Gagal mengubah pesanan di database: "
                    + e.getMessage()
            );

            muatDataPesanan();
        }

        return false;
    }

    // ==========================================
    // UBAH STATUS PESANAN
    // ==========================================

    public boolean ubahStatusPesanan(
            String idPesanan,
            String statusBaru) {

        PesananJastip pesanan =
                cariPesanan(idPesanan);

        if (pesanan == null) {
            return false;
        }

        boolean statusValid =
                pesanan.ubahStatus(statusBaru);

        if (!statusValid) {
            return false;
        }

        try {

            boolean berhasil =
                    pesananDAO.ubahStatusPesanan(
                            idPesanan,
                            statusBaru
                    );

            if (berhasil) {
                return true;
            }

            muatDataPesanan();

        } catch (SQLException e) {

            System.out.println(
                    "Gagal mengubah status di database: "
                    + e.getMessage()
            );

            muatDataPesanan();
        }

        return false;
    }

    // ==========================================
    // HAPUS PESANAN
    // ==========================================

    public boolean hapusPesanan(
            String idPesanan) {

        PesananJastip pesanan =
                cariPesanan(idPesanan);

        if (pesanan == null) {
            return false;
        }

        try {

            boolean berhasil =
                    pesananDAO.hapusPesanan(
                            idPesanan
                    );

            if (berhasil) {

                daftarPesanan.remove(
                        pesanan
                );

                return true;
            }

        } catch (SQLException e) {

            System.out.println(
                    "Gagal menghapus pesanan dari database: "
                    + e.getMessage()
            );
        }

        return false;
    }

    // ==========================================
    // TAMPILKAN STRUK
    // ==========================================

    public void tampilkanStruk(
            String idPesanan) {

        PesananJastip pesanan =
                cariPesanan(idPesanan);

        if (pesanan != null) {

            view.tampilkanStruk(
                    pesanan
            );

        } else {

            System.out.println();
            System.out.println(
                    "Pesanan tidak ditemukan."
            );
        }
    }

    // ==========================================
    // TAMPILKAN RINGKASAN
    // ==========================================

    public void tampilkanRingkasan() {

        view.tampilkanRingkasan(
                daftarPesanan
        );
    }

    // ==========================================
    // TAMPILKAN RIWAYAT STATUS
    // ==========================================

    public void tampilkanRiwayatStatus(
            String idPesanan) {

        PesananJastip pesanan =
                cariPesanan(idPesanan);

        if (pesanan != null) {

            pesanan.tampilkanRiwayatStatus();

        } else {

            System.out.println();
            System.out.println(
                    "Pesanan tidak ditemukan."
            );
        }
    }

    // ==========================================
    // GET DAFTAR BATCH
    // ==========================================

    public ArrayList<BatchJastip> getDaftarBatch() {

        return daftarBatch;
    }

    // ==========================================
    // TAMBAH BATCH
    // ==========================================

    public boolean tambahBatch(
            BatchJastip batch) {

        if (batch == null) {
            return false;
        }

        try {

            boolean berhasil =
                    pesananDAO.tambahBatch(
                            batch
                    );

            if (berhasil) {

                daftarBatch.add(
                        batch
                );

                return true;
            }

        } catch (SQLException e) {

            System.out.println(
                    "Gagal menambahkan batch ke database: "
                    + e.getMessage()
            );
        }

        return false;
    }

    // ==========================================
    // CARI BATCH
    // ==========================================

    public BatchJastip cariBatch(
            String idBatch) {

        if (idBatch == null) {
            return null;
        }

        for (BatchJastip batch :
                daftarBatch) {

            if (batch.getIdBatch()
                    .equalsIgnoreCase(idBatch)) {

                return batch;
            }
        }

        return null;
    }

    // ==========================================
    // GET DAFTAR PESANAN
    // ==========================================

    public ArrayList<PesananJastip> getDaftarPesanan() {

        return daftarPesanan;
    }
}