import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class EcommerceClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",8399);
            EcommerceService ecommerceService = (EcommerceService) registry.lookup("EcommerceService");

            // Use the ecommerceService to interact with the server methods
            List<Product> products = ecommerceService.getAllProducts();
            System.out.println(products);
            for (Product product : products) {
                System.out.println(product);
            }
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
