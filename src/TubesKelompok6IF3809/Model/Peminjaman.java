/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TubesKelompok6IF3809.Model;

/**
 *
 * @author A_CITRA
 */

import java.util.Date;

public class Peminjaman {
    private Date tanggalPinjam;
    private Date tanggalPengembalian;
    private String namaPeminjam;
    private String idBarang;
    private String nomorRuangan;
    
    public Peminjaman(){
    
    }

    public Peminjaman( String namaPeminjam, Date tanggalPinjam, Date tanggalPengembalian) {
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalPengembalian = tanggalPengembalian;
        this.namaPeminjam = namaPeminjam;
    }

    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public Date getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public void setTanggalPengembalian(Date tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNomorRuangan() {
        return nomorRuangan;
    }

    public void setNomorRuangan(String nomorRuangan) {
        this.nomorRuangan = nomorRuangan;
    }
    
    
}
