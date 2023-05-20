/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.LichHoc;
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
public class QLLichHoc {

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

    public ArrayList<LichHoc> DocDL(int tuan) {
        try {

            ArrayList<LichHoc> data = new ArrayList<>();
            Connection con = getConnection();
            String sql = "select * from lichhocvaca where tuan = '" + tuan + "'";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                String malh = rs.getNString("malop");
                String magv = rs.getNString("magv");
                String lh = rs.getNString("lichhoc");
                String ph = rs.getNString("phonghoc");
                int _tuan = rs.getInt("tuan");
                LichHoc mh = new LichHoc(malh, magv, lh, ph, _tuan);
                data.add(mh);
            }
            return data;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLLichHoc.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Chua co thu vien");
        } catch (SQLException ex) {
            System.out.println("Loi ket noi");
            Logger.getLogger(QLLichHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int ThemDL(LichHoc hv) {
        try {
            Connection con = getConnection();
            String sql = "insert into lichhocvaca(malop,magv, lichhoc, phonghoc,tuan) Values ('" + hv.getMa_lop_hoc() + "','"
                    + hv.getMa_giang_vien() + "','"
                    + hv.getLich_hoc() + "','"
                    + hv.getPhong_hoc()+ "',"
                    + hv.getTuan()+ ")";
            return con.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLLichHoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLLichHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int XoaDL(String mahv) {
        try {
            Connection con = getConnection();
            String sql = "Delete from lichhocvaca where malop = '" + mahv + "'";
            return con.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLLichHoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLLichHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
