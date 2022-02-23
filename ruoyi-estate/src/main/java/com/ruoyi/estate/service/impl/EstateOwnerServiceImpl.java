package com.ruoyi.estate.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.estate.mapper.EstateOwnerMapper;
import com.ruoyi.estate.domain.EstateOwner;
import com.ruoyi.estate.service.IEstateOwnerService;

/**
 * 人员管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-04
 */
@Service
public class EstateOwnerServiceImpl implements IEstateOwnerService 
{
    @Autowired
    private EstateOwnerMapper estateOwnerMapper;

    /**
     * 查询人员管理
     * 
     * @param id 人员管理主键
     * @return 人员管理
     */
    @Override
    public EstateOwner selectEstateOwnerById(Long id)
    {
        return estateOwnerMapper.selectEstateOwnerById(id);
    }

    /**
     * 查询人员管理列表
     * 
     * @param estateOwner 人员管理
     * @return 人员管理
     */
    @Override
    public List<EstateOwner> selectEstateOwnerList(EstateOwner estateOwner)
    {
        return estateOwnerMapper.selectEstateOwnerList(estateOwner);
    }

    /**
     * 新增人员管理
     * 
     * @param estateOwner 人员管理
     * @return 结果
     */
    @Override
    public int insertEstateOwner(EstateOwner estateOwner)
    {
        estateOwner.setCreateTime(DateUtils.getNowDate());
        return estateOwnerMapper.insertEstateOwner(estateOwner);
    }

    /**
     * 修改人员管理
     * 
     * @param estateOwner 人员管理
     * @return 结果
     */
    @Override
    public int updateEstateOwner(EstateOwner estateOwner)
    {
        estateOwner.setUpdateTime(DateUtils.getNowDate());
        return estateOwnerMapper.updateEstateOwner(estateOwner);
    }

    /**
     * 批量删除人员管理
     * 
     * @param ids 需要删除的人员管理主键
     * @return 结果
     */
    @Override
    public int deleteEstateOwnerByIds(Long[] ids)
    {
        return estateOwnerMapper.deleteEstateOwnerByIds(ids);
    }

    /**
     * 删除人员管理信息
     * 
     * @param id 人员管理主键
     * @return 结果
     */
    @Override
    public int deleteEstateOwnerById(Long id)
    {
        return estateOwnerMapper.deleteEstateOwnerById(id);
    }
}
