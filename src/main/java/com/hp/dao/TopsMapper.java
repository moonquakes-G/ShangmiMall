package com.hp.dao;

import com.hp.pojo.Tops;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Curtain-call
 */
@Mapper
public interface TopsMapper {

    /**
     * 查找排名1-3的热销
     * @return 一个List
     * */
    @Select("SELECT tops.*,goods.id AS goodId ,goods.cover,goods.name,goods.intro,goods.spec,goods.price  FROM tops JOIN goods ON tops.good_id=goods.id ORDER BY tops.id LIMIT 3")
    List<Tops> getTopsFirstList();

    /**
     * 查找排名4-8的热销
     * @return 一个List
     * */
    @Select("SELECT tops.*,goods.id AS goodId ,goods.cover,goods.name,goods.intro,goods.spec,goods.price  FROM tops JOIN goods ON tops.good_id=goods.id ORDER BY tops.id LIMIT 3,5")
    List<Tops> getTopsFourList();


}
