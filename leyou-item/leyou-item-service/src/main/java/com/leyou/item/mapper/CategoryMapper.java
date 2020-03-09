package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<Category> {

    @Select("SELECT id,name,parent_id as parentId,is_parent as isParent,sort FROM tb_category WHERE id in(SELECT category_id FROM tb_category_brand WHERE brand_id=#{bid})")
    List<Category> querByBrandId(@Param("bid") Long bid);

}
