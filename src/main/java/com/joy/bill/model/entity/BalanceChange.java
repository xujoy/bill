package com.joy.bill.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by joy on 2018/3/27.
 */
@Entity
public class BalanceChange {


    @Id
    @GeneratedValue
    int id;
    double changeAfter;
    double changeBefore;
    String account;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
}
