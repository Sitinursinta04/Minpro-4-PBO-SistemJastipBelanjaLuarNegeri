## 📦🛍️ Sistem Jasa Titip Belanja Luar Negeri - Mini Project 4 

<table align="center">
<tr>
<td align="center"><b>Nama</b><br>Siti Nursinta</td>
<td align="center"><b>NIM</b><br>2509116087</td>
<td align="center"><b>Kelas</b><br>C25</td>
<td align="center"><b>Praktikum</b><br>Pemrograman Berorientasi Objek</td>
</tr>
</table>
---

<p align="center">
  <b>Pengembangan Sistem Jasa Titip Berbasis Java, JDBC, DAO, dan Hibernate ORM</b>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-26-orange?style=for-the-badge&logo=openjdk" alt="Java">
  <img src="https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql" alt="MySQL">
  <img src="https://img.shields.io/badge/JDBC-PreparedStatement-1f6feb?style=for-the-badge" alt="JDBC">
  <img src="https://img.shields.io/badge/DAO-Data_Access_Object-6f42c1?style=for-the-badge" alt="DAO">
  <img src="https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate" alt="Hibernate">
  <img src="https://img.shields.io/badge/Maven-Project-C71A36?style=for-the-badge&logo=apachemaven" alt="Maven">
</p>

<p align="center">
  <i>Pengembangan lanjutan dari Mini Project 3 dengan integrasi database dan ORM.</i>
</p>

---

<table align="center">
<tr>
<td align="center"><b>📦 Project</b><br>Mini Project 4</td>
<td align="center"><b>☕ Bahasa</b><br>Java</td>
<td align="center"><b>🗄️ Database</b><br>MySQL</td>
<td align="center"><b>🔌 Database Access</b><br>JDBC + DAO</td>
<td align="center"><b>✨ Value Add</b><br>Hibernate ORM</td>
</tr>
</table>

---
## 📌 Tentang Project

**Sistem Jasa Titip Luar Negeri** merupakan aplikasi berbasis Java yang dikembangkan untuk membantu pengelolaan pesanan jasa titip dari luar negeri, mulai dari menyimpan data pelanggan, barang, pembayaran, batch jastip, hingga mengelola status pesanan.

Project ini merupakan pengembangan lanjutan dari **Mini Project 3**. Pada Mini Project 4, sistem yang sebelumnya hanya mengelola object selama program berjalan dikembangkan agar dapat terhubung dengan database MySQL secara langsung.

Integrasi database diterapkan menggunakan **JDBC, PreparedStatement, dan DAO**. Dengan penerapan tersebut, data pesanan yang dibuat, diubah, maupun dihapus melalui program dapat ikut tersimpan atau berubah pada database.

Selain memenuhi ketentuan utama menggunakan JDBC, project ini juga mengimplementasikan **Hibernate ORM sebagai nilai tambah**. Hibernate tidak menggantikan JDBC, tetapi digunakan sebagai pendekatan tambahan untuk memperlihatkan bagaimana object Java dapat dipetakan ke tabel database dan diakses melalui framework ORM.

---

## 🎯 Tujuan Pengembangan

Pengembangan Mini Project 4 dilakukan untuk:

- Menghubungkan aplikasi Java dengan database MySQL.
- Menerapkan koneksi database menggunakan JDBC.
- Menerapkan `PreparedStatement` dalam proses query.
- Menerapkan pola **DAO (Data Access Object)** untuk memisahkan akses database dari logika program.
- Mengimplementasikan operasi **CRUD** pada data pesanan.
- Menyediakan dummy data awal melalui file `.sql`.
- Mempertahankan konsep OOP yang telah diterapkan pada Mini Project 3.
- Menerapkan **Hibernate ORM** sebagai nilai tambah.
- Memahami hubungan antara object Java, proses aplikasi, dan database.

---

## 🧩 Struktur Project

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Matkul/third/Screenshot%202026-10-13%20165853.png" width="75%" alt="Struktur Package">
    </td>
  </tr>
</table>

Struktur package dipisahkan berdasarkan tanggung jawab masing-masing bagian agar kode lebih terorganisir, mudah dipahami, dan lebih mudah dikembangkan.

