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
public class CapDo {
    String ma_cap;
    String loai_cap;

    public CapDo(String ma_cap, String loai_cap) {
        this.ma_cap = ma_cap;
        this.loai_cap = loai_cap;
    }

    public CapDo() {
    }

    public String getMa_cap() {
        return ma_cap;
    }

    public void setMa_cap(String ma_cap) {
        this.ma_cap = ma_cap;
    }

    public String getLoai_cap() {
        return loai_cap;
    }

    public void setLoai_cap(String loai_cap) {
        this.loai_cap = loai_cap;
    }

    @Override
    public String toString() {
        return loai_cap;
    }
    
    
}
