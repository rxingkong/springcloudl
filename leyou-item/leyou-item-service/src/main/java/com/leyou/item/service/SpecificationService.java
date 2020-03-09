package com.leyou.item.service;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;

import java.util.List;

public interface SpecificationService {
    /**
     * 根据cid查询商品规格
     *
     * @param cid
     * @return
     */
    public List<SpecGroup> querGroupByCid(Long cid);

    /**
     * 根据组id查询参数
     * @param gid
     * @return
     */
    public List<SpecParam> querParamByGid(Long gid);
}
