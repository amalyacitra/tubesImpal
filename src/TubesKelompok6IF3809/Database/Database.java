/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TubesKelompok6IF3809.Database;

import TubesKelompok6IF3809.Model.*;
import TubesKelompok6IF3809.View.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author A_CITRA
 */
public class Database {

    private Statement stmt = null;
    private Connection c = null;
    private ResultSet rs = null;
// membuat koneksi

    public void buatKoneksi() {
        try {
            String url = "jdbc:mysql://localhost:3306";
            String hostname = "root";
            String password = "y";
            Class.forName("com.mysql.jdbc.Drivers");
            c = DriverManager.getConnection(url, hostname, password);
        } catch (SQLException exception) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
//Database Barang

    public void saveBarang(Barang brg) throws SQLException {
        String query = "INSERT INTO barang(namaBarang, tanggalBeli, kondisiBarang, harga, fakultas, prodi) VALUES ('" + brg.getNamaBarang() + "','" + brg.getTanggalBeli() + "','" + brg.getKondisiBarang() + "','" + brg.getHarga() + "','" + brg.getFakultas() + "','" + brg.getProdi() + "')";
        stmt.execute(query, Statement.RETURN_GENERATED_KEYS);
        rs = stmt.getGeneratedKeys();
    }

    public void editBarang(Barang brg) throws SQLException {
        String query = "UPDATE BARANG set namaBarang='" + brg.getNamaBarang() + "', tanggalBeli='" + brg.getTanggalBeli() + "', kondisiBarang='" + brg.getKondisiBarang() + "', harga='" + brg.getHarga() + "', fakultas='" + brg.getFakultas() + "', prodi='" + brg.getProdi() + "'";
        stmt.execute(query);
    }

    public Barang getBarang(String namaBarang) throws SQLException {
        Barang brg = null;
        String query = "select * FROM barang where namaBarang= '" + namaBarang + "'";
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            brg = new Barang(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6));
        }
        return brg;
    }

    public String[] getListNamaBarang() throws SQLException {
        ArrayList<String> listNama = new ArrayList<>();
        String query = "SELECT namaBarang FROM barang";
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            listNama.add(rs.getString(1));

        }
        return listNama.toArray(new String[0]);
    }

    public void delBarang(String namaBarang) throws SQLException {
        String query = "DELETE FROM Barang where namaBarang= '" + namaBarang + "'";
        stmt.execute(query);

    }

    public ArrayList<Barang> selectAllListBarang() throws SQLException {
        ArrayList<Barang> listBarang = new ArrayList<>();
        try {

            String query = "select * from Barang";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                listBarang.add(new Barang(rs.getString("namaBarang"), rs.getDate("tanggalBeli"), rs.getString("kondisiBarang"), rs.getLong("harga"), rs.getString("fakultas"), rs.getString("prodi")));
            }
        } catch (SQLException exception) {
            return null;
        }
        return listBarang;
    }
//Database Ruangan

    public void saveRuangan(Ruangan ruang) throws SQLException {
        String query = "INSERT INTO Ruangan(namaRuangan, nomorRuangan, namaGedung, jenisRuangan, fakultas, prodi) VALUES ('" + ruang.getNamaRuangan() + "','" + ruang.getNomorRuangan() + "','" + ruang.getNamaGedung() + "','" + ruang.getJenisRuangan() + "','" + ruang.getFakultas() + "','" + ruang.getProdi() + "')";
        stmt.execute(query, Statement.RETURN_GENERATED_KEYS);
        rs = stmt.getGeneratedKeys();
    }

    public void editRuangan(Ruangan ruang) throws SQLException {
        String query = "UPDATE RUANGAN set namaRuangan='" + ruang.getNamaRuangan() + "', nomorRuangan='" + ruang.getNomorRuangan() + "', namaGedung='" + ruang.getNamaGedung() + "', jenisRuangan='" + ruang.getJenisRuangan() + "', fakultas='" + ruang.getFakultas() + "', prodi='" + ruang.getProdi() + "'";
        stmt.execute(query);
    }

    public Ruangan getRuangan(String namaRuangan) throws SQLException {
        Ruangan ruang = null;
        String query = "select *FROM RUANGAN where namaRuangan= '" + namaRuangan + "'";
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            ruang = new Ruangan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        }
        return ruang;
    }

    public String[] getListNamaRuangan() throws SQLException {
        ArrayList<String> listNama = new ArrayList<>();
        String query = "SELECT namaRuangan FROM RUANGAN";
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            listNama.add(rs.getString(1));

        }
        return listNama.toArray(new String[0]);
    }

    public void delRuangan(String namaRuangan) throws SQLException {
        String query = "DELETE FROM RUANGAN where namaRuangan= '" + namaRuangan + "'";
        stmt.execute(query);

    }

    public ArrayList<Ruangan> selectAllListRuangan() throws SQLException {
        ArrayList<Ruangan> listRuangan = new ArrayList<>();
        try {

            String query = "select * FROM RUANGAN";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                listRuangan.add(new Ruangan(rs.getString("namaRuangan"), rs.getString("nomorRuangan"), rs.getString("namaGedung"), rs.getString("jenisRuangan"), rs.getString("fakultas"), rs.getString("prodi")));
            }
        } catch (SQLException exception) {
            return null;
        }
        return listRuangan;
    }

    // Database Peminjaman
    public void savePinjam(Peminjaman pin) throws SQLException {
        String query = "INSERT INTO Ruangan(namaPeminjam, tanggalPinjam, tanggalPengembalian) VALUES ('" + pin.getNamaPeminjam()+ "','" + pin.getTanggalPinjam() + "','" + pin.getTanggalPengembalian() + "')";
        stmt.execute(query, Statement.RETURN_GENERATED_KEYS);
        rs = stmt.getGeneratedKeys();
    }

    public Ruangan getPinjamRuangan(String namaRuangan) throws SQLException {
        Ruangan ruang = null;
        String query = "select *FROM PEMINJAMAN where namaRuangan= '" + namaRuangan + "'";
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            ruang = new Ruangan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        }
        return ruang;
    }
    public Barang getPinjamBarang(String namaBarang) throws SQLException {
        Barang brg = null;
        String query = "select * FROM PEMINJAMAN where namaBarang= '" + namaBarang + "'";
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            brg = new Barang(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6));
        }
        return brg;
    }

    public String[] getListPinjamNamaRuangan() throws SQLException {
        ArrayList<String> listNama = new ArrayList<>();
        String query = "SELECT namaRuangan FROM PEMINJAMAN";
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            listNama.add(rs.getString(1));

        }
        return listNama.toArray(new String[0]);
    }
     public String[] getListPinjamNamaBarang() throws SQLException {
        ArrayList<String> listNama = new ArrayList<>();
        String query = "SELECT namaBarang FROM PEMINJAMAN";
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            listNama.add(rs.getString(1));

        }
        return listNama.toArray(new String[0]);
    }
}
