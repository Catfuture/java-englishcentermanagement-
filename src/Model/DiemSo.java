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
public class DiemSo {
    private String ma_hoc_vien;
    private int diem_so;
    private String xep_loai;
    private String ngay_thi;

    public DiemSo() {
    }

    public DiemSo(String ma_hoc_vien, int diem_so, String xep_loai, String ngay_thi) {
        this.ma_hoc_vien = ma_hoc_vien;
        this.diem_so = diem_so;
        this.xep_loai = xep_loai;
        this.ngay_thi = ngay_thi;
    }

    public String getMa_hoc_vien() {
        return ma_hoc_vien;
    }

    public void setMa_hoc_vien(String ma_hoc_vien) {
        this.ma_hoc_vien = ma_hoc_vien;
    }

    public int getDiem_so() {
        return diem_so;
    }

    public void setDiem_so(int diem_so) {
        this.diem_so = diem_so;
    }

    public String getXep_loai() {
        return xep_loai;
    }

    public void setXep_loai(String xep_loai) {
        this.xep_loai = xep_loai;
    }

    public String getNgay_thi() {
        return ngay_thi;
    }

    public void setNgay_thi(String ngay_thi) {
        this.ngay_thi = ngay_thi;
    }

    @Override
    public String toString() {
        return "DiemSo{" + "ma_hoc_vien=" + ma_hoc_vien + ", diem_so=" + diem_so + ", xep_loai=" + xep_loai + ", ngay_thi=" + ngay_thi + '}';
    }
    
    
}
