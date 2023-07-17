
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface EcommerceService extends Remote {
        List<Product> getAllProducts() throws RemoteException;
        Product getProductById(int id) throws RemoteException;
        void addProduct(Product product) throws RemoteException;
        void updateProduct(Product product) throws RemoteException;
        void deleteProduct(int id) throws RemoteException;
}

