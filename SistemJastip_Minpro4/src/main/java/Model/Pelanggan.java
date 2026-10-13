/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
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
@Table(name = "pelanggan")
public class Pelanggan {

    @Id
    @Column(name = "id_pelanggan")
    private String idPelanggan;

    @Column(name = "nama_pelanggan")
    private String namaPelanggan;

    @Column(name = "nomor_telepon")
    private String nomorTelepon;

    // Constructor kosong untuk Hibernate
    public Pelanggan() {
    }

    // Constructor
    public Pelanggan(
            String idPelanggan,
            String namaPelanggan,
            String nomorTelepon) {

        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.nomorTelepon = nomorTelepon;
    }

    // Getter
    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    // Setter
    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }
}