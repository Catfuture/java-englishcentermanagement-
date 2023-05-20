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
public class GiangVien {
    private String ma_giang_vien;
    private String ten_giang_vien;
    private String phai;
    private String ngay_sinh;
    private String dia_chi;
    private int lien_he;
    private int luong_cb;

    public GiangVien(String ma_giang_vien, String ten_giang_vien, String phai, String ngay_sinh, String dia_chi, int lien_he, int luong_cb) {
        this.ma_giang_vien = ma_giang_vien;
        this.ten_giang_vien = ten_giang_vien;
        this.phai = phai;
        this.ngay_sinh = ngay_sinh;
        this.dia_chi = dia_chi;
        this.lien_he = lien_he;
        this.luong_cb = luong_cb;
    }

    public GiangVien() {
    }

    public GiangVien(String mahv, String tenhv, String phai, String strDate, String diachi, String lienhe, String luong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMa_giang_vien() {
        return ma_giang_vien;
    }

    public void setMa_giang_vien(String ma_giang_vien) {
        this.ma_giang_vien = ma_giang_vien;
    }

    public String getTen_giang_vien() {
        return ten_giang_vien;
    }

    public void setTen_giang_vien(String ten_giang_vien) {
        this.ten_giang_vien = ten_giang_vien;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
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

    public int getLuong_cb() {
        return luong_cb;
    }

    public void setLuong_cb(int luong_cb) {
        this.luong_cb = luong_cb;
    }

    @Override
    public String toString() {
        return ten_giang_vien + " - " + ma_giang_vien;
    }
}
