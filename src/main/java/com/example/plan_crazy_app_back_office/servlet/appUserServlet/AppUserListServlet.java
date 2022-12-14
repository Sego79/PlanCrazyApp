package com.example.plan_crazy_app_back_office.servlet.appUserServlet;

import com.example.plan_crazy_app_back_office.dao.AppUserDao;
import com.example.plan_crazy_app_back_office.model.AppUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/app-users")
public class AppUserListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppUserDao appUserDao = new AppUserDao();
        List<AppUser> appUserList = appUserDao.findAll().stream().filter(t -> !t.getIsAdmin()).collect(Collectors.toList());

        req.setAttribute("appUserList", appUserList);
        req.getRequestDispatcher("/WEB-INF/app-user-list.jsp").forward(req, resp);
    }
}
