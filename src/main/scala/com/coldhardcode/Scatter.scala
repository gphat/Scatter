package com.coldhardcode

import java.io.{PrintWriter, IOException}
import javax.servlet.{RequestDispatcher, ServletContextListener, ServletContextEvent}
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

import com.coldhardcode.scatter.annotation.Public
import com.coldhardcode.WebClasspathDiscoverer

import com.impetus.annovention.{Discoverer,ClasspathDiscoverer}
import com.impetus.annovention.listener.{MethodAnnotationDiscoveryListener}

class Scatter extends HttpServlet with ServletContextListener with MethodAnnotationDiscoveryListener {

    def contextInitialized(event:ServletContextEvent) : Unit = {

        println("### Starting Up")

        val disc:Discoverer = new WebClasspathDiscoverer(event.getServletContext);
        disc.addAnnotationListener(this)
        println("### Firing Discoverer")
        disc.discover
        println("### Done")
    }

    def contextDestroyed(event:ServletContextEvent) : Unit = {

        println("### Shutting Down")
    }

    /* Annotation Shit! */

    override def discovered(clas:String, method:String, annotation:String) : Unit = {

        println("Discovered " + clas + "." + method + ": " + annotation);
    }
    
    override def supportedAnnotations() : Array[java.lang.String] = {

        println("Registering interesting Annotations")
        return Array("com.coldhardcode.scatter.annotation.Public")
    };

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

        val defaultTemplate:String = req.getPathInfo

        val dispatcher:RequestDispatcher = getServletConfig.getServletContext.getRequestDispatcher(defaultTemplate + ".jsp")
        dispatcher.forward(req, resp)
    }
}