| Package | Fungsi |
|---|---|
| `Model` | Merepresentasikan data dan menerapkan konsep OOP |
| `View` | Menangani interaksi dengan pengguna dan menampilkan informasi |
| `Controller` | Mengatur alur proses aplikasi |
| `DAO` | Menangani akses, penyimpanan, perubahan, dan penghapusan data |
| `Config` | Mengatur konfigurasi JDBC dan Hibernate |
| `Main` | Menjadi titik awal ketika aplikasi dijalankan |

Pemisahan tersebut digunakan agar setiap bagian program memiliki tanggung jawab yang jelas. Dengan struktur ini, perubahan pada proses akses atau pengelolaan database dapat dilakukan pada bagian `DAO` tanpa harus mengubah seluruh tampilan atau struktur `Model`.

Hal tersebut membuat kode menjadi lebih terstruktur dan lebih mudah dipelihara.

---

## 📚 Dependencies

Bagian `Dependencies` berisi library tambahan yang digunakan oleh project untuk mendukung koneksi database dan penerapan Hibernate ORM.

| Dependency | Kegunaan |
|---|---|
| `hibernate-core-6.6.26.Final.jar` | Menerapkan Hibernate ORM sebagai nilai tambah |
| `mysql-connector-j-9.4.0.jar` | Driver agar Java dapat terhubung dengan MySQL melalui JDBC |
| `jakarta.persistence-api-3.1.0.jar` | Mendukung entity dan persistence pada Hibernate |
| `jakarta.transaction-api-2.1.1.jar` | Mendukung kebutuhan transaksi persistence |
| `protobuf-java-4.31.1.jar` | Library pendukung yang digunakan oleh dependency Hibernate |

Dependencies tersebut digunakan karena project membutuhkan library tambahan di luar Java standar, terutama untuk koneksi MySQL dan penerapan Hibernate ORM.

### 📄 Project Files

File konfigurasi utama project adalah:

```text
pom.xml
```

File `pom.xml` digunakan untuk mengatur konfigurasi project Maven, termasuk dependency yang dibutuhkan oleh aplikasi. Dengan adanya file ini, library yang digunakan dalam project dapat dikelola secara terpusat sehingga konfigurasi project menjadi lebih terstruktur dan mudah dikelola.

> **Catatan:** `Dependencies` dan `Project Files` bukan merupakan package utama yang dibuat untuk menyimpan logika program. Keduanya merupakan bagian pendukung project yang ditampilkan oleh NetBeans/Maven dan membantu project dalam mengelola library serta konfigurasi yang dibutuhkan.

---

## ⏩ Alur Program

Program dijalankan melalui class `SistemJastip_Minpro4`. Setelah program berjalan, data pesanan dapat dimuat dari database melalui `PesananController` dan `PesananDAOImpl`.

<table align="center">
<tr>
<td align="center">①<br><b>Program</b></td>
<td>→</td>
<td align="center">②<br><b>Controller</b></td>
<td>→</td>
<td align="center">③<br><b>DAO</b></td>
<td>→</td>
<td align="center">④<br><b>JDBC</b></td>
<td>→</td>
<td align="center">⑤<br><b>MySQL</b></td>
</tr>
</table>

Secara umum, proses pengelolaan data berjalan melalui tahapan berikut:

- Program dijalankan melalui `SistemJastip_Minpro4`.
- `PesananController` meminta data kepada DAO.
- `PesananDAOImpl` mengambil data dari MySQL menggunakan JDBC dan `PreparedStatement`.
- Hasil query diubah menjadi object `PesananJastip` beserta jenis pesanan yang sesuai.
- Data ditampilkan melalui View.
- Pengguna memilih operasi seperti tambah, lihat, ubah, hapus, atau mengubah status pesanan.
- Controller meneruskan proses tersebut kepada DAO.
- DAO menjalankan query database sesuai operasi yang dipilih.
- Setelah berhasil, perubahan disimpan pada database.
- Data dapat dimuat kembali sehingga informasi yang tampil pada program mengikuti kondisi database terbaru.

Pembagian proses tersebut membuat alur antara tampilan, logika aplikasi, akses database, dan penyimpanan data menjadi lebih jelas.

---

## 🔐 Penerapan Encapsulation

**Encapsulation** digunakan untuk membatasi akses langsung terhadap data yang dimiliki oleh sebuah object.

Pada project ini, encapsulation diterapkan pada class-class dalam package `Model` dengan menggunakan atribut `private`.

