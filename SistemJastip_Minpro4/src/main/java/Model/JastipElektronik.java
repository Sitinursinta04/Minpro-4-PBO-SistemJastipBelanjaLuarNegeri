/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 */

/**
 *
 * @author Lenovo
 */
package Model;

public class JastipElektronik extends PesananJastip implements BisaDivalidasi {

    private String merek;
    private int garansi;

    public JastipElektronik(
            String idPesanan,
            Pelanggan pelanggan,
            Barang barang,
            int jumlah,
            Pembayaran pembayaran,
            String statusPesanan,
            double biayaJastip,
            BatchJastip batch,
            String requestKhusus,
            String merek,
            int garansi) {

        super(
                idPesanan,
                pelanggan,
                barang,
                jumlah,
                pembayaran,
                statusPesanan,
                biayaJastip,
                batch,
                requestKhusus
        );

        this.merek = merek;
        this.garansi = garansi;
    }

    public String getMerek() {
        return merek;
    }

    public int getGaransi() {
        return garansi;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public void setGaransi(int garansi) {
        this.garansi = garansi;
    }

    @Override
    public String getJenisPesanan() {
        return "Jastip Elektronik";
    }

    @Override
    public boolean validasiDetailPesanan() {

        return merek != null
                && !merek.trim().isEmpty()
                && garansi >= 0;
    }
}