package com.coldhardcode.myapp.controller

import com.coldhardcode.scatter.Context
import com.coldhardcode.scatter.annotation.Public

class Root {

    @Public
    def default(context:Context) : Unit = {

        context.request.setAttribute("hello", "Hello!")
        println("### default")
    }
}