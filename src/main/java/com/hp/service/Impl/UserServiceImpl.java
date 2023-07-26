package com.hp.service.Impl;

import com.hp.dao.UserMapper;
import com.hp.pojo.Users;
import com.hp.service.UserService;
import com.hp.util.SafeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Curtain-call
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询数据总行数
     *
     * @return 返回一个int，实现查询数据总行数功能
     */
    @Override
    public int getUserPage() {
        return userMapper.getUserPage();
    }

    /**
     * 查询所有用户
     *
     * @return 返回一个List，实现查询功能
     */
    @Override
    public List<Users> getFindUser(String currentPage) {
        int currentPage1 = (Integer.parseInt(currentPage)-1)*5;
        return userMapper.getFindUser(currentPage1);
    }

    /**
     * 根据ID查询用户
     *
     * @param id
     * @return 返回一个 Users对象，实现根据ID查询功能
     */
    @Override
    public Users getFindUserById(int id) {
        return userMapper.getFindUserById(id);
    }

    /**
     * 增加用户
     *
     * @param users
     * @return 返回一个int，实现增加功能
     */
    @Override
    public int getAddUser(Users users) {
        users.setPassword(SafeUtil.md5(users.getPassword()));
        return userMapper.getAddUser(users);
    }

    /**
     * 修改用户
     *
     * @param users
     * @return 返回一个int，实现修改功能
     */
    @Override
    public int getUpdateUser(Users users) {
        return userMapper.getUpdateUser(users);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return 返回一个int，实现删除功能
     */
    @Override
    public int getDeleteUser(int id) {
        return userMapper.getDeleteUser(id);
    }

    /**
     * 重置密码
     *
     * @param users
     * @return 返回一个int，实现修改功能
     */
    @Override
    public int getUpdateUserPwd(Users users) {
        users.setPassword(SafeUtil.md5(users.getPassword()));
        return userMapper.getUpdateUserPwd(users);
    }


    /**
     * ===================================================   前台   ====================================================
     * */

    /**
     * 用户页登录
     *
     * @param username :用户输入的账号
     * @param password :用户输入的密码
     * @return 返回一个Users，实现用户登录功能
     */
    @Override
    public Users getUserLogin(String username, String password) {
        password=SafeUtil.md5(password);
        return userMapper.getUserLogin(username, password);
    }


}
