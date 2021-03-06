package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Ása Júlía Aðalsteinsdóttir
 * @author Melkorka Mjöll Jóhannesdóttir
 * @author Sigurlaug Þórðardóttir
 * @author Valgerður Sigfinnsdóttir
 * @date Oktober 2017
 * Háskóli Íslands
 *
 * Stýriklasi fyrir villumeðhöndlun
 */

@Controller
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController{

    private static final String PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    /**
     * Meðhöndlar villu sem verður á þjóninum
     * @param request  beiðnin með villuskilaboðum
     * @return
     */
    @RequestMapping(value = PATH)
    public ModelAndView villa(HttpServletRequest request) {

        // sendir attribute til viðmótsins og birtir síðuna með villuskilaboðum
        return new ModelAndView("view/Error", "attrs", getErrorAttributes(request, false));
    }

    /**
     * Skilar slóðinni fyrir villu
     */
    @Override
    public String getErrorPath() {
        return PATH;
    }


    /**
     * Nær í villu-attribute sem komu út úr Http beiðni
     * @param request  Http beiðnin
     * @param includeStackTrace ef true þá er skilað stack trace annars ekki
     * @return mengi af tvíundum með nafni af attributi og gildi þeirra
     */
    private Map<String, Object> getErrorAttributes(HttpServletRequest request,
                                                   boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes,
                includeStackTrace);
    }
}
