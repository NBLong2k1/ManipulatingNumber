/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.DAONumber;
import DAO.GetResult;
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
public class ControllerLesson2 extends HttpServlet {
   
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
          String textField=request.getParameter("textField");
          String reset=request.getParameter("reset");
          String submit=request.getParameter("submit");
          String myRsPrime="";
            if (reset!=null) {
                textField="";
                request.setAttribute("start", textField);
                request.setAttribute("begin", textField);

                request.setAttribute("result", textField);
                  
            } 
            if (submit!=null) {
                String result="";
                try {
                     
                    int number=Integer.parseInt(textField);
                    if (number<2) {
                        result="Error";
                        textField="";
                          request.setAttribute("start", textField);
                request.setAttribute("result", result);
                    }
                    GetResult get=new GetResult();
                      if(get.checkNumber(number)) {
                          
                        String myResult=get.getResultbyNum(number);
                        request.setAttribute("begin", textField);
                        request.setAttribute("start", "n: "+textField);
                request.setAttribute("result","result: "+ myResult);
                        
                    }else{
                          StringBuilder myPrime = new StringBuilder();
                        String num;
                       
                        int n=Integer.parseInt(textField);
                        for (int i = 0; i <= n; i++) {
                            if (isPrime(i)) {
                               
                                num = String.valueOf(i);
                                 
                                    myPrime.append(num + " ");
                                
                                 

                            }
                        }
                        myRsPrime = String.valueOf(myPrime);
                        
                         DAONumber addNum = new DAONumber();
                           int add=addNum.AddNum(new Model.Number(number, myRsPrime));
                          if (add>0) {
                               request.setAttribute("start", "n: "+textField);
                        request.setAttribute("result","result: "+ myRsPrime);
                          }else{
                              request.setAttribute("start", "");
                        request.setAttribute("result","Error");
                          }
                        
                        request.getRequestDispatcher("Lesson2.jsp").forward(request, response);
                      }
                    
                    
                     
                   
                    
                    
                    
                } catch (Exception e) {
                     result="Error";
                        textField="";
                          request.setAttribute("start", textField);
                request.setAttribute("result", result);
                }
              
                
            }
            request.getRequestDispatcher("Lesson2.jsp").forward(request, response);
            
            
        }
    } 
    static boolean isPrime(int n) {

        // Check if number is less than
        // equal to 1
        if (n <= 1) {
            return false;
        } // Check if number is 2
        else if (n == 2) {
            return true;
        } // Check if n is a multiple of 2
        else if (n % 2 == 0) {
            return false;
        }

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
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
