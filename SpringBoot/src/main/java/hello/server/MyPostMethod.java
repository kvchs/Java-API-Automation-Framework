package hello.server;

import hello.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", description = "all my post method")
@RequestMapping("/v1")
public class MyPostMethod {

//    保存Cookie信息
    private static Cookie cookie;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登陆接口，成功登陆后可以获取到Cookie信息", httpMethod = "POST")
    public String login(HttpServletResponse response, @RequestParam(value = "userName", required = true) String userName, @RequestParam(value = "password", required = true) String password){
        if (userName.equals("charleychen") && password.equals("123456")){
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "login success";
        }
        return "用户名和密码不匹配";
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public User getUserList(HttpServletRequest request, @RequestBody User user){
        Cookie[] cookies = request.getCookies();
        User user1 = new User();
        user1.setAge("1");
        user1.setName("cc");
        user1.setSex("man");
        for (Cookie cookie: cookies){
            System.out.println(cookie.getName() + " " + cookie.getValue());
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return user1;
            }
        }

        return new User();
    }
}
