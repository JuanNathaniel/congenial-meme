/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author TUF GAMING
 */
public class MainMenu implements ActionListener{
     JButton login, registrasi, lihatdata;
    JLabel llogin, lregistrasi, ldata;
    JFrame frame;
    public MainMenu(){
        frame = new JFrame();
        frame.setSize(800, 500);
        
        login = new JButton("login");
        login.setBounds(350, 50, 100, 40);
        frame.add(login);
        login.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new MenuLogin();
            }
            
        });
        
        registrasi = new JButton("registrasi");
        registrasi.setBounds(350, 150, 100, 40);
        frame.add(registrasi);
        registrasi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new MenuRegistrasi();
            }
            
        });
        
        lihatdata = new JButton("lihatdata");
        lihatdata.setBounds(350, 250, 100, 40);
        frame.add(lihatdata);
        
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
        
    }
    public static void main(String[] args) {
        new MainMenu();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            
        }
        if (ae.getSource() == registrasi) {
            new MenuRegistrasi();
        }
    }
    
    
   
}
