/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import context.DBContext;
import Model.Number;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DAONumber extends DBContext{
     Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection cnn; 
     //Khai bao cac thanh` phan` xu ly co so du lieu
   
    Statement stm; //Thực thi câu lệnh SQL

    
    
    public int AddNum(Number user) throws Exception{
        int n=0;
        String sql="INSERT INTO [tblNumber]\n" +
"           ([iNum]\n" +
"           ,[sResult])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?)";
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(sql);
        
        try {

         ps.setInt(1, user.getNumber());
         ps.setString(2, user.getResult());
         

            // run
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }return n;
    } 
    
    
   
     
    
  
}
