package com.oreo.entity;

import java.util.List;
import com.oreo.dao.UserDaoMysqlmp;

public class Users {
    private UserDaoMysqlmp agentDaoUser = new UserDaoMysqlmp(); // Correction: () -> = new...

    public boolean deleteUser(User u) {
        User userToDelete = agentDaoUser.findUserById(u.getUser_id());
        if (userToDelete == null) {
            System.out.println("Utilisateur non trouvé avec ID: " + u.getUser_id());
            return false;
        } else {
            agentDaoUser.deleteUser(u.getUser_id());
            System.out.println("Utilisateur supprimé avec succès");
            return true;
        }
    }
    
    // ... autres méthodes
}