Contohnya pada class `Pelanggan`:

```java
private String idPelanggan;
private String namaPelanggan;
private String nomorTelepon;
```

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Matkul/third/Screenshot%202026-10-13%20170144.png" width="75%" alt="Encapsulation">
    </td>
  </tr>
</table>

Atribut tersebut tidak diakses secara langsung dari luar class. Pengaksesan data dilakukan melalui getter dan setter.

```java
public String getNamaPelanggan() {
    return namaPelanggan;
}
```

```java
public void setNamaPelanggan(String namaPelanggan) {
    this.namaPelanggan = namaPelanggan;
}
```

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Matkul/third/Screenshot%202026-10-13%20170200.png" width="75%" alt="Getter Setter">
    </td>
  </tr>
</table>

Encapsulation digunakan agar data object lebih terkontrol. Sebagai contoh, perubahan nama pelanggan dilakukan melalui method `setNamaPelanggan()`, bukan dengan mengubah atribut secara langsung dari class lain.

Penerapan ini juga membuat tanggung jawab setiap class lebih jelas, karena data pelanggan dikelola oleh `Pelanggan`, sedangkan data barang dikelola oleh `Barang`.

---

## 🧬 Penerapan Inheritance

**Inheritance** digunakan agar sebuah class dapat mewarisi karakteristik dan perilaku dari class lain.

Pada sistem ini, inheritance diterapkan pada jenis pesanan jasa titip. Class induknya adalah:

```java
public abstract class PesananJastip {
    ...
}
```

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Matkul/third/Screenshot%202026-10-13%20170326.png" width="75%" alt="Inheritance">
    </td>
  </tr>
</table>

Class tersebut memiliki beberapa class turunan:

```text
PesananJastip
├── JastipFashion
├── JastipSkincare
└── JastipElektronik
```

Masing-masing subclass memiliki karakteristik khusus:

- `JastipFashion` memiliki ukuran dan warna.
- `JastipSkincare` memiliki jenis kulit dan ukuran produk.
- `JastipElektronik` memiliki merek dan informasi garansi.

Inheritance digunakan agar bagian yang bersifat umum tidak perlu ditulis ulang pada setiap class. Class turunan cukup menambahkan data dan perilaku yang memang khusus untuk jenis pesanan tersebut.

Dengan pendekatan ini, struktur program menjadi lebih rapi karena karakteristik umum pesanan berada pada `PesananJastip`, sedangkan detail khusus berada pada masing-masing subclass.

---

## 🔄 Penerapan Polymorphism

**Polymorphism** memungkinkan beberapa object dari class yang berbeda diperlakukan melalui tipe induk yang sama.

Pada project ini, polymorphism diterapkan melalui hubungan antara `PesananJastip` dengan class `JastipFashion`, `JastipSkincare`, dan `JastipElektronik`.

Salah satu penerapannya adalah overriding method:

```java
@Override
public String getJenisPesanan() {
    return "Jastip Fashion";
}
```

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Matkul/third/Screenshot%202026-10-13%20170412.png" width="75%" alt="Polymorphism">
    </td>
  </tr>
</table>

Class turunan lainnya memberikan implementasi `getJenisPesanan()` sesuai dengan jenis pesanan masing-masing.

Dengan demikian, program dapat menggunakan referensi bertipe `PesananJastip`, tetapi method yang dijalankan tetap mengikuti object sebenarnya.

Penerapan polymorphism membuat pengelolaan berbagai jenis pesanan menjadi lebih fleksibel karena setiap jenis dapat memiliki perilaku khusus tanpa mengubah struktur class induknya.

---

## 🌌 Penerapan Abstraction

**Abstraction** digunakan untuk menyediakan struktur umum yang dapat digunakan oleh class lain tanpa harus menampilkan seluruh detail implementasinya.

Pada project ini, abstraction diterapkan melalui abstract class:

```java
public abstract class PesananJastip
```

Salah satu method abstract yang digunakan adalah:

```java
public abstract String getJenisPesanan();
```

Class `PesananJastip` menyediakan bagian yang bersifat umum untuk semua jenis pesanan. Sementara itu, detail mengenai jenis pesanan diserahkan kepada class turunannya.

Dengan cara ini, class induk tidak perlu mengetahui detail bagaimana setiap jenis pesanan menentukan jenisnya. Detail tersebut ditangani oleh subclass masing-masing.

