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
            String url = "jdbc:mysql://localhost:3306/databaseimpal";
            String hostname = "root";
            String password = "y";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                c = DriverManager.getConnection(url, hostname, password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException exception) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
//Database Barang

    public void saveBarang(Barang brg) {
        try {
            buatKoneksi();
            stmt = c.createStatement();
            String query = "INSERT INTO barang(idBarang, namaBarang, tanggalBeli, kondisiBarang, harga, fakultas, prodi, lokasiRuangan) "
                    +"VALUES ("+ brg.getIdBarang()+ ",'" + brg.getNamaBarang() + "'," + "'"+brg.getTanggalBeli()+"'" + ",'" + brg.getKondisiBarang() + "','" + brg.getHarga() + "','" + brg.getFakultas() + "','" + brg.getProdi()  + "','" + brg.getLokasiRuangan()+ "')";
            stmt.execute(query, Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void editBarang(Barang brg, Barang cari) {
        try {
            buatKoneksi();
            stmt = c.createStatement();
            
            String query = "UPDATE BARANG set namaBarang='" + brg.getNamaBarang() + "', tanggalBeli='" + brg.getTanggalBeli() + "', kondisiBarang='" + brg.getKondisiBarang() + "', harga='" + brg.getHarga() 
                    + "', fakultas='" + brg.getFakultas() + "', prodi='" + brg.getProdi()+ "', lokasiRuangan='" + brg.getLokasiRuangan()+ "'" 
                    + "WHERE namaBarang = " + "'" + cari.getNamaBarang() + "'";
            stmt.execute(query, Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public ArrayList<Barang> getListBarang()  {
        try {
            ArrayList<Barang> listBarang  = new ArrayList<>();
            buatKoneksi();
            String q = "select * from barang";
            stmt = c.createStatement();
            rs = stmt.executeQuery(q);
            while(rs.next()){
                Barang b = new Barang(rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getLong(5), rs.getString(6), rs.getString(7));
                b.setIdBarang(Integer.parseInt(rs.getString(1)));
                b.setStatus(rs.getString("status"));
                b.setLokasiRuangan(rs.getString("lokasiRuangan"));
                listBarang.add(b);
            }
            c.close();
            return listBarang;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

//Database Ruangan

    public void saveRuangan(Ruangan ruang)  {
        try {
            buatKoneksi();
            stmt = c.createStatement();
            String query = "INSERT INTO ruangan(idRuangan, nomorRuangan, namaGedung, jenisRuangan, fakultas, prodi) "
                    +"VALUES ("+ ruang.getIdRuangan()+ "," + "'"+ruang.getNomorRuangan()+"'" + ",'" + ruang.getNamaGedung()+ "','" + ruang.getJenisRuangan() + "','" + ruang.getFakultas() + "','" + ruang.getProdi() + "')";
            stmt.execute(query, Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editRuangan(Ruangan ruang, Ruangan cari) {
        try {
            buatKoneksi();
            stmt = c.createStatement();
            
            String query = "UPDATE RUANGAN set nomorRuangan='" + ruang.getNomorRuangan() + "', namaGedung='" + ruang.getNamaGedung() + "', jenisRuangan='" + ruang.getJenisRuangan() 
                    + "', fakultas='" + ruang.getFakultas() + "', prodi='" + ruang.getProdi() + "'"  
                    + "WHERE nomorRuangan = " + "'" + cari.getNomorRuangan()+ "'";
            stmt.execute(query, Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public ArrayList<Ruangan> getListRuangan()  {
        try {
            ArrayList<Ruangan> listRuangan  = new ArrayList<>();
            buatKoneksi();
            String q = "select * from ruangan";
            stmt = c.createStatement();
            rs = stmt.executeQuery(q);
            while(rs.next()){
                Ruangan r = new Ruangan(rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getString(6));
                r.setIdRuangan(Integer.parseInt(rs.getString(1)));
                r.setStatus(rs.getString("status"));
                listRuangan.add(r);
            }
            c.close();
            return listRuangan;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // Database Peminjaman
    public void savePinjam(Peminjaman pinjam, Barang cari) {
        try {
            buatKoneksi();
            stmt = c.createStatement();
            String query = "INSERT INTO peminjaman(idPeminjaman, tanggalPinjam, tanggalPengembalian, namaPeminjam, idBarang, nomorRuangan) "
                    +"VALUES ("+ pinjam.getIdPeminjaman()+ ",'" + pinjam.getTanggalPinjam()+ "'," + "'"+pinjam.getTanggalPengembalian()+"'" + ",'" + pinjam.getNamaPeminjam() + "','" + pinjam.getIdBarang() + "','" + pinjam.getNomorRuangan() + "')";
            String queryy = "UPDATE BARANG set status='dipinjam'" + "WHERE namaBarang = " + "'" + cari.getNamaBarang() + "'";
            stmt.execute(query, Statement.RETURN_GENERATED_KEYS);
            stmt.execute(queryy, Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public ArrayList<Peminjaman> getListPeminjaman()  {
        try {
            ArrayList<Peminjaman> listPeminjaman  = new ArrayList<>();
            buatKoneksi();
            String q = "select * from peminjaman";
            stmt = c.createStatement();
            rs = stmt.executeQuery(q);
            while(rs.next()){
                Peminjaman p = new Peminjaman(rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getInt(5), rs.getString(6));
                p.setIdPeminjaman(Integer.parseInt(rs.getString(1)));
                listPeminjaman.add(p);
            }
            c.close();
            return listPeminjaman;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    

}