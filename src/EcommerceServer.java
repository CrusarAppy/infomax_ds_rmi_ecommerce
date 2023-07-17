import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EcommerceServer {
    public static void main(String[] args) {
        try {
            EcommerceService ecommerceService = new EcommerceServiceImpl();
            Registry registry = LocateRegistry.createRegistry(8399);
            registry.rebind("EcommerceService", ecommerceService);
            System.out.println("Ecommerce server is running...");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
