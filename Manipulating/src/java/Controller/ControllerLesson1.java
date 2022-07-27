/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.DAONumber;
import DAO.GetResult;
import Model.Number;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author notur
 */
public class ControllerLesson1 extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         String submit=request.getParameter("submit");
         String reset=request.getParameter("reset");
         String textField=request.getParameter("textField");
         String result="";
           
            if (submit!=null) {
                try {
                    int n=Integer.parseInt(textField);
                    GetResult get=new GetResult();
                    int number=Integer.parseInt(textField);
                      if(get.checkNumber(number)) {
                          
                        String myResult=get.getResultbyNum(number);
                        request.setAttribute("begin", textField);
                        request.setAttribute("start", "n: "+textField);
                request.setAttribute("result","result: "+ myResult);
                        
                    }
                      else{
                    if (n>0) {
                        result=textField;
                        
                       String value=String.valueOf(lietKeUocSNT(n));
                       DAONumber dao = new DAONumber();
                       
                        if (value.isEmpty()) {
                               request.setAttribute("start", "n: "+n);
                            request.setAttribute("result", "Result > 10");
                        }else{
                            
                            int add=dao.AddNum(new Number(n, value));
                        if (add>0) {
                            request.setAttribute("start", "n: "+n);
                    request.setAttribute("result", "result: "+value);
                        }else{
                            request.setAttribute("result", "Error");
                        }
                        }
                       
                         
                     
                         
                       
                    }else{
                         result="Number Must > 0";
                         request.setAttribute("result", result);
                    }
                      }
                    
                } catch (Exception e) {
                     result="Wrong Number Format";
                     request.setAttribute("result", result);
                }
            }
            if (reset!=null) {
                result="";
                textField="";
                request.setAttribute("start", textField);
                request.setAttribute("result", result);
            }
            
            
            
             
               request.getRequestDispatcher("Lesson1.jsp").forward(request, response);
               
               
               
               
            
        }
        
    } 

    public static boolean checkSNT(int n){
        if(n>1){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
            return true;
        }
        else 
            return false;
    }

    public static StringBuilder lietKeUocSNT(int n){
        int count=0;
        StringBuilder uoc = new StringBuilder();
        for(int i=1 ; i<=n ; i++){
            if(n%i==0 && (checkSNT(i))) {
                
                if (i<10) {
                     uoc.append(i+" ");
               }
               
            }
        }
        return uoc;
       
    }
    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
