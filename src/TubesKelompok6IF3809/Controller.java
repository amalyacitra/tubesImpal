/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TubesKelompok6IF3809;

import TubesKelompok6IF3809.Model.*;
import TubesKelompok6IF3809.View.*;
import TubesKelompok6IF3809.Database.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author KELOMPOK 6 IF-38-09
 */
public class Controller implements ActionListener{
    //variabel
    private ArrayList<Admin> listAdmin;
    private ArrayList <Barang> listBarang;
    private ArrayList <Ruangan> listRuangan;
    private ArrayList <Peminjaman> listPeminjamanBarang;
    private LaporanKeuangan LapKeuangan;
    private LaporanMutasiPerubahan LapMutasiPerubahan;
    private LaporanKondisiBarang LapKondisiBarang;
    private View v;
    private Database database;
    private Admin admin;
    private Barang barangDicari;
    private Barang barangDipinjam;
    private Ruangan ruanganDicari;
    private FileIO file;
    
    //buat akses view
//===================================================================================================================
    
    
    
    public Controller() {
        LapKeuangan = new LaporanKeuangan();
        LapMutasiPerubahan = new LaporanMutasiPerubahan();
        LapKondisiBarang = new LaporanKondisiBarang();
        listBarang = new ArrayList<>();
        listRuangan = new ArrayList<>();
        listAdmin = new ArrayList<>();
        listPeminjamanBarang = new ArrayList<>();
        listAdmin.add(new Admin("a","a"));
        ruanganDicari = new Ruangan();
        barangDicari = new Barang();
        barangDipinjam = new Barang();
        database = new Database();
        file = new FileIO();
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
    
            else if(p.equals(tampilan.getBtn_tambahRuangan())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan_tambahdataruangan();
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
                String pilih = tampilan.getCb_listjenislaporan().getSelectedItem().toString();
                
                if (pilih.equals("Mutasi Perubahan")){
                    LapMutasiPerubahan = addLaporanMutasi(tampilan);
                    tampilan.showMessage(String.valueOf(LapMutasiPerubahan.tanggal));
                    tampilan.showMessage(String.valueOf(LapMutasiPerubahan.jumlah));
                    //saveLaporanMutasi();
                }
                else if (pilih.equals("Keuangan")){
                    LapKeuangan = addLaporanKeuangan(tampilan);
                    tampilan.showMessage(String.valueOf(LapKeuangan.tanggal));
                    tampilan.showMessage(String.valueOf(LapKeuangan.jumlah));
                    //saveLaporanKeuangan();
                }
                else if (pilih.equals("Kondisi Barang")){
                    LapKondisiBarang = addLaporanKondisi(tampilan);
                    tampilan.showMessage(String.valueOf(LapKondisiBarang.tanggal));
                    tampilan.showMessage(String.valueOf(LapKondisiBarang.jumlah));
                    //saveLaporanKondisi();
                }
                
                
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
            
            else if (p.equals(tampilan.getBtn_ubah())){
                barangDicari = cariBarang_KelolaBarang(tampilan);
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
            
            if(p.equals(tampilan.getBtn_pilih())){
                barangDipinjam = cariBarangPinjam_KelolaBarang(tampilan);
                System.out.println(barangDipinjam.getNamaBarang());
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaBarang_peminjamanbarang();
            }
            
            else if (p.equals(tampilan.getBtn_pinjam())){
                
                pinjamBarang_KelolaBarang(tampilan);
                database.savePinjam(listPeminjamanBarang.get(listPeminjamanBarang.size()-1));
                database.ubahStatusBarang(barangDipinjam.getNamaBarang());
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
                
                tambahBarang_KelolaBarang(tampilan);
                
                database.saveBarang(listBarang.get(listBarang.size()-1));
                
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
                Barang barang;
                barang = ubahDataBarang_KelolaBarang(tampilan);
                database.editBarang(barang,barangDicari);
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
            
            else if (p.equals(tampilan.getBtn_ubah())){
                ruanganDicari = cariRuangan_KelolaRuangan(tampilan);
                
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
       
        
         else if(v instanceof KelolaRuangan_Tambah){
            KelolaRuangan_Tambah tampilan = (KelolaRuangan_Tambah) v;
            if (p.equals(tampilan.getBtn_kembali())){
                tampilan.setVisible(true);
                tampilan.dispose();
                toMenuKelolaRuangan();
            }
            else if (p.equals(tampilan.getBtn_tambah())){
                tambahRuangan_KelolaRuangan(tampilan);
                database.saveRuangan(listRuangan.get(listRuangan.size()-1));
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
                Ruangan ruangan;
                ruangan = ubahDataRuangan_KelolaRuangan(tampilan);
                System.out.println(ruangan.getNomorRuangan());
                database.editRuangan(ruangan,ruanganDicari.getNomorRuangan());
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
        
        listBarang = database.getListBarang();
        listRuangan = database.getListRuangan();
        listPeminjamanBarang = database.getListPeminjaman();
        v = menuawal;
    }
    
    public void toMenuKelolaBarang() {
        MenuKelolaBarang menukelolabarang = new MenuKelolaBarang();
        menukelolabarang.setVisible(true);
        menukelolabarang.setListener(this);
        listBarang = database.getListBarang();
        listPeminjamanBarang = database.getListPeminjaman();
        v = menukelolabarang;
    }
    
    public void toMenuKelolaBarang_tambahdatabarang() {
        KelolaBarang_Tambah tambah = new KelolaBarang_Tambah();
        String listruangan[] = new String[listRuangan.size()];
        int i = 0;
        for (Ruangan r: listRuangan){
            listruangan[i] = r.getNomorRuangan();
            i++;
        }
        tambah.getCb_lokasiruangan().setModel(new DefaultComboBoxModel<String>(listruangan));
        tambah.setVisible(true);
        tambah.setListener(this);
        v = tambah;
    }
    
    public void toMenuKelolaBarang_lihatdaftarbarang() {
        KelolaBarang_LihatDaftar lihat = new KelolaBarang_LihatDaftar();
        
        String c[]= {"ID","NAMA","TANGGAL BELI","HARGA","KONDISI","STATUS","FAKULTAS","PRODI","LOKASI RUANGAN"};
        String data[][] = new String[listBarang.size()][c.length];
        int i = 0;
        for(Barang b: listBarang){
            data[i][0] = String.valueOf(b.getIdBarang());
            data[i][1] = b.getNamaBarang();
            data[i][2] = String.valueOf(b.getTanggalBeli());
            data[i][3] = String.valueOf(b.getHarga());
            data[i][4] = b.getKondisiBarang();
            data[i][5] = b.getStatus();
            data[i][6] = b.getFakultas();
            data[i][7] = b.getProdi();
            data[i][8] = b.getLokasiRuangan();
            i++;
        }
        
        lihat.getTabel_daftarbarang().setModel(new DefaultTableModel(data, c));
        
        lihat.setVisible(true);
        lihat.setListener(this);
        v = lihat;
    }
    
    public void toMenuKelolaBarang_caridatabarang() {
        KelolaBarang_Cari cari = new KelolaBarang_Cari();
        String listbarang[] = new String[listBarang.size()];
        int i = 0;
        for (Barang b: listBarang){
            listbarang[i] = b.getNamaBarang();
            i++;
        }
        cari.getListbarang().setModel(new DefaultComboBoxModel<String>(listbarang));
        cari.setVisible(true);
        cari.setListener(this);
        v = cari;
    }
    
    public void toMenuKelolaBarang_ubahdatabarang() {
        KelolaBarang_Ubah ubah = new KelolaBarang_Ubah();
        String listruangan[] = new String[listRuangan.size()];
        int i = 0;
        for (Ruangan r: listRuangan){
            listruangan[i] = r.getNomorRuangan();
            i++;
        }
        ubah.getCb_lokasiruangan().setModel(new DefaultComboBoxModel<String>(listruangan));
        ubah.setVisible(true);
        ubah.setListener(this);
        v = ubah;
    }
    
    public void toMenuKelolaBarang_peminjamanbarang() {
        KelolaBarang_Pinjam pinjam = new KelolaBarang_Pinjam();
        String listbarang[] = new String[listBarang.size()];
        int i = 0;
        for (Barang b: listBarang){
            listbarang[i] = b.getNamaBarang();
            i++;
        }
        pinjam.getList_barang().setModel(new DefaultComboBoxModel<String>(listbarang));
        pinjam.setVisible(true);
        pinjam.setListener(this);
        v = pinjam;
    }
    
    public void toMenuKelolaBarang_lihatdaftarpeminjaman() {
        KelolaBarang_LihatDaftarPeminjaman lihatpinjam = new KelolaBarang_LihatDaftarPeminjaman();
        
        String c[]= {"ID","TANGGAL PINJAM","TANGGAL PENGEMBALIAN","NAMA PEMINJAM"};
        String data[][] = new String[listPeminjamanBarang.size()][c.length];
        int i = 0;
        for(Peminjaman p: listPeminjamanBarang){
            data[i][0] = String.valueOf(p.getIdPeminjaman());
            data[i][1] = p.getTanggalPinjam();
            data[i][2] = p.getTanggalPengembalian();
            data[i][3] = p.getNamaPeminjam();
            i++;
        }
        
        lihatpinjam.getTabel_peminjaman().setModel(new DefaultTableModel(data, c));
        
        lihatpinjam.setVisible(true);
        lihatpinjam.setListener(this);
        v = lihatpinjam;
    }
    
     public void toMenuKelolaRuangan() {
        MenuKelolaRuangan menukelolaruangan = new MenuKelolaRuangan();
        menukelolaruangan.setVisible(true);
        menukelolaruangan.setListener(this);
        listRuangan = database.getListRuangan();
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
        
        String c[]= {"ID","NOMOR RUANGAN","GEDUNG","JENIS","FAKULTAS","PRODI","STATUS"};
        String data[][] = new String[listRuangan.size()][c.length];
        int i = 0;
        for(Ruangan r: listRuangan){
            data[i][0] = String.valueOf(r.getIdRuangan());
            data[i][1] = r.getNomorRuangan();
            data[i][2] = r.getNamaGedung();
            data[i][3] = r.getJenisRuangan();
            data[i][4] = r.getFakultas();
            data[i][5] = r.getProdi();
            data[i][6] = r.getStatus();
            i++;
        }
        
        lihat.getTabel_daftar().setModel(new DefaultTableModel(data, c));
        
        lihat.setVisible(true);
        lihat.setListener(this);
        v = lihat;
    }
    
    public void toMenuKelolaRuangan_caridataruangan() {
        KelolaRuangan_Cari cari = new KelolaRuangan_Cari();
        String listruangan[] = new String[listRuangan.size()];
        int i = 0;
        for (Ruangan r: listRuangan){
            listruangan[i] = r.getNomorRuangan();
            i++;
        }
        cari.getList_ruangan().setModel(new DefaultComboBoxModel<String>(listruangan));
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
    
    
   private void tambahBarang_KelolaBarang (KelolaBarang_Tambah tampilan) {
       Barang barang = new Barang();
       String tanggal,bulan,tahun;
       String tanggalbeli;
       
       tanggal = tampilan.getCb_tanggal().getSelectedItem().toString();
       bulan = tampilan.getCb_bulan().getSelectedItem().toString();
       tahun = tampilan.getCb_tahun().getSelectedItem().toString();
       tanggalbeli = tahun+"-"+bulan+"-"+tanggal;
       
       barang.setIdBarang(listBarang.size()+1);
       barang.setNamaBarang(tampilan.getTf_namaBarang().getText());
       barang.setKondisiBarang(tampilan.getCb_kondisi().getSelectedItem().toString());
       barang.setHarga(Long.parseLong(tampilan.getTf_harga().getText()));
       barang.setFakultas(tampilan.getCb_fakultas().getSelectedItem().toString());
       barang.setProdi(tampilan.getCb_prodi().getSelectedItem().toString());
       barang.setTanggalBeli(tanggalbeli);
       barang.setLokasiRuangan(tampilan.getCb_lokasiruangan().getSelectedItem().toString());
       barang.setStatus("dipinjam");
       listBarang.add(barang);
   }
   
   private Barang cariBarang_KelolaBarang (KelolaBarang_Cari tampilan){
       Barang ketemu = new Barang();
       String cari = tampilan.getListbarang().getSelectedValuesList().toString();
       for (Barang b : listBarang){
           if (b.getNamaBarang().equals(cari)){
               ketemu = b;
           }
       }
       return ketemu;
   }
   
   private Barang cariBarangPinjam_KelolaBarang (KelolaBarang_Pinjam tampilan){
       Barang ketemu = new Barang();
       
       String cari = tampilan.getList_barang().getSelectedValuesList().toString();
       int panjang = cari.length()-1;
       for (Barang b : listBarang){
           if (b.getNamaBarang().equals(cari.substring(1, panjang))){
               ketemu = b;
           }
       }
       return ketemu;
   }
   
   private Barang ubahDataBarang_KelolaBarang (KelolaBarang_Ubah tampilan){
       Barang barang = barangDicari;
       String tanggal,bulan,tahun;
       String tanggalbeli;
       
       tanggal = tampilan.getCb_tanggal().getSelectedItem().toString();
       bulan = tampilan.getCb_bulan().getSelectedItem().toString();
       tahun = tampilan.getCb_tahun().getSelectedItem().toString();
       tanggalbeli = tahun+"-"+bulan+"-"+tanggal;
       
       
       barang.setNamaBarang(tampilan.getTf_nama().getText());
       barang.setKondisiBarang(tampilan.getCb_kondisi().getSelectedItem().toString());
       barang.setHarga(Long.parseLong(tampilan.getTf_harga().getText()));
       barang.setFakultas(tampilan.getCb_fakultas().getSelectedItem().toString());
       barang.setProdi(tampilan.getCb_prodi().getSelectedItem().toString());
       barang.setTanggalBeli(tanggalbeli);
       barang.setLokasiRuangan(tampilan.getCb_lokasiruangan().getSelectedItem().toString());
       
       return barang;
   }
  
   
   private void pinjamBarang_KelolaBarang (KelolaBarang_Pinjam tampilan)  {
       Barang barang = barangDipinjam;
       Peminjaman peminjamanbarang = new Peminjaman();
       
       String tanggal,bulan,tahun;
       String tanggall,bulann,tahunn;
       String tanggalpinjam;
       String tanggalkembali;
       
       tanggal = tampilan.getCb_tanggalpinjam().getSelectedItem().toString();
       bulan = tampilan.getCb_bulanpinjam().getSelectedItem().toString();
       tahun = tampilan.getCb_tahunpinjam().getSelectedItem().toString();
       tanggalpinjam = tahun+"-"+bulan+"-"+tanggal;
      
       
       tanggall = tampilan.getCb_tanggalpengembalian().getSelectedItem().toString();
       bulann = tampilan.getCb_bulanpengembalian().getSelectedItem().toString();
       tahunn = tampilan.getCb_tahunpengembalian().getSelectedItem().toString();
       tanggalkembali = tahunn+"-"+bulann+"-"+tanggall;
       
       peminjamanbarang.setIdPeminjaman(listPeminjamanBarang.size()+1);
       peminjamanbarang.setIdBarang(barang.getIdBarang());
       peminjamanbarang.setNomorRuangan(barang.getLokasiRuangan());
       peminjamanbarang.setNamaPeminjam(tampilan.getTf_namapeminjam().getText());
       peminjamanbarang.setTanggalPinjam(tanggalpinjam);
       peminjamanbarang.setTanggalPengembalian(tanggalkembali);
     
       listPeminjamanBarang.add(peminjamanbarang);
       
   }
   
   private void tambahRuangan_KelolaRuangan (KelolaRuangan_Tambah tampilan){
       Ruangan ruangan = new Ruangan();
       ruangan.setIdRuangan(listRuangan.size()+1);
       ruangan.setNomorRuangan(tampilan.getTf_nomor().getText());
       ruangan.setNamaGedung(tampilan.getTf_namagedung().getText());
       ruangan.setJenisRuangan(tampilan.getTf_jenis().getText());
       ruangan.setProdi(tampilan.getCb_prodi().getSelectedItem().toString());
       ruangan.setFakultas(tampilan.getCb_fakultas().getSelectedItem().toString());
       
       listRuangan.add(ruangan);
   }
   
   private Ruangan cariRuangan_KelolaRuangan (KelolaRuangan_Cari tampilan){
       Ruangan ketemu = new Ruangan();
       
       String cari;
       cari =  tampilan.getList_ruangan().getSelectedValuesList().toString();
        int panjang = cari.length()-1;
       
       for (Ruangan r : listRuangan){
           if (r.getNomorRuangan().equals(cari.substring(1, panjang))){
               ketemu = r;
           }
       }
       
       return ketemu;
   }
   
   private Ruangan ubahDataRuangan_KelolaRuangan (KelolaRuangan_Ubah tampilan){
       Ruangan ruangan = ruanganDicari;
       ruangan.setNomorRuangan(tampilan.getTf_nomor().getText());
       ruangan.setNamaGedung(tampilan.getTf_namagedung().getText());
       ruangan.setJenisRuangan(tampilan.getTf_jenis().getText());
       ruangan.setFakultas(tampilan.getCb_fakultas().getSelectedItem().toString());
       ruangan.setProdi(tampilan.getCb_prodi().getSelectedItem().toString());
       return ruangan;
   }
   
   private LaporanMutasiPerubahan addLaporanMutasi (MenuCetakLaporan tampilan){
       LaporanMutasiPerubahan lap = new LaporanMutasiPerubahan();
       int jumlah = listPeminjamanBarang.size();
       lap.hitungBarangDipinjam(jumlah);
       
       String tanggal,bulan,tahun;

       String tanggall;
       
       tanggal = tampilan.getCb_tanggal().getSelectedItem().toString();
       bulan = tampilan.getCb_bulan().getSelectedItem().toString();
       tahun = tampilan.getCb_tahun().getSelectedItem().toString();
       tanggall = tahun+"-"+bulan+"-"+tanggal;
       
       lap.tanggal = tanggall;
       
       return lap;
   }
   
   private LaporanKondisiBarang addLaporanKondisi (MenuCetakLaporan tampilan){
       LaporanKondisiBarang lap = new LaporanKondisiBarang();
       int jumlah=0;
       for (Barang b : listBarang){
           if (b.getKondisiBarang().equals("Baik"))
               jumlah++;
       }
       lap.cekKondisiBarang(jumlah);
       
       String tanggal,bulan,tahun;

       String tanggall;
       
       tanggal = tampilan.getCb_tanggal().getSelectedItem().toString();
       bulan = tampilan.getCb_bulan().getSelectedItem().toString();
       tahun = tampilan.getCb_tahun().getSelectedItem().toString();
       tanggall = tahun+"-"+bulan+"-"+tanggal;
       
       lap.tanggal = tanggall;
       
       return lap;
   }
   
    private LaporanKeuangan addLaporanKeuangan (MenuCetakLaporan tampilan){
       LaporanKeuangan lap = new LaporanKeuangan();
       long jumlah=0;
       for (Barang b : listBarang){
               jumlah = jumlah + b.getHarga();
       }
       lap.hitungPendapatan(jumlah);
       
       String tanggal,bulan,tahun;

       String tanggall;
       
       tanggal = tampilan.getCb_tanggal().getSelectedItem().toString();
       bulan = tampilan.getCb_bulan().getSelectedItem().toString();
       tahun = tampilan.getCb_tahun().getSelectedItem().toString();
       tanggall = tahun+"-"+bulan+"-"+tanggal;
       
       lap.tanggal = tanggall;
       
       return lap;
   }
   
    public void saveLaporanMutasi(){
       file.saveObject(LapMutasiPerubahan, "LaporanMutasi.dat");
    }
    
    public void saveLaporanKeuangan(){
       file.saveObject(LapKeuangan, "LaporanKeuangan.dat");
    }
    
    public void saveLaporanKondisi(){
       file.saveObject(LapKondisiBarang, "LaporanKondisi.dat");
    }
}
