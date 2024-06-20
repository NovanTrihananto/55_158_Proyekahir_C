/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAOimplement.hewanimplement;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;
import hewan.MainView;
import DAOdata.DAOdatahewan;
/**
 *
 * @author 
 */
public class DAOcontrollerhewan {
    MainView frame;
    hewanimplement impldatahewan;
    List<datahewan> dh;
    
    
    public DAOcontrollerhewan(MainView frame){
        this.frame = frame;
        impldatahewan = new DAOdatahewan();
        dh = impldatahewan.getAll();
    }
    public void isitabel(){
        dh = impldatahewan.getAll();
        modeltabelhewan mp = new modeltabelhewan(dh);
        frame.getTabelhewan().setModel(mp);
    }
    
    
    public void insert(){
        datahewan dh = new datahewan();
        dh.setNama_pemilik(frame.getJtnp().getText());
        dh.setNama_hewan(frame.getJtnh().getText());
        dh.setJenis_hewan (frame.getJtjh().getText());
        dh.setNomor_telepon(Integer.parseInt(frame.getJtnt().getText()));
        dh.setDurasi_titip(Integer.parseInt(frame.getJtdt().getText()));
        if (dh.getDurasi_titip() <= 5){
         dh.setTotal_biaya(dh.getDurasi_titip() * 200000);
         } else {
            int waktu_tambahan = dh.getDurasi_titip() - 9;
            dh.setTotal_biaya((2 * 100000) + (waktu_tambahan * 100000));
        }
        impldatahewan.insert(dh);
        
    }
    
    public void update(){
        datahewan dh = new datahewan();
        dh.setNama_pemilik(frame.getJtnp().getText());
        dh.setNama_hewan(frame.getJtnh().getText());
        dh.setJenis_hewan (frame.getJtjh().getText());
        dh.setNomor_telepon(Integer.parseInt(frame.getJtnt().getText()));
        dh.setDurasi_titip(Integer.parseInt(frame.getJtdt().getText()));
        if (dh.getDurasi_titip() <= 5){
         dh.setTotal_biaya(dh.getDurasi_titip() * 200000);
         } else {
            int waktu_tambahan = dh.getDurasi_titip() - 9;
            dh.setTotal_biaya((2 * 100000) + (waktu_tambahan * 100000));
        }
        dh.setId(Integer.parseInt(frame.getJtid().getText()));
        impldatahewan.update(dh);
        
    }
    public void delete(){
        int id = (Integer.parseInt(frame.getJtid().getText()));
        impldatahewan.delete(id);
    }
    
    public void clearFields() {
    datahewan dh = new datahewan();
    frame.getJtjh().setText("");
    frame.getJtdt().setText("");
    frame.getJtnp().setText("");
    frame.getJtnt().setText("");
    frame.getJtnh().setText("");
    frame.getJtid().setText("");  
    impldatahewan.update(dh);
    }
}
