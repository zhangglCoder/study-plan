package cn.zpro.study.build;

/**
 * 使用Build模式构建User工厂
 * @author dell
 */
public class UserFactory {

    private String id;
    private String name;
    private Integer age;

    public static class UserBuild{
        private String id;
        private String name;
        private Integer age;

        public UserBuild(String id, String name) {
            this.id = id;
            this.name = name;
        }

        /**
         * 根据用户年龄构建UserBuild对象
         * @param age
         */
        public UserBuild setAge(Integer age) {
            this.age = age;
            return this;
        }

        public UserFactory bulid(){
            return new UserFactory(this);
        }
    }


    public UserFactory(UserBuild userBuild) {
        this.id = userBuild.id;
        this.name = userBuild.name;
        this.age = userBuild.age;
    }

    @Override
    public String toString() {
        return "UserFactory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
