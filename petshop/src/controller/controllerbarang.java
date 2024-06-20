/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAOimplement.hewanimplement;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;
import DAOdata.DAOdatahewan;
import hewan.shopview;
/**
 *
 * @author ASUS
 */
public class controllerbarang {
    shopview frame;
    hewanimplement impldatahewan;
    List<datahewan> dh;
    
    public controllerbarang(shopview frame){
        this.frame = frame;
        impldatahewan = new DAOdatahewan();
    }
    public void isitabelbarang(){
        dh = impldatahewan.getAllbarang();
        modeltabelbarang mp = new modeltabelbarang(dh);
        frame.getTabelshop().setModel(mp);
    }
    
    public void isitabeltransaksi(){
        dh = impldatahewan.getAlltransaksi();
        modeltabeltransaksi mp = new modeltabeltransaksi(dh);
        frame.getTabelpelanggan().setModel(mp);
    }
    
    public void isitabelhasil(){
        dh = impldatahewan.getAllhasil();
        modeltabelhasil mp = new modeltabelhasil(dh);
        frame.getTabelhasil().setModel(mp);
    }

    public void insertpelanggan(){
        datahewan dh = new datahewan();
        dh.setNama(frame.getJtpelanggan().getText());
        impldatahewan.insertpelanggan(dh);
    }
    
    public void inserthasil(){
        datahewan dh = new datahewan();
        dh.setId_pelanggan(Integer.parseInt(frame.getJtidt().getText()));
        dh.setNama_pelanggan(frame.getJtnp().getText());
        dh.setBarang(frame.getJtb().getText());
        dh.setHarga(Integer.parseInt(frame.getJth().getText()));        
        impldatahewan.inserthasil(dh);
    }
    
    public void clearFields() {
    datahewan dh = new datahewan();
    frame.getJth().setText("");
    frame.getJtidpelanggan().setText("");
    frame.getJtj().setText("");
    frame.getJtnb().setText("");
    frame.getJtpelanggan().setText("");
    frame.getJtb().setText("");
    frame.getJtnp().setText("");
    frame.getJtidt().setText("");
    impldatahewan.update(dh);
    }
    
}
