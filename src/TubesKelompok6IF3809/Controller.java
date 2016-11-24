/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TubesKelompok6IF3809;

import TubesKelompok6IF3809.Model.*;
import TubesKelompok6IF3809.View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author KELOMPOK 6 IF-38-09
 */
public class Controller implements ActionListener{
    //variabel
    private ArrayList <Barang> listBarang;
    private ArrayList <Ruangan> listRuangan;
    private ArrayList <Peminjaman> listPeminjaman;
    private ArrayList <LaporanKeuangan> listLapKeuangan;
    private ArrayList <LaporanMutasiPerubahan> listLapMutasiPerubahan;
    private ArrayList <LaporanKondisiBarang> listLapKondisiBarang;
    private View v;
    
    SimpleDateFormat dfFormat = new SimpleDateFormat("dd.MM.yyyy");
    
    Admin admin = new Admin("Citra", "1301140389");
    
    //buat akses view
//===================================================================================================================
    
    
    
    public Controller() {
        listLapKeuangan = new ArrayList<>();
        listLapMutasiPerubahan = new ArrayList<>();
        listLapKondisiBarang = new ArrayList<>();
        listBarang = new ArrayList<>();
        listRuangan = new ArrayList<>();
        
        toMenuAwal();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object p=e.getSource();
        if (v instanceof MenuAwal){
            MenuAwal tampilan = (MenuAwal) v;
            if (p.equals(tampilan.getBtn_kelolabarang())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang();
            }
            else if (p.equals(tampilan.getBtn_kelolaruangan())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan();
            }
            else if (p.equals(tampilan.getBtn_cetaklaporan())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuCetakLaporan();
            }
        }
        
        else if (v instanceof MenuKelolaBarang){
            MenuKelolaBarang tampilan = (MenuKelolaBarang) v;
            if (p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuAwal();
            }
            else if(p.equals(tampilan.getBtn_ubahdata())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang_ubahdatabarang();
            }
            else if(p.equals(tampilan.getBtn_lihatdaftarbarang())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang_lihatdaftarbarang();
            }
            else if(p.equals(tampilan.getBtn_lihatdaftarpeminjaman())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang_lihatdaftarpeminjaman();
            }
            else if(p.equals(tampilan.getBtn_peminjamanbarang())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang_peminjamanbarang();
            }
            else if(p.equals(tampilan.getBtn_tambahbarang())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang_tambahdatabarang();
            }
            
        }
        
        else if (v instanceof MenuKelolaRuangan){
            MenuKelolaRuangan tampilan = (MenuKelolaRuangan) v;
            if (p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuAwal();
            }
            else if(p.equals(tampilan.getBtn_cariRuangan())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan_caridataruangan();
            }
            else if(p.equals(tampilan.getBtn_lihatdaftarRuangan())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan_lihatdaftarruangan();
            }
            else if(p.equals(tampilan.getBtn_lihatdaftarpinjam())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan_lihatdaftarpeminjaman();
            }
            else if(p.equals(tampilan.getBtn_peminjamanRuangan())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan_peminjamanruangan();
            }
            else if(p.equals(tampilan.getBtn_tambahRuangan())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan_tambahdataruangan();
            }
            else if(p.equals(tampilan.getBtn_tambahbarang())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan_pilihruangantambahbarang();
            }
        }
        else if (v instanceof MenuCetakLaporan){
            MenuCetakLaporan tampilan = (MenuCetakLaporan) v;
            if (p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuAwal();
            }
            else if (p.equals(tampilan.getBtn_cetak())){
                tampilan.showMessage("mencetak laporan");
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuCetakLaporan();
            }
        }
        
        else if(v instanceof KelolaBarang_Cari){
            KelolaBarang_Cari tampilan = (KelolaBarang_Cari) v;
            if (p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang();
            }
            else if (p.equals(tampilan.getBtn_cari())){
                 String cari = tampilan.getTf_cari().getText();
                
            }
            else if (p.equals(tampilan.getBtn_ubah())){
        
                //pindah
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang();
            }
        }
        
        else if(v instanceof KelolaBarang_LihatDaftar){
            KelolaBarang_LihatDaftar tampilan = (KelolaBarang_LihatDaftar) v;
            if(p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang();
            }
        }
        
        else if(v instanceof KelolaBarang_LihatDaftarPeminjaman){
            KelolaBarang_LihatDaftarPeminjaman tampilan = (KelolaBarang_LihatDaftarPeminjaman) v;
            if(p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang();
            }
        }
        
        else if(v instanceof KelolaBarang_Pinjam){
            KelolaBarang_Pinjam tampilan = (KelolaBarang_Pinjam) v;
            if(p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang();
            }
            else if (p.equals(tampilan.getBtn_cari())){
                 String cari = tampilan.getTf_cari().getText();
                 
            }
            else if (p.equals(tampilan.getBtn_pinjam())){
                String namapeminjam = tampilan.getTf_namapeminjam().getText();
                 
                //pindah
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang();
            }
            
        }
        
        else if(v instanceof KelolaBarang_Tambah){
            KelolaBarang_Tambah tampilan = (KelolaBarang_Tambah) v;
            if(p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang();
            }
            else if (p.equals(tampilan.getBtn_tambah())){
                String nama = tampilan.getTf_namaBarang().getText();
                String kondisi = tampilan.getTf_kondisi().getText();
                long harga = Long.parseLong(tampilan.getTf_harga().getText()) ;
                //addBarang(nama, tanggalBeli, kondisi, harga, fakultas, prodi);
                //pindah
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang();
            }
        }
        
        else if(v instanceof KelolaBarang_Ubah){
            KelolaBarang_Ubah tampilan = (KelolaBarang_Ubah) v;
            if(p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang();
            }
            else if (p.equals(tampilan.getBtn_simpan())){
                String nama = tampilan.getTf_nama().getText();
                String kondisi = tampilan.getTf_kondisi().getText();
                long harga = Long.parseLong(tampilan.getTf_harga().getText()) ;
                //pindah
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang();
            }
        }
        
        else if(v instanceof KelolaRuangan_Cari){
            KelolaRuangan_Cari tampilan = (KelolaRuangan_Cari) v;
            if (p.equals(tampilan.getBtn_kembali())){
                String cari = tampilan.getTf_cari().getText();
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan();
            }
            else if (p.equals(tampilan.getBtn_cari())){
                
            }
            else if (p.equals(tampilan.getBtn_ubah())){
                
                //pindah
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan();
            }
            
        }
        
        else if(v instanceof KelolaRuangan_LihatDaftar){
            KelolaRuangan_LihatDaftar tampilan = (KelolaRuangan_LihatDaftar) v;
            if (p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan();
            }
        }
        
        else if(v instanceof KelolaRuangan_LihatDaftarPeminjaman){
            KelolaRuangan_LihatDaftarPeminjaman tampilan = (KelolaRuangan_LihatDaftarPeminjaman) v;
            if (p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan();
            }
        }
        
        else if(v instanceof KelolaRuangan_PilihRuanganTambahBarang){
            KelolaRuangan_PilihRuanganTambahBarang tampilan = (KelolaRuangan_PilihRuanganTambahBarang) v;
            if (p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan();
            }
            else if (p.equals(tampilan.getBtn_pilih())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan_tambahbarang();
            }
        }
        
        else if(v instanceof KelolaRuangan_Pinjam){
            KelolaRuangan_Pinjam tampilan = (KelolaRuangan_Pinjam) v;
            if(p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan();
            }
            else if (p.equals(tampilan.getBtn_cari())){
                
            }
            else if (p.equals(tampilan.getBtn_pinjam())){
                
                //pindah
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan();
            }
        }
        
         else if(v instanceof KelolaRuangan_Tambah){
            KelolaRuangan_Tambah tampilan = (KelolaRuangan_Tambah) v;
            if (p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan();
            }
            else if (p.equals(tampilan.getBtn_tambah())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan();
            }
        }
        
        else if(v instanceof KelolaRuangan_TambahBarang){
            KelolaRuangan_TambahBarang tampilan = (KelolaRuangan_TambahBarang) v;
            if (p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan_pilihruangantambahbarang();
            }
            else if (p.equals(tampilan.getBtn_tambah())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan();
            }
        }
        
        else if (v instanceof KelolaRuangan_Ubah){
            KelolaRuangan_Ubah tampilan= (KelolaRuangan_Ubah)  v;
            if (p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan();
            }
            else if (p.equals(tampilan.getBtn_simpan())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan();
            }
        }
        
    }
// fungsi buat nampilin view
//===================================================================================================================    

