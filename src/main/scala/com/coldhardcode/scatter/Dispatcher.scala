package com.coldhardcode.scatter

import scala.collection.mutable.HashMap

object Dispatcher {

    val actions = new HashMap[String, String]

    def addAction(path:String, clas:String) {

        actions.put(path, clas)
        println(actions.mkString)
    }

    def getAction(path:String, context:Context) : Unit = {

        println(actions.mkString)
        val result = actions.get(path)

        result match {
            case None => println("No match for " + path)
            case Some(x) => {
                val meth = Class.forName(x).getMethod(path, Class.forName("com.coldhardcode.scatter.Context"))
                meth.invoke(Class.forName(x).newInstance, context)
            }
        }
    }
}