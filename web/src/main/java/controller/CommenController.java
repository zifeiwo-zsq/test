package controller;


import common.Intterface.RemoteInterface;
import entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;


@Controller
public class CommenController {

    @Autowired
    private UserService userService;

    @GetMapping("test")
    @ResponseBody
    public Admin test() {
        Admin user = userService.findUserById(1L);
        System.out.println(user);
        return user;
    }
    @GetMapping("testRest/{param}")
    @ResponseBody
    public String testRest(@PathVariable String param) {
        System.out.println(param);
        return param;
    }

    @GetMapping(value = "getCaiHongPi",produces = {"text/html;charset=UTF-8;", "application/json;"})
    @ResponseBody
    public String getCaiHongPi(){
        String caiHongPi = RemoteInterface.urlContent("https://apis.tianapi.com/caihongpi/index");
        return caiHongPi;
    }

    @GetMapping(value = "httpClientContent",produces = {"text/html;charset=UTF-8;", "application/json;"})
    @ResponseBody
    public String httpClientContent(){
        String caiHongPi = RemoteInterface.httpClientContent("https://apis.tianapi.com/caihongpi/index");
        return caiHongPi;
    }

}
