-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 20 Jun 2024 pada 05.34
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `petshop`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang_petshop`
--

CREATE TABLE `barang_petshop` (
  `id` int(11) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `jenis` varchar(30) NOT NULL,
  `harga` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `barang_petshop`
--

INSERT INTO `barang_petshop` (`id`, `nama_barang`, `jenis`, `harga`) VALUES
(1, 'Dog Food Premium', 'Makanan Anjing', 150000),
(2, 'Cat Food Premium', 'Makanan Kucing', 130000),
(3, 'Hamster Wheel', 'Aksesoris', 50000),
(4, 'Bird Cage', 'Aksesoris', 200000),
(5, 'Aquarium Large', 'Aksesoris', 350000),
(6, 'Fish Food Flakes', 'Makanan Ikan', 45000),
(7, 'Dog Collar', 'Aksesoris', 30000),
(8, 'Cat Litter', 'Kebersihan', 40000),
(9, 'Rabbit Hay', 'Makanan Kelinci', 60000),
(10, 'Parrot Toy', 'Mainan', 75000),
(11, 'Dog Shampoo', 'Kebersihan', 55000),
(12, 'Cat Shampoo', 'Kebersihan', 50000),
(13, 'Fish Tank Filter', 'Aksesoris', 80000),
(14, 'Turtle Food', 'Makanan Kura-kura', 35000),
(15, 'Guinea Pig Cage', 'Aksesoris', 180000),
(16, 'Dog Bed', 'Peralatan', 120000),
(17, 'Cat Scratching Post', 'Peralatan', 110000),
(18, 'Bird Seed Mix', 'Makanan Burung', 30000),
(19, 'Hamster Bedding', 'Kebersihan', 40000),
(20, 'Dog Leash', 'Aksesoris', 45000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_pelanggan` int(11) DEFAULT NULL,
  `nama_pelanggan` varchar(30) NOT NULL,
  `barang` varchar(30) NOT NULL,
  `harga` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id_pelanggan`, `nama_pelanggan`, `barang`, `harga`) VALUES
(3, 'dhyiya', 'Aquarium Large', 350000),
(3, 'dhyiya', 'Hamster Wheel', 50000),
(3, 'dhyiya', 'Dog Collar', 30000),
(3, 'dhyiya', 'Hamster Wheel', 50000),
(3, 'dhyiya', 'Fish Food Flakes', 45000),
(1, 'Dhidi', 'Hamster Wheel', 50000),
(1, 'Dhidi', 'Hamster Wheel', 50000),
(2, 'ilham', 'Cat Food Premium', 130000),
(4, 'haqi', 'Cat Scratching Post', 110000),
(4, 'haqi', 'Hamster Bedding', 40000),
(5, 'ham', 'Bird Cage', 200000),
(7, 'putra', 'Dog Bed', 120000),
(7, 'putra', 'Bird Seed Mix', 30000),
(8, 'Iqbal', 'Guinea Pig Cage', 180000),
(8, 'Iqbal', 'Cat Scratching Post', 110000),
(8, 'Iqbal', 'Hamster Bedding', 40000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
--

CREATE TABLE `pegawai` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pegawai`
--

INSERT INTO `pegawai` (`id`, `username`, `password`) VALUES
(1, 'Dhidi', '1234'),
(2, 'ilham', '1234');

-- --------------------------------------------------------

--
-- Struktur dari tabel `titip_hewan`
--

CREATE TABLE `titip_hewan` (
  `id` int(11) NOT NULL,
  `nama_pemilik` varchar(30) NOT NULL,
  `nama_hewan` varchar(30) NOT NULL,
  `jenis_hewan` varchar(30) NOT NULL,
  `nomor_telepon` int(11) NOT NULL,
  `durasi_titip` int(11) NOT NULL,
  `total_biaya` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `titip_hewan`
--

INSERT INTO `titip_hewan` (`id`, `nama_pemilik`, `nama_hewan`, `jenis_hewan`, `nomor_telepon`, `durasi_titip`, `total_biaya`) VALUES
(6, 'ilham', 'Babi', 'Babi guling', 62813475, 5, 1000000),
(8, 'Ilham', 'Kucing', 'anggora', 62878546, 5, 1000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id`, `nama`) VALUES
(1, 'Dhidi'),
(2, 'ilham'),
(3, 'dhyiya'),
(4, 'haqi'),
(5, 'ham'),
(6, ''),
(7, 'putra'),
(8, 'Iqbal');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang_petshop`
--
ALTER TABLE `barang_petshop`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `titip_hewan`
--
ALTER TABLE `titip_hewan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `barang_petshop`
--
ALTER TABLE `barang_petshop`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `titip_hewan`
--
ALTER TABLE `titip_hewan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
