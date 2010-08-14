package com.coldhardcode

import java.io.{PrintWriter, IOException}
import javax.servlet.{RequestDispatcher}
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

import com.coldhardcode.scatter.Dispatcher

class Scatter extends HttpServlet {

    /* Servlet Shit! */

    override def doGet(req:HttpServletRequest, resp:HttpServletResponse) : Unit = {

        handleRequest(req, resp)
    }

    override def doPost(req:HttpServletRequest, resp:HttpServletResponse) : Unit  = {

        handleRequest(req, resp)
    }

    def handleRequest(req:HttpServletRequest, resp:HttpServletResponse) : Unit = {

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

/*        val d:Dispatcher = new Dispatcher;*/
        println(Dispatcher.getAction(actionName))

        val defaultTemplate:String = req.getPathInfo

        val dispatcher:RequestDispatcher = getServletConfig.getServletContext.getRequestDispatcher(defaultTemplate + ".jsp")
        dispatcher.forward(req, resp)
    }
}
