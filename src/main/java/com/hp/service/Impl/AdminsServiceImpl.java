package com.hp.service.Impl;

import com.hp.dao.AdminsMapper;
import com.hp.pojo.Admins;
import com.hp.service.AdminsService;
import com.hp.util.SafeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminsServiceImpl implements AdminsService {

    @Autowired
    private AdminsMapper adminsMapper;


    /**
     * 查询数据总行数
     *
     * @return 返回一个int，实现查询数据总行数功能
     */
    @Override
    public int getAdminsPage() {
        return adminsMapper.getAdminsPage();
    }

    /**
     * 查询所有管理员
     *
     * @return 返回一个List，实现查询功能
     */
    @Override
    public List<Admins> getAllAdmins(String currentPage) {
         int currentPage1 = (Integer.parseInt(currentPage)-1)*5;
        return adminsMapper.getAllAdmins(currentPage1);
    }

    /**
     * 根据id查询管理员
     *
     * @param id
     * @return 返回一个Admins，实现根据ID查询功能
     */
    @Override
    public Admins getAdminsById(int id) {
        return adminsMapper.getAdminsById(id);
    }

    /**
     * 登录
     *
     * @param username :账号
     * @param password :密码
     * @return 返回一个Admins，实现登录功能
     */
    @Override
    public Admins getAdminsLogin(String username, String password) {
        password = SafeUtil.md5(password);
        return adminsMapper.getAdminsLogin(username, password);
    }

    /**
     * 增加管理员
     *
     * @param admins :账号、密码
     * @return 返回一个int，实现增加功能
     */
    @Override
    public int getAddAdmins(Admins admins) {
        admins.setPassword(SafeUtil.md5(admins.getPassword()));
        return adminsMapper.getAddAdmins(admins);
    }

    /**
     * 修改管理员密码
     *
     * @param admins :
     * @return 返回一个int，实现修改功能
     */
    @Override
    public int getUpdateAdmins(Admins admins) {
        admins.setPassword(SafeUtil.md5(admins.getPassword()));
        return adminsMapper.getUpdateAdmins(admins);
    }

    /**
     * 删除管理员
     *
     * @param id :id
     * @return 返回一个int，实现删除功能
     */
    @Override
    public int getDeleteAdmins(int id) {
        return adminsMapper.getDeleteAdmins(id);
    }
}
