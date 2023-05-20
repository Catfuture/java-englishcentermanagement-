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
public class LopHoc {
    private String ma_khoa_hoc;
    private String ten_khoa_hoc;
    private String ma_cap_do;
    private String ngay_bat_dau;
    private String ngay_ket_thuc;

    public LopHoc() {
    }

    public LopHoc(String ma_khoa_hoc, String ten_khoa_hoc, String ma_cap_do, String ngay_bat_dau, String ngay_ket_thuc) {
        this.ma_khoa_hoc = ma_khoa_hoc;
        this.ten_khoa_hoc = ten_khoa_hoc;
        this.ma_cap_do = ma_cap_do;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public String getMa_khoa_hoc() {
        return ma_khoa_hoc;
    }

    public void setMa_khoa_hoc(String ma_khoa_hoc) {
        this.ma_khoa_hoc = ma_khoa_hoc;
    }

    public String getTen_khoa_hoc() {
        return ten_khoa_hoc;
    }

    public void setTen_khoa_hoc(String ten_khoa_hoc) {
        this.ten_khoa_hoc = ten_khoa_hoc;
    }

    public String getMa_cap_do() {
        return ma_cap_do;
    }

    public void setMa_cap_do(String ma_cap_do) {
        this.ma_cap_do = ma_cap_do;
    }

    public String getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public void setNgay_bat_dau(String ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public String getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public void setNgay_ket_thuc(String ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    @Override
    public String toString() {
        return ten_khoa_hoc + " - " + ma_khoa_hoc;
    }
    
    
}
