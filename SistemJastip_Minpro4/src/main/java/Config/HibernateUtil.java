/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 * to edit this template
 */
package Config;

import Model.Pelanggan;
import Model.Barang;
import Model.Pembayaran;
import Model.BatchJastip;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Lenovo
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            // Mendaftarkan Entity
            configuration.addAnnotatedClass(Pelanggan.class);
            configuration.addAnnotatedClass(Barang.class);
            configuration.addAnnotatedClass(Pembayaran.class);
            configuration.addAnnotatedClass(BatchJastip.class);

            // Konfigurasi Driver Database
            configuration.setProperty(
                    "hibernate.connection.driver_class",
                    "com.mysql.cj.jdbc.Driver"
            );

            // Konfigurasi Database
            configuration.setProperty(
                    "hibernate.connection.url",
                    "jdbc:mysql://localhost:3306/sistem_jastip"
            );

            configuration.setProperty(
                    "hibernate.connection.username",
                    "root"
            );

            configuration.setProperty(
                    "hibernate.connection.password",
                    ""
            );

            // Dialect MySQL
            configuration.setProperty(
                    "hibernate.dialect",
                    "org.hibernate.dialect.MySQLDialect"
            );

            // Menampilkan SQL yang dijalankan Hibernate
            configuration.setProperty(
                    "hibernate.show_sql",
                    "true"
            );

            configuration.setProperty(
                    "hibernate.format_sql",
                    "true"
            );

            // Hibernate tidak membuat atau mengubah struktur tabel
            configuration.setProperty(
                    "hibernate.hbm2ddl.auto",
                    "none"
            );

            return configuration.buildSessionFactory();

        } catch (Throwable e) {
            System.err.println("Gagal membuat SessionFactory.");
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}