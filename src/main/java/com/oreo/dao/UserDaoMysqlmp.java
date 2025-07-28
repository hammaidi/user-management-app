package com.oreo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.oreo.entity.User;

public class UserDaoMysqlmp implements UserDao {
    private Connection con = new ConnectorMysql().getCon();

    @Override
    public void displayUsers() {
        List<User> users = returnUsersByNameAsc();
        users.forEach(System.out::println);
    }

    @Override
    public List<User> returnUsersByNameAsc() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user ORDER BY user_name ASC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(
                    rs.getInt("user_id"),
                    rs.getString("user_name"),
                    rs.getString("user_password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void addUser(User u) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO user(user_name, user_password) VALUES(?, ?)");
            ps.setString(1, u.getUser_name());
            ps.setString(2, u.getUser_password());
            int rowsAffected = ps.executeUpdate();
            con.commit();
            System.out.println(rowsAffected + " ligne(s) affectée(s) - Utilisateur ajouté: " + u.getUser_name());
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM user WHERE user_id = ?");
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            con.commit();
            System.out.println(rowsAffected + " ligne(s) affectée(s) - Utilisateur supprimé ID: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public User findUserById(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE user_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("user_id"),
                    rs.getString("user_name"),
                    rs.getString("user_password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> returnUsersByNameDesc() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user ORDER BY user_name DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(
                    rs.getInt("user_id"),
                    rs.getString("user_name"),
                    rs.getString("user_password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUser(User u) {
        try (PreparedStatement ps = con.prepareStatement(
                "UPDATE user SET user_name = ?, user_password = ? WHERE user_id = ?")) {
            
            ps.setString(1, u.getUser_name());
            ps.setString(2, u.getUser_password());
            ps.setInt(3, u.getUser_id());
            int rowsAffected = ps.executeUpdate();
            con.commit();
            System.out.println(rowsAffected + " ligne(s) modifiée(s) - ID: " + u.getUser_id());
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public boolean findUser(User u) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM user WHERE user_name = ? AND user_password = ?");
            ps.setString(1, u.getUser_name());
            ps.setString(2, u.getUser_password());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}