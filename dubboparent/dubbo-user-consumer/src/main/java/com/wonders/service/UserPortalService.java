package com.wonders.service;

import com.wonders.commons.dto.UserProviderResponse;
import com.wonders.entity.User;
import com.wonders.provider.UserProviderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPortalService {
    @Reference
    UserProviderService userProviderService;

    public UserProviderResponse addUser(User user) {
        UserProviderResponse response = this.userProviderService.saveUser(user);
        return response;
    }

    public UserProviderResponse modifyUser(User user) {
        UserProviderResponse response = this.userProviderService.modifyUser(user);
        return response;
    }

    public UserProviderResponse getUserById(Long id) {
        UserProviderResponse response = this.userProviderService.findUserById(id);
        return response;
    }

    public UserProviderResponse deleteUser(Long[] ids) {
        List<Long> idList = new ArrayList<>();
        for(Long id : ids){
            idList.add(id);
        }
        UserProviderResponse response = this.userProviderService.removeUsersById(idList);
        return response;
    }

    public UserProviderResponse listUsers(int page, int rows) {

        UserProviderResponse response = this.userProviderService.findUserByPage(page, rows);

        return response;
    }

}
