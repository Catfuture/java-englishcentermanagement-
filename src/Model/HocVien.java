/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;



/**
 *
 * @author ASUS
 */
public class HocVien {
    private String ma_hv;
    private String ten_hv;
    private String ngay_sinh;
    private String phai;
    private String dia_chi;
    private int lien_he;
    private String ma_khoa_hoc;
    private byte[] picture;
    

    public HocVien() {
    }

    public HocVien(String ma_hv, String ten_hv, String ngay_sinh, String phai, String dia_chi, int lien_he, String ma_khoa_hoc) {
        this.ma_hv = ma_hv;
        this.ten_hv = ten_hv;
        this.ngay_sinh = ngay_sinh;
        this.phai = phai;
        this.dia_chi = dia_chi;
        this.lien_he = lien_he;
        this.ma_khoa_hoc = ma_khoa_hoc;
    }

    public HocVien(String ma_hv, String ten_hv, String ngay_sinh, String phai, String dia_chi, int lien_he, String ma_khoa_hoc, byte[] picture) {
        this.ma_hv = ma_hv;
        this.ten_hv = ten_hv;
        this.ngay_sinh = ngay_sinh;
        this.phai = phai;
        this.dia_chi = dia_chi;
        this.lien_he = lien_he;
        this.ma_khoa_hoc = ma_khoa_hoc;
        this.picture = picture;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    

    public String getMa_khoa_hoc() {
        return ma_khoa_hoc;
    }

    public void setMa_khoa_hoc(String ma_khoa_hoc) {
        this.ma_khoa_hoc = ma_khoa_hoc;
    }

    

    
    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    

    public String getMa_hv() {
        return ma_hv;
    }

    public void setMa_hv(String ma_hv) {
        this.ma_hv = ma_hv;
    }

    public String getTen_hv() {
        return ten_hv;
    }

    public void setTen_hv(String ten_hv) {
        this.ten_hv = ten_hv;
    }

   

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public int getLien_he() {
        return lien_he;
    }

    public void setLien_he(int lien_he) {
        this.lien_he = lien_he;
    }

    @Override
    public String toString() {
        return "HocVien{" + "ma_hv=" + ma_hv + ", ten_hv=" + ten_hv + ", ngay_sinh=" + ngay_sinh + ", phai=" + phai + ", dia_chi=" + dia_chi + ", lien_he=" + lien_he + ", ma_khoa_hoc=" + ma_khoa_hoc + ", picture=" + picture + '}';
    }

  
    
}
