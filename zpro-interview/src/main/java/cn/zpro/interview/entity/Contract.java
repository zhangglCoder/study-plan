package cn.zpro.interview.entity;

import java.util.Date;

/**
 * 合同
 * @author zhanggl
 */
public class Contract {

    /**
     * 期限-开始
     */
    private Date termTimeStart;

    /**
     * 期限-结束
     */
    private Date termTimeEnd;

    /**
     * 月租金
     */
    private Double monthlyRent;

    /**
     * 付款方式
     * 季付是3，半年付是6
     */
    private Integer paymentMethod;

    public Contract(Date termTimeStart, Date termTimeEnd, Double monthlyRent, Integer paymentMethod) {
        this.termTimeStart = termTimeStart;
        this.termTimeEnd = termTimeEnd;
        this.monthlyRent = monthlyRent;
        this.paymentMethod = paymentMethod;
    }

    public Contract() {
    }

    public Date getTermTimeStart() {
        return termTimeStart;
    }

    public void setTermTimeStart(Date termTimeStart) {
        this.termTimeStart = termTimeStart;
    }

    public Date getTermTimeEnd() {
        return termTimeEnd;
    }

    public void setTermTimeEnd(Date termTimeEnd) {
        this.termTimeEnd = termTimeEnd;
    }

    public Double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(Double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }



}

