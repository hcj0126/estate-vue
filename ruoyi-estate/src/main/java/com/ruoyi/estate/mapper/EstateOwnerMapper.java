package com.ruoyi.estate.mapper;

import java.util.List;
import com.ruoyi.estate.domain.EstateOwner;

/**
 * 人员管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-04
 */
public interface EstateOwnerMapper 
{
    /**
     * 查询人员管理
     * 
     * @param id 人员管理主键
     * @return 人员管理
     */
    public EstateOwner selectEstateOwnerById(Long id);

    /**
     * 查询人员管理列表
     * 
     * @param estateOwner 人员管理
     * @return 人员管理集合
     */
    public List<EstateOwner> selectEstateOwnerList(EstateOwner estateOwner);

    /**
     * 新增人员管理
     * 
     * @param estateOwner 人员管理
     * @return 结果
     */
    public int insertEstateOwner(EstateOwner estateOwner);

    /**
     * 修改人员管理
     * 
     * @param estateOwner 人员管理
     * @return 结果
     */
    public int updateEstateOwner(EstateOwner estateOwner);

    /**
     * 删除人员管理
     * 
     * @param id 人员管理主键
     * @return 结果
     */
    public int deleteEstateOwnerById(Long id);

    /**
     * 批量删除人员管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEstateOwnerByIds(Long[] ids);
}