    public void toMenuAwal() {
        MenuAwal menuawal = new MenuAwal();
        menuawal.setVisible(true);
        menuawal.setListener(this);
        v = menuawal;
    }
    
    public void toMenuKelolaBarang() {
        MenuKelolaBarang menukelolabarang = new MenuKelolaBarang();
        menukelolabarang.setVisible(true);
        menukelolabarang.setListener(this);
        v = menukelolabarang;
    }
    
    public void toMenuKelolaBarang_tambahdatabarang() {
        KelolaBarang_Tambah tambah = new KelolaBarang_Tambah();
        tambah.setVisible(true);
        tambah.setListener(this);
        v = tambah;
    }
    
    public void toMenuKelolaBarang_lihatdaftarbarang() {
        KelolaBarang_LihatDaftar lihat = new KelolaBarang_LihatDaftar();
        lihat.setVisible(true);
        lihat.setListener(this);
        v = lihat;
    }
    
    public void toMenuKelolaBarang_caridatabarang() {
        KelolaBarang_Cari cari = new KelolaBarang_Cari();
        cari.setVisible(true);
        cari.setListener(this);
        v = cari;
    }
    
    public void toMenuKelolaBarang_ubahdatabarang() {
        KelolaBarang_Ubah ubah = new KelolaBarang_Ubah();
        ubah.setVisible(true);
        ubah.setListener(this);
        v = ubah;
    }
    
