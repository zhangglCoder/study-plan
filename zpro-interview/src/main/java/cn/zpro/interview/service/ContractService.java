package cn.zpro.interview.service;

import cn.zpro.interview.entity.Contract;
import cn.zpro.interview.entity.YearReceipt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 租赁合同服务
 * @author leon
 */
public class ContractService {


    /**
     * 统计
     */
    public List<YearReceipt> statistics(Contract contract) {
        List<YearReceipt> yearReceiptList = new ArrayList<>();
        Integer paymentMethod = contract.getPaymentMethod();
        Double monthlyRent = contract.getMonthlyRent();
        Date termTimeStart = contract.getTermTimeStart();
        Date termTimeEnd = contract.getTermTimeEnd();
        //1 计算时间区间能够计算多少个期
        int term = getTerm(termTimeStart, termTimeEnd, paymentMethod);
        Date idate = null;
        for (int i = 1; i <= term; i++) {
            if(i == 1){
                idate = termTimeStart;
            }
            YearReceipt receipt = new YearReceipt();
            receipt.setPeriod(i);
            Calendar instance = Calendar.getInstance();
            instance.setTime(idate);
            instance.add(Calendar.MONTH , paymentMethod);
            instance.add(Calendar.DATE,-1);
            if(termTimeEnd.compareTo(instance.getTime())>0){
                receipt.setHouseMoneyEndDay(instance.getTime());
            }else {
                receipt.setHouseMoneyEndDay(termTimeEnd);
            }

            instance.add(Calendar.DATE,1);
            receipt.setHouseMoneyStartDay(idate);
            setRentInfo(receipt.getHouseMoneyStartDay(),receipt.getHouseMoneyEndDay(),receipt,monthlyRent);
            receipt.setReceiptOfDate(idate);
            Calendar instance_year = Calendar.getInstance();
            instance_year.setTime(receipt.getReceiptOfDate());
            receipt.setYear(instance_year.get(Calendar.YEAR));
            yearReceiptList.add(receipt);
            idate = instance.getTime();
        }
        return yearReceiptList;

    }
    private void setRentInfo(Date start,Date end,YearReceipt receipt,double monthlyRent){
        double money;
        //2018-02-28
        //2018-03-01
        int mouth = getMouth(start, end);
        int date = differentDays(start,end) + 1;

        //如果足月
        if(date > 28 ){
            money = mouth * monthlyRent;
        }else {
            //日租金
            double dayRent = monthlyRent / 30;
            money = dayRent * date;
        }
        //如果不足月
        receipt.setRent(money);
    }

    /**
     * 打印
     */
    public void printScal(List<YearReceipt> earReceipt){
        int zj_2014 = 0;
        int zj_2015 = 0;
        int zj_2016 = 0;
        int zj_2017 = 0;
        int zj_2018 = 0;
        int zj = 0;
        for (YearReceipt receipt:earReceipt) {
            if(receipt.getYear() == 2014){
                zj_2014 += receipt.getRent();
            }
            if(receipt.getYear() == 2015){
                zj_2015 += receipt.getRent();
            }
            if(receipt.getYear() == 2016){
                zj_2016 += receipt.getRent();
            }
            if(receipt.getYear() == 2017){
                zj_2017 += receipt.getRent();
            }
            if(receipt.getYear() == 2018){
                zj_2018 += receipt.getRent();
            }
            zj += receipt.getRent();
        }

        System.out.println("2014年度收款"+zj_2014);
        System.out.println("2015年度收款"+zj_2015);
        System.out.println("2016年度收款"+zj_2016);
        System.out.println("2017年度收款"+zj_2017);
        System.out.println("2018年度收款"+zj_2018);
        System.out.println("总计:"+zj);

    }


    /**
     * 根据开始日期和结束日期计算有多少期租金
     *
     * @param termTimeStart
     * @param termTimeEnd
     * @return
     */
    private int getTerm(Date termTimeStart, Date termTimeEnd, int paymentMethod) {
        int mouth = getMouth(termTimeStart, termTimeEnd);
        //1 计算时间区间能够计算多少个期
        int q = 0;
        if(mouth % paymentMethod >0){
            q = mouth / paymentMethod;
            q++;
        }else {
            q = mouth / paymentMethod;
        }
        //TODO
        return q;
    }

    private int getMouth(Date termTimeStart, Date termTimeEnd) {
        Calendar instanceTermTimeStart = Calendar.getInstance();
        Calendar instanceTermTimeEnd = Calendar.getInstance();
        instanceTermTimeStart.setTime(termTimeStart);
        instanceTermTimeEnd.setTime(termTimeEnd);
        int y = instanceTermTimeEnd.get(Calendar.YEAR) - instanceTermTimeStart.get(Calendar.YEAR);
        int m = instanceTermTimeEnd.get(Calendar.MONTH) - instanceTermTimeStart.get(Calendar.MONTH);

        if (y > 0) {
            m += y * 12;
        }
        return m;
    }

    private int getDate(Date termTimeStart, Date termTimeEnd){
        Calendar instanceTermTimeStart = Calendar.getInstance();
        Calendar instanceTermTimeEnd = Calendar.getInstance();
        instanceTermTimeStart.setTime(termTimeStart);
        instanceTermTimeEnd.setTime(termTimeEnd);
        int y = instanceTermTimeEnd.get(Calendar.YEAR) - instanceTermTimeStart.get(Calendar.YEAR);
        int m = instanceTermTimeEnd.get(Calendar.MONTH) - instanceTermTimeStart.get(Calendar.MONTH);
        int r = instanceTermTimeEnd.get(Calendar.DATE) - instanceTermTimeStart.get(Calendar.DATE);
        if (y > 0) {
            m += y * 12;
        }
        if(m>0 ){
            r += m * 30;
        }
        return r;
    }

    /**
     * date2比date1多的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            //System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }
}
