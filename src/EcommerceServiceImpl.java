import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EcommerceServiceImpl extends UnicastRemoteObject implements EcommerceService {
    protected EcommerceServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<Product> getAllProducts() throws RemoteException {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM products");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
//                double price = resultSet.getDouble("price");
//                String description = resultSet.getString("description");

                products.add(new Product(id, name));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(products);
        return products;
    }

    @Override
    public Product getProductById(int id) throws RemoteException {

        // Similar database retrieval logic as getAllProducts()
        return null;
    }

    @Override
    public void addProduct(Product product) throws RemoteException {
        // Database insertion logic
    }

    @Override
    public void updateProduct(Product product) throws RemoteException {
        // Database update logic
    }

    @Override
    public void deleteProduct(int id) throws RemoteException {
        // Database deletion logic
    }
}
