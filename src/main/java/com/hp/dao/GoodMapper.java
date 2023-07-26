package com.hp.dao;

import com.hp.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodMapper {
    /**
     * 查询所有商品
     * @return 返回一个List，实现查询功能
     */
    @Select("select goods.*,types.name as typeName from goods,types where goods.type_id=types.id")
    List<Goods> getFindGood();

    /**
     * 根据ID查询商品
     * @return 返回一个Goods对象，实现根据ID查询功能
     */
    @Select("select goods.*,types.id as typeId ,types.name as typeName from goods,types where goods.type_id=types.id and goods.id=#{id}")
    Goods getFindGoodById(int id);

    /**
     * 增加商品
     * @param goods:参数
     * @return 返回一个int，实现增加功能
     */
    @Insert("INSERT INTO goods VALUES (default, #{cover}, #{name},#{intro},#{spec},#{price},#{stock},#{sales},#{content},#{typeId})")
    int getAddGood(Goods goods);

    /**
     * 修改商品
     * @param goods:参数
     * @return 返回一个int，实现修改功能
     */
    @Update("UPDATE goods SET cover=#{cover},name=#{name},intro=#{intro},spec=#{spec},price=#{price},stock=#{stock},sales=#{sales},content=#{content},type_id=#{typeId} WHERE id=#{id}")
    int getUpdateGood(Goods goods);

    /**
     * 删除商品
     * @param id:id
     * @return 返回一个int，实现删除功能
     */
    @Delete("delete from goods where id=#{id}")
    int getDeleteGood(@Param("id") int id);



    /**
     * ========================================================   前台   ====================================================
     * */

    /**
     * 查询类型为？的所有商品
     * @param id:id
     * @return 返回一个List，实现查询功能
     */
    @Select("SELECT goods.*,types.name AS typeName FROM goods,types WHERE goods.type_id=types.id AND types.id=#{id};")
    List<Goods> getGoodsByTypeName(@Param("id") int id);


}
