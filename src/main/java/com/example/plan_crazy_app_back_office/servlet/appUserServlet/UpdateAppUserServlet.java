package com.example.plan_crazy_app_back_office.servlet.appUserServlet;

import com.example.plan_crazy_app_back_office.dao.AppUserDao;
import com.example.plan_crazy_app_back_office.model.AppUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/app-users/update")
public class UpdateAppUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String appUserId = req.getParameter("appUserId");

        try {
            Long id = Long.parseLong(appUserId);
            AppUserDao dao = new AppUserDao();
            Optional<AppUser> appUser = dao.findById(id);

            if (appUser.isPresent()) {
                req.setAttribute("appUser", appUser.get());
            } else {
                //TODO : game not found
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        req.getRequestDispatcher("/WEB-INF/update-app-user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("appUserId"));
        String nickname = req.getParameter("nickname");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String address = req.getParameter("address");
        Integer postcode = Integer.parseInt(req.getParameter("postcode"));
        String city = req.getParameter("city");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Boolean isAdmin = Boolean.valueOf(req.getParameter("isAdmin"));


        AppUser appUser = new AppUser(id, nickname, firstName, lastName, address, postcode, city, phoneNumber, email, password, isAdmin);

        System.out.println(appUser);

        AppUserDao appUserDao = new AppUserDao();
        appUserDao.update(appUser);

        resp.sendRedirect(req.getContextPath() + "/app-users");
    }
}