---

## 🔗 Penerapan Interface

Selain abstract class, sistem menggunakan interface:

```java
public interface BisaDivalidasi {
    boolean validasiDetailPesanan();
}
```

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Matkul/third/Screenshot%202026-10-13%20170512.png" width="75%" alt="Interface">
    </td>
  </tr>
</table>

Interface tersebut memberikan kemampuan validasi kepada jenis pesanan.

Aturan validasi disesuaikan dengan karakteristik masing-masing jenis:

| Jenis Pesanan | Detail yang Divalidasi |
|---|---|
| Fashion | Ukuran dan warna |
| Skincare | Jenis kulit dan ukuran produk |
| Elektronik | Merek dan garansi |

Interface digunakan karena setiap jenis pesanan memiliki kebutuhan validasi yang berbeda, tetapi tetap memiliki tujuan yang sama, yaitu memastikan detail pesanan valid sebelum digunakan.

---

## 🗄️ Database MySQL

Database yang digunakan dalam project ini bernama:

```sql
sistem_jastip
```

Database terdiri dari beberapa tabel:

| Tabel | Fungsi |
|---|---|
| `pelanggan` | Menyimpan data pelanggan |
| `barang` | Menyimpan data barang |
| `pembayaran` | Menyimpan metode pembayaran |
| `batch_jastip` | Menyimpan informasi batch jasa titip |
| `pesanan` | Menyimpan data utama pesanan |
| `detail_fashion` | Menyimpan detail pesanan fashion |
| `detail_skincare` | Menyimpan detail pesanan skincare |
| `detail_elektronik` | Menyimpan detail pesanan elektronik |
| `riwayat_status` | Menyimpan riwayat perubahan status |

Relasi antar tabel digunakan agar setiap jenis data memiliki tempat penyimpanan yang sesuai. Sebagai contoh, informasi pelanggan disimpan pada tabel `pelanggan`, sedangkan tabel `pesanan` menyimpan `id_pelanggan` sebagai foreign key.

Pendekatan tersebut membuat database lebih terstruktur dan menghindari penyimpanan informasi yang sama secara berulang pada tabel pesanan.

---

## 📄 Dummy Data

Sesuai ketentuan Mini Project 4, database harus memiliki data awal sehingga fitur **Read** dapat langsung menampilkan data ketika program dijalankan.

Dummy data dimasukkan melalui file:

```text
database/sistem_jastip.sql
```

Contohnya:

```sql
INSERT INTO pelanggan
(id_pelanggan, nama_pelanggan, nomor_telepon)
VALUES
('P001', 'Alya Putri', '081234567890'),
('P002', 'Raka Pratama', '082345678901');
```

Data awal dimasukkan melalui file SQL, bukan melalui kode Java. Hal ini membuat proses pengujian lebih mudah karena ketika program dijalankan dan fitur Read digunakan, database sudah memiliki data yang dapat langsung ditampilkan.

---

## 🔌 Penerapan JDBC

**JDBC (Java Database Connectivity)** digunakan sebagai mekanisme utama yang menghubungkan aplikasi Java dengan database MySQL.

Koneksi database terdapat pada:

```text
Config/DatabaseConnection.java
```

Contoh konfigurasi:

```java
private static final String URL =
        "jdbc:mysql://localhost:3306/sistem_jastip";

private static final String USER = "root";

private static final String PASSWORD = "";
```

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Matkul/third/Screenshot%202026-10-13%20170648.png" width="75%" alt="Konfigurasi JDBC">
    </td>
  </tr>
</table>

Koneksi dibuat menggunakan:

```java
DriverManager.getConnection(URL, USER, PASSWORD);
```

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Matkul/third/Screenshot%202026-10-13%20170735.png" width="75%" alt="DriverManager JDBC">
    </td>
  </tr>
</table>

JDBC digunakan sebagai mekanisme utama karena merupakan bagian wajib dari Mini Project 4 dan memberikan kontrol langsung terhadap proses query database.

Melalui JDBC, aplikasi tidak hanya mengelola object di dalam memory, tetapi dapat menyimpan, mengambil, mengubah, dan menghapus data secara permanen pada MySQL.

---

## 🛡️ PreparedStatement

Dalam proses JDBC, project menggunakan **PreparedStatement** untuk menjalankan query database. Penerapan ini terdapat pada class:

