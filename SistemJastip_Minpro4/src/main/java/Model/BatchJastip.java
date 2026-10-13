/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "batch_jastip")
public class BatchJastip {

    @Id
    @Column(name = "id_batch")
    private String idBatch;

    @Column(name = "negara_tujuan")
    private String negaraTujuan;

    @Column(name = "tanggal_buka")
    private String tanggalBuka;

    @Column(name = "batas_order")
    private String batasOrder;

    @Column(name = "tanggal_berangkat")
    private String tanggalBerangkat;

    @Column(name = "status_batch")
    private String statusBatch;

    // Constructor kosong untuk Hibernate
    public BatchJastip() {
    }

    // Constructor
    public BatchJastip(
            String idBatch,
            String negaraTujuan,
            String tanggalBuka,
            String batasOrder,
            String tanggalBerangkat,
            String statusBatch) {

        this.idBatch = idBatch;
        this.negaraTujuan = negaraTujuan;
        this.tanggalBuka = tanggalBuka;
        this.batasOrder = batasOrder;
        this.tanggalBerangkat = tanggalBerangkat;
        this.statusBatch = statusBatch;
    }

    // Getter
    public String getIdBatch() {
        return idBatch;
    }

    public String getNegaraTujuan() {
        return negaraTujuan;
    }

    public String getTanggalBuka() {
        return tanggalBuka;
    }

    public String getBatasOrder() {
        return batasOrder;
    }

    public String getTanggalBerangkat() {
        return tanggalBerangkat;
    }

    public String getStatusBatch() {
        return statusBatch;
    }

    // Setter
    public void setNegaraTujuan(String negaraTujuan) {
        this.negaraTujuan = negaraTujuan;
    }

    public void setTanggalBuka(String tanggalBuka) {
        this.tanggalBuka = tanggalBuka;
    }

    public void setBatasOrder(String batasOrder) {
        this.batasOrder = batasOrder;
    }

    public void setTanggalBerangkat(String tanggalBerangkat) {
        this.tanggalBerangkat = tanggalBerangkat;
    }

    public void setStatusBatch(String statusBatch) {
        this.statusBatch = statusBatch;
    }
}