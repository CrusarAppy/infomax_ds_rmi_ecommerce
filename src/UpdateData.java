import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateData {
    static final String QUERY = "SELECT id, name FROM products";
    public static void main(String[] args) {

        try
        {
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();

            String sql = "UPDATE products " +
                    "SET name = 'doll' WHERE id = 100";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next()){
                //Display values
                System.out.print("ID: " + rs.getInt("id") + "\n");
                System.out.print("Name: " + rs.getString("name") + "\n");
            }

            con.close();
        }
        catch (Exception e)
        {
            System.out.println("aa");
            e.printStackTrace();
        }
    }
}
