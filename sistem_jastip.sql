-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 13, 2026 at 01:08 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistem_jastip`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` int NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `negara_asal` varchar(50) NOT NULL,
  `harga` decimal(15,2) NOT NULL,
  `berat` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `negara_asal`, `harga`, `berat`) VALUES
(1, 'Dress Korea Premium', 'Korea Selatan', '700000.00', '0.80'),
(2, 'Skincare Serum', 'Korea Selatan', '250000.00', '0.30'),
(4, 'Hoodie', 'Korea Selatan', '350000.00', '0.70');

-- --------------------------------------------------------

--
-- Table structure for table `batch_jastip`
--

CREATE TABLE `batch_jastip` (
  `id_batch` varchar(10) NOT NULL,
  `negara_tujuan` varchar(50) NOT NULL,
  `tanggal_buka` date NOT NULL,
  `batas_order` date NOT NULL,
  `tanggal_berangkat` date NOT NULL,
  `status_batch` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `batch_jastip`
--

INSERT INTO `batch_jastip` (`id_batch`, `negara_tujuan`, `tanggal_buka`, `batas_order`, `tanggal_berangkat`, `status_batch`) VALUES
('B001', 'Korea Selatan', '2026-10-01', '2026-10-15', '2026-10-20', 'Dibuka');

-- --------------------------------------------------------

--
-- Table structure for table `detail_elektronik`
--

CREATE TABLE `detail_elektronik` (
  `id_pesanan` varchar(10) NOT NULL,
  `merek` varchar(50) NOT NULL,
  `garansi` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `detail_fashion`
--

CREATE TABLE `detail_fashion` (
  `id_pesanan` varchar(10) NOT NULL,
  `ukuran` varchar(20) NOT NULL,
  `warna` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `detail_fashion`
--

INSERT INTO `detail_fashion` (`id_pesanan`, `ukuran`, `warna`) VALUES
('FSH-001', 'L', 'Putih');

-- --------------------------------------------------------

--
-- Table structure for table `detail_skincare`
--

CREATE TABLE `detail_skincare` (
  `id_pesanan` varchar(10) NOT NULL,
  `jenis_kulit` varchar(50) NOT NULL,
  `ukuran_produk` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `detail_skincare`
--

INSERT INTO `detail_skincare` (`id_pesanan`, `jenis_kulit`, `ukuran_produk`) VALUES
('PJ002', 'Berminyak', 30);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(10) NOT NULL,
  `nama_pelanggan` varchar(100) NOT NULL,
  `nomor_telepon` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `nomor_telepon`) VALUES
('P001', 'Alya Putri', '081234567890'),
('P002', 'Raka Pratama', '082345678901'),
('P003', 'Eva', '082234567810');

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` int NOT NULL,
  `metode_pembayaran` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id_pembayaran`, `metode_pembayaran`) VALUES
(1, 'Transfer Bank'),
(2, 'E-Wallet');

-- --------------------------------------------------------

--
-- Table structure for table `pesanan`
--

CREATE TABLE `pesanan` (
  `id_pesanan` varchar(10) NOT NULL,
  `id_pelanggan` varchar(10) NOT NULL,
  `id_barang` int NOT NULL,
  `jumlah` int NOT NULL,
  `id_pembayaran` int NOT NULL,
  `status_pesanan` varchar(50) NOT NULL,
  `biaya_jastip` decimal(15,2) NOT NULL,
  `id_batch` varchar(10) DEFAULT NULL,
  `request_khusus` varchar(255) DEFAULT NULL,
  `jenis_pesanan` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `pesanan`
--

INSERT INTO `pesanan` (`id_pesanan`, `id_pelanggan`, `id_barang`, `jumlah`, `id_pembayaran`, `status_pesanan`, `biaya_jastip`, `id_batch`, `request_khusus`, `jenis_pesanan`) VALUES
('FSH-001', 'P003', 4, 1, 2, 'Menunggu Pembayaran', '100000.00', 'B001', 'Tidak Ada', 'Jastip Fashion'),
('PJ002', 'P002', 2, 2, 2, 'Pembayaran Berhasil', '30000.00', 'B001', 'Mohon bubble wrap', 'Skincare');

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_status`
--

CREATE TABLE `riwayat_status` (
  `id_riwayat` int NOT NULL,
  `id_pesanan` varchar(10) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `riwayat_status`
--

INSERT INTO `riwayat_status` (`id_riwayat`, `id_pesanan`, `status`) VALUES
(2, 'PJ002', 'Menunggu Pembayaran'),
(3, 'PJ002', 'Pembayaran Berhasil'),
(4, 'FSH-001', 'Menunggu Pembayaran');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `batch_jastip`
--
ALTER TABLE `batch_jastip`
  ADD PRIMARY KEY (`id_batch`);

--
-- Indexes for table `detail_elektronik`
--
ALTER TABLE `detail_elektronik`
  ADD PRIMARY KEY (`id_pesanan`);

--
-- Indexes for table `detail_fashion`
--
ALTER TABLE `detail_fashion`
  ADD PRIMARY KEY (`id_pesanan`);

--
-- Indexes for table `detail_skincare`
--
ALTER TABLE `detail_skincare`
  ADD PRIMARY KEY (`id_pesanan`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`);

--
-- Indexes for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`id_pesanan`),
  ADD KEY `id_pelanggan` (`id_pelanggan`),
  ADD KEY `id_barang` (`id_barang`),
  ADD KEY `id_pembayaran` (`id_pembayaran`),
  ADD KEY `id_batch` (`id_batch`);

--
-- Indexes for table `riwayat_status`
--
ALTER TABLE `riwayat_status`
  ADD PRIMARY KEY (`id_riwayat`),
  ADD KEY `id_pesanan` (`id_pesanan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id_pembayaran` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `riwayat_status`
--
ALTER TABLE `riwayat_status`
  MODIFY `id_riwayat` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_elektronik`
--
ALTER TABLE `detail_elektronik`
  ADD CONSTRAINT `detail_elektronik_ibfk_1` FOREIGN KEY (`id_pesanan`) REFERENCES `pesanan` (`id_pesanan`) ON DELETE CASCADE;

--
-- Constraints for table `detail_fashion`
--
ALTER TABLE `detail_fashion`
  ADD CONSTRAINT `detail_fashion_ibfk_1` FOREIGN KEY (`id_pesanan`) REFERENCES `pesanan` (`id_pesanan`) ON DELETE CASCADE;

--
-- Constraints for table `detail_skincare`
--
ALTER TABLE `detail_skincare`
  ADD CONSTRAINT `detail_skincare_ibfk_1` FOREIGN KEY (`id_pesanan`) REFERENCES `pesanan` (`id_pesanan`) ON DELETE CASCADE;

--
-- Constraints for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD CONSTRAINT `pesanan_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`),
  ADD CONSTRAINT `pesanan_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `pesanan_ibfk_3` FOREIGN KEY (`id_pembayaran`) REFERENCES `pembayaran` (`id_pembayaran`),
  ADD CONSTRAINT `pesanan_ibfk_4` FOREIGN KEY (`id_batch`) REFERENCES `batch_jastip` (`id_batch`);

--
-- Constraints for table `riwayat_status`
--
ALTER TABLE `riwayat_status`
  ADD CONSTRAINT `riwayat_status_ibfk_1` FOREIGN KEY (`id_pesanan`) REFERENCES `pesanan` (`id_pesanan`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
