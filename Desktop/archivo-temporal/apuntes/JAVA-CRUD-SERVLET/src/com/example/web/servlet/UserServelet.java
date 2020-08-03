package com.example.web.servlet;

import com.example.web.models.User;
import com.example.web.services.UserService;
import com.example.web.utils.UserTransformer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/usuarios")
public class UserServelet extends HttpServlet {

    UserService usuarioService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        usuarioService = new UserService();
        List<User> users = usuarioService.getAll();

        String jsonUsers = UserTransformer.objectToJson(users);

        resp.setContentType("application/json");
        resp.getWriter().write(jsonUsers);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("user");
        user = "{id: 1, username: \"admin\", password: \"1233\", email: \"admin@gmail.com\"}";
        System.out.println("que llega===========" + user);


        User jsonUsers = UserTransformer.jsonToObject(user);
        usuarioService = new UserService();
        boolean status = usuarioService.crearteUser(jsonUsers);
        resp.setContentType("application/json");
        resp.getWriter().write(String.valueOf(status));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

}
