package com.hp.service;

import com.hp.pojo.Tops;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Curtain-call
 */
public interface TopsService {

    /**
     * 查找排名1-3的热销
     * @return 一个List
     * */
    List<Tops> getTopsFirstList();

    /**
     * 查找排名4-8的热销
     * @return 一个List
     * */
    List<Tops> getTopsFourList();
}
