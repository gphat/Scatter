package com.coldhardcode.scatter

import scala.collection.mutable.HashMap

object Dispatcher {

    val actions = new HashMap[String, String]

    def addAction(path:String, clas:String) {

        actions.put(path, clas)
        println(actions.mkString)
    }

    def getAction(path:String) : String = {

        println(actions.mkString)
        println("Tryna find it!")
        val result = actions.get(path)

        result match {
            case None => println("No match for " + path)
            case Some(x) => Class.forName(x).getMethod(path).invoke(Class.forName(x).newInstance)
        }
        
        return "asdasd"
    }
}