package DB_base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Base_Class {

    public static Connection con;

    @BeforeMethod
    public Connection setUp() throws SQLException{
        try{
            String dburl = "jdbc:mysql://localhost:3306/databasetesting";
            String UserName = "root";
            String Password = "Ram@2002";
            con = DriverManager.getConnection(dburl, UserName, Password);

        }catch (SQLException sqe){
            System.out.println(sqe.getErrorCode());
            System.out.println(sqe.getSQLState());
            System.out.println(sqe.getMessage());
            sqe.printStackTrace();
        }
        return con;
    }

    @AfterMethod
    public void tearDown() throws SQLException{
        con.close();
    }
}
