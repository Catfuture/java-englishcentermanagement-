/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.HocVien;
import Model.LopHoc;
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
public class QLLopHoc {

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

    public ArrayList<LopHoc> DocDL() {
        try {

            ArrayList<LopHoc> data = new ArrayList<>();
            Connection con = getConnection();
            String sql = "select * from lophoc";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                String makh = rs.getNString("malop");
                String tenkh = rs.getNString("tenlop");
                String macd = rs.getNString("capdo");
                String nbd = rs.getNString("ngaybatdau");
                String nkt = rs.getNString("ngayketthuc");
                LopHoc mh = new LopHoc(makh, tenkh, macd, nbd, nkt);
                data.add(mh);
            }
            return data;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLLopHoc.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Chua co thu vien");
        } catch (SQLException ex) {
            System.out.println("Loi ket noi");
            Logger.getLogger(QLLopHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int ThemDL(LopHoc hv) {
        try {
            Connection con = getConnection();
            String sql = "insert into lophoc(malop, tenlop, capdo, ngaybatdau, ngayketthuc) Values ('" + hv.getMa_khoa_hoc() + "','"
                    + hv.getTen_khoa_hoc() + "','"
                    + hv.getMa_cap_do() + "','"
                    + hv.getNgay_bat_dau() + "','"
                    + hv.getNgay_ket_thuc() + "')";
            return con.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLLopHoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLLopHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int XoaDL(String mahv) {
        try {
            Connection con = getConnection();
            String sql = "Delete from lophoc where malop = '" + mahv + "'";
            return con.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLLopHoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLLopHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int SuaDL(LopHoc hv) {
        try {
            Connection con = getConnection();
            String sql = "UPDATE lophoc set tenlop='" + hv.getTen_khoa_hoc()+ "',"
                    + "capdo='" + hv.getMa_cap_do()+ "',"
                    + "ngaybatdau='" + hv.getNgay_bat_dau()+ "',"
                    + "ngayketthuc='" +hv.getNgay_ket_thuc()+ "' WHERE malop = '" + hv.getMa_khoa_hoc()+ "'";
            return con.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLLopHoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLLopHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
     public LopHoc DocKhoaHocByID(String id){           
        try {
            LopHoc mh = new LopHoc();
            Connection con = getConnection();
            String sql = "select * from lophoc where malop = '" + id + "'";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
               String makh = rs.getNString("malop");
                String tenkh = rs.getNString("tenlop");
                String macd = rs.getNString("capdo");
                String nbd = rs.getNString("ngaybatdau");
                String nkt = rs.getNString("ngayketthuc");
                mh = new LopHoc(makh, tenkh, macd, nbd, nkt);
            }
            return mh;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLLopHoc.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Chua co thu vien");
        } catch (SQLException ex) {
            System.out.println("Loi ket noi");
            Logger.getLogger(QLLopHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
    }
     public int SLKhoaHoc() {
        try {

            ArrayList<LopHoc> data = new ArrayList<>();
            Connection con = getConnection();
            String sql = "select * from lophoc";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                String makh = rs.getNString("malop");
                String tenkh = rs.getNString("tenlop");
                String macd = rs.getNString("capdo");
                String nbd = rs.getNString("ngaybatdau");
                String nkt = rs.getNString("ngayketthuc");
                LopHoc mh = new LopHoc(makh, tenkh, macd, nbd, nkt);
                data.add(mh);
            }
            return data.size();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLLopHoc.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Chua co thu vien");
        } catch (SQLException ex) {
            System.out.println("Loi ket noi");
            Logger.getLogger(QLLopHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
      public int SiSoHocVien(String ma_lop) {
        try {

            ArrayList<HocVien> data = new ArrayList<>();
            Connection con = getConnection();
            String sql = "select * from hocvien where lophoc = '" + ma_lop + "'";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
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
            Logger.getLogger(QLLopHoc.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Chua co thu vien");
        } catch (SQLException ex) {
            System.out.println("Loi ket noi");
            Logger.getLogger(QLLopHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
