package com.coldhardcode.scatter

import com.impetus.annovention.{Discoverer,ClasspathDiscoverer}
import com.impetus.annovention.listener.{MethodAnnotationDiscoveryListener}

import javax.servlet.{ServletContextListener, ServletContextEvent}

import scala.collection.mutable.HashMap

class ServletListener extends ServletContextListener with MethodAnnotationDiscoveryListener {

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
        println("Storing " + method + " -> " + clas)
        Dispatcher.addAction(method, clas)
    }

    override def supportedAnnotations() : Array[java.lang.String] = {

        println("Registering interesting Annotations")
        return Array("com.coldhardcode.scatter.annotation.Public")
    }
}