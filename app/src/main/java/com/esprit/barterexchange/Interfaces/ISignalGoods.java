package com.esprit.barterexchange.Interfaces;

import java.util.Date;

public interface ISignalGoods {

    public int getId();

    public Goods getGood();
    public void setGood(Goods Good);

    public Date getDateSignalGood();
    public void setDateSignalGood(Date DateSignalGood);

    public String getDescription();
    public void setDescription(String Description);

    public boolean getIsTreated();
    public void setIsTreated(boolean IsTreated);
}
