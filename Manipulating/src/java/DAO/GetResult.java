/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author notur
 */
public class GetResult {
    public GetResult(){
    connectDB();
}
 Connection cnn; //kết nối cơ sở dữ liệu
    Statement stm; //Thực thi câu lệnh SQL
    ResultSet rs; //Lưu trữ và xử lý dữ liệu

     private void connectDB() {
        try {
            cnn = (new DBContext()).getConnection();
            System.out.println("Connect Successfully.");

        } catch (Exception e) {
            System.out.println("Connect Error:" + e.getMessage());
        }
    }
     
      public String getResultbyNum(int num) {
   try {
     
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select *from tblNumber where iNum='"+num+"'" ;
            rs = stm.executeQuery(strSelect);
            while(rs.next()){
                return rs.getString(2);
            }

        } catch (Exception e) {
            System.out.println("Login Error" + e.getMessage());
        }
   return "";
    }
     
     public boolean checkNumber(int num) {
       

        
try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select *from tblNumber where iNum='"+num+"'";
            //strSelect = "select *from tblUser where pass='" + pass + "'";
            rs = stm.executeQuery(strSelect);
            while(rs.next()){
                return true;
            }

        } catch (Exception e) {
            System.out.println("Check Error" + e.getMessage());
        }return false;
        
        
    } 
     
     
//    public static void main(String[] args) {
//        GetResult re=new GetResult();
//        System.out.println(re.checkLoginAccount(52));
//    }
}
