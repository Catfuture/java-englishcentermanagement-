/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.CapDo;
import Model.HocVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class QLCapDo {
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

    public ArrayList<CapDo> DocDL(){           
        try {          
            ArrayList<CapDo> data = new ArrayList<>();
            Connection con = getConnection();
            System.out.println("Ket noi thanh cong");
            String sql = "select * from capdo";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                String macd = rs.getNString("macap");
                String tencd = rs.getNString("loaicap");              
                CapDo cd = new CapDo(macd, tencd);
                data.add(cd);
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
}
