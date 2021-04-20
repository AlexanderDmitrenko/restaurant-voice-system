package com.dmitrenko.restaurant.web;

import com.dmitrenko.restaurant.util.DishUtils;
import com.dmitrenko.restaurant.web.dish.DishRestController;
import org.slf4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class DishServlet extends HttpServlet {
    private static final Logger log = getLogger(DishServlet.class);

    private ClassPathXmlApplicationContext springContext;
    private DishRestController dishController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        dishController = springContext.getBean(DishRestController.class);
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("forward to dishes");
        request.setAttribute("dishes", dishController.getAll());
        request.getRequestDispatcher("/dishes.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
