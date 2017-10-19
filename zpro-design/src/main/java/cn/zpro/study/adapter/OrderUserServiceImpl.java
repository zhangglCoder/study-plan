package cn.zpro.study.adapter;

public class OrderUserServiceImpl implements UserService {

    @Override
    public Object getUser(String id) {
        SuperUser superUser = new SuperUser();
        superUser.setId(id);
        superUser.setName("OrderUserServiceImpl");
        return superUser;
    }
}
