/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.HocVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class QLHocVien {
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

    public ArrayList<HocVien> DocDL(){           
        try {
            
            ArrayList<HocVien> data = new ArrayList<>();
            Connection con = getConnection();
            String sql = "select * from hocvien";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                String mahv = rs.getNString("mahv");
                String tenhv = rs.getNString("tengv");
                String ngaysinh = rs.getNString("ngaysinh");
                String phai = rs.getNString("phai");
                String diachi = rs.getNString("diachi");
                int lienhe = rs.getInt("lienhe");
                String makhoahoc = rs.getNString("lophoc");
                byte[] imgae = rs.getBytes("image");
                HocVien mh = new HocVien(mahv, tenhv, ngaysinh, phai, diachi, lienhe,makhoahoc,imgae);
                data.add(mh);
            }
            return data;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Chua co thu vien");
        } catch (SQLException ex) {
            System.out.println("Loi ket noi");
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
    }
    public int ThemDL(HocVien hv){
        try {
            Connection con = getConnection();
            String sql = "insert into hocvien(mahv, tengv, ngaysinh, phai, diachi, lienhe, lophoc, image) Values ('" + hv.getMa_hv()+ "','"
                    +hv.getTen_hv()+"','"
                    +hv.getNgay_sinh()+"','"
                    +hv.getPhai()+"','"
                    +hv.getDia_chi()+"',"
                    +hv.getLien_he()+",'"
                    +hv.getMa_khoa_hoc()+"','"
                    +hv.getPicture()+"')";
            return con.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public boolean ThemDuLieu(HocVien hv){
        try {
            Connection con = getConnection();
            String sql = "insert into hocvien(mahv, tengv, ngaysinh, phai, diachi, lienhe, lophoc, image) values(?,?,?,?,?,?,?,?) ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, hv.getMa_hv());
            ps.setString(2, hv.getTen_hv());
            ps.setString(3, hv.getNgay_sinh());
            ps.setString(4, hv.getPhai());
            ps.setString(5, hv.getDia_chi());
            ps.setInt(6, hv.getLien_he());
            ps.setString(7, hv.getMa_khoa_hoc());
            ps.setBytes(8, hv.getPicture());
            return ps.executeUpdate() > 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int XoaDL(String mahv){
        try {
            Connection con = getConnection();
            String sql = "Delete from hocvien where mahv = '" + mahv + "'";
            return con.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
     public int SuaDL(HocVien hv){
        try {
            Connection con = getConnection();
            String sql = "UPDATE hocvien set tengv='"+hv.getTen_hv()+"',"
                    + "ngaysinh='"+hv.getNgay_sinh()+"',"
                    + "phai='"+hv.getPhai()+"',"
                    + "diachi='"+hv.getDia_chi()+"',"
                    + "lienhe='"+hv.getLien_he()+"',"
                    + "lophoc='"+hv.getMa_khoa_hoc()+"',"
                    + "image='"+hv.getPicture()+"' WHERE mahv = '" + hv.getMa_hv() + "'";
            return con.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
      public boolean SuaDuLieu(HocVien hv){
        try {
            Connection con = getConnection();
            String sql = "UPDATE hocvien set tengv = ?, ngaysinh = ?, phai = ?, diachi = ?, lienhe = ?, lophoc = ?, image = ? where mahv = ?";
            PreparedStatement ps = con.prepareStatement(sql);            
            ps.setString(1, hv.getTen_hv());
            ps.setString(2, hv.getNgay_sinh());
            ps.setString(3, hv.getPhai());
            ps.setString(4, hv.getDia_chi());
            ps.setInt(5, hv.getLien_he());
            ps.setString(6, hv.getMa_khoa_hoc());
            ps.setBytes(7, hv.getPicture());
            ps.setString(8, hv.getMa_hv());
            return ps.executeUpdate() > 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     public HocVien DocHocVienByID(String id){           
        try {
            HocVien mh = new HocVien();
            Connection con = getConnection();
            String sql = "select * from hocvien where mahv = '" + id + "'";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                String mahv = rs.getNString("mahv");
                String tenhv = rs.getNString("tengv");
                String ngaysinh = rs.getNString("ngaysinh");
                String diachi = rs.getNString("diachi");
                String phai = rs.getNString("phai");
                int lienhe = rs.getInt("lienhe");
                String makhoahoc = rs.getNString("lophoc");
                byte[] imgae = rs.getBytes("image");
                mh = new HocVien(mahv, tenhv, ngaysinh, phai, diachi, lienhe,makhoahoc,imgae);
            }
            return mh;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Chua co thu vien");
        } catch (SQLException ex) {
            System.out.println("Loi ket noi");
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }
    public boolean KiemTraHocVienByID(String id){    
        boolean flag = false;
        try {
           
            Connection con = getConnection();
            String sql = "select * from hocvien where mahv = '" + id + "'";
            ResultSet rs = con.createStatement().executeQuery(sql);            
            if(rs.next()){
                flag = true;
            }
            return flag;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Chua co thu vien");
        } catch (SQLException ex) {
            System.out.println("Loi ket noi");
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;     
    }
    public int SoLuongHocVien(){           
        try {
            
            ArrayList<HocVien> data = new ArrayList<>();
            Connection con = getConnection();
            String sql = "select * from hocvien";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                String mahv = rs.getNString("mahv");
                String tenhv = rs.getNString("tengv");
                String ngaysinh = rs.getNString("ngaysinh");
                String diachi = rs.getNString("diachi");
                String phai = rs.getNString("phai");
                int lienhe = rs.getInt("lienhe");
                String makhoahoc = rs.getNString("lophoc");
                byte[] imgae = rs.getBytes("image");
                HocVien mh = new HocVien(mahv, tenhv, ngaysinh, phai, diachi, lienhe,makhoahoc, imgae);
                data.add(mh);
            }
            return data.size();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Chua co thu vien");
        } catch (SQLException ex) {
            System.out.println("Loi ket noi");
            Logger.getLogger(QLHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;     
    }
}
