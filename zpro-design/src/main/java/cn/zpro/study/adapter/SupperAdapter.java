package cn.zpro.study.adapter;

/**
 适配器类
 */
public class SupperAdapter {

    /**
     * 使用特殊方法查询SuperUser
     * @param name
     * @return
     */
    public SuperUser SpecificOperation(String name){
        SuperUser superUser = new SuperUser();
        superUser.setId("2");
        superUser.setName(name+":SupperAdapter");
        return superUser;
    }


}
