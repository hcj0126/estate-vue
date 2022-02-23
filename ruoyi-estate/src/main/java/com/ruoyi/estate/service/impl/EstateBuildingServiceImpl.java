package com.ruoyi.estate.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.estate.mapper.EstateBuildingMapper;
import com.ruoyi.estate.domain.EstateBuilding;
import com.ruoyi.estate.service.IEstateBuildingService;

/**
 * 楼栋Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-03
 */
@Service
public class EstateBuildingServiceImpl implements IEstateBuildingService 
{
    @Autowired
    private EstateBuildingMapper estateBuildingMapper;

    /**
     * 查询楼栋
     * 
     * @param id 楼栋主键
     * @return 楼栋
     */
    @Override
    public EstateBuilding selectEstateBuildingById(Long id)
    {
        return estateBuildingMapper.selectEstateBuildingById(id);
    }

    /**
     * 查询楼栋列表
     * 
     * @param estateBuilding 楼栋
     * @return 楼栋
     */
    @Override
    public List<EstateBuilding> selectEstateBuildingList(EstateBuilding estateBuilding)
    {
        return estateBuildingMapper.selectEstateBuildingList(estateBuilding);
    }

    /**
     * 新增楼栋
     * 
     * @param estateBuilding 楼栋
     * @return 结果
     */
    @Override
    public int insertEstateBuilding(EstateBuilding estateBuilding)
    {
        estateBuilding.setCreateTime(DateUtils.getNowDate());
        return estateBuildingMapper.insertEstateBuilding(estateBuilding);
    }

    /**
     * 修改楼栋
     * 
     * @param estateBuilding 楼栋
     * @return 结果
     */
    @Override
    public int updateEstateBuilding(EstateBuilding estateBuilding)
    {
        estateBuilding.setUpdateTime(DateUtils.getNowDate());
        return estateBuildingMapper.updateEstateBuilding(estateBuilding);
    }

    /**
     * 批量删除楼栋
     * 
     * @param ids 需要删除的楼栋主键
     * @return 结果
     */
    @Override
    public int deleteEstateBuildingByIds(Long[] ids)
    {
        return estateBuildingMapper.deleteEstateBuildingByIds(ids);
    }

    /**
     * 删除楼栋信息
     * 
     * @param id 楼栋主键
     * @return 结果
     */
    @Override
    public int deleteEstateBuildingById(Long id)
    {
        return estateBuildingMapper.deleteEstateBuildingById(id);
    }
}
