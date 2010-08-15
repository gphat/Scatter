package com.coldhardcode.scatter

import scala.collection.mutable.HashMap

import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

class Context (var request:HttpServletRequest, var response:HttpServletResponse) {
    
    val stash = new HashMap[String,AnyRef]
}