    public void toMenuKelolaBarang_peminjamanbarang() {
        KelolaBarang_Pinjam pinjam = new KelolaBarang_Pinjam();
        pinjam.setVisible(true);
        pinjam.setListener(this);
        v = pinjam;
    }
    
    public void toMenuKelolaBarang_lihatdaftarpeminjaman() {
        KelolaBarang_LihatDaftarPeminjaman lihatpinjam = new KelolaBarang_LihatDaftarPeminjaman();
        lihatpinjam.setVisible(true);
        lihatpinjam.setListener(this);
        v = lihatpinjam;
    }
    
    
    
     public void toMenuKelolaRuangan() {
        MenuKelolaRuangan menukelolaruangan = new MenuKelolaRuangan();
        menukelolaruangan.setVisible(true);
        menukelolaruangan.setListener(this);
        v = menukelolaruangan;
    }
     
    public void toMenuKelolaRuangan_tambahdataruangan() {
        KelolaRuangan_Tambah tambah = new KelolaRuangan_Tambah();
        tambah.setVisible(true);
        tambah.setListener(this);
        v = tambah;
    }
    
    public void toMenuKelolaRuangan_lihatdaftarruangan() {
        KelolaRuangan_LihatDaftar lihat = new KelolaRuangan_LihatDaftar();
        lihat.setVisible(true);
        lihat.setListener(this);
        v = lihat;
    }
    
    public void toMenuKelolaRuangan_caridataruangan() {
        KelolaRuangan_Cari cari = new KelolaRuangan_Cari();
        cari.setVisible(true);
        cari.setListener(this);
        v = cari;
    }
    
    public void toMenuKelolaRuangan_ubahdataruangan() {
        KelolaRuangan_Ubah ubah = new KelolaRuangan_Ubah();
        ubah.setVisible(true);
        ubah.setListener(this);
        v = ubah;
    }
    
    public void toMenuKelolaRuangan_peminjamanruangan() {
        KelolaRuangan_Pinjam pinjam = new KelolaRuangan_Pinjam();
        pinjam.setVisible(true);
        pinjam.setListener(this);
        v = pinjam;
    }
    
    public void toMenuKelolaRuangan_lihatdaftarpeminjaman() {
        KelolaRuangan_LihatDaftarPeminjaman lihatpinjam = new KelolaRuangan_LihatDaftarPeminjaman();
        lihatpinjam.setVisible(true);
        lihatpinjam.setListener(this);
        v = lihatpinjam;
    }
    
    public void toMenuKelolaRuangan_pilihruangantambahbarang() {
        KelolaRuangan_PilihRuanganTambahBarang tambah = new KelolaRuangan_PilihRuanganTambahBarang();
        tambah.setVisible(true);
        tambah.setListener(this);
        v = tambah;
    }
    
    public void toMenuKelolaRuangan_tambahbarang() {
        KelolaRuangan_TambahBarang tambah = new KelolaRuangan_TambahBarang();
        tambah.setVisible(true);
        tambah.setListener(this);
        v = tambah;
    }
     
    public void toMenuCetakLaporan() {
        MenuCetakLaporan menucetaklaporan = new MenuCetakLaporan();
        menucetaklaporan.setVisible(true);
        menucetaklaporan.setListener(this);
        v = menucetaklaporan;
    }


   //buat control model
//===================================================================================================================
    
    public void addBarang (String namaBarang, Date tanggalBeli, String kondisiBarang, long harga, String fakultas, String prodi){
        listBarang.add(new Barang (namaBarang,tanggalBeli, kondisiBarang, harga, fakultas, prodi));
    }
    
    public void addPeminjaman(String namapeminjam, Date tanggalpinjam, Date pengembalian){
        listPeminjaman.add(new Peminjaman(namapeminjam, tanggalpinjam, pengembalian));
    }
   
}
