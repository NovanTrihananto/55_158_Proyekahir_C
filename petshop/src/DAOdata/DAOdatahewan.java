package DAOdata;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.koneksi;
import model.*;
import DAOimplement.hewanimplement;
/**
 *
 * @author 
 */
public class DAOdatahewan implements hewanimplement {
    Connection connection;
 
    final String select = "SELECT * FROM titip_hewan";
    final String insert = "INSERT titip_hewan (nama_pemilik, nama_hewan, jenis_hewan, nomor_telepon, durasi_titip, total_biaya) VALUES (?,?,?,?,?,?);";
    final String update = "UPDATE titip_hewan SET nama_pemilik=?, nama_hewan=?, jenis_hewan=?, nomor_telepon=?, durasi_titip=?, total_biaya=? where id=?;";
    final String delete = "delete from titip_hewan where id=?";
    final String selectakun ="SELECT * FROM pegawai where username=?;";
    final String selectbarang = "SELECT * FROM barang_petshop";
    final String insertpelanggan = "INSERT transaksi (nama) VALUES (?);";
    final String selectpelanggan = "SELECT * FROM transaksi";
    final String selecthasil = "SELECT * FROM detail_transaksi";
    final String inserthasil = "INSERT detail_transaksi (id_pelanggan, nama_pelanggan, barang, harga) VALUES (?,?,?,?);";
    final String deleteshop = "delete from titip_hewan where id=?";
    
    public DAOdatahewan(){
        connection = koneksi.connection();
    }

    @Override
    public void insert(datahewan dh) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, dh.getNama_pemilik());
            statement.setString(2, dh.getNama_hewan());
            statement.setString(3, dh.getJenis_hewan());
            statement.setInt(4, dh.getNomor_telepon());
            statement.setInt(5, dh.getDurasi_titip());
            statement.setInt(6, dh.getTotal_biaya());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex ){
                ex.printStackTrace();
            }
        }
    }

    public void update(datahewan dh) {
           PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, dh.getNama_pemilik());
            statement.setString(2, dh.getNama_hewan());
            statement.setString(3, dh.getJenis_hewan());
            statement.setInt(4, dh.getNomor_telepon());
            statement.setInt(5, dh.getDurasi_titip());
            statement.setInt(6, dh.getTotal_biaya());
            statement.setInt(7, dh.getId());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                if (statement !=null){
                    statement.close();
                }
            }catch(SQLException ex ){
                ex.printStackTrace();
            }
        }
    }
    public List<datahewan> getAll() {
        List<datahewan> dh = null;
        try{
            dh = new ArrayList<datahewan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datahewan dr = new datahewan();
                dr.setId(rs.getInt("id"));
                dr.setNama_pemilik(rs.getString("nama_pemilik"));
                dr.setNama_hewan(rs.getString("nama_hewan"));
                dr.setJenis_hewan(rs.getString("jenis_hewan"));
                dr.setNomor_telepon(rs.getInt("nomor_telepon"));
                dr.setDurasi_titip(rs.getInt("durasi_titip"));
                dr.setTotal_biaya(rs.getInt("total_biaya"));
                dh.add(dr);
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOdatahewan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dh;
    }
    @Override
    public void delete(int Id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, Id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex ){
                ex.printStackTrace();
            }
        }
    }
    
    public List<datahewan> getAkun(String username) {
        List<datahewan> dh = null;
        try{
            dh = new ArrayList<datahewan>();
            Statement st = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(selectakun);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                datahewan dk = new datahewan();
                dk.setId(rs.getInt("id"));
                dk.setUsername(rs.getString("username"));
                dk.setPassword(rs.getString("password"));
                dh.add(dk);
                
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOdatahewan.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dh;
    }
    
    @Override
    public List<datahewan> getAllbarang() {
        List<datahewan> dh = null;
        try{
            dh = new ArrayList<datahewan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(selectbarang);
            while(rs.next()){
                datahewan hew = new datahewan();
                hew.setId(rs.getInt("id"));
                hew.setNama_barang(rs.getString("nama_barang"));
                hew.setJenis(rs.getString("jenis"));
                hew.setHarga(rs.getInt("Harga"));
                dh.add(hew);
                
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOdatahewan.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dh;
    }
    
    public List<datahewan> getAlltransaksi() {
        List<datahewan> dh = null;
        try{
            dh = new ArrayList<datahewan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(selectpelanggan);
            while(rs.next()){
                datahewan tr = new datahewan();
                tr.setId(rs.getInt("id"));
                tr.setNama(rs.getString("nama"));
                dh.add(tr);
                
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOdatahewan.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dh;
    }
    
    public List<datahewan> getAllhasil() {
        List<datahewan> dh = null;
        try{
            dh = new ArrayList<datahewan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(selecthasil);
            while(rs.next()){
                datahewan tr = new datahewan();
                tr.setId_pelanggan(rs.getInt("id_pelanggan"));
                tr.setNama_pelanggan(rs.getString("nama_pelanggan"));
                tr.setBarang(rs.getString("Barang"));
                tr.setHarga(rs.getInt("Harga"));
                dh.add(tr);
                
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOdatahewan.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dh;
    }
    
    public void inserthasil(datahewan dh) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(inserthasil, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, dh.getId_pelanggan());
            statement.setString(2, dh.getNama_pelanggan());
            statement.setString(3, dh.getBarang());
            statement.setInt(4, dh.getHarga());            
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex ){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void insertpelanggan(datahewan dh) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insertpelanggan, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, dh.getNama());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex ){
                ex.printStackTrace();
            }
        }
    }
}
