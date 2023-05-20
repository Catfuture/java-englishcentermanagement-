/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.DiemSo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class QLDiemSo {
     private static Connection c;
    private static String db_url = "jdbc:mysql://localhost:3306/dbquanly";
    private static String username = "root";
    private static String password = "";
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (c == null) {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(db_url, username, password);
        }
        return c;
    }
    public ArrayList<DiemSo> DocDL(){           
        try {
            
            ArrayList<DiemSo> data = new ArrayList<>();
            Connection con = getConnection();
            String sql = "select * from diemkiemtra";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                String mahv = rs.getNString("mahv");
                int diem = rs.getInt("diem");
                String xeploai = rs.getNString("xeploai");
                String ngay = rs.getNString("ngay");
                DiemSo ds = new DiemSo(mahv, diem, xeploai, ngay);
                data.add(ds);
            }
            return data;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLDiemSo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Chua co thu vien");
        } catch (SQLException ex) {
            System.out.println("Loi ket noi");
            Logger.getLogger(QLDiemSo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
    }
    public int ThemDL(DiemSo hv){
        try {
            Connection con = getConnection();
            String sql = "insert into diemkiemtra(mahv, diem, xeploai, ngay) Values ('" + hv.getMa_hoc_vien()+ "',"
                    +hv.getDiem_so()+",'"
                    +hv.getXep_loai()+"','"
                    +hv.getNgay_thi()+"')";
            return con.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLDiemSo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLDiemSo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
     public int XoaDL(String mahv){
        try {
            Connection con = getConnection();
            String sql = "Delete from diemkiemtra where mahv = '" + mahv + "'";
            return con.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLDiemSo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLDiemSo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
      public int SuaDL(DiemSo hv){
        try {
            Connection con = getConnection();
            String sql = "UPDATE diemkiemtra set diem='"+hv.getDiem_so()+"',"
                    + "xeploai='"+hv.getXep_loai()+"',"
                    + "ngay='"+hv.getNgay_thi()+"' WHERE mahv = '" + hv.getMa_hoc_vien()+ "'";
            return con.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
      public DiemSo DocDiemSoById(String id){           
        try {
            
            DiemSo ds = new DiemSo();
            Connection con = getConnection();
            String sql = "select * from diemkiemtra where mahv = '" + id + "'";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                String mahv = rs.getNString("mahv");
                int diem = rs.getInt("diem");
                String xeploai = rs.getNString("xeploai");
                String ngay = rs.getNString("ngay");
                ds = new DiemSo(mahv, diem, xeploai, ngay);
            }
            return ds;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLDiemSo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Chua co thu vien");
        } catch (SQLException ex) {
            System.out.println("Loi ket noi");
            Logger.getLogger(QLDiemSo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
    }
}
