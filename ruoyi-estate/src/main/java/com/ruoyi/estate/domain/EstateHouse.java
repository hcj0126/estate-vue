package com.ruoyi.estate.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房产对象 estate_house
 * 
 * @author ruoyi
 * @date 2022-01-03
 */
public class EstateHouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房屋ID */
    private Long id;

    /** 所属小区名称 */
    @Excel(name = "所属小区名称")
    private String communityName;

    /** 所属小区ID */
    @Excel(name = "所属小区ID")
    private Long communityId;

    /** 所属栋数名称 */
    @Excel(name = "所属栋数名称")
    private String buildingName;

    /** 所属栋数ID */
    @Excel(name = "所属栋数ID")
    private Long buildingId;

    /** 房产编码 */
    @Excel(name = "房产编码")
    private String houseCode;

    /** 房产名称 */
    @Excel(name = "房产名称")
    private String houseName;

    /** 户主（业主）ID */
    @Excel(name = "户主", readConverterExp = "业=主")
    private Long ownerId;

    /** 户主（业主）名称 */
    @Excel(name = "户主", readConverterExp = "业=主")
    private String ownerName;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private Long telephone;

    /** 房间数 */
    @Excel(name = "房间数")
    private Long roomNum;

    /** 单元 */
    @Excel(name = "单元")
    private Integer unit;

    /** 楼层 */
    @Excel(name = "楼层")
    private Integer floor;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 入住时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入住时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date liveTime;

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
    public void setBuildingId(Long buildingId) 
    {
        this.buildingId = buildingId;
    }

    public Long getBuildingId() 
    {
        return buildingId;
    }
    public void setHouseCode(String houseCode) 
    {
        this.houseCode = houseCode;
    }

    public String getHouseCode() 
    {
        return houseCode;
    }
    public void setHouseName(String houseName) 
    {
        this.houseName = houseName;
    }

    public String getHouseName() 
    {
        return houseName;
    }
    public void setOwnerId(Long ownerId) 
    {
        this.ownerId = ownerId;
    }

    public Long getOwnerId() 
    {
        return ownerId;
    }
    public void setOwnerName(String ownerName) 
    {
        this.ownerName = ownerName;
    }

    public String getOwnerName() 
    {
        return ownerName;
    }
    public void setTelephone(Long telephone) 
    {
        this.telephone = telephone;
    }

    public Long getTelephone() 
    {
        return telephone;
    }
    public void setRoomNum(Long roomNum) 
    {
        this.roomNum = roomNum;
    }

    public Long getRoomNum() 
    {
        return roomNum;
    }
    public void setUnit(Integer unit) 
    {
        this.unit = unit;
    }

    public Integer getUnit() 
    {
        return unit;
    }
    public void setFloor(Integer floor) 
    {
        this.floor = floor;
    }

    public Integer getFloor() 
    {
        return floor;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setLiveTime(Date liveTime) 
    {
        this.liveTime = liveTime;
    }

    public Date getLiveTime() 
    {
        return liveTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("communityName", getCommunityName())
            .append("communityId", getCommunityId())
            .append("buildingName", getBuildingName())
            .append("buildingId", getBuildingId())
            .append("houseCode", getHouseCode())
            .append("houseName", getHouseName())
            .append("ownerId", getOwnerId())
            .append("ownerName", getOwnerName())
            .append("telephone", getTelephone())
            .append("roomNum", getRoomNum())
            .append("unit", getUnit())
            .append("floor", getFloor())
            .append("description", getDescription())
            .append("liveTime", getLiveTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
