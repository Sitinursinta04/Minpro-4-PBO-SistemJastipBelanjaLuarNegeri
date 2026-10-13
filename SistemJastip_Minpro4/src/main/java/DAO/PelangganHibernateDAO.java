/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.HibernateUtil;
import Model.Pelanggan;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Lenovo
 */

public class PelangganHibernateDAO {

    public List<Pelanggan> getAllPelanggan() {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            return session
                    .createQuery(
                            "FROM Pelanggan",
                            Pelanggan.class
                    )
                    .getResultList();

        } catch (Exception e) {

            System.out.println(
                    "Gagal mengambil data pelanggan menggunakan Hibernate: "
                    + e.getMessage()
            );

            return List.of();
        }
    }
}