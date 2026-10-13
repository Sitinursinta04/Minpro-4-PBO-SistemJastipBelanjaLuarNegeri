/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.DatabaseConnection;
import Model.BatchJastip;
import Model.Barang;
import Model.JastipElektronik;
import Model.JastipFashion;
import Model.JastipSkincare;
import Model.Pelanggan;
import Model.Pembayaran;
import Model.PesananJastip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class PesananDAOImpl implements PesananDAO {

    // ==================================================
    // READ
    // ==================================================

    @Override
    public List<PesananJastip> getAllPesanan()
            throws SQLException {

        List<PesananJastip> daftarPesanan =
                new ArrayList<>();

        String sql = """
            SELECT
                p.id_pesanan,
                p.jumlah,
                p.status_pesanan,
                p.biaya_jastip,
                p.request_khusus,
                p.jenis_pesanan,

                pl.id_pelanggan,
                pl.nama_pelanggan,
                pl.nomor_telepon,

                b.id_barang,
                b.nama_barang,
                b.negara_asal,
                b.harga,
                b.berat,

                pb.id_pembayaran,
                pb.metode_pembayaran,

                bt.id_batch,
                bt.negara_tujuan,
                bt.tanggal_buka,
                bt.batas_order,
                bt.tanggal_berangkat,
                bt.status_batch,

                df.ukuran,
                df.warna,

                ds.jenis_kulit,
                ds.ukuran_produk,

                de.merek,
                de.garansi

            FROM pesanan p

            JOIN pelanggan pl
                ON p.id_pelanggan = pl.id_pelanggan

            JOIN barang b
                ON p.id_barang = b.id_barang

            JOIN pembayaran pb
                ON p.id_pembayaran = pb.id_pembayaran

            LEFT JOIN batch_jastip bt
                ON p.id_batch = bt.id_batch

            LEFT JOIN detail_fashion df
                ON p.id_pesanan = df.id_pesanan

            LEFT JOIN detail_skincare ds
                ON p.id_pesanan = ds.id_pesanan

            LEFT JOIN detail_elektronik de
                ON p.id_pesanan = de.id_pesanan
            """;

        try (
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet result =
                    statement.executeQuery()
        ) {

            while (result.next()) {

                Pelanggan pelanggan =
                        new Pelanggan(
                                result.getString("id_pelanggan"),
                                result.getString("nama_pelanggan"),
                                result.getString("nomor_telepon")
                        );

                Barang barang =
                        new Barang(
                                result.getString("nama_barang"),
                                result.getString("negara_asal"),
                                result.getDouble("harga"),
                                result.getDouble("berat")
                        );

                Pembayaran pembayaran =
                        new Pembayaran(
                                result.getString("metode_pembayaran")
                        );

                BatchJastip batch = null;

                if (result.getString("id_batch") != null) {

                    batch =
                            new BatchJastip(
                                    result.getString("id_batch"),
                                    result.getString("negara_tujuan"),
                                    result.getString("tanggal_buka"),
                                    result.getString("batas_order"),
                                    result.getString("tanggal_berangkat"),
                                    result.getString("status_batch")
                            );
                }

                String idPesanan =
                        result.getString("id_pesanan");

                int jumlah =
                        result.getInt("jumlah");

                String statusPesanan =
                        result.getString("status_pesanan");

                double biayaJastip =
                        result.getDouble("biaya_jastip");

                String requestKhusus =
                        result.getString("request_khusus");

                String jenisPesanan =
                        result.getString("jenis_pesanan");

                PesananJastip pesanan;

                switch (jenisPesanan) {

                    case "Fashion":
                    case "Jastip Fashion":

                        pesanan =
                                new JastipFashion(
                                        idPesanan,
                                        pelanggan,
                                        barang,
                                        jumlah,
                                        pembayaran,
                                        statusPesanan,
                                        biayaJastip,
                                        batch,
                                        requestKhusus,
                                        result.getString("ukuran"),
                                        result.getString("warna")
                                );

                        break;

                    case "Skincare":
                    case "Jastip Skincare":

                        pesanan =
                                new JastipSkincare(
                                        idPesanan,
                                        pelanggan,
                                        barang,
                                        jumlah,
                                        pembayaran,
                                        statusPesanan,
                                        biayaJastip,
                                        batch,
                                        requestKhusus,
                                        result.getString("jenis_kulit"),
                                        result.getInt("ukuran_produk")
                                );

                        break;

                    case "Elektronik":
                    case "Jastip Elektronik":

                        pesanan =
                                new JastipElektronik(
                                        idPesanan,
                                        pelanggan,
                                        barang,
                                        jumlah,
                                        pembayaran,
                                        statusPesanan,
                                        biayaJastip,
                                        batch,
                                        requestKhusus,
                                        result.getString("merek"),
                                        result.getInt("garansi")
                                );

                        break;

                    default:
                        continue;
                }

                daftarPesanan.add(pesanan);
            }
        }

        return daftarPesanan;
    }

    // ==================================================
    // CREATE PESANAN
    // ==================================================

    @Override
    public boolean tambahPesanan(
            PesananJastip pesanan
    ) throws SQLException {

        String sqlPesanan = """
            INSERT INTO pesanan
            (
                id_pesanan,
                id_pelanggan,
                id_barang,
                jumlah,
                id_pembayaran,
                status_pesanan,
                biaya_jastip,
                id_batch,
                request_khusus,
                jenis_pesanan
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        Connection connection =
                DatabaseConnection.getConnection();

        if (connection == null) {
            return false;
        }

        try {

            connection.setAutoCommit(false);

            // ------------------------------------------
            // PELANGGAN
            // ------------------------------------------

            String sqlPelanggan = """
                INSERT INTO pelanggan
                (
                    id_pelanggan,
                    nama_pelanggan,
                    nomor_telepon
                )
                VALUES (?, ?, ?)
                ON DUPLICATE KEY UPDATE
                    nama_pelanggan = VALUES(nama_pelanggan),
                    nomor_telepon = VALUES(nomor_telepon)
                """;

            try (
                PreparedStatement statement =
                        connection.prepareStatement(
                                sqlPelanggan
                        )
            ) {

                statement.setString(
                        1,
                        pesanan.getPelanggan()
                                .getIdPelanggan()
                );

                statement.setString(
                        2,
                        pesanan.getPelanggan()
                                .getNamaPelanggan()
                );

                statement.setString(
                        3,
                        pesanan.getPelanggan()
                                .getNomorTelepon()
                );

                statement.executeUpdate();
            }

            // ------------------------------------------
            // BARANG
            // ------------------------------------------

            int idBarang =
                    cariAtauTambahBarang(
                            connection,
                            pesanan.getBarang()
                    );

            // ------------------------------------------
            // PEMBAYARAN
            // ------------------------------------------

            int idPembayaran =
                    cariAtauTambahPembayaran(
                            connection,
                            pesanan.getPembayaran()
                    );

            // ------------------------------------------
            // PESANAN
            // ------------------------------------------

            try (
                PreparedStatement statement =
                        connection.prepareStatement(
                                sqlPesanan
                        )
            ) {

                statement.setString(
                        1,
                        pesanan.getIdPesanan()
                );

                statement.setString(
                        2,
                        pesanan.getPelanggan()
                                .getIdPelanggan()
                );

                statement.setInt(
                        3,
                        idBarang
                );

                statement.setInt(
                        4,
                        pesanan.getJumlah()
                );

                statement.setInt(
                        5,
                        idPembayaran
                );

                statement.setString(
                        6,
                        pesanan.getStatusPesanan()
                );

                statement.setDouble(
                        7,
                        pesanan.getBiayaJastip()
                );

                if (pesanan.getBatch() != null) {

                    statement.setString(
                            8,
                            pesanan.getBatch()
                                    .getIdBatch()
                    );

                } else {

                    statement.setNull(
                            8,
                            java.sql.Types.VARCHAR
                    );
                }

                statement.setString(
                        9,
                        pesanan.getRequestKhusus()
                );

                statement.setString(
                        10,
                        pesanan.getJenisPesanan()
                );

                statement.executeUpdate();
            }

            // ------------------------------------------
            // DETAIL PESANAN
            // ------------------------------------------

            tambahDetailPesanan(
                    connection,
                    pesanan
            );

            // ------------------------------------------
            // RIWAYAT STATUS AWAL
            // ------------------------------------------

            tambahRiwayatStatus(
                    connection,
                    pesanan.getIdPesanan(),
                    pesanan.getStatusPesanan()
            );

            connection.commit();

            return true;

        } catch (SQLException e) {

            connection.rollback();

            throw e;

        } finally {

            connection.close();
        }
    }

    // ==================================================
    // UPDATE PESANAN
    // ==================================================

    @Override
    public boolean ubahPesanan(
            PesananJastip pesanan
    ) throws SQLException {

        Connection connection =
                DatabaseConnection.getConnection();

        if (connection == null) {
            return false;
        }

        try {

            connection.setAutoCommit(false);

            String sqlPelanggan = """
                UPDATE pelanggan
                SET nama_pelanggan = ?,
                    nomor_telepon = ?
                WHERE id_pelanggan = ?
                """;

            try (
                PreparedStatement statement =
                        connection.prepareStatement(
                                sqlPelanggan
                        )
            ) {

                statement.setString(
                        1,
                        pesanan.getPelanggan()
                                .getNamaPelanggan()
                );

                statement.setString(
                        2,
                        pesanan.getPelanggan()
                                .getNomorTelepon()
                );

                statement.setString(
                        3,
                        pesanan.getPelanggan()
                                .getIdPelanggan()
                );

                statement.executeUpdate();
            }

            String sqlBarang = """
                UPDATE barang
                SET nama_barang = ?,
                    harga = ?,
                    berat = ?
                WHERE id_barang = (
                    SELECT id_barang
                    FROM pesanan
                    WHERE id_pesanan = ?
                )
                """;

            try (
                PreparedStatement statement =
                        connection.prepareStatement(
                                sqlBarang
                        )
            ) {

                statement.setString(
                        1,
                        pesanan.getBarang()
                                .getNamaBarang()
                );

                statement.setDouble(
                        2,
                        pesanan.getBarang()
                                .getHarga()
                );

                statement.setDouble(
                        3,
                        pesanan.getBarang()
                                .getBerat()
                );

                statement.setString(
                        4,
                        pesanan.getIdPesanan()
                );

                statement.executeUpdate();
            }

            String sqlPesanan = """
                UPDATE pesanan
                SET jumlah = ?,
                    biaya_jastip = ?,
                    request_khusus = ?
                WHERE id_pesanan = ?
                """;

            try (
                PreparedStatement statement =
                        connection.prepareStatement(
                                sqlPesanan
                        )
            ) {

                statement.setInt(
                        1,
                        pesanan.getJumlah()
                );

                statement.setDouble(
                        2,
                        pesanan.getBiayaJastip()
                );

                statement.setString(
                        3,
                        pesanan.getRequestKhusus()
                );

                statement.setString(
                        4,
                        pesanan.getIdPesanan()
                );

                statement.executeUpdate();
            }

            updateDetailPesanan(
                    connection,
                    pesanan
            );

            connection.commit();

            return true;

        } catch (SQLException e) {

            connection.rollback();

            throw e;

        } finally {

            connection.close();
        }
    }

    // ==================================================
    // DELETE
    // ==================================================

    @Override
    public boolean hapusPesanan(
            String idPesanan
    ) throws SQLException {

        String sql = """
            DELETE FROM pesanan
            WHERE id_pesanan = ?
            """;

        try (
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    idPesanan
            );

            return statement.executeUpdate() > 0;
        }
    }

    // ==================================================
    // UPDATE STATUS
    // ==================================================

    @Override
    public boolean ubahStatusPesanan(
            String idPesanan,
            String statusBaru
    ) throws SQLException {

        String sql = """
            UPDATE pesanan
            SET status_pesanan = ?
            WHERE id_pesanan = ?
            """;

        Connection connection =
                DatabaseConnection.getConnection();

        if (connection == null) {
            return false;
        }

        try {

            connection.setAutoCommit(false);

            try (
                PreparedStatement statement =
                        connection.prepareStatement(sql)
            ) {

                statement.setString(
                        1,
                        statusBaru
                );

                statement.setString(
                        2,
                        idPesanan
                );

                int hasil =
                        statement.executeUpdate();

                if (hasil == 0) {

                    connection.rollback();

                    return false;
                }
            }

            tambahRiwayatStatus(
                    connection,
                    idPesanan,
                    statusBaru
            );

            connection.commit();

            return true;

        } catch (SQLException e) {

            connection.rollback();

            throw e;

        } finally {

            connection.close();
        }
    }

    // ==================================================
    // CREATE BATCH
    // ==================================================

    @Override
    public boolean tambahBatch(
            BatchJastip batch
    ) throws SQLException {

        if (batch == null) {
            return false;
        }

        String sql = """
            INSERT INTO batch_jastip
            (
                id_batch,
                negara_tujuan,
                tanggal_buka,
                batas_order,
                tanggal_berangkat,
                status_batch
            )
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        Connection connection =
                DatabaseConnection.getConnection();

        if (connection == null) {
            return false;
        }

        try (
            PreparedStatement statement =
                    connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    batch.getIdBatch()
            );

            statement.setString(
                    2,
                    batch.getNegaraTujuan()
            );

            statement.setString(
                    3,
                    batch.getTanggalBuka()
            );

            statement.setString(
                    4,
                    batch.getBatasOrder()
            );

            statement.setString(
                    5,
                    batch.getTanggalBerangkat()
            );

            statement.setString(
                    6,
                    batch.getStatusBatch()
            );

            return statement.executeUpdate() > 0;

        } finally {

            connection.close();
        }
    }

    // ==================================================
    // CARI / TAMBAH BARANG
    // ==================================================

    private int cariAtauTambahBarang(
            Connection connection,
            Barang barang
    ) throws SQLException {

        String sqlCari = """
            SELECT id_barang
            FROM barang
            WHERE nama_barang = ?
              AND negara_asal = ?
              AND harga = ?
              AND berat = ?
            LIMIT 1
            """;

        try (
            PreparedStatement statement =
                    connection.prepareStatement(sqlCari)
        ) {

            statement.setString(
                    1,
                    barang.getNamaBarang()
            );

            statement.setString(
                    2,
                    barang.getNegaraAsal()
            );

            statement.setDouble(
                    3,
                    barang.getHarga()
            );

            statement.setDouble(
                    4,
                    barang.getBerat()
            );

            try (
                ResultSet result =
                        statement.executeQuery()
            ) {

                if (result.next()) {

                    return result.getInt(
                            "id_barang"
                    );
                }
            }
        }

        String sqlTambah = """
            INSERT INTO barang
            (
                nama_barang,
                negara_asal,
                harga,
                berat
            )
            VALUES (?, ?, ?, ?)
            """;

        try (
            PreparedStatement statement =
                    connection.prepareStatement(
                            sqlTambah,
                            Statement.RETURN_GENERATED_KEYS
                    )
        ) {

            statement.setString(
                    1,
                    barang.getNamaBarang()
            );

            statement.setString(
                    2,
                    barang.getNegaraAsal()
            );

            statement.setDouble(
                    3,
                    barang.getHarga()
            );

            statement.setDouble(
                    4,
                    barang.getBerat()
            );

            statement.executeUpdate();

            try (
                ResultSet result =
                        statement.getGeneratedKeys()
            ) {

                if (result.next()) {

                    return result.getInt(1);
                }
            }
        }

        throw new SQLException(
                "ID barang gagal diperoleh."
        );
    }

    // ==================================================
    // CARI / TAMBAH PEMBAYARAN
    // ==================================================

    private int cariAtauTambahPembayaran(
            Connection connection,
            Pembayaran pembayaran
    ) throws SQLException {

        String sqlCari = """
            SELECT id_pembayaran
            FROM pembayaran
            WHERE metode_pembayaran = ?
            LIMIT 1
            """;

        try (
            PreparedStatement statement =
                    connection.prepareStatement(sqlCari)
        ) {

            statement.setString(
                    1,
                    pembayaran.getMetodePembayaran()
            );

            try (
                ResultSet result =
                        statement.executeQuery()
            ) {

                if (result.next()) {

                    return result.getInt(
                            "id_pembayaran"
                    );
                }
            }
        }

        String sqlTambah = """
            INSERT INTO pembayaran
            (
                metode_pembayaran
            )
            VALUES (?)
            """;

        try (
            PreparedStatement statement =
                    connection.prepareStatement(
                            sqlTambah,
                            Statement.RETURN_GENERATED_KEYS
                    )
        ) {

            statement.setString(
                    1,
                    pembayaran.getMetodePembayaran()
            );

            statement.executeUpdate();

            try (
                ResultSet result =
                        statement.getGeneratedKeys()
            ) {

                if (result.next()) {

                    return result.getInt(1);
                }
            }
        }

        throw new SQLException(
                "ID pembayaran gagal diperoleh."
        );
    }

    // ==================================================
    // TAMBAH DETAIL
    // ==================================================

    private void tambahDetailPesanan(
            Connection connection,
            PesananJastip pesanan
    ) throws SQLException {

        if (pesanan instanceof JastipFashion fashion) {

            String sql = """
                INSERT INTO detail_fashion
                (
                    id_pesanan,
                    ukuran,
                    warna
                )
                VALUES (?, ?, ?)
                """;

            try (
                PreparedStatement statement =
                        connection.prepareStatement(sql)
            ) {

                statement.setString(
                        1,
                        pesanan.getIdPesanan()
                );

                statement.setString(
                        2,
                        fashion.getUkuran()
                );

                statement.setString(
                        3,
                        fashion.getWarna()
                );

                statement.executeUpdate();
            }

        } else if (pesanan instanceof JastipSkincare skincare) {

            String sql = """
                INSERT INTO detail_skincare
                (
                    id_pesanan,
                    jenis_kulit,
                    ukuran_produk
                )
                VALUES (?, ?, ?)
                """;

            try (
                PreparedStatement statement =
                        connection.prepareStatement(sql)
            ) {

                statement.setString(
                        1,
                        pesanan.getIdPesanan()
                );

                statement.setString(
                        2,
                        skincare.getJenisKulit()
                );

                statement.setInt(
                        3,
                        skincare.getUkuranProduk()
                );

                statement.executeUpdate();
            }

        } else if (pesanan instanceof JastipElektronik elektronik) {

            String sql = """
                INSERT INTO detail_elektronik
                (
                    id_pesanan,
                    merek,
                    garansi
                )
                VALUES (?, ?, ?)
                """;

            try (
                PreparedStatement statement =
                        connection.prepareStatement(sql)
            ) {

                statement.setString(
                        1,
                        pesanan.getIdPesanan()
                );

                statement.setString(
                        2,
                        elektronik.getMerek()
                );

                statement.setInt(
                        3,
                        elektronik.getGaransi()
                );

                statement.executeUpdate();
            }
        }
    }

    // ==================================================
    // UPDATE DETAIL
    // ==================================================

    private void updateDetailPesanan(
            Connection connection,
            PesananJastip pesanan
    ) throws SQLException {

        if (pesanan instanceof JastipFashion fashion) {

            String sql = """
                UPDATE detail_fashion
                SET ukuran = ?,
                    warna = ?
                WHERE id_pesanan = ?
                """;

            try (
                PreparedStatement statement =
                        connection.prepareStatement(sql)
            ) {

                statement.setString(
                        1,
                        fashion.getUkuran()
                );

                statement.setString(
                        2,
                        fashion.getWarna()
                );

                statement.setString(
                        3,
                        pesanan.getIdPesanan()
                );

                statement.executeUpdate();
            }

        } else if (pesanan instanceof JastipSkincare skincare) {

            String sql = """
                UPDATE detail_skincare
                SET jenis_kulit = ?,
                    ukuran_produk = ?
                WHERE id_pesanan = ?
                """;

            try (
                PreparedStatement statement =
                        connection.prepareStatement(sql)
            ) {

                statement.setString(
                        1,
                        skincare.getJenisKulit()
                );

                statement.setInt(
                        2,
                        skincare.getUkuranProduk()
                );

                statement.setString(
                        3,
                        pesanan.getIdPesanan()
                );

                statement.executeUpdate();
            }

        } else if (pesanan instanceof JastipElektronik elektronik) {

            String sql = """
                UPDATE detail_elektronik
                SET merek = ?,
                    garansi = ?
                WHERE id_pesanan = ?
                """;

            try (
                PreparedStatement statement =
                        connection.prepareStatement(sql)
            ) {

                statement.setString(
                        1,
                        elektronik.getMerek()
                );

                statement.setInt(
                        2,
                        elektronik.getGaransi()
                );

                statement.setString(
                        3,
                        pesanan.getIdPesanan()
                );

                statement.executeUpdate();
            }
        }
    }

    // ==================================================
    // RIWAYAT STATUS
    // ==================================================

    private void tambahRiwayatStatus(
            Connection connection,
            String idPesanan,
            String status
    ) throws SQLException {

        String sql = """
            INSERT INTO riwayat_status
            (
                id_pesanan,
                status
            )
            VALUES (?, ?)
            """;

        try (
            PreparedStatement statement =
                    connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    idPesanan
            );

            statement.setString(
                    2,
                    status
            );

            statement.executeUpdate();
        }
    }
}