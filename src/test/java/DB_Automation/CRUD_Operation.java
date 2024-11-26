package DB_Automation;

import DB_base.Base_Class;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD_Operation extends Base_Class {

    @Test
    public void DB_Test_InsertData() throws SQLException{
        con = this.setUp();
        PreparedStatement ps = con.prepareStatement("insert into User values(?, ?)");
       ps.setInt(1,2);
       ps.setString(2,"RAM");
        ps.executeUpdate();
        DB_Test_SelectQuery();
    }

    @Test
    public  void DB_Test_UpdateData() throws SQLException{
        con=this.setUp();
        PreparedStatement ps=con.prepareStatement("update User set User_name='DPL' where User_Id=1");
        ps.executeUpdate();
        DB_Test_SelectQuery();
    }

    @Test
    public void DB_Test_deleteData() throws SQLException{
        con = this.setUp();
        try {
            PreparedStatement ps = con.prepareStatement("delete from User where User_id = 2");
            ps.executeUpdate();
            DB_Test_SelectQuery();
        } catch (SQLException sqe){
            System.out.println(sqe.getErrorCode());
            System.out.println(sqe.getSQLState());
            System.out.println(sqe.getMessage());
            sqe.printStackTrace();
        }
    }

    @Test
    public void DB_Test_SelectQuery() throws SQLException{
        con = this.setUp();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("Select * from User");
        while (rs.next()){
            int User_Id = rs.getInt(1);
            String User_Name = rs.getString(2);
            System.out.println(User_Id + "  "+User_Name+"   ");
        }
    }

}
