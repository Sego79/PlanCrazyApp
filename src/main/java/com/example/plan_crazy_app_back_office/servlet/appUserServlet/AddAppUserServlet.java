package com.example.plan_crazy_app_back_office.servlet.appUserServlet;

import com.example.plan_crazy_app_back_office.dao.AppUserDao;
import com.example.plan_crazy_app_back_office.model.AppUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/app-users/add")
public class AddAppUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/add-app-user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String address = req.getParameter("address");
        Integer postcode = Integer.parseInt(req.getParameter("postcode"));
        String city = req.getParameter("city");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Boolean isAdmin = Boolean.parseBoolean(req.getParameter("isAdmin"));

        AppUser appUser = new AppUser(nickname, firstName, lastName, address, postcode, city, phoneNumber, email, password, isAdmin);

        AppUserDao customerDao = new AppUserDao();

        customerDao.create(appUser);

        resp.sendRedirect(req.getContextPath() + "/app-users");
    }
}