```text
DAO/PesananDAOImpl.java
```

Salah satu contohnya terdapat pada method `hapusPesanan()`:

```java
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
```

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Matkul/third/Screenshot%202026-10-13%20171314.png" width="75%" alt="PreparedStatement">
    </td>
  </tr>
</table>

Penggunaan `?` membuat nilai parameter diberikan secara terpisah dari perintah SQL.

Pada contoh tersebut, nilai `idPesanan` dimasukkan menggunakan:

```java
statement.setString(1, idPesanan);
```

PreparedStatement digunakan agar query lebih terstruktur dan parameter tidak perlu digabungkan langsung ke dalam string SQL. Pendekatan ini juga membantu membuat proses pengiriman parameter ke database lebih aman dibandingkan menyusun query menggunakan penggabungan string secara langsung.

Selain operasi Delete, `PreparedStatement` juga digunakan pada operasi Create, Update, dan perubahan status di `PesananDAOImpl.java`.

---

## 🗂️ Penerapan DAO

**DAO (Data Access Object)** digunakan untuk memisahkan proses akses database dari Controller dan View.

Interface DAO terdapat pada:

```text
DAO/PesananDAO.java
```

dengan operasi utama:

```java
List<PesananJastip> getAllPesanan();

boolean tambahPesanan(
    PesananJastip pesanan
);

boolean ubahPesanan(
    PesananJastip pesanan
);

boolean hapusPesanan(
    String idPesanan
);

boolean ubahStatusPesanan(
    String idPesanan,
    String statusBaru
);
```

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Matkul/third/Screenshot%202026-10-13%20171411.png" width="75%" alt="DAO Interface">
    </td>
  </tr>
</table>

Implementasinya terdapat pada:

```text
DAO/PesananDAOImpl.java
```

`PesananDAOImpl` menjadi bagian yang berisi implementasi query JDBC, termasuk `PreparedStatement`.

Dengan adanya DAO, `PesananController` tidak perlu menulis query SQL secara langsung. Controller cukup memanggil method DAO sesuai kebutuhan.

Pemisahan ini membuat kode lebih mudah dipelihara. Jika query database perlu diperbaiki, perubahan dapat dilakukan pada bagian DAO tanpa harus mengubah seluruh controller atau tampilan.

---

## 📥 Penerapan CRUD

JDBC dan DAO digunakan untuk mendukung operasi CRUD pada data pesanan.

<table align="center">
<tr>
<td align="center">➕<br><b>Create</b></td>
<td align="center">📖<br><b>Read</b></td>
<td align="center">✏️<br><b>Update</b></td>
<td align="center">🗑️<br><b>Delete</b></td>
</tr>
</table>

### ➕ Create

Create digunakan ketika pengguna menambahkan pesanan baru.

Data yang dimasukkan melalui program diteruskan ke `PesananDAOImpl`, kemudian disimpan ke database menggunakan query `INSERT`.

```sql
INSERT INTO pesanan ...
```

Setelah proses berhasil, data baru dapat ditampilkan kembali melalui fitur Read.

### 📖 Read

Read digunakan untuk mengambil data pesanan dari database.

Pada proses ini, `PesananDAOImpl` mengambil data menggunakan query `SELECT` dan beberapa `JOIN` sehingga informasi yang ditampilkan dapat mencakup pelanggan, barang, pembayaran, batch, dan detail jenis pesanan.

Hasil query kemudian dibentuk menjadi object seperti `JastipFashion`, `JastipSkincare`, atau `JastipElektronik`.

### ✏️ Update

Update digunakan untuk mengubah data yang sudah tersimpan.

Pada proses ini, perubahan data pelanggan, barang, jumlah pesanan, biaya jastip, dan request khusus diteruskan dari Controller ke DAO dan kemudian disimpan menggunakan query `UPDATE`.

```sql
UPDATE pesanan
SET ...
WHERE id_pesanan = ?
```

### 🗑️ Delete

Delete digunakan untuk menghapus pesanan berdasarkan ID pesanan.

```sql
DELETE FROM pesanan
WHERE id_pesanan = ?
```

Query tersebut dijalankan melalui `PreparedStatement` pada `PesananDAOImpl`.

CRUD digunakan agar sistem tidak hanya dapat menampilkan data, tetapi juga dapat mengelola perubahan data secara langsung dan permanen pada database.

