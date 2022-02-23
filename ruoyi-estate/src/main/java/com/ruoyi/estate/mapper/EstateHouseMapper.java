package com.ruoyi.estate.mapper;

import java.util.List;
import com.ruoyi.estate.domain.EstateHouse;

/**
 * 房产Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-03
 */
public interface EstateHouseMapper 
{
    /**
     * 查询房产
     * 
     * @param id 房产主键
     * @return 房产
     */
    public EstateHouse selectEstateHouseById(Long id);

    /**
     * 查询房产列表
     * 
     * @param estateHouse 房产
     * @return 房产集合
     */
    public List<EstateHouse> selectEstateHouseList(EstateHouse estateHouse);

    /**
     * 新增房产
     * 
     * @param estateHouse 房产
     * @return 结果
     */
    public int insertEstateHouse(EstateHouse estateHouse);

    /**
     * 修改房产
     * 
     * @param estateHouse 房产
     * @return 结果
     */
    public int updateEstateHouse(EstateHouse estateHouse);

    /**
     * 删除房产
     * 
     * @param id 房产主键
     * @return 结果
     */
    public int deleteEstateHouseById(Long id);

    /**
     * 批量删除房产
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEstateHouseByIds(Long[] ids);
}
