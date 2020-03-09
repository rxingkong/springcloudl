package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface BrandMapper extends Mapper<Brand> {
    /**
     * 维护品牌和分类中间表
     * @param cid
     * @param bid
     * @return
     */
    @Insert("INSERT INTO tb_category_brand (category_id,brand_id) VALUES(#{cid},#{bid});")
    int saveCategoryBrand(@Param("cid") Long cid, @Param("bid") Long bid);

    /**
     * 删除品牌分类中间表
     * @param bid
     */
    @Delete("DELETE FROM tb_category_brand WHERE brand_id=#{bdi}")
    void deleByBrandIdCategoryBrand(Long bid);
}
