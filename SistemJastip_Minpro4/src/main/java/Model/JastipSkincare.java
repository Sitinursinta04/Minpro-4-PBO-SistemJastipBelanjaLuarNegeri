/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package Model;

/**
 *
 * @author Lenovo
 */

public class JastipSkincare extends PesananJastip implements BisaDivalidasi {

    private String jenisKulit;
    private int ukuranProduk;

    public JastipSkincare(
            String idPesanan,
            Pelanggan pelanggan,
            Barang barang,
            int jumlah,
            Pembayaran pembayaran,
            String statusPesanan,
            double biayaJastip,
            BatchJastip batch,
            String requestKhusus,
            String jenisKulit,
            int ukuranProduk) {

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

        this.jenisKulit = jenisKulit;
        this.ukuranProduk = ukuranProduk;
    }

    public String getJenisKulit() {
        return jenisKulit;
    }

    public int getUkuranProduk() {
        return ukuranProduk;
    }

    public void setJenisKulit(String jenisKulit) {
        this.jenisKulit = jenisKulit;
    }

    public void setUkuranProduk(int ukuranProduk) {
        this.ukuranProduk = ukuranProduk;
    }

    @Override
    public String getJenisPesanan() {
        return "Jastip Skincare";
    }

    @Override
    public boolean validasiDetailPesanan() {

        return jenisKulit != null
                && !jenisKulit.trim().isEmpty()
                && ukuranProduk > 0;
    }
}