package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {


    /*
create table dbo.RyanTest_Deleteme(Name varchar(100) null)

insert dbo.RyanTest_Deleteme(Name) values ('Apple'), ('sauce'), ('grape')
     */

    public static void main(String[] args) {
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://DBServerAO22.SPIE.ORG:40204;databaseName=VisitorDatamart;integratedSecurity=true"; //"DEVWarehouse"="DBMSSOCN,DBServerAO22.SPIE.ORG,40204"

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT  * FROM dbo.RyanTest_Deleteme";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
