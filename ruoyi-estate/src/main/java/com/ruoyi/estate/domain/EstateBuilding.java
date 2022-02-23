package com.ruoyi.estate.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 楼栋对象 estate_building
 * 
 * @author ruoyi
 * @date 2022-01-03
 */
public class EstateBuilding extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 楼栋ID */
    private Long id;

    /** 所属小区名称 */
    @Excel(name = "所属小区名称")
    private String communityName;

    /** 所属小区ID */
    @Excel(name = "所属小区ID")
    private Long communityId;

    /** 栋数名称 */
    @Excel(name = "栋数名称")
    private String buildingName;

    /** 总户数 */
    @Excel(name = "总户数")
    private Long buildingTotalHouseholds;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCommunityName(String communityName) 
    {
        this.communityName = communityName;
    }

    public String getCommunityName() 
    {
        return communityName;
    }
    public void setCommunityId(Long communityId) 
    {
        this.communityId = communityId;
    }

    public Long getCommunityId() 
    {
        return communityId;
    }
    public void setBuildingName(String buildingName) 
    {
        this.buildingName = buildingName;
    }

    public String getBuildingName() 
    {
        return buildingName;
    }
    public void setBuildingTotalHouseholds(Long buildingTotalHouseholds) 
    {
        this.buildingTotalHouseholds = buildingTotalHouseholds;
    }

    public Long getBuildingTotalHouseholds() 
    {
        return buildingTotalHouseholds;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("communityName", getCommunityName())
            .append("communityId", getCommunityId())
            .append("buildingName", getBuildingName())
            .append("buildingTotalHouseholds", getBuildingTotalHouseholds())
            .append("description", getDescription())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
