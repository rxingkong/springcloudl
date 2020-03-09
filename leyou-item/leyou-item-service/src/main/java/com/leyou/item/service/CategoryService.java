package com.leyou.item.service;

import com.leyou.item.pojo.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 根据PID分类查询
     * @param pid
     * @return
     */
    public List<Category> queryCategoryListByPid(Long pid);

    /**
     * 根据品牌id查询商品分类
     * @param bid
     * @return
     */
    List<Category> queryByBrandId(Long bid);

}
