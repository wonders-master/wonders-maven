package com.wonders.controller;

import com.wonders.commons.dto.EasyUIDatagrid;
import com.wonders.commons.dto.UserProviderResponse;
import com.wonders.entity.User;
import com.wonders.service.UserPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserPortalController {
    /**
     * 千万不要在Consumer的控制器中直接注入Provider提供的服务接口。
     * 因为，Provider提供的服务接口，在执行完毕后，得到的结果经常需要处理。
     * 客户端传递的参数，也未必是可以直接使用的参数。
     * 如果参数的处理逻辑和服务的返回结果处理逻辑都在控制器中编写的话，耦合度太高。
     * 代表控制器低内聚。
     */
    @Autowired
    private UserPortalService userService;
    @RequestMapping("/user/addUser")
    @ResponseBody
    public UserProviderResponse addUser(User user){
        return this.userService.addUser(user);
    }

    @RequestMapping("/user/modifyUser")
    @ResponseBody
    public UserProviderResponse modifyUser(User user){
        return this.userService.modifyUser(user);
    }

    @RequestMapping("/user/getUser4Modify")
    @ResponseBody
    public User getUser4Modify(Long id){
        UserProviderResponse result =  this.userService.getUserById(id);
        if(result.getStatus() != 200){
            return null;
        }
        return (User) result.getData();
    }

    @RequestMapping("/user/deleteUser")
    @ResponseBody
    public UserProviderResponse deleteUser(Long[] ids){
        return this.userService.deleteUser(ids);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("/user/listUsers")
    @ResponseBody
    public EasyUIDatagrid<User> listUsers(int page, int rows){
        UserProviderResponse result = this.userService.listUsers(page, rows);

        if(result.getStatus() != 200){
            return new EasyUIDatagrid<User>();
        }

        return (EasyUIDatagrid<User>)result.getData();
    }

    @RequestMapping("/")
    public String index(){
        return "/index";
    }

}
