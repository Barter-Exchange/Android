package com.esprit.barterexchange.Classes;

import com.esprit.barterexchange.Interfaces.IGoods;

public class Goods {

    private int id, user;
    private String 	Name, Image, Description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Goods(int id, int user, String name, String image, String description) {
        this.id = id;
        this.user = user;
        Name = name;
        Image = image;
        Description = description;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", user=" + user +
                ", Name='" + Name + '\'' +
                ", Image='" + Image + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
