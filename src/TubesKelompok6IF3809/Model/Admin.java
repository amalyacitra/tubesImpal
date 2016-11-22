/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TubesKelompok6IF3809.Model;

/**
 *
 * @author KELOMPOK 6 IF-38-09
 */
public class Admin {
    private String nama;
    private String nip;
    
     public Admin() {
        
    }

    public Admin(String nama, String nip) {
        this.nama = nama;
        this.nip = nip;
    }
   

    public String getNama() {
        return nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
   
}
