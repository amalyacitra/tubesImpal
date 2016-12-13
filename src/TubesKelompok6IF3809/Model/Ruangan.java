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

    private String nomorRuangan;
    private String namaGedung;
    private String jenisRuangan;
    private String fakultas;
    private String prodi;
    private String status = "tidak dipinjam";
    private int idRuangan = 0;
    
   
    
    public Ruangan(){
    
    }

    public Ruangan(String nomorRuangan, String namaGedung, String jenisRuangan, String fakultas, String prodi) {
        this.idRuangan = idRuangan +1;
        this.nomorRuangan = nomorRuangan;
        this.namaGedung = namaGedung;
        this.jenisRuangan = jenisRuangan;
        this.fakultas = fakultas;
        this.prodi = prodi;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdRuangan() {
        return idRuangan;
    }

    public void setIdRuangan(int idRuangan) {
        this.idRuangan = idRuangan;
    }
    
    
    
}
