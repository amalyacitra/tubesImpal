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
public class Ruangan {
    private String namaRuangan;
    private String nomorRuangan;
    private String namaGedung;
    private String jenisRuangan;
    private String fakultas;
    private String prodi;
    private String status = "tidak dipinjam";
    
    private ArrayList<Barang> listbarang;
    
    public Ruangan(){
    
    }

    public Ruangan(String namaRuangan, String nomorRuangan, String namaGedung, String jenisRuangan, String fakultas, String prodi) {
        this.namaRuangan = namaRuangan;
        this.nomorRuangan = nomorRuangan;
        this.namaGedung = namaGedung;
        this.jenisRuangan = jenisRuangan;
        this.fakultas = fakultas;
        this.prodi = prodi;
    }

    public String getNamaRuangan() {
        return namaRuangan;
    }

    public void setNamaRuangan(String namaRuangan) {
        this.namaRuangan = namaRuangan;
    }

    public String getNomorRuangan() {
        return nomorRuangan;
    }

    public void setNomorRuangan(String nomorRuangan) {
        this.nomorRuangan = nomorRuangan;
    }

    public String getNamaGedung() {
        return namaGedung;
    }

    public void setNamaGedung(String namaGedung) {
        this.namaGedung = namaGedung;
    }

    public String getJenisRuangan() {
        return jenisRuangan;
    }

    public void setJenisRuangan(String jenisRuangan) {
        this.jenisRuangan = jenisRuangan;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public ArrayList<Barang> getListbarang() {
        return listbarang;
    }

    public void setListbarang(ArrayList<Barang> listbarang) {
        this.listbarang = listbarang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
