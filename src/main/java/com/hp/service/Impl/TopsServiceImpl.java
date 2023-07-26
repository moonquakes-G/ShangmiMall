package com.hp.service.Impl;

import com.hp.dao.TopsMapper;
import com.hp.pojo.Tops;
import com.hp.service.TopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Curtain-call
 */
@Service
public class TopsServiceImpl implements TopsService {

    @Autowired
    private TopsMapper topsMapper;

    /**
     * 查找全部的热销
     *
     * @return 一个List
     */
    @Override
    public List<Tops> getTopsFirstList() {
        return topsMapper.getTopsFirstList();
    }

    /**
     * 查找排名4-8的热销
     *
     * @return 一个List
     */
    @Override
    public List<Tops> getTopsFourList() {
        return topsMapper.getTopsFourList();
    }
}
