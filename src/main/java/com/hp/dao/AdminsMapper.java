package com.hp.dao;

import com.hp.pojo.Admins;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Curtain-call
 */
@Mapper
public interface AdminsMapper {

    /**
     * 查询数据总行数
     * @return 返回一个int，实现查询数据总行数功能
     */
    @Select("select count(*) from admins")
    int getAdminsPage();

    /**
     * 查询所有管理员
     * @return 返回一个List，实现查询功能
     */
    @Select("select * from admins limit #{currentPage1},5")
    List<Admins> getAllAdmins(int currentPage1);

    /**
     * 根据id查询管理员
     * @return 返回一个Admins，实现根据ID查询功能
     */
    @Select("select * from admins where id=#{id}")
    Admins getAdminsById(int id);

    /**
     * 登录
     * @param username:账号
     * @param password:密码
     * @return 返回一个Admins，实现登录功能
     */
    @Select("select * from admins where username=#{username} and password=#{password} ")
    Admins getAdminsLogin(String username, String password);

    /**
     * 增加管理员
     * @param admins:账号、密码,
     * @return 返回一个int，实现增加功能
     */
    @Insert("INSERT INTO admins VALUES (default, #{username}, #{password})")
    int getAddAdmins(Admins admins);

    /**
     * 修改管理员密码
     * @param admins:
     * @return 返回一个int，实现修改功能
     */
    @Update("update admins set password=#{password } where id=#{id} ")
    int getUpdateAdmins(Admins admins);

    /**
     * 删除管理员
     * @param id:id
     * @return 返回一个int，实现删除功能
     */
    @Delete("delete from admins where id=#{id}")
    int getDeleteAdmins(int id);
}
