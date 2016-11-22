/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TubesKelompok6IF3809.Model;

import java.util.Date;

/**
 *
 * @author KELOMPOK 6 IF-38-09
 */
public class Laporan{
    private Date tanggal;
    private String idLaporan;
    private StrategiLaporan jenislaporan;
    private Admin admin;
    
    public Laporan(){
    
    }

    public Laporan(Date tanggal, String idLaporan, String admin) {
        this.tanggal = tanggal;
        this.idLaporan = idLaporan;
        this.admin.setNama(admin);
    }

    public Date getTanggal() {
        return tanggal;
    }

    public String getIdLaporan() {
        return idLaporan;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public void setIdLaporan(String idLaporan) {
        this.idLaporan = idLaporan;
    }

    public void setJenislaporan(StrategiLaporan jenislaporan) {
        this.jenislaporan = jenislaporan;
    }

    public StrategiLaporan getJenislaporan() {
        return jenislaporan;
    }
    
    
 
}
