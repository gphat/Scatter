package com.coldhardcode

import java.io.{PrintWriter, IOException};
import javax.servlet.{RequestDispatcher, ServletContextListener, ServletContextEvent};
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse};

class Scatter extends HttpServlet { // implements ServletContextListener {

/*
    def contextInitialized(ServletContextEvent event) {

        out.println("Starting Up");
    }

    def contextDestroyed(ServletContextEvent event) {

        out.println("Shutting Down");
    }
*/

    override def doGet(req:HttpServletRequest, resp:HttpServletResponse) : Unit = {

        val out:PrintWriter = resp.getWriter;
        out.println("<html>");
        out.println("<h1>GET</h1");
        out.println("</html");

        val dispatcher:RequestDispatcher = getServletConfig.getServletContext.getRequestDispatcher("/hello.jsp");
        dispatcher.forward(req, resp);
    }

    override def doPost(req:HttpServletRequest, resp:HttpServletResponse) : Unit  = {


        val out:PrintWriter = resp.getWriter;
        out.println("<html>");
        out.println("<h1>POST</h1");
        out.println("</html");
    }
}
