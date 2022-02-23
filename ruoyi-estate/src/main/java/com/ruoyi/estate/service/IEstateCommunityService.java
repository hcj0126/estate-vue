package com.ruoyi.estate.service;

import java.util.List;
import com.ruoyi.estate.domain.EstateCommunity;

/**
 * 小区Service接口
 * 
 * @author ruoyi
 * @date 2021-12-18
 */
public interface IEstateCommunityService 
{
    /**
     * 查询小区
     * 
     * @param communityId 小区主键
     * @return 小区
     */
    public EstateCommunity selectEstateCommunityByCommunityId(Long communityId);

    /**
     * 查询小区列表
     * 
     * @param estateCommunity 小区
     * @return 小区集合
     */
    public List<EstateCommunity> selectEstateCommunityList(EstateCommunity estateCommunity);

    /**
     * 新增小区
     * 
     * @param estateCommunity 小区
     * @return 结果
     */
    public int insertEstateCommunity(EstateCommunity estateCommunity);

    /**
     * 修改小区
     * 
     * @param estateCommunity 小区
     * @return 结果
     */
    public int updateEstateCommunity(EstateCommunity estateCommunity);

    /**
     * 批量删除小区
     * 
     * @param communityIds 需要删除的小区主键集合
     * @return 结果
     */
    public int deleteEstateCommunityByCommunityIds(Long[] communityIds);

    /**
     * 删除小区信息
     * 
     * @param communityId 小区主键
     * @return 结果
     */
    public int deleteEstateCommunityByCommunityId(Long communityId);
}
