package com.hp.service.Impl;

import com.hp.dao.GoodMapper;
import com.hp.pojo.Goods;
import com.hp.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    /**
     * 查询所有商品
     *
     * @return 返回一个List，实现查询功能
     */
    @Override
    public List<Goods> getFindGood() {
        return goodMapper.getFindGood();
    }

    /**
     * 根据ID查询商品
     *
     * @param id
     * @return 返回一个Goods对象，实现根据ID查询功能
     */
    @Override
    public Goods getFindGoodById(int id) {
        return goodMapper.getFindGoodById(id);
    }

    /**
     * 增加商品
     *
     * @param goods
     * @return 返回一个int，实现增加功能
     * INSERT INTO `goods` VALUES ('1', '../upload/1-1.jpg', '四川耙耙柑 酸甜甘香 柔嫩多汁', '皮薄易剥 肉质软嫩', '约500g', '13', '9', '2', '', '1');
     */
    @Override
    public int getAddGood(Goods goods) {
        System.out.println(goods.toString());
        return goodMapper.getAddGood(goods);
    }

    /**
     * 修改商品
     *
     * @param goods
     * @return 返回一个int，实现修改功能
     */
    @Override
    public int getUpdateGood(Goods goods) {
        return goodMapper.getUpdateGood(goods);
    }

    /**
     * 删除商品
     *
     * @param id
     * @return 返回一个int，实现删除功能
     */
    @Override
    public int getDeleteGood(int id) {
        return goodMapper.getDeleteGood(id);
    }

    /**
     * ========================================================   前台   ====================================================
     * */

    /**
     * 查询类型为？的所有商品
     *
     * @param id :id
     * @return 返回一个List，实现查询功能
     */
    @Override
    public List<Goods> getGoodsByTypeName(int id) {
        return goodMapper.getGoodsByTypeName(id);
    }
}
