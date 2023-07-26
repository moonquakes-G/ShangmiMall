package com.hp.service;

import com.hp.pojo.Types;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TypeService {
    /**
     * 查询所有类目
     * @return 返回一个List，实现查询功能
     */
    List<Types> getFindType();

    /**
     * 根据ID查询类目
     * @return 返回一个Types对象，实现根据ID查询功能
     */
    Types getFindTypeById(int id);

    /**
     * 增加类目
     * @return 返回一个int，实现增加功能
     */
    int getAddType(Types types);

    /**
     * 修改类目
     * @return 返回一个int，实现修改功能
     */
    int getUpdateType(Types types);

    /**
     * 删除类目
     * @return 返回一个int，实现删除功能
     */
    int getDeleteType(int id);
}
