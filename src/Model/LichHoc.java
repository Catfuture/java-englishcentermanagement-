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
public class LichHoc {
    private String ma_lop_hoc;
    private String ma_giang_vien;
    private String lich_hoc;
    private String phong_hoc;
    private int tuan;

    public LichHoc() {
    }

    public LichHoc(String ma_lop_hoc, String ma_giang_vien, String lich_hoc, String phong_hoc, int tuan) {
        this.ma_lop_hoc = ma_lop_hoc;
        this.ma_giang_vien = ma_giang_vien;
        this.lich_hoc = lich_hoc;
        this.phong_hoc = phong_hoc;
        this.tuan = tuan;
    }

    public int getTuan() {
        return tuan;
    }

    public void setTuan(int tuan) {
        this.tuan = tuan;
    }
    
    

    public String getMa_lop_hoc() {
        return ma_lop_hoc;
    }

    public void setMa_lop_hoc(String ma_lop_hoc) {
        this.ma_lop_hoc = ma_lop_hoc;
    }
    

    public String getMa_giang_vien() {
        return ma_giang_vien;
    }

    public void setMa_giang_vien(String ma_giang_vien) {
        this.ma_giang_vien = ma_giang_vien;
    }

    public String getLich_hoc() {
        return lich_hoc;
    }

    public void setLich_hoc(String lich_hoc) {
        this.lich_hoc = lich_hoc;
    }

    public String getPhong_hoc() {
        return phong_hoc;
    }

    public void setPhong_hoc(String phong_hoc) {
        this.phong_hoc = phong_hoc;
    }
    
    
    
}
