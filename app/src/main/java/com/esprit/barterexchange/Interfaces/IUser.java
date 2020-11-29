package com.esprit.barterexchange.Interfaces;

public interface IUser {
    public int getId();

    public String getFirstName();
    public void setFirstName(String firstName);

    public String getLastName();
    public void setLastName(String lastName);

    public String getEmail();
    public void setEmail(String email);

    public String getPassword();
    public void setPassword(String password);

    public String getUsername();
    public void setUsername(String username);
}
