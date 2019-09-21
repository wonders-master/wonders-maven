package com.wonders.provider.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wonders.commons.dto.EasyUIDatagrid;
import com.wonders.mapper.UserMapper;
import com.wonders.commons.dto.UserProviderResponse;
import com.wonders.entity.User;
import com.wonders.provider.UserProviderService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserProviderServiceImpl implements UserProviderService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 新增
     */
    @Override
    public UserProviderResponse saveUser(User user) {
        int rows = this.userMapper.insertUser(user);
        if(rows != 1){
            // 新增数据有问题。
            return UserProviderResponse.error("新增用户错误", null);
        }
        return UserProviderResponse.ok();
    }

    @Override
    public UserProviderResponse removeUserById(Long id) {
        int rows = this.userMapper.deleteUserById(id);
        if(rows != 1){
            return UserProviderResponse.error("根据主键删除用户错误", null);
        }
        return UserProviderResponse.ok();
    }

    @Override
    public UserProviderResponse removeUserByExample(User example) {
        int rows = this.userMapper.deleteUserByExample(example);
        if(rows != 1){
            return UserProviderResponse.error("根据条件删除用户错误", null);
        }
        return UserProviderResponse.ok();
    }

    @Override
    public UserProviderResponse removeUsersById(List<Long> ids) {
        int rows = this.userMapper.deleteUsersById(ids);
        if(rows != ids.size()){
            return UserProviderResponse.error("根据主键批量删除用户错误", null);
        }
        return UserProviderResponse.ok();
    }

    @Override
    public UserProviderResponse modifyUser(User user) {
        int rows = this.userMapper.updateUser(user);
        if(rows != 1){
            return UserProviderResponse.error("根据主键更新用户错误", null);
        }
        return UserProviderResponse.ok();
    }

    @Override
    public UserProviderResponse findUserByPage(int page, int rows) {
        PageHelper.startPage(page, rows);

        List<User> list = this.userMapper.selectUsers();
        PageInfo<User> info = new PageInfo<>(list);

        EasyUIDatagrid<User> datagrid = new EasyUIDatagrid<>();
        datagrid.setTotal(info.getTotal());
        datagrid.setRows(list);

        return UserProviderResponse.ok(datagrid);
    }

    @Override
    public UserProviderResponse findUserById(Long id) {
        User user = this.userMapper.selectUserById(id);

        return UserProviderResponse.ok(user);
    }
}
