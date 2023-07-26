package com.hp.service;

import com.hp.pojo.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Curtain-call
 */
public interface UserService {

    /**
     * 查询数据总行数
     * @return 返回一个int，实现查询数据总行数功能
     */
    int getUserPage();

    /**
     * 查询所有用户
     * @return 返回一个List，实现查询功能
     */
    @Select("select * from users")
    List<Users> getFindUser(String currentPage);

    /**
     * 根据ID查询用户
     * @return 返回一个 Users对象，实现根据ID查询功能
     */
    Users getFindUserById(int id);

    /**
     * 增加用户
     * @return 返回一个int，实现增加功能
     */
    int getAddUser(Users users);

    /**
     * 修改用户
     * @return 返回一个int，实现修改功能
     */
    int getUpdateUser(Users users);

    /**
     * 删除用户
     * @return 返回一个int，实现删除功能
     */
    int getDeleteUser(int id);

    /**
     * 重置密码
     * @return 返回一个int，实现修改功能
     */
    int getUpdateUserPwd(Users users);


    /**
     * ===================================================   前台   ====================================================
     * */

    /**
     * 用户页登录
     * @param username:用户输入的账号
     * @param password:用户输入的密码
     * @return 返回一个Users，实现用户登录功能
     */
    Users getUserLogin(String username,String password);
}
