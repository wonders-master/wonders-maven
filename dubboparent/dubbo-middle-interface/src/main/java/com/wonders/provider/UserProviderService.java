package com.wonders.provider;

import com.wonders.commons.dto.UserProviderResponse;
import com.wonders.entity.User;

import java.util.List;

public interface UserProviderService {
    UserProviderResponse saveUser(User user);
    UserProviderResponse removeUserById(Long id);
    UserProviderResponse removeUserByExample(User example);
    UserProviderResponse removeUsersById(List<Long> ids);
    UserProviderResponse modifyUser(User user);
    // 分页查询，分页操作使用pagehelper实现
    UserProviderResponse findUserByPage(int page, int rows);
    UserProviderResponse findUserById(Long id);
}
