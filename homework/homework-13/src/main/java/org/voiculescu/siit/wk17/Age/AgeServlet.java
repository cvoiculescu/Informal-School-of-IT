package org.voiculescu.siit.wk17.Age;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * this Servlet Class will handle the GET requests
 */
public class AgeServlet extends HttpServlet {

    /**
     * this birthDate is used if no birthDate is provided in request
     */
    private String birthDate;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        /**
         * reading the birthDate from web.xml
         */
        birthDate = servletConfig.getInitParameter("birthDate");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //reading the birthDate from request
        String requestBirthDate = request.getParameter("birthDate");
        //setting the birthDate from request if this is provided or from init configuration
        LocalDate date = LocalDate.parse((requestBirthDate == null) ? birthDate : requestBirthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate now = LocalDate.now();
        long numberOfYears = ChronoUnit.YEARS.between(date, now);
        long numberOfDays = ChronoUnit.DAYS.between(date, now);
        //setting the attributes for years and days
        request.setAttribute("years", numberOfYears);
        request.setAttribute("days", numberOfDays);
        //forward the request to a jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("show-age.jsp");
        dispatcher.forward(request, response);
    }
}
