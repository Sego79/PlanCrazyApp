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

@WebServlet(urlPatterns = "/app-users/delete")
public class DeleteAppUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("appUserId");

        try {
            Long id = Long.parseLong(idStr);
            AppUserDao dao = new AppUserDao();
            Optional<AppUser> appUser = dao.findById(id);

            if (appUser.isPresent()) {
                dao.delete(appUser.get().getAppUserId());
                resp.sendRedirect(req.getContextPath() + "/app-users");
            } else {
                //TODO : game not found
            }

        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }
}
