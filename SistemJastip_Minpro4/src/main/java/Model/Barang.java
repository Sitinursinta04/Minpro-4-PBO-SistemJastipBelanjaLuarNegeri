/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "barang")
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barang")
    private int idBarang;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "negara_asal")
    private String negaraAsal;

    @Column(name = "harga")
    private double harga;

    @Column(name = "berat")
    private double berat;

    // Constructor kosong untuk Hibernate
    public Barang() {
    }

    // Constructor
    public Barang(
            String namaBarang,
            String negaraAsal,
            double harga,
            double berat) {

        this.namaBarang = namaBarang;
        this.negaraAsal = negaraAsal;
        this.harga = harga;
        this.berat = berat;
    }

    // Getter
    public int getIdBarang() {
        return idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getNegaraAsal() {
        return negaraAsal;
    }

    public double getHarga() {
        return harga;
    }

    public double getBerat() {
        return berat;
    }

    // Setter
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setNegaraAsal(String negaraAsal) {
        this.negaraAsal = negaraAsal;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }
}