package com.hp.service;

import com.hp.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodService {
    /**
     * 查询所有商品
     * @return 返回一个List，实现查询功能
     */
    List<Goods> getFindGood();

    /**
     * 根据ID查询商品
     * @return 返回一个Goods对象，实现根据ID查询功能
     */
    Goods getFindGoodById(int id);

    /**
     * 增加商品
     * @param goods:参数
     * @return 返回一个int，实现增加功能
     */
    int getAddGood(Goods goods);

    /**
     * 修改商品
     * @param goods:参数
     * @return 返回一个int，实现修改功能
     */
    int getUpdateGood(Goods goods);

    /**
     * 删除商品
     * @param id:id
     * @return 返回一个int，实现删除功能
     */
    int getDeleteGood(@Param("id") int id);

    /**
     * ========================================================   前台   ====================================================
     * */


    /**
     * 查询类型为？的所有商品
     * @param id:id
     * @return 返回一个List，实现查询功能
     */
    List<Goods> getGoodsByTypeName(int id);
}
