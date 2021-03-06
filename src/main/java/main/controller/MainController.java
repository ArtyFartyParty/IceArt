package main.controller;

import main.model.Category;
import main.model.Event;
import main.model.User;
import main.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Ása Júlía Aðalsteinsdóttir
 * @author Melkorka Mjöll Jóhannesdóttir
 * @author Sigurlaug Þórðardóttir
 * @author Valgerður Sigfinnsdóttir
 * @date Október 2017
 * Háskóli Íslands
 *
 * Stýriklasi fyrir aðgang notenda að kerfinu
 */

@Controller
public class MainController {

    @Autowired
    IService service;

    /**
     * Þetta fall birtir upphafssíðuna með 10 viðburðum
     * @return
     */
    @RequestMapping(value = "")
    public String showPage(ModelMap model, HttpSession session, HttpServletResponse response){

        List<Event> events = service.getTop10Events();
        List<Category> categories = service.getAllCategories();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date now = cal.getTime();
        String todayDate = dateFormat.format(now);
        cal.add(Calendar.DATE, 7);
        Date week = cal.getTime();
        String inWeekDate = dateFormat.format(week);

        User currentUser = (User) session.getAttribute("user");

        model.addAttribute("events", events);
        model.addAttribute("categories", categories);
        model.addAttribute("todayDate", todayDate);
        model.addAttribute("inWeekDate", inWeekDate);
        model.addAttribute("currentUser", currentUser);

        return "view/MainPage";
    }

}
