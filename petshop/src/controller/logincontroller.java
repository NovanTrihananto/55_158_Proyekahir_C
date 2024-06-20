/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdata.DAOdatahewan;
import DAOimplement.hewanimplement;
import javax.swing.JOptionPane;
import model.*;
import hewan.LoginView;
import hewan.OptionView;


public class logincontroller {
    LoginView frame;
    hewanimplement impldatahewan;
    List<datahewan> cek;
    
    public logincontroller(LoginView frame){
        this.frame = frame;
        impldatahewan = new DAOdatahewan();
    }
    public void cekakun(){
        String username = frame.getJtuser().getText();
        String password = frame.getJtpass().getText();
        List<datahewan> cek = impldatahewan.getAkun(username);
        if (cek != null && !cek.isEmpty()) {
            datahewan dp = cek.get(0);
            if(password.equals(dp.getPassword())){ 
                OptionView v = new OptionView(dp);
                v.setVisible(true);
                v.setLocationRelativeTo(null);
                 
            }else{
                JOptionPane.showMessageDialog(frame, "Password Salah!", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(frame, "Akun Tidak Ditemukan, Silahkan Buat Akun Terlebih Dahulu", "Message", JOptionPane.INFORMATION_MESSAGE);   
        }
    }
}
