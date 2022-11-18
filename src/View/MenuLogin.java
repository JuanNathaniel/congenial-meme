/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static Controller.Controller.*;
import Model.User;
/**
 *
 * @author TUF GAMING
 */
public class MenuLogin {
    JTextField email, pass;
    JLabel lemail, lpass, image;
    JButton login, back;
    
    JFrame frame;
    public MenuLogin(){
        frame = new JFrame();
        frame.setSize(800, 500);
        
        image = new JLabel(new ImageIcon("d://people.png"));
        image.setBounds(50, 50, 200, 200);
        frame.add(image);
        
        lemail = new JLabel("email : ");
        lemail.setBounds(270, 50, 100, 40);
        frame.add(lemail);
        
        email = new JTextField();
        email.setBounds(370, 50, 100, 40);
        frame.add(email);
        
        lpass = new JLabel("lpass");
        lpass.setBounds(270, 90, 100, 40);
        frame.add(lpass);
        
        pass = new JTextField();
        pass.setBounds(370, 90, 100, 40);
        frame.add(pass);
        
        
        //button
        login = new JButton("Login");
        login.setBounds(350, 140, 100, 40);
        frame.add(login);
        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                User user = getUser(email.getText());
                user.toString();
                if (user.getName() != null) {
                    frame.dispose();
                    new MenuLihatData();
                }
            }           
        });
        
        back = new JButton("Back");
        back.setBounds(470, 140, 100, 40);
        frame.add(back);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new MainMenu();
            }
            
        });
        
        
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
