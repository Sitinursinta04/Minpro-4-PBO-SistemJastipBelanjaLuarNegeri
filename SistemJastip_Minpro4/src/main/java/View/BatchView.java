/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package View;

/**
 *
 * @author Lenovo
 */

import java.util.ArrayList;
import Model.BatchJastip;

public class BatchView {

    public void tampilkanSemuaBatch(
            ArrayList<BatchJastip> daftarBatch) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("           DAFTAR BATCH JASTIP");
        System.out.println("==========================================");

        if (daftarBatch.isEmpty()) {

            System.out.println("Belum ada batch jastip.");

            System.out.println("==========================================");

            return;
        }

        for (BatchJastip batch : daftarBatch) {

            System.out.println("------------------------------------------");

            System.out.println("ID Batch          : "
                    + batch.getIdBatch());

            System.out.println("Negara Tujuan     : "
                    + batch.getNegaraTujuan());

            System.out.println("Tanggal Buka      : "
                    + batch.getTanggalBuka());

            System.out.println("Batas Order       : "
                    + batch.getBatasOrder());

            System.out.println("Tanggal Berangkat : "
                    + batch.getTanggalBerangkat());

            System.out.println("Status Batch      : "
                    + batch.getStatusBatch());
        }

        System.out.println("------------------------------------------");
        System.out.println("==========================================");
    }

    public void tampilkanDetailBatch(
            BatchJastip batch) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("            DETAIL BATCH JASTIP");
        System.out.println("==========================================");

        if (batch == null) {

            System.out.println("Batch tidak ditemukan.");

            System.out.println("==========================================");

            return;
        }

        System.out.println("ID Batch          : "
                + batch.getIdBatch());

        System.out.println("Negara Tujuan     : "
                + batch.getNegaraTujuan());

        System.out.println("Tanggal Buka      : "
                + batch.getTanggalBuka());

        System.out.println("Batas Order       : "
                + batch.getBatasOrder());

        System.out.println("Tanggal Berangkat : "
                + batch.getTanggalBerangkat());

        System.out.println("Status Batch      : "
                + batch.getStatusBatch());

        System.out.println("==========================================");
    }
}