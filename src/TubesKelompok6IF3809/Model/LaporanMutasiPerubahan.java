/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TubesKelompok6IF3809.Model;

import java.util.ArrayList;

/**
 *
 * @author KELOMPOK 6 IF-38-09
 */
public class LaporanMutasiPerubahan implements StrategiLaporan {
    
    public int jumlah;
    public String tanggal;
    
    @Override
    public int durasiRekap(int durasi) {
       return durasi;
    }
    
    public void hitungBarangDipinjam (int jumlah){
       this.jumlah = jumlah;
    }
   
    public void setTanggal (String tanggal){
       this.tanggal = tanggal;
    }
    
}
