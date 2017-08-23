package cn.zpro.study.design;


/**
 * The type Biz service.
 *
 * @author :<a href="mailto:guolongzhang@ebnew.com">张国龙</a>
 * @date :2017-08-18 08:37:35
 */
public class BizService {

    public String getMethonStr(IHandler handler){
        handler.doTask();
        return "good";
    }
}
