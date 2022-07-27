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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notur
 */
public class ControllerLesson3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            List<Integer> numbersList = new ArrayList<>();
            String submit = request.getParameter("submit");
            String reset = request.getParameter("reset");
            String textField = request.getParameter("n");

            String start = "";
            String begin = "";
            String sum = "";
            int total=0;
            if (reset != null) {
                request.setAttribute("start", start);
                request.setAttribute("begin", begin);
                request.setAttribute("sum", sum);
            }
            if (submit != null) {
                try {
                    int num = Integer.parseInt(textField);
                    GetResult get = new GetResult();
                    if (get.checkNumber(num)) {

                        String myResult = get.getResultbyNum(num);
                        String[] s = myResult.split(" ");
                        
                         for (int i = 0; i < s.length; i++) {
                int numList = Integer.parseInt(s[i]);
                numbersList.add(numList);
                
            }
                         
                           for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) % 2 == 0) {

                            total += numbersList.get(i);
                        }

                    }
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        request.setAttribute("begin", textField);
                        request.setAttribute("start", "n: " + textField);
                        request.setAttribute("sum", total);
                        request.setAttribute("result", "result: " + myResult);

                    } else {
                        if (num>3) {
                            
                            
                            
                            
                            
                            int number = 2;
                        StringBuilder EvenNum = new StringBuilder();
                        String myEvenNum="";
                        while (number <= num) {
                            EvenNum.append(number + " ");
                            total+=number;
                            number += 2;
                        }
                       myEvenNum=String.valueOf(EvenNum);
                        
                        DAONumber addNum = new DAONumber();
                         int add=addNum.AddNum(new Model.Number(num, myEvenNum));
                            if (add>0) {
                                request.setAttribute("begin", textField);
                        request.setAttribute("start", "n: " + textField);
                        request.setAttribute("result", "result: " + myEvenNum);
                         request.setAttribute("sum", total);
                            }
                         
                       
                        }else{
                            request.setAttribute("begin", "");
                        request.setAttribute("start", "");
                        request.setAttribute("result", "Error");
                         request.setAttribute("sum", "");
                        }
                         
                    }

                    
                    
                    
                    

                } catch (Exception e) {
                    request.setAttribute("begin", "");
                    request.setAttribute("start", "Error");
                    request.setAttribute("sum", "");
                }

            }
            request.getRequestDispatcher("Lesson3.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
