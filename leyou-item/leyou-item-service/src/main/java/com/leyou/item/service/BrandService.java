package com.leyou.item.service;

import com.leyou.common.vo.PageResult;
import com.leyou.item.pojo.Brand;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BrandService {
   /**
    * 分页查询品牌
    * @param page
    * @param rows
    * @param sortBy
    * @param desc
    * @param key
    * @return
    */
   public PageResult<Brand> querBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key);

   /**
    * 新增品牌
    * @param brand
    * @param cids
    */
   public void saveBrand(Brand brand, List<Long> cids);

    /**
     * 修改品牌 并且维护品牌和分类的中间表
     * @param brand
     * @param cids
     */
   public void updateBrand(Brand brand, List<Long> cids);

    /**
     * 根据brand Id删除数据
     * @param bid
     */
   public void deleByBrandIdCategoryBrand(Long bid);

    /**
     * 删除品牌并维护中间表
     * @param id
     */
   public void deleteBrand(long id);
}
