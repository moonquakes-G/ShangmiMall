package com.hp.service.Impl;

import com.hp.dao.TypeMapper;
import com.hp.pojo.Types;
import com.hp.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;
    /**
     * 查询所有类目
     *
     * @return 返回一个List，实现查询功能
     */
    @Override
    public List<Types> getFindType() {
        return typeMapper.getFindType();
    }

    /**
     * 根据ID查询类目
     *
     * @param id
     * @return 返回一个Types对象，实现根据ID查询功能
     */
    @Override
    public Types getFindTypeById(int id) {
        return typeMapper.getFindTypeById(id);
    }

    /**
     * 增加类目
     *
     * @param types
     * @return 返回一个int，实现增加功能
     */
    @Override
    public int getAddType(Types types) {
        return typeMapper.getAddType(types);
    }

    /**
     * 修改类目
     *
     * @param types
     * @return 返回一个int，实现修改功能
     */
    @Override
    public int getUpdateType(Types types) {
        return typeMapper.getUpdateType(types);
    }

    /**
     * 删除类目
     *
     * @param id
     * @return 返回一个int，实现删除功能
     */
    @Override
    public int getDeleteType(int id) {
        return typeMapper.getDeleteType(id);
    }
}
