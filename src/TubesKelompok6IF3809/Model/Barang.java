/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TubesKelompok6IF3809.Model;
import java.util.ArrayList;



/**
 *
 * @author A_CITRA
 */
public class Barang {
    private int idBarang=0;
    private String namaBarang;
    private String tanggalBeli;
    private String kondisiBarang;
    private long harga;
    private String fakultas;
    private String prodi;
    private String status = "tidak dipinjam";
    private String lokasiRuangan;
    
    public Barang(){
    
    }

    public Barang(String namaBarang, String tanggalBeli, String kondisiBarang, long harga, String fakultas, String prodi) {
        this.idBarang = idBarang +1;
        this.namaBarang = namaBarang;
        this.tanggalBeli = tanggalBeli;
        this.kondisiBarang = kondisiBarang;
        this.harga = harga;
        this.fakultas = fakultas;
        this.prodi = prodi;
    }
    
    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }


    public String getTanggalBeli() {
        return tanggalBeli;
    }

    public void setTanggalBeli(String tanggalBeli) {
        this.tanggalBeli = tanggalBeli;
    }

    public String getKondisiBarang() {
        return kondisiBarang;
    }

    public void setKondisiBarang(String kondisiBarang) {
        this.kondisiBarang = kondisiBarang;
    }

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String Fakultas) {
        this.fakultas = Fakultas;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String Prodi) {
        this.prodi = Prodi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLokasiRuangan() {
        return lokasiRuangan;
    }

    public void setLokasiRuangan(String lokasiRuangan) {
        this.lokasiRuangan = lokasiRuangan;
    }
    
    
    
}
