/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 
 */
public class modeltabelbarang extends AbstractTableModel {
    List<datahewan> dh;
    public modeltabelbarang(List<datahewan>dh){
        this.dh = dh;
    }
    
    @Override
    public int getRowCount() {
        return dh.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "id";
            case 1:
                return "nama_barang";
            case 2:
                return "jenis";
            case 3:
                return "harga";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dh.get(row).getId();
            case 1:
                return dh.get(row).getNama_barang();
            case 2:
                return dh.get(row).getJenis();
            case 3:
                return dh.get(row).getHarga();
            default:
                return null;
        }
    }
}
