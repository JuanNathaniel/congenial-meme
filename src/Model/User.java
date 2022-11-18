/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author TUF GAMING
 */
public class User {
    int id;
    String name;
    String email;
    String password;
    int idCategory;
    String photo;

    public User() {
    }

    public User(String name, String email, String password, int idCategory, String photo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.idCategory = idCategory;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    @Override
    public String toString(){
        System.out.println("ID : " + this.id);
        System.out.println("Nama : "+this.name);
        System.out.println("Email : "+ this.email);
        System.out.println("Pass : "+this.password);
        System.out.println("kategori : "+this.idCategory);
        System.out.println("Photo : "+this.photo);
        return "";
    }
}
