package DAOimplement;
import model.*;
import java.util.List;

/**
 *
 * @author
 */
public interface hewanimplement {
    public List<datahewan> getAll();
    public List<datahewan> getAllbarang();
    public List<datahewan> getAlltransaksi();
    public List<datahewan> getAllhasil();
    public void insert(datahewan dh);
    public void insertpelanggan(datahewan dh);
    public void inserthasil(datahewan dh);
    public void update(datahewan dh);
    public void delete(int Id);
    public List<datahewan> getAkun(String username);
}
