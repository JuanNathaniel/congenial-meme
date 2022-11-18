/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import Model.categoryuser;
import View.MenuLihatData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TUF GAMING
 */
public class Controller {

    static DatabaseHandler conn = new DatabaseHandler();

    public static boolean insertNew(User user) {
        conn.connect();
        String query = "INSERT INTO users(name, email, password, idcategory, photo) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getIdCategory());
            stmt.setString(5, user.getPhoto());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil insert kak");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    //get all categoryname
    public static ArrayList<categoryuser> getAllcUsers() {
        ArrayList<categoryuser> cusers = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM categoryuser";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                categoryuser user = new categoryuser();
                user.setId(rs.getInt("idcategory"));
                user.setName(rs.getString("name"));
                //
                cusers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (cusers);
    }

    public static User getUser(String email) {
        conn.connect();
        String query = "SELECT * FROM users WHERE email='" + email + "';";
        User user = new User();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdCategory(rs.getInt(rs.getInt("idcategory")));
                user.setPhoto(rs.getString("photo"));
                //
                JOptionPane.showMessageDialog(null, "Data ditemukan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);
    }

}
