package com.ruoyi.estate.service;

import java.util.List;
import com.ruoyi.estate.domain.EstateCar;

/**
 * 车辆管理Service接口
 * 
 * @author ruoyi
 * @date 2022-01-04
 */
public interface IEstateCarService 
{
    /**
     * 查询车辆管理
     * 
     * @param id 车辆管理主键
     * @return 车辆管理
     */
    public EstateCar selectEstateCarById(Long id);

    /**
     * 查询车辆管理列表
     * 
     * @param estateCar 车辆管理
     * @return 车辆管理集合
     */
    public List<EstateCar> selectEstateCarList(EstateCar estateCar);

    /**
     * 新增车辆管理
     * 
     * @param estateCar 车辆管理
     * @return 结果
     */
    public int insertEstateCar(EstateCar estateCar);

    /**
     * 修改车辆管理
     * 
     * @param estateCar 车辆管理
     * @return 结果
     */
    public int updateEstateCar(EstateCar estateCar);

    /**
     * 批量删除车辆管理
     * 
     * @param ids 需要删除的车辆管理主键集合
     * @return 结果
     */
    public int deleteEstateCarByIds(Long[] ids);

    /**
     * 删除车辆管理信息
     * 
     * @param id 车辆管理主键
     * @return 结果
     */
    public int deleteEstateCarById(Long id);
}
