/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.QLCapDo;
import DAO.QLHocVien;
import Model.HocVien;
import java.util.List;


/**
 *
 * @author ASUS
 */
public class HocVienService {
    private QLHocVien qlhv;
    
    public HocVienService(){
        qlhv = new QLHocVien();
    }
    public List<HocVien> getAllhocVien(){
        return qlhv.DocDL();
    }
}