---

## 🖥️ Dokumentasi Output Program

Bagian ini berisi screenshot hasil program setelah fitur-fitur utama dijalankan. Dokumentasi output digunakan sebagai bukti visual bahwa fitur yang dikembangkan dapat berjalan dengan baik dan perubahan data yang dilakukan melalui program dapat diterapkan pada database.

### 01 Menu Utama

Menampilkan menu utama sistem setelah program berhasil dijalankan. Menu ini menjadi halaman awal yang digunakan pengguna untuk memilih fitur yang tersedia di dalam sistem.

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Dokumentasi/Screenshot%202026-09-19%20211755.png" width="75%" alt="Menu Utama">
    </td>
  </tr>
</table>

---

### 02 Menampilkan Data Pesanan

Menampilkan data pesanan yang berasal dari database. Data dapat langsung ditampilkan karena sebelumnya telah tersedia dummy data pada file `sistem_jastip.sql`.

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Dokumentasi/kedua/Screenshot%202026-10-12%20235100.png" width="75%" alt="Data Pesanan">
    </td>
  </tr>
</table>

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Dokumentasi/kedua/Screenshot%202026-10-13%20004622.png" width="75%" alt="Detail Data Pesanan">
    </td>
  </tr>
</table>

---

### 03 Menambahkan Pesanan

Menampilkan proses ketika pengguna menambahkan data pesanan baru melalui program.

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Dokumentasi/kedua/Screenshot%202026-10-13%20000605.png" width="75%" alt="Proses Tambah Pesanan">
    </td>
  </tr>
</table>

Setelah proses penambahan berhasil, data pesanan baru juga tersimpan di dalam database. Hal ini menunjukkan bahwa data yang dimasukkan melalui program berhasil diteruskan dan disimpan ke database.

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Dokumentasi/kedua/Screenshot%202026-10-13%20000628.png" width="75%" alt="Hasil Tambah Pesanan">
    </td>
  </tr>
</table>

---

### 04 Mengubah Data Pesanan

Menampilkan proses dan hasil perubahan data pesanan yang sebelumnya telah tersimpan di dalam sistem.

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Dokumentasi/kedua/Screenshot%202026-10-13%20001127.png" width="75%" alt="Proses Ubah Pesanan">
    </td>
  </tr>
</table>

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Dokumentasi/kedua/Screenshot%202026-10-13%20001158.png" width="75%" alt="Hasil Ubah Pesanan">
    </td>
  </tr>
</table>

---

### 05 Menghapus Data Pesanan

Menampilkan proses dan hasil penghapusan data pesanan berdasarkan ID pesanan.

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Dokumentasi/kedua/Screenshot%202026-10-13%20002128.png" width="75%" alt="Proses Hapus Pesanan">
    </td>
  </tr>
</table>

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Dokumentasi/kedua/Screenshot%202026-10-13%20002137.png" width="75%" alt="Konfirmasi Hapus Pesanan">
    </td>
  </tr>
</table>

Setelah proses penghapusan berhasil, data pesanan yang dipilih juga terhapus dari database. Dengan demikian, perubahan yang dilakukan melalui program berhasil diterapkan pada data yang tersimpan di database.

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Dokumentasi/kedua/Screenshot%202026-10-13%20002152.png" width="75%" alt="Hasil Hapus Pesanan">
    </td>
  </tr>
</table>

---

### 06 Mengubah Status Pesanan

Menampilkan proses dan hasil perubahan status pesanan melalui sistem.

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Dokumentasi/kedua/Screenshot%202026-10-13%20001513.png" width="75%" alt="Proses Ubah Status">
    </td>
  </tr>
</table>

Setelah status pesanan berhasil diubah melalui program, status yang tersimpan di dalam database juga diperbarui sesuai dengan perubahan tersebut. Hal ini menunjukkan bahwa perubahan status tidak hanya ditampilkan pada program, tetapi juga tersimpan pada database.

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Dokumentasi/kedua/Screenshot%202026-10-13%20001530.png" width="75%" alt="Hasil Ubah Status">
    </td>
  </tr>
</table>

---

### 07 Penerapan Hibernate ORM

