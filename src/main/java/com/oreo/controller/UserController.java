package com.oreo.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.oreo.dao.UserDao;
import com.oreo.dao.UserDaoMysqlmp;
import com.oreo.entity.User;

@WebServlet(urlPatterns = {"/users1", "/add.htm", "/delete.htm", "/edit.htm", "/update.htm"})
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userDao = new UserDaoMysqlmp();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = request.getServletPath();
        String contextPath = request.getContextPath();

        try {
            switch (path) {
                case "/users1":
                    listUsers(request, response);
                    break;

                case "/add.htm":
                    showAddForm(request, response);
                    break;

                case "/delete.htm":
                    deleteUser(request, response);
                    break;

                case "/edit.htm":
                    showEditForm(request, response);
                    break;

                default:
                    response.sendRedirect(contextPath + "/users1");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(contextPath + "/users1");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = request.getServletPath();
        String contextPath = request.getContextPath();

        try {
            switch (path) {
                case "/add.htm":
                    addUser(request, response);
                    break;

                case "/update.htm":
                    updateUser(request, response);
                    break;

                default:
                    response.sendRedirect(contextPath + "/users1");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(contextPath + "/users1");
        }
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = userDao.returnUsersByNameAsc();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/pages/users.jsp").forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/pages/add.jsp").forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int idToDelete = Integer.parseInt(request.getParameter("id"));
        userDao.deleteUser(idToDelete);
        response.sendRedirect(request.getContextPath() + "/users1");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idToEdit = Integer.parseInt(request.getParameter("id"));
        User userToEdit = userDao.findUserById(idToEdit);
        request.setAttribute("user", userToEdit);
        request.getRequestDispatcher("/pages/modifier_user.jsp").forward(request, response);

    }

    private void addUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("user_name");
        String password = request.getParameter("user_password");
        userDao.addUser(new User(name, password));
        response.sendRedirect(request.getContextPath() + "/users1");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String updatedName = request.getParameter("user_name");
        String updatedPassword = request.getParameter("user_password");
        userDao.updateUser(new User(id, updatedName, updatedPassword));
        response.sendRedirect(request.getContextPath() + "/users1");
    }
}