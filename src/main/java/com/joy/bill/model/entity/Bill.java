package com.joy.bill.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by joy on 2018/3/27.
 */
@Entity
@JsonIgnoreProperties(value = {"bill"})
public class Bill implements Serializable{


    @Id
    @GeneratedValue
    private int id;

    /**
     * 买入
     */
    private double buy;
    /**
     * 卖出
     */
    private double sale;
    /**
     *利润
     */
    private double profit;
    /**
     *运费
     */
    private double freight;
    /**
     * 退款
     */
    private double refund;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();


    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Bill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public double getRefund() {
        return refund;
    }

    public void setRefund(double refund) {
        this.refund = refund;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
