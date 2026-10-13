/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.BatchJastip;
import Model.PesananJastip;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface PesananDAO {

    // READ
    List<PesananJastip> getAllPesanan() throws SQLException;

    // CREATE
    boolean tambahPesanan(
            PesananJastip pesanan
    ) throws SQLException;

    // UPDATE
    boolean ubahPesanan(
            PesananJastip pesanan
    ) throws SQLException;

    // DELETE
    boolean hapusPesanan(
            String idPesanan
    ) throws SQLException;

    // UPDATE STATUS
    boolean ubahStatusPesanan(
            String idPesanan,
            String statusBaru
    ) throws SQLException;

    // CREATE BATCH
    boolean tambahBatch(
            BatchJastip batch
    ) throws SQLException;
}