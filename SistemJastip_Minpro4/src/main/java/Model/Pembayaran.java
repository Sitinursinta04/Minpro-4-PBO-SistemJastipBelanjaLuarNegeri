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
@Table(name = "pembayaran")
public class Pembayaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pembayaran")
    private int idPembayaran;

    @Column(name = "metode_pembayaran")
    private String metodePembayaran;

    // Constructor kosong untuk Hibernate
    public Pembayaran() {
    }

    // Constructor
    public Pembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    // Getter
    public int getIdPembayaran() {
        return idPembayaran;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    // Setter
    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }
}