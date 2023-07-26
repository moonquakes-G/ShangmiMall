package com.hp.service;

import com.hp.pojo.Admins;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminsService {

    /**
     * 查询数据总行数
     * @return 返回一个int，实现查询数据总行数功能
     */
    int getAdminsPage();

    /**
     * 查询所有管理员
     * @return 返回一个List，实现查询功能
     */
    List<Admins> getAllAdmins(String currentPage);

    /**
     * 根据id查询管理员
     * @return 返回一个Admins，实现根据ID查询功能
     */
    Admins getAdminsById(int id);

    /**
     * 登录
     * @param username:账号
     * @param password:密码
     * @return 返回一个Admins，实现登录功能
     */
    Admins getAdminsLogin(String username, String password);

    /**
     * 增加管理员
     * @param admins:账号、密码,
     * @return 返回一个int，实现增加功能
     */
    int getAddAdmins(Admins admins);

    /**
     * 修改管理员密码
     * @param admins:
     * @return 返回一个int，实现修改功能
     */
    int getUpdateAdmins(Admins admins);

    /**
     * 删除管理员
     * @param id:id
     * @return 返回一个int，实现删除功能
     */
    int getDeleteAdmins(int id);
}
