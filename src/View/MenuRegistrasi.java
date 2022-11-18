/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Controller.Controller.*;
import Model.User;
import Model.categoryuser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author TUF GAMING
 */
public class MenuRegistrasi {

    JFrame frame;
    JTextField email, nama;
    JPasswordField pass;
    JFileChooser foto;
    File pathfoto;
    JButton bfoto, registrasi, back;
    JComboBox namaKategori;

    public MenuRegistrasi() {
        frame = new JFrame();
        frame.setSize(800, 500);

        email = new JTextField("email");
        email.setBounds(350, 50, 100, 40);
        frame.add(email);

        nama = new JTextField("nama");
        nama.setBounds(350, 120, 100, 40);
        frame.add(nama);

        pass = new JPasswordField("Pass");
        pass.setBounds(100, 100, 100, 40);
        frame.add(pass);
        
        bfoto = new JButton("UPLOAD FOTO SINI SUU");
        bfoto.setBounds(350, 170, 200, 40);
        frame.add(bfoto);
        bfoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                foto = new JFileChooser("d:");
                int response = foto.showOpenDialog(null);
                if (response == JFileChooser.APPROVE_OPTION) {
                    pathfoto = new File(foto.getSelectedFile().getAbsolutePath());
                    System.out.println(pathfoto);
                }
            }
        });

        //inituh belom ya
        String[] kategori = new String[3];

        ArrayList<categoryuser> list = new ArrayList();
        list = getAllcUsers();
        for (int i = 0; i < list.size(); i++) {
            kategori[i] = list.get(i).getName();
        }
        namaKategori = new JComboBox(kategori);
        namaKategori.setBounds(350, 230, 150, 40);
        frame.add(namaKategori);
        

        //button
        back = new JButton("Back");
        back.setBounds(470, 290, 100, 40);
        frame.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new MainMenu();
            }
        });

        registrasi = new JButton("Registrasi");
        registrasi.setBounds(350, 290, 100, 40);
        frame.add(registrasi);
        registrasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("masok");
                insertNew(new User(nama.getText(), email.getText(),  pass.getText(),namaKategori.getSelectedIndex(), foto.getSelectedFile().getAbsolutePath()));
            }

        });

        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MenuRegistrasi();
    }
}
