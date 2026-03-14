package p2;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JavaxServletWebApplication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IfEach1 extends HttpServlet {

     JavaxServletWebApplication jswa;
     WebApplicationTemplateResolver wtr;
     TemplateEngine te;

    @Override
    public void init() throws ServletException {
        jswa= JavaxServletWebApplication.buildApplication(getServletContext());
        wtr=new WebApplicationTemplateResolver(jswa);
        wtr.setPrefix("/templates/");
        wtr.setSuffix(".html");
        te= new TemplateEngine();
        te.setTemplateResolver(wtr);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IWebExchange iw = jswa.buildExchange(req,resp);
        WebContext wc = new WebContext(iw);
        wc.setVariable("name","Vishwa");
        wc.setVariable("age",10);
        List<String>list= new ArrayList<>();
        list.add("apple");
        list.add("orange");
        wc.setVariable("fru",list);

        te.process("home",wc,resp.getWriter());

    }


}