Menampilkan hasil penerapan Hibernate ORM melalui `PelangganHibernateDAO`. Data pelanggan diambil menggunakan mekanisme ORM sehingga proses interaksi dengan database dapat dilakukan melalui objek entity dan Hibernate.

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Dokumentasi/kedua/Screenshot%202026-10-13%20001753.png" width="75%" alt="Hibernate ORM">
    </td>
  </tr>
</table>

---

### 08 Keluar dari Program

Menampilkan proses ketika pengguna memilih menu `9` untuk keluar dari sistem. Setelah memilih menu tersebut, program menghentikan proses dan menampilkan pesan bahwa aplikasi telah selesai digunakan.

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Dokumentasi/kedua/Screenshot%202026-10-13%20005130.png" width="75%" alt="Keluar Program">
    </td>
  </tr>
</table>

---

## ✨ Penerapan Nilai Tambah - Hibernate ORM

Sebagai nilai tambah, project ini mengimplementasikan **Hibernate ORM**.

Hibernate merupakan framework ORM yang digunakan untuk memetakan object Java dengan tabel database. Dengan pendekatan tersebut, proses akses data tertentu dapat dilakukan melalui entity dan Hibernate Session tanpa harus menuliskan query SQL secara langsung pada bagian tersebut.

Dependency Hibernate ditambahkan melalui:

```text
pom.xml
```

```xml
<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>6.6.26.Final</version>
</dependency>
```

Hibernate digunakan sebagai **nilai tambah**, sehingga tidak menggantikan JDBC yang menjadi ketentuan utama Mini Project 4.

Dalam project ini:

- **JDBC** tetap digunakan sebagai mekanisme utama CRUD pesanan.
- **Hibernate ORM** digunakan sebagai implementasi tambahan.
- Entity Hibernate digunakan untuk merepresentasikan tabel tertentu sebagai object Java.
- Hibernate DAO digunakan untuk mengakses entity tersebut melalui `Session`.

Dengan menggunakan kedua pendekatan tersebut, project dapat memperlihatkan perbedaan antara akses database secara langsung menggunakan JDBC dan pendekatan ORM menggunakan object Java.

---

## ⚙️ Konfigurasi Hibernate

Konfigurasi Hibernate terdapat pada:

```text
Config/HibernateUtil.java
```

Class tersebut bertanggung jawab untuk membuat `SessionFactory` dan mengatur koneksi Hibernate dengan database.

Beberapa konfigurasi yang digunakan:

```java
configuration.setProperty(
        "hibernate.connection.driver_class",
        "com.mysql.cj.jdbc.Driver"
);

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
```

Hibernate juga dikonfigurasi agar tidak mengubah struktur database:

```java
configuration.setProperty(
        "hibernate.hbm2ddl.auto",
        "none"
);
```

Pengaturan tersebut digunakan karena struktur tabel database sudah dibuat melalui file SQL. Hibernate hanya digunakan untuk berinteraksi dengan struktur database yang sudah tersedia.

---

## 🏷️ Entity Mapping

Beberapa class pada package `Model` digunakan sebagai entity Hibernate:

```text
Model
├── Pelanggan
├── Barang
├── Pembayaran
└── BatchJastip
```

Entity ditandai menggunakan annotation seperti:

```java
@Entity
@Table(name = "pelanggan")
public class Pelanggan {
    ...
}
```

Primary key ditandai menggunakan:

```java
@Id
```

Sedangkan pemetaan atribut terhadap kolom database menggunakan:

```java
@Column(name = "nama_pelanggan")
```

Contohnya:

```java
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
}
```

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Matkul/third/Screenshot%202026-10-13%20171729.png" width="75%" alt="Entity Mapping">
    </td>
  </tr>
</table>

Mapping tersebut digunakan agar Hibernate mengetahui bahwa object `Pelanggan` berhubungan dengan tabel `pelanggan`, termasuk hubungan antara atribut Java dan kolom database.

---

## 🗃️ Hibernate DAO

Implementasi Hibernate DAO terdapat pada:

```text
DAO/PelangganHibernateDAO.java
```

Contoh pengambilan data:

```java
try (Session session =
        HibernateUtil.getSessionFactory().openSession()) {

    return session
            .createQuery(
                    "FROM Pelanggan",
                    Pelanggan.class
            )
            .getResultList();
}
```

<table border="1" bordercolor="black">
  <tr>
    <td>
      <img src="https://github.com/Sitinursinta04/PRAKTIKUM_PBO/blob/main/Matkul/third/Screenshot%202026-10-13%20171820.png" width="75%" alt="Hibernate DAO">
    </td>
  </tr>
