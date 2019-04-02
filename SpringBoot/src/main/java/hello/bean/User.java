package hello.bean;

import lombok.Data;

@Data
public class User {
    /**
     * lombok可以自动生成Getter Setter toString方法
     */

    private String name;
    private String age;
    private String sex;

}
