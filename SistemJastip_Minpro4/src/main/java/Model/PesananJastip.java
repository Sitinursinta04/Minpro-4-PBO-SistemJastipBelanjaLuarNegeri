/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public abstract class PesananJastip {

    private final String idPesanan;
    private Pelanggan pelanggan;
    private Barang barang;
    private int jumlah;
    private Pembayaran pembayaran;
    private String statusPesanan;
    private double biayaJastip;
    private BatchJastip batch;

    private String requestKhusus;
    private ArrayList<String> riwayatStatus;

    public PesananJastip(
            String idPesanan,
            Pelanggan pelanggan,
            Barang barang,
            int jumlah,
            Pembayaran pembayaran,
            String statusPesanan,
            double biayaJastip,
            BatchJastip batch,
            String requestKhusus) {

        this.idPesanan = idPesanan;
        this.pelanggan = pelanggan;
        this.barang = barang;
        this.jumlah = jumlah;
        this.pembayaran = pembayaran;
        this.statusPesanan = statusPesanan;
        this.biayaJastip = biayaJastip;
        this.batch = batch;
        this.requestKhusus = requestKhusus;

        riwayatStatus = new ArrayList<>();
        riwayatStatus.add(statusPesanan);
    }

    // ==========================================
    // GETTER
    // ==========================================

    public String getIdPesanan() {
        return idPesanan;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public Barang getBarang() {
        return barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public String getStatusPesanan() {
        return statusPesanan;
    }

    public double getBiayaJastip() {
        return biayaJastip;
    }

    public BatchJastip getBatch() {
        return batch;
    }

    public String getRequestKhusus() {
        return requestKhusus;
    }

    public ArrayList<String> getRiwayatStatus() {
        return new ArrayList<>(riwayatStatus);
    }

    // ==========================================
    // SETTER
    // ==========================================

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    public void setBiayaJastip(double biayaJastip) {
        this.biayaJastip = biayaJastip;
    }

    public void setBatch(BatchJastip batch) {
        this.batch = batch;
    }

    public void setRequestKhusus(String requestKhusus) {
        this.requestKhusus = requestKhusus;
    }

    // ==========================================
    // ABSTRACTION
    // ==========================================

    public abstract String getJenisPesanan();

    // ==========================================
    // POLYMORPHISM - OVERLOADING
    // ==========================================

    public double hitungTotal() {
        return barang.getHarga() * jumlah;
    }

    public double hitungTotal(double biayaJastip) {
        return hitungTotal() + biayaJastip;
    }

    // ==========================================
    // ESTIMASI BIAYA JASTIP
    // ==========================================

    public double hitungEstimasiJastip() {

        double biayaPerKg = 50000;

        return barang.getBerat() * jumlah * biayaPerKg;
    }

    public double hitungEstimasiJastip(double biayaPerKg) {

        return barang.getBerat() * jumlah * biayaPerKg;
    }

    public double getTotalPembayaran() {
        return hitungTotal(biayaJastip);
    }

    // ==========================================
    // VALIDASI PERUBAHAN STATUS
    // ==========================================

    public boolean ubahStatus(String statusBaru) {

        if (statusBaru == null) {
            return false;
        }

        if (statusPesanan.equalsIgnoreCase(statusBaru)) {
            return false;
        }

        boolean boleh = false;

        switch (statusPesanan) {

            case "Menunggu Pembayaran":
                boleh = statusBaru.equals("Pembayaran Berhasil");
                break;

            case "Pembayaran Berhasil":
                boleh = statusBaru.equals("Sedang Dibeli");
                break;

            case "Sedang Dibeli":
                boleh = statusBaru.equals("Dalam Pengiriman");
                break;

            case "Dalam Pengiriman":
                boleh = statusBaru.equals("Pesanan Selesai");
                break;

            case "Pesanan Selesai":
                boleh = false;
                break;
        }

        if (boleh) {

            statusPesanan = statusBaru;
            riwayatStatus.add(statusBaru);

            return true;
        }

        return false;
    }

    // ==========================================
    // RIWAYAT STATUS
    // ==========================================

    public void tampilkanRiwayatStatus() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("             RIWAYAT STATUS");
        System.out.println("==========================================");

        if (riwayatStatus.isEmpty()) {

            System.out.println("Belum ada riwayat status.");

        } else {

            for (int i = 0; i < riwayatStatus.size(); i++) {

                System.out.println(
                        (i + 1)
                        + ". "
                        + riwayatStatus.get(i)
                );
            }
        }

        System.out.println("==========================================");
    }
}