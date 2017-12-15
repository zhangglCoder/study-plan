package cn.zpro.interview.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 年度收款
 */
public class YearReceipt {

    /**
     * 年度
     */
    private int year;

    /**
     * 收款金额
     */
    private double rent;

    /**
     * 第几期
     */
    private int period;

    /**
     * 预计收款日期
     */
    private Date receiptOfDate;

    /**
     * 房款开始日
     */
    private Date houseMoneyStartDay;

    /**
     * 房款结束日
     */
    private Date houseMoneyEndDay;

    public YearReceipt(int year, double rent, int period, Date receiptOfDate, Date houseMoneyStartDay, Date houseMoneyEndDay) {
        this.year = year;
        this.rent = rent;
        this.period = period;
        this.receiptOfDate = receiptOfDate;
        this.houseMoneyStartDay = houseMoneyStartDay;
        this.houseMoneyEndDay = houseMoneyEndDay;
    }

    public YearReceipt() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Date getReceiptOfDate() {
        return receiptOfDate;
    }

    public void setReceiptOfDate(Date receiptOfDate) {
        this.receiptOfDate = receiptOfDate;
    }

    public Date getHouseMoneyStartDay() {
        return houseMoneyStartDay;
    }

    public void setHouseMoneyStartDay(Date houseMoneyStartDay) {
        this.houseMoneyStartDay = houseMoneyStartDay;
    }

    public Date getHouseMoneyEndDay() {
        return houseMoneyEndDay;
    }

    public void setHouseMoneyEndDay(Date houseMoneyEndDay) {
        this.houseMoneyEndDay = houseMoneyEndDay;
    }

    static SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public String toString() {
        return "YearReceipt{" +
                "year=" + year +
                ", rent=" + rent +
                ", period=" + period +
                ", receiptOfDate=" + sdf.format(receiptOfDate) +
                ", houseMoneyStartDay=" + sdf.format(houseMoneyStartDay) +
                ", houseMoneyEndDay=" + sdf.format(houseMoneyEndDay) +
                '}';
    }
}
