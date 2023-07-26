package com.hp.dao;

import com.hp.pojo.Types;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeMapper {

    /**
     * 查询所有类目
     * @return 返回一个List，实现查询功能
     */
    @Select("select * from types")
    List<Types> getFindType();

    /**
     * 根据ID查询类目
     * @return 返回一个Types对象，实现根据ID查询功能
     */
    @Select("select * from types where id=#{id}")
    Types getFindTypeById(int id);

    /**
     * 增加类目
     * @return 返回一个int，实现增加功能
     */
    @Insert("INSERT INTO types VALUES (default, #{name}, #{num})")
    int getAddType(Types types);

    /**
     * 修改类目
     * @return 返回一个int，实现修改功能
     */
    @Update("update types set name=#{name},num=#{num} where id=#{id}")
    int getUpdateType(Types types);

    /**
     * 删除类目
     * @return 返回一个int，实现删除功能
     */
    @Delete("delete from types where id=#{id}")
    int getDeleteType(@Param("id") int id);
}
