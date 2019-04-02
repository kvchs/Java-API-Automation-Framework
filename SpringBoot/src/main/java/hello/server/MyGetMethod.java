package hello.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/", description = "all get method")
public class MyGetMethod {

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "method description 1", httpMethod = "GET")
    public String getCookies(HttpServletResponse response) {
//        HttpServletRequest
//        HttpServletResponse
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "获取Cookies成功";
    }


    /**
     * 携带Cookie才能访问
     */
    @ApiOperation(value = "method description 2", httpMethod = "GET")
    @RequestMapping(value = "/getWithCookies", method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "No Cookies";
        }

        for (Cookie cookie: cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "已经获取到Cookies";
            }
        }
        return "Cookie不为空，但是也没有鉴权";

    }


    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方式
     *url: key=value&key=value
     */
    @ApiOperation(value = "method description 3", httpMethod = "GET")
    @RequestMapping(value = "/getwithparameter", method = RequestMethod.GET)
    public Map<String, Integer> getList(@RequestParam Integer start, @RequestParam Integer end){
        Map<String, Integer> myList = new HashMap<>();
        myList.put("shot", 400);
        myList.put("foot", 540);
        myList.put("I-short", 451);
        return myList;

    }

    /**
     * 第二种携带参数的get请求
     *
     */
    @RequestMapping("/getwithparam/{start}/{end}")
    @ApiOperation(value = "method description 4", httpMethod = "GET")
    public Map<String, Integer> myGetList(@PathVariable Integer start, @PathVariable Integer end){
        Map<String, Integer> myList = new HashMap<>();
        myList.put("shot", 400);
        myList.put("foot", 540);
        myList.put("I-short", 451);
        return myList;
    }
}
