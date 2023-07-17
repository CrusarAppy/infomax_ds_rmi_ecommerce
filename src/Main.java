import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try
        {
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from products");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("hello "+ rsmd.getColumnCount());
            while(rs.next())
            {
                System.out.println("ID: "+rs.getInt("id")+" Name: "+rs.getString("name"));
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