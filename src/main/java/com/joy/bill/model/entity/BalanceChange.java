package com.joy.bill.model.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by joy on 2018/3/27.
 */
@Entity
public class BalanceChange implements Serializable {


    @Id
    @GeneratedValue
    int id;
    double changeAfter;
    double changeBefore;
    String account;
    String message;


    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {

        return account;
    }

    @Temporal(TemporalType.TIMESTAMP)
    Date date;
    int changeType;

    public BalanceChange() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getChangeAfter() {
        return changeAfter;
    }

    public void setChangeAfter(double changeAfter) {
        this.changeAfter = changeAfter;
    }

    public double getChangeBefore() {
        return changeBefore;
    }

    public void setChangeBefore(double changeBefore) {
        this.changeBefore = changeBefore;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getChangeType() {
        return changeType;
    }

    public void setChangeType(int changeType) {
        this.changeType = changeType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
