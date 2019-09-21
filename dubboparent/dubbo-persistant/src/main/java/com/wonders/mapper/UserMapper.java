package com.wonders.mapper;

import com.wonders.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserMapper {
    // 新增
    int insertUser(User user);
    // 主键更新
    int updateUser(User user);
    // 查询多用户数据
    List<User> selectUsers();
    // 主键查询
    User selectUserById(@Param("id") Long id);
    // 主键删除
    int deleteUserById(@Param("id") Long id);
    // 条件删除
    int deleteUserByExample(@Param("example") User example);
    // 主键批量删除
    int deleteUsersById(@Param("ids") List<Long> ids);
}
