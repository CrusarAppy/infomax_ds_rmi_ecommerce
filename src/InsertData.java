import java.sql.Connection;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {
        try
        {
            Connection con = DatabaseConnection.getConnection();

            Statement stmt = con.createStatement();

            System.out.println("Inserting records into the table...");
            String sql;
            sql = "INSERT INTO products VALUES (101,'Fatma')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO products VALUES (102, 'Zaid')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO products VALUES(103, 'Mittal')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

            con.close();
        }
        catch (Exception e)
        {
            System.out.println("aa");
            e.printStackTrace();
        }
    }
}
