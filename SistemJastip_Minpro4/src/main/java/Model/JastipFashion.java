/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package Model;

/**
 *
 * @author Lenovo
 */

public class JastipFashion extends PesananJastip implements BisaDivalidasi {

    private String ukuran;
    private String warna;

    public JastipFashion(
            String idPesanan,
            Pelanggan pelanggan,
            Barang barang,
            int jumlah,
            Pembayaran pembayaran,
            String statusPesanan,
            double biayaJastip,
            BatchJastip batch,
            String requestKhusus,
            String ukuran,
            String warna) {

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

        this.ukuran = ukuran;
        this.warna = warna;
    }

    public String getUkuran() {
        return ukuran;
    }

    public String getWarna() {
        return warna;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    @Override
    public String getJenisPesanan() {
        return "Jastip Fashion";
    }

    @Override
    public boolean validasiDetailPesanan() {

        return ukuran != null
                && !ukuran.trim().isEmpty()
                && warna != null
                && !warna.trim().isEmpty();
    }
}