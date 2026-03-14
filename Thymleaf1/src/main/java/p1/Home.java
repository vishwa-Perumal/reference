package p1;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;
import org.thymeleaf.web.servlet.JavaxServletWebApplication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Home extends HttpServlet {

    private TemplateEngine templateEngine;  // Thymeleaf's main engine
    JavaxServletWebApplication jswa;
    WebApplicationTemplateResolver wtr;


    @Override
    public void init() {

        jswa= JavaxServletWebApplication.buildApplication(getServletContext());
        wtr= new WebApplicationTemplateResolver(jswa);
        wtr.setPrefix("/templates/");
        wtr.setSuffix(".html");
        templateEngine=new TemplateEngine();
        templateEngine.setTemplateResolver(wtr);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       IWebExchange exchange =jswa.buildExchange(req,resp);
        WebContext wc = new WebContext(exchange);
       wc.setVariable("name","abc");

       templateEngine.process("home",wc,resp.getWriter());

    }
}
