package com.ruoyi.estate.mapper;

import java.util.List;
import com.ruoyi.estate.domain.EstateBuilding;

/**
 * 楼栋Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-03
 */
public interface EstateBuildingMapper 
{
    /**
     * 查询楼栋
     * 
     * @param id 楼栋主键
     * @return 楼栋
     */
    public EstateBuilding selectEstateBuildingById(Long id);

    /**
     * 查询楼栋列表
     * 
     * @param estateBuilding 楼栋
     * @return 楼栋集合
     */
    public List<EstateBuilding> selectEstateBuildingList(EstateBuilding estateBuilding);

    /**
     * 新增楼栋
     * 
     * @param estateBuilding 楼栋
     * @return 结果
     */
    public int insertEstateBuilding(EstateBuilding estateBuilding);

    /**
     * 修改楼栋
     * 
     * @param estateBuilding 楼栋
     * @return 结果
     */
    public int updateEstateBuilding(EstateBuilding estateBuilding);

    /**
     * 删除楼栋
     * 
     * @param id 楼栋主键
     * @return 结果
     */
    public int deleteEstateBuildingById(Long id);

    /**
     * 批量删除楼栋
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEstateBuildingByIds(Long[] ids);
}
