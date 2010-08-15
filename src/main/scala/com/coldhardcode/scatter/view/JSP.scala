package com.coldhardcode.scatter.view

import com.coldhardcode.scatter.{Context,View}
import javax.servlet.RequestDispatcher

class JSP extends View {

    def process(context:Context) = {

        val jsp = "/" + context.stash.get("template").get + ".jsp"
        println(jsp)
        val dispatcher = context.context.getRequestDispatcher(jsp)
        dispatcher.forward(context.request, context.response)
    }
}