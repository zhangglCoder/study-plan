package cn.zpro.interview.test;

import cn.zpro.interview.entity.Contract;
import cn.zpro.interview.entity.YearReceipt;
import cn.zpro.interview.service.ContractService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 条件：
 * 合同期限（yyyyMMdd格式，int型）
 * 合同月租金（double）
 * 合同收款方式（int，租金月数，譬如季付是3，半年付是6）


 1、统计2014--2018各年度的收款金额。（假设租赁期限的首天支付房租）
 2、年底最后一期收款的截止日期和顺延天数。
 */
public class RunTest {

    public static void main(String[] args) throws ParseException {
        test1();
    }

    /**
     * 统计2014--2018各年度的收款金额。（假设租赁期限的首天支付房租）
     */
    static void test1() throws ParseException {
        ContractService contractService = new ContractService();
        Contract contract = new Contract();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse("2016-02-29");
        Date end = sdf.parse("2018-03-01");
        contract.setMonthlyRent(3000D);
        contract.setTermTimeStart(start);
        contract.setTermTimeEnd(end);
        contract.setPaymentMethod(3);
        List<YearReceipt> statistics = contractService.statistics(contract);
        for (YearReceipt receipt:statistics) {
            System.out.println(receipt);
        }
        contractService.printScal(statistics);

    }

    /**
     * 2、年底最后一期收款的截止日期和顺延天数。
     */
    static void test2(){

    }
}
