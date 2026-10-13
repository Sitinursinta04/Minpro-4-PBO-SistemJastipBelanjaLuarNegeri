/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package View;

/**
 *
 * @author Lenovo
 */

import java.util.Scanner;

public class ValidasiInput {

    private Scanner scanner;

    public ValidasiInput(Scanner scanner) {
        this.scanner = scanner;
    }

    // ==========================================
    // STRING
    // ==========================================

    public String inputString(String pesan) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input tidak boleh kosong."
            );
        }
    }

    public String inputStringBisaBatal(String pesan) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                return null;
            }

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input tidak boleh kosong."
            );
        }
    }

    // ==========================================
    // NAMA
    // ==========================================

    public String inputNama(String pesan) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {

                System.out.println(
                        "Nama tidak boleh kosong."
                );

                continue;
            }

            if (!input.matches(
                    "[a-zA-ZÀ-ÿ .'-]+")) {

                System.out.println(
                        "Nama hanya boleh berisi huruf."
                );

                continue;
            }

            return input;
        }
    }

    public String inputNamaBisaBatal(String pesan) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                return null;
            }

            if (input.isEmpty()) {

                System.out.println(
                        "Nama tidak boleh kosong."
                );

                continue;
            }

            if (!input.matches(
                    "[a-zA-ZÀ-ÿ .'-]+")) {

                System.out.println(
                        "Nama hanya boleh berisi huruf."
                );

                continue;
            }

            return input;
        }
    }

    // ==========================================
    // NOMOR TELEPON
    // ==========================================

    public String inputNomorTelepon(String pesan) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            if (!input.matches("\\d+")) {

                System.out.println(
                        "Nomor telepon hanya boleh berisi angka."
                );

                continue;
            }

            if (input.length() < 10
                    || input.length() > 15) {

                System.out.println(
                        "Nomor telepon harus 10-15 digit."
                );

                continue;
            }

            return input;
        }
    }

    public String inputNomorTeleponBisaBatal(
            String pesan) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                return null;
            }

            if (!input.matches("\\d+")) {

                System.out.println(
                        "Nomor telepon hanya boleh berisi angka."
                );

                continue;
            }

            if (input.length() < 10
                    || input.length() > 15) {

                System.out.println(
                        "Nomor telepon harus 10-15 digit."
                );

                continue;
            }

            return input;
        }
    }

    // ==========================================
    // INTEGER
    // ==========================================

    public int inputInteger(
            String pesan,
            int minimum,
            int maksimum) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            try {

                int angka = Integer.parseInt(input);

                if (angka < minimum
                        || angka > maksimum) {

                    System.out.println(
                            "Masukkan angka "
                            + minimum
                            + " sampai "
                            + maksimum
                    );

                    continue;
                }

                return angka;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input harus berupa angka."
                );
            }
        }
    }

    public int inputIntegerBisaBatal(
            String pesan,
            int minimum,
            int maksimum) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                return 0;
            }

            try {

                int angka = Integer.parseInt(input);

                if (angka < minimum
                        || angka > maksimum) {

                    System.out.println(
                            "Masukkan angka "
                            + minimum
                            + " sampai "
                            + maksimum
                    );

                    continue;
                }

                return angka;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input harus berupa angka."
                );
            }
        }
    }

    // ==========================================
    // DOUBLE
    // ==========================================

    public double inputDouble(
            String pesan,
            double minimum,
            double maksimum) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            try {

                double angka =
                        Double.parseDouble(input);

                if (angka < minimum
                        || angka > maksimum) {

                    System.out.println(
                            "Masukkan angka "
                            + minimum
                            + " sampai "
                            + maksimum
                    );

                    continue;
                }

                return angka;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input harus berupa angka."
                );
            }
        }
    }

    public double inputDoubleBisaBatal(
            String pesan,
            double minimum,
            double maksimum) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                return 0;
            }

            try {

                double angka =
                        Double.parseDouble(input);

                if (angka < minimum
                        || angka > maksimum) {

                    System.out.println(
                            "Masukkan angka "
                            + minimum
                            + " sampai "
                            + maksimum
                    );

                    continue;
                }

                return angka;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input harus berupa angka."
                );
            }
        }
    }
}