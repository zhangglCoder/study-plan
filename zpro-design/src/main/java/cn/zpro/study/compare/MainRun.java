package cn.zpro.study.compare;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainRun {

    public static void main(String[] args) throws ParseException {

        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setCreateTime(new Date());
            user.setName("zhanggl" + i);
            user.setAge(i);
            userList.add(user);
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dt1 = df.parse("2017-08-14 18:00:00");
        userList.get(3).setCreateTime(dt1);
        userList.get(3).setAge(100);

        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
               if(o1.getCreateTime().getTime()> o2.getCreateTime().getTime()){
                   return -1;
               }else {
                   return 1;
               }
            }
        });

        System.out.println(userList);
    }


}
