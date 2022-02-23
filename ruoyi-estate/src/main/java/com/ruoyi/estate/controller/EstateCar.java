package com.ruoyi.estate.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆管理对象 estate_car
 * 
 * @author ruoyi
 * @date 2022-01-04
 */
public class EstateCar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 车辆ID */
    private Long id;

    /** 车辆照片 */
    @Excel(name = "车辆照片")
    private String carPicture;

    /** 所属成员（业主） */
    @Excel(name = "所属成员", readConverterExp = "业=主")
    private Long ownerId;

    /** 车辆颜色 */
    @Excel(name = "车辆颜色")
    private String carColor;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String carNumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCarPicture(String carPicture) 
    {
        this.carPicture = carPicture;
    }

    public String getCarPicture() 
    {
        return carPicture;
    }
    public void setOwnerId(Long ownerId) 
    {
        this.ownerId = ownerId;
    }

    public Long getOwnerId() 
    {
        return ownerId;
    }
    public void setCarColor(String carColor) 
    {
        this.carColor = carColor;
    }

    public String getCarColor() 
    {
        return carColor;
    }
    public void setCarNumber(String carNumber) 
    {
        this.carNumber = carNumber;
    }

    public String getCarNumber() 
    {
        return carNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carPicture", getCarPicture())
            .append("ownerId", getOwnerId())
            .append("carColor", getCarColor())
            .append("carNumber", getCarNumber())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
