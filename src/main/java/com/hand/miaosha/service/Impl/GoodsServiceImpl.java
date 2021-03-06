package com.hand.miaosha.service.Impl;

import com.hand.miaosha.dao.GoodsDao;
import com.hand.miaosha.domain.MiaoshaGoods;
import com.hand.miaosha.service.GoodsService;

import com.hand.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Class: GoodsServiceImpl
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2018-11-14 10:44
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<GoodsVo> listGoodsVo() {
        List<GoodsVo>list = goodsDao.listGoodsVo();
        System.out.println("11111111111111111111"+list.get(0));
        return goodsDao.listGoodsVo();
    }

    @Override
    public GoodsVo getGoodsVoByGoodsId(long goodsId) {
        return goodsDao.getGoodVoByGoodsId(goodsId);
    }

    @Override
    public boolean reduceStock(GoodsVo goods) {
        MiaoshaGoods g = new MiaoshaGoods();
        g.setGoodsId(goods.getId());
        int ret = goodsDao.reduceStock(g);
        return ret>0;
    }

    public void resetStock(List<GoodsVo> goodsList) {
        for(GoodsVo goods : goodsList ) {
            MiaoshaGoods g = new MiaoshaGoods();
            g.setGoodsId(goods.getId());
            g.setStockCount(goods.getStockCount());
            goodsDao.resetStock(g);
        }
    }
}
