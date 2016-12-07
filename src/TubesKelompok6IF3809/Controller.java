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
import javax.swing.JComboBox;


/**
 *
 * @author KELOMPOK 6 IF-38-09
 */
public class Controller implements ActionListener{
    //variabel
    private ArrayList<Admin> listAdmin;
    private ArrayList <Barang> listBarang;
    private ArrayList <Ruangan> listRuangan;
    private ArrayList <Peminjaman> listPeminjaman;
    private ArrayList <LaporanKeuangan> listLapKeuangan;
    private ArrayList <LaporanMutasiPerubahan> listLapMutasiPerubahan;
    private ArrayList <LaporanKondisiBarang> listLapKondisiBarang;
    private View v;
    private Database database;
    private Admin admin;
    SimpleDateFormat dfFormat = new SimpleDateFormat("dd.MM.yyyy");
    
    String[] ArrFakultas = {"FIF","FRI"};
    String[] ArrProdi = {"Teknik Informatika","Sistem Informasi"};
    String[] ArrTanggal = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
                                    "20","21","22","23","24","25","26","27","28","29","30","31"
                                    };
    String[] ArrBulan = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    String[] ArrTahun = {"2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
    
    //JComboBox comboBoxFakultas = new JComboBox(ArrFakultas);
    //JComboBox<String> comboBoxFakultas = new JComboBox<String>(ArrFakultas);
    
    
    //buat akses view
//===================================================================================================================
    
    
    
    public Controller() {
        listLapKeuangan = new ArrayList<>();
        listLapMutasiPerubahan = new ArrayList<>();
        listLapKondisiBarang = new ArrayList<>();
        listBarang = new ArrayList<>();
        listRuangan = new ArrayList<>();
        listAdmin = new ArrayList<>();
        listAdmin.add(new Admin("kel6","if3809"));
        
        database = new Database();
        toLogin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object p=e.getSource();
        
        if (v instanceof Login){
            Login tampilan = (Login) v;
            if (p.equals(tampilan.getBtn_masuk())){
                validasiLogin(tampilan);
                if (admin!=null){
                    tampilan.setVisible(false);
                    tampilan.dispose();
                    toMenuAwal();
                    
                }
                else {
                    tampilan.showMessage("Nama/Kata sandi salah, coba ulang kembali");
                }
                
            }
        }
        
        else if (v instanceof MenuAwal){
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
            else if (p.equals(tampilan.getBtn_keluar())){
                admin = null;
                tampilan.setVisible(true);
                tampilan.dispose();
                toLogin();
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
                toMenuKelolaBarang_caridatabarang();
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
                toMenuKelolaBarang_ubahdatabarang();
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
            JComboBox comboBoxFakultas = new JComboBox(ArrFakultas);
            tampilan.setCb_fakultas(comboBoxFakultas);
            if(p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang();
            }
            else if (p.equals(tampilan.getBtn_tambah())){
                
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
                
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang();
            }
        }
        
        else if(v instanceof KelolaRuangan_Cari){
            KelolaRuangan_Cari tampilan = (KelolaRuangan_Cari) v;
            if (p.equals(tampilan.getBtn_kembali())){
                
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
                toMenuKelolaRuangan_ubahdataruangan();
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
    
     public void toLogin() {
        Login login = new Login();
        login.setVisible(true);
        login.setListener(this);
        v = login;
    }
    
    
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
    
    private void validasiLogin (Login tampilan){
        String nama,katasandi;
        nama = tampilan.getTf_nama().getText();
        katasandi = tampilan.getTf_katasandi().getText();
        
        if (nama.isEmpty()|| katasandi.isEmpty()){
            admin = null;
        }
        else{
            for (Admin a: listAdmin){
                if (a.getNama().equals(nama)&&a.getNip().equals(katasandi)){
                    admin = a;
                }
            }
        }
    }
    
    
   private void tambahBarang_KelolaBarang (KelolaBarang_Tambah tampilan){
       
   }
    
    
   
}
