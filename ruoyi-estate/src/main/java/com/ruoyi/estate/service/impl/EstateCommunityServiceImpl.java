package com.ruoyi.estate.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.estate.mapper.EstateCommunityMapper;
import com.ruoyi.estate.domain.EstateCommunity;
import com.ruoyi.estate.service.IEstateCommunityService;

/**
 * 小区Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-18
 */
@Service
public class EstateCommunityServiceImpl implements IEstateCommunityService 
{
    @Autowired
    private EstateCommunityMapper estateCommunityMapper;

    /**
     * 查询小区
     * 
     * @param communityId 小区主键
     * @return 小区
     */
    @Override
    public EstateCommunity selectEstateCommunityByCommunityId(Long communityId)
    {
        return estateCommunityMapper.selectEstateCommunityById(communityId);
    }

    /**
     * 查询小区列表
     * 
     * @param estateCommunity 小区
     * @return 小区
     */
    @Override
    public List<EstateCommunity> selectEstateCommunityList(EstateCommunity estateCommunity)
    {
        return estateCommunityMapper.selectEstateCommunityList(estateCommunity);
    }

    /**
     * 新增小区
     * 
     * @param estateCommunity 小区
     * @return 结果
     */
    @Override
    public int insertEstateCommunity(EstateCommunity estateCommunity)
    {
        estateCommunity.setCreateTime(DateUtils.getNowDate());
        return estateCommunityMapper.insertEstateCommunity(estateCommunity);
    }

    /**
     * 修改小区
     * 
     * @param estateCommunity 小区
     * @return 结果
     */
    @Override
    public int updateEstateCommunity(EstateCommunity estateCommunity)
    {
        estateCommunity.setUpdateTime(DateUtils.getNowDate());
        return estateCommunityMapper.updateEstateCommunity(estateCommunity);
    }

    /**
     * 批量删除小区
     * 
     * @param communityIds 需要删除的小区主键
     * @return 结果
     */
    @Override
    public int deleteEstateCommunityByCommunityIds(Long[] communityIds)
    {
        return estateCommunityMapper.deleteEstateCommunityByIds(communityIds);
    }

    /**
     * 删除小区信息
     * 
     * @param communityId 小区主键
     * @return 结果
     */
    @Override
    public int deleteEstateCommunityByCommunityId(Long communityId)
    {
        return estateCommunityMapper.deleteEstateCommunityById(communityId);
    }
}
