package com.esprit.barterexchange.Interfaces;

import java.util.Date;

public interface IExchange {
    public int getId();

    public User getUser1();
    public void setUser1(User User1);

    public User getUser2();
    public void setUser2(User User2);

    public Goods getgoodUser1();
    public void setgoodUser1(Goods goodUser1);

    public Goods getgoodUser2();
    public void setgoodUser2(Goods goodUser2);

    public Date getDateExchange();
    public void setDate(Date DateExchange);


}
