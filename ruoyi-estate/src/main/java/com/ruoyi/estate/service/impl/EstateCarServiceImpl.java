package com.ruoyi.estate.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.estate.mapper.EstateCarMapper;
import com.ruoyi.estate.domain.EstateCar;
import com.ruoyi.estate.service.IEstateCarService;

/**
 * 车辆管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-04
 */
@Service
public class EstateCarServiceImpl implements IEstateCarService 
{
    @Autowired
    private EstateCarMapper estateCarMapper;

    /**
     * 查询车辆管理
     * 
     * @param id 车辆管理主键
     * @return 车辆管理
     */
    @Override
    public EstateCar selectEstateCarById(Long id)
    {
        return estateCarMapper.selectEstateCarById(id);
    }

    /**
     * 查询车辆管理列表
     * 
     * @param estateCar 车辆管理
     * @return 车辆管理
     */
    @Override
    public List<EstateCar> selectEstateCarList(EstateCar estateCar)
    {
        return estateCarMapper.selectEstateCarList(estateCar);
    }

    /**
     * 新增车辆管理
     * 
     * @param estateCar 车辆管理
     * @return 结果
     */
    @Override
    public int insertEstateCar(EstateCar estateCar)
    {
        estateCar.setCreateTime(DateUtils.getNowDate());
        return estateCarMapper.insertEstateCar(estateCar);
    }

    /**
     * 修改车辆管理
     * 
     * @param estateCar 车辆管理
     * @return 结果
     */
    @Override
    public int updateEstateCar(EstateCar estateCar)
    {
        estateCar.setUpdateTime(DateUtils.getNowDate());
        return estateCarMapper.updateEstateCar(estateCar);
    }

    /**
     * 批量删除车辆管理
     * 
     * @param ids 需要删除的车辆管理主键
     * @return 结果
     */
    @Override
    public int deleteEstateCarByIds(Long[] ids)
    {
        return estateCarMapper.deleteEstateCarByIds(ids);
    }

    /**
     * 删除车辆管理信息
     * 
     * @param id 车辆管理主键
     * @return 结果
     */
    @Override
    public int deleteEstateCarById(Long id)
    {
        return estateCarMapper.deleteEstateCarById(id);
    }
}
