package com.ruoyi.estate.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.estate.mapper.EstateHouseMapper;
import com.ruoyi.estate.domain.EstateHouse;
import com.ruoyi.estate.service.IEstateHouseService;

/**
 * 房产Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-03
 */
@Service
public class EstateHouseServiceImpl implements IEstateHouseService 
{
    @Autowired
    private EstateHouseMapper estateHouseMapper;

    /**
     * 查询房产
     * 
     * @param id 房产主键
     * @return 房产
     */
    @Override
    public EstateHouse selectEstateHouseById(Long id)
    {
        return estateHouseMapper.selectEstateHouseById(id);
    }

    /**
     * 查询房产列表
     * 
     * @param estateHouse 房产
     * @return 房产
     */
    @Override
    public List<EstateHouse> selectEstateHouseList(EstateHouse estateHouse)
    {
        return estateHouseMapper.selectEstateHouseList(estateHouse);
    }

    /**
     * 新增房产
     * 
     * @param estateHouse 房产
     * @return 结果
     */
    @Override
    public int insertEstateHouse(EstateHouse estateHouse)
    {
        estateHouse.setCreateTime(DateUtils.getNowDate());
        return estateHouseMapper.insertEstateHouse(estateHouse);
    }

    /**
     * 修改房产
     * 
     * @param estateHouse 房产
     * @return 结果
     */
    @Override
    public int updateEstateHouse(EstateHouse estateHouse)
    {
        estateHouse.setUpdateTime(DateUtils.getNowDate());
        return estateHouseMapper.updateEstateHouse(estateHouse);
    }

    /**
     * 批量删除房产
     * 
     * @param ids 需要删除的房产主键
     * @return 结果
     */
    @Override
    public int deleteEstateHouseByIds(Long[] ids)
    {
        return estateHouseMapper.deleteEstateHouseByIds(ids);
    }

    /**
     * 删除房产信息
     * 
     * @param id 房产主键
     * @return 结果
     */
    @Override
    public int deleteEstateHouseById(Long id)
    {
        return estateHouseMapper.deleteEstateHouseById(id);
    }
}
