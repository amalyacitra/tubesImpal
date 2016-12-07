-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2016 at 10:38 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `databaseimpal`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `nama` varchar(10) NOT NULL,
  `nip` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='dml admin';

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `idBarang` int(5) NOT NULL,
  `namaBarang` varchar(10) NOT NULL,
  `tanggalBeli` date NOT NULL,
  `kondisiBarang` varchar(5) NOT NULL,
  `harga` float NOT NULL,
  `fakultas` varchar(20) NOT NULL,
  `prodi` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `lokasiRuangan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `laporan`
--

CREATE TABLE IF NOT EXISTS `laporan` (
  `tanggal` date NOT NULL,
  `idLaporan` varchar(10) NOT NULL,
  `jenislaporan` varchar(10) NOT NULL,
  `admin` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE IF NOT EXISTS `peminjaman` (
  `tanggalPinjam` date NOT NULL,
  `tanggalPengembalian` date NOT NULL,
  `namaPeminjam` varchar(10) NOT NULL,
  `idBarang` varchar(9) NOT NULL,
  `nomorRuangan` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE IF NOT EXISTS `ruangan` (
  `namaRuangan` varchar(10) NOT NULL,
  `nomorRuangan` varchar(3) NOT NULL,
  `namaGedung` varchar(11) NOT NULL,
  `jenisRuangan` varchar(12) NOT NULL,
  `fakultas` varchar(20) NOT NULL,
  `prodi` varchar(19) NOT NULL,
  `status` varchar(9) NOT NULL,
  `listbarang` set('10') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
