package com.esprit.barterexchange.Interfaces;

import java.util.Date;

public interface ISignalUser {

    public int getId();

    public User getUser();
    public void setUser(User user);

    public Date getDateSignalGood();
    public void setDateSignalGood(Date DateSignalGood);

    public String getDescription();
    public void setDescription(String Description);

    public boolean getIsTreated();
    public void setIsTreated(boolean IsTreated);
}
