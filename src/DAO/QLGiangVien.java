/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.GiangVien;
import Model.HocVien;
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
public class QLGiangVien {
    private static Connection c;
    private static String db_url = "jdbc:mysql://localhost:82/dbquanly";
    private static String username = "root";
    private static String password = "";
    
     public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (c == null) {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(db_url, username, password);
        }
        return c;
    }
     public ArrayList<GiangVien> DocDL(){           
        try {
            
            ArrayList<GiangVien> data = new ArrayList<>();
            Connection con = getConnection();
            String sql = "select * from giangvien";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                String mahv = rs.getNString("magv");
                String tenhv = rs.getNString("tengv");
                String ngaysinh = rs.getNString("ngaysinh");
                String diachi = rs.getNString("diachi");
                String phai = rs.getNString("phai");
                int lienhe = rs.getInt("lienhe");
                int luong = rs.getInt("luongcoban");
                GiangVien gv = new GiangVien(mahv, tenhv, phai, ngaysinh, diachi, lienhe, luong);
                data.add(gv);
            }
            return data;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLGiangVien.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Chua co thu vien");
        } catch (SQLException ex) {
            System.out.println("Loi ket noi");
            Logger.getLogger(QLGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
    }
     public int ThemDL(GiangVien hv){
        try {
            Connection con = getConnection();
            String sql = "insert into giangvien(magv, tengv, phai, ngaysinh, diachi, lienhe, luongcoban) Values ('" + hv.getMa_giang_vien()+ "','"
                    +hv.getTen_giang_vien()+"','"
                    +hv.getNgay_sinh()+"','"
                    +hv.getPhai()+"','"
                    +hv.getDia_chi()+"',"
                    +hv.getLien_he()+",'"
                    +hv.getLuong_cb()+"')";
            return con.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
     public int XoaDL(String mahv){
        try {
            Connection con = getConnection();
            String sql = "Delete from giangvien where magv = '" + mahv + "'";
            return con.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int SuaDL(GiangVien hv){
        try {
            Connection con = getConnection();
            String sql = "UPDATE giangvien set tengv='"+hv.getTen_giang_vien()+"',"
                    + "ngaysinh='"+hv.getNgay_sinh()+"',"
                    + "phai='"+hv.getPhai()+"',"
                    + "diachi='"+hv.getDia_chi()+"',"
                    + "lienhe='"+hv.getLien_he()+"',"
                    + "luongcoban='"+hv.getLuong_cb()+"' WHERE magv = '" + hv.getMa_giang_vien()+ "'";
            return con.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public GiangVien DocGVByID(String id){           
        try {
            GiangVien gv = new GiangVien();
            ArrayList<GiangVien> data = new ArrayList<>();
            Connection con = getConnection();
            String sql = "select * from giangvien where magv = '" + id + "'";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                String mahv = rs.getNString("magv");
                String tenhv = rs.getNString("tengv");
                String ngaysinh = rs.getNString("ngaysinh");
                String diachi = rs.getNString("diachi");
                String phai = rs.getNString("phai");
                int lienhe = rs.getInt("lienhe");
                int luong = rs.getInt("luongcoban");
                gv = new GiangVien(mahv, tenhv, phai, ngaysinh, diachi, lienhe, luong);
            }
            return gv;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLGiangVien.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Chua co thu vien");
        } catch (SQLException ex) {
            System.out.println("Loi ket noi");
            Logger.getLogger(QLGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
    }
     public int SLGiangVien(){           
        try {
            
            ArrayList<GiangVien> data = new ArrayList<>();
            Connection con = getConnection();
            String sql = "select * from giangvien";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                String mahv = rs.getNString("magv");
                String tenhv = rs.getNString("tengv");
                String ngaysinh = rs.getNString("ngaysinh");
                String diachi = rs.getNString("diachi");
                String phai = rs.getNString("phai");
                int lienhe = rs.getInt("lienhe");
                int luong = rs.getInt("luongcoban");
                GiangVien gv = new GiangVien(mahv, tenhv, phai, ngaysinh, diachi, lienhe, luong);
                data.add(gv);
            }
            return data.size();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLGiangVien.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Chua co thu vien");
        } catch (SQLException ex) {
            System.out.println("Loi ket noi");
            Logger.getLogger(QLGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;     
    }
     
}
