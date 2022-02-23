package com.ruoyi.estate.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小区对象 estate_community
 * 
 * @author ruoyi
 * @date 2021-12-18
 */
public class EstateCommunity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 小区id */
    private Long id;

    /** 小区编码 */
    @Excel(name = "小区编码")
    private String communityCode;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String communityName;

    /** 坐落地址 */
    @Excel(name = "坐落地址")
    private String communityAddress;

    /** 占地面积（m2） */
    @Excel(name = "占地面积", readConverterExp = "m=2")
    private Long communityArea;

    /** 总栋数 */
    @Excel(name = "总栋数")
    private Long communityTotalBuildings;

    /** 总户数 */
    @Excel(name = "总户数")
    private Long communityTotalHouseholds;

    /** 绿化率（%） */
    @Excel(name = "绿化率", readConverterExp = "%=")
    private Long communityGreeningRate;

    /** 开发商名称 */
    @Excel(name = "开发商名称")
    private String communityDeveloper;

    /** 物业公司名称 */
    @Excel(name = "物业公司名称")
    private String communityEstateCompany;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setId(Long communityId)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCommunityCode(String communityCode) 
    {
        this.communityCode = communityCode;
    }

    public String getCommunityCode() 
    {
        return communityCode;
    }
    public void setCommunityName(String communityName) 
    {
        this.communityName = communityName;
    }

    public String getCommunityName() 
    {
        return communityName;
    }
    public void setCommunityAddress(String communityAddress) 
    {
        this.communityAddress = communityAddress;
    }

    public String getCommunityAddress() 
    {
        return communityAddress;
    }
    public void setCommunityArea(Long communityArea) 
    {
        this.communityArea = communityArea;
    }

    public Long getCommunityArea() 
    {
        return communityArea;
    }
    public void setCommunityTotalBuildings(Long communityTotalBuildings) 
    {
        this.communityTotalBuildings = communityTotalBuildings;
    }

    public Long getCommunityTotalBuildings() 
    {
        return communityTotalBuildings;
    }
    public void setCommunityTotalHouseholds(Long communityTotalHouseholds) 
    {
        this.communityTotalHouseholds = communityTotalHouseholds;
    }

    public Long getCommunityTotalHouseholds() 
    {
        return communityTotalHouseholds;
    }
    public void setCommunityGreeningRate(Long communityGreeningRate) 
    {
        this.communityGreeningRate = communityGreeningRate;
    }

    public Long getCommunityGreeningRate() 
    {
        return communityGreeningRate;
    }
    public void setCommunityDeveloper(String communityDeveloper) 
    {
        this.communityDeveloper = communityDeveloper;
    }

    public String getCommunityDeveloper() 
    {
        return communityDeveloper;
    }
    public void setCommunityEstateCompany(String communityEstateCompany) 
    {
        this.communityEstateCompany = communityEstateCompany;
    }

    public String getCommunityEstateCompany() 
    {
        return communityEstateCompany;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("communityCode", getCommunityCode())
            .append("communityName", getCommunityName())
            .append("communityAddress", getCommunityAddress())
            .append("communityArea", getCommunityArea())
            .append("communityTotalBuildings", getCommunityTotalBuildings())
            .append("communityTotalHouseholds", getCommunityTotalHouseholds())
            .append("communityGreeningRate", getCommunityGreeningRate())
            .append("communityDeveloper", getCommunityDeveloper())
            .append("communityEstateCompany", getCommunityEstateCompany())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
