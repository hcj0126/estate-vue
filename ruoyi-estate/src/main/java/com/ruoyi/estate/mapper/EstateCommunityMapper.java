package com.ruoyi.estate.mapper;

import java.util.List;
import com.ruoyi.estate.domain.EstateCommunity;

/**
 * 小区Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-18
 */
public interface EstateCommunityMapper {
    /**
     * 查询小区
     * 
     * @param communityId 小区主键
     * @return 小区
     */
    public EstateCommunity selectEstateCommunityById(Long communityId);

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
     * 删除小区
     * 
     * @param communityId 小区主键
     * @return 结果
     */
    public int deleteEstateCommunityById(Long communityId);

    /**
     * 批量删除小区
     * 
     * @param communityIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEstateCommunityByIds(Long[] communityIds);
}