</table>

Pada bagian ini, Hibernate digunakan untuk mengambil data berdasarkan entity `Pelanggan`.

Query:

```java
FROM Pelanggan
```

merupakan **HQL (Hibernate Query Language)** yang mengacu pada entity Java, bukan penulisan SQL langsung seperti:

```sql
SELECT * FROM pelanggan;
```

Inilah salah satu bagian yang menunjukkan penerapan ORM dalam project, karena proses pengambilan data dilakukan melalui object/entity yang telah dipetakan ke tabel database.

---

## 🗺️ Lokasi Penerapan Konsep

| Konsep | Lokasi |
|---|---|
| Encapsulation | `Model/` |
| Inheritance | `Model/JastipFashion.java`, `JastipSkincare.java`, `JastipElektronik.java` |
| Polymorphism | `Model/PesananJastip.java` dan class turunannya |
| Abstraction | `Model/PesananJastip.java` |
| Interface | `Model/BisaDivalidasi.java` |
| JDBC | `Config/DatabaseConnection.java` |
| PreparedStatement | `DAO/PesananDAOImpl.java` |
| DAO | `DAO/PesananDAO.java`, `DAO/PesananDAOImpl.java` |
| CRUD | `DAO/PesananDAOImpl.java` dan `Controller/PesananController.java` |
| Database | `database/sistem_jastip.sql` |
| Hibernate Configuration | `Config/HibernateUtil.java` |
| Hibernate Entity | `Model/Pelanggan.java`, `Barang.java`, `Pembayaran.java`, `BatchJastip.java` |
| Hibernate DAO | `DAO/PelangganHibernateDAO.java` |
| Hibernate Dependency | `pom.xml` |

---

## 🗂️ File Database

File database disediakan dalam repository pada:

```text
database/sistem_jastip.sql
```

File tersebut berisi:

- Pembuatan database.
- Pembuatan tabel.
- Primary key.
- Foreign key.
- Relasi antar tabel.
- Dummy data awal.

File SQL disertakan agar database dapat dibuat kembali dengan struktur dan data awal yang sama ketika project dijalankan pada lingkungan lain.

---

## 🔗 Dependency Project

Project menggunakan Maven untuk mengelola dependency.

### MySQL Connector

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.4.0</version>
</dependency>
```

Dependency tersebut digunakan agar aplikasi Java dapat berkomunikasi dengan MySQL melalui JDBC.

### Hibernate ORM

```xml
<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>6.6.26.Final</version>
</dependency>
```

Dependency tersebut digunakan untuk menerapkan Hibernate sebagai nilai tambah ORM pada project.

---

## 📑 Kesimpulan

Mini Project 4 mengembangkan **Sistem Jasa Titip Luar Negeri** menjadi aplikasi Java yang telah terintegrasi dengan database MySQL.

Penggunaan **JDBC, PreparedStatement, dan DAO** memungkinkan aplikasi melakukan proses penyimpanan, pembacaan, perubahan, dan penghapusan data secara langsung pada database. Pemisahan proses tersebut melalui DAO juga membuat struktur program lebih terorganisir karena akses database tidak dilakukan langsung dari View.

Konsep OOP dari Mini Project sebelumnya tetap dipertahankan melalui penerapan **encapsulation, inheritance, polymorphism, abstraction, dan interface**. Konsep tersebut diterapkan langsung pada struktur class yang membangun sistem jasa titip.

Sebagai nilai tambah, project mengimplementasikan **Hibernate ORM** melalui konfigurasi `HibernateUtil`, entity mapping, HQL, dan `PelangganHibernateDAO`. Implementasi tersebut menunjukkan bahwa data tertentu dapat diakses melalui object Java yang telah dipetakan ke tabel database.

Dengan demikian, project ini tidak hanya menerapkan integrasi Java dengan MySQL, tetapi juga memperlihatkan hubungan antara **OOP, JDBC, DAO, CRUD, database relational, dan ORM** dalam membangun aplikasi yang terstruktur.

---

<p align="center">
  <b>📦🛍️ Mini Project 4 — Sistem Jasa Titip Luar Negeri</b><br>
  <i>Java • JDBC • DAO • MySQL • Hibernate ORM</i>
</p>
