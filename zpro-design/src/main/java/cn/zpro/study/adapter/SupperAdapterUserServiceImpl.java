package cn.zpro.study.adapter;

public class SupperAdapterUserServiceImpl implements UserService {

    private SupperAdapter supperAdapter;

    public SupperAdapterUserServiceImpl() {
    }

    public SupperAdapterUserServiceImpl(SupperAdapter supperAdapter) {
        this.supperAdapter = supperAdapter;
    }

    @Override
    public Object getUser(String name) {
        return supperAdapter.SpecificOperation(name);
    }

}
