package com.hp.dao;

import com.hp.pojo.Types;
import com.hp.pojo.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Curtain-call
 */
@Mapper
public interface UserMapper {

    /**
     * 查询数据总行数
     * @return 返回一个int，实现查询数据总行数功能
     */
    @Select("select count(*) from users")
    int getUserPage();

    /**
     * 查询所有用户
     * @return 返回一个List，实现查询功能
     */
    @Select("select * from users limit #{currentPage1},5")
    List<Users> getFindUser(int currentPage1);

    /**
     * 根据ID查询用户
     * @return 返回一个 Users对象，实现根据ID查询功能
     */
    @Select("select * from users where id=#{id}")
    Users getFindUserById(int id);

    /**
     * 增加用户
     * @return 返回一个int，实现增加功能
     */
    @Insert("INSERT INTO users VALUES (default, #{username}, #{password}, #{name}, #{phone}, #{address})")
    int getAddUser(Users users);

    /**
     * 修改用户
     * @return 返回一个int，实现修改功能
     */
    @Update("update users set name=#{name},phone=#{phone},address=#{address} where id=#{id}")
    int getUpdateUser(Users users);

    /**
     * 删除用户
     * @return 返回一个int，实现删除功能
     */
    @Delete("delete from users where id=#{id}")
    int getDeleteUser(@Param("id") int id);

    /**
     * 重置密码
     * @return 返回一个int，实现修改功能
     */
    @Update("update users set password=#{password} where id=#{id}")
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
    @Select("select * from users where username=#{username} and password=#{password}")
    Users getUserLogin(String username,String password);
}
