package com.coldhardcode.scatter

import java.io.{PrintWriter, IOException}
import javax.servlet.{RequestDispatcher}
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

import com.coldhardcode.scatter.view.JSP

class Servlet extends HttpServlet {

    override def doGet(req:HttpServletRequest, resp:HttpServletResponse) : Unit = {

        handleRequest(req, resp)
    }

    override def doPost(req:HttpServletRequest, resp:HttpServletResponse) : Unit  = {

        handleRequest(req, resp)
    }

    def handleRequest(req:HttpServletRequest, resp:HttpServletResponse) : Unit = {

        val context:Context = new Context(getServletConfig.getServletContext, req, resp)

        println("Request Information")
        println("Request URI: " + req.getRequestURI)
        println("Request URL: " + req.getRequestURL)
        println("Servlet Path: " + req.getServletPath)
        println("Context Path: " + req.getContextPath)
        println("Query String: " + req.getQueryString)
        println("Path Info: " + req.getPathInfo)
        println("Path Translated: " + req.getPathTranslated)

        val actionName = req.getPathInfo.substring(1)
        println("Looking for: " + actionName)

        // Dispatch!
        Dispatcher.getAction(actionName, context)

        if(context.stash.get("template").isEmpty) {
            context.stash.put("template", req.getPathInfo.substring(1))
        }

        val view = new JSP;
        view.process(context)
    }
}
