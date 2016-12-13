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


public class Peminjaman {
    private String tanggalPinjam;
    private String tanggalPengembalian;
    private String namaPeminjam;
    private int idBarang;
    private String nomorRuangan;
    private int idPeminjaman=0;
    
    public Peminjaman(){
    
    }

    public Peminjaman(String tanggalPinjam, String tanggalPengembalian,  String namaPeminjam, int idBarang, String nomorRuangan) {
        this.idPeminjaman = idPeminjaman + 1;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalPengembalian = tanggalPengembalian;
        this.namaPeminjam = namaPeminjam;
        this.idBarang = idBarang;
        this.nomorRuangan = nomorRuangan;
    }


    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public String getNomorRuangan() {
        return nomorRuangan;
    }

    public void setNomorRuangan(String nomorRuangan) {
        this.nomorRuangan = nomorRuangan;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public void setTanggalPengembalian(String tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }

    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }
    
    
    
    
}
