package com.ruoyi.estate.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人员管理对象 estate_owner
 * 
 * @author ruoyi
 * @date 2022-01-04
 */
public class EstateOwner extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 业主ID */
    private Long id;

    /** 所属小区 */
    @Excel(name = "所属小区")
    private Long communityId;

    /** 所属房产 */
    @Excel(name = "所属房产")
    private Long houseId;

    /** 业主姓名 */
    @Excel(name = "业主姓名")
    private String ownerName;

    /** 业主照片 */
    @Excel(name = "业主照片")
    private String ownerPicture;

    /** 业主身份证号 */
    @Excel(name = "业主身份证号")
    private String ownerIdcard;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private Long telephone;

    /** 职业 */
    @Excel(name = "职业")
    private String profession;

    /** 性别:0-男（默认），1-女 */
    @Excel(name = "性别:0-男", readConverterExp = "默=认")
    private String sex;

    /** 类型:0-房主（默认），1-租客 */
    @Excel(name = "类型:0-房主", readConverterExp = "默=认")
    private String type;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCommunityId(Long communityId) 
    {
        this.communityId = communityId;
    }

    public Long getCommunityId() 
    {
        return communityId;
    }
    public void setHouseId(Long houseId) 
    {
        this.houseId = houseId;
    }

    public Long getHouseId() 
    {
        return houseId;
    }
    public void setOwnerName(String ownerName) 
    {
        this.ownerName = ownerName;
    }

    public String getOwnerName() 
    {
        return ownerName;
    }
    public void setOwnerPicture(String ownerPicture) 
    {
        this.ownerPicture = ownerPicture;
    }

    public String getOwnerPicture() 
    {
        return ownerPicture;
    }
    public void setOwnerIdcard(String ownerIdcard) 
    {
        this.ownerIdcard = ownerIdcard;
    }

    public String getOwnerIdcard() 
    {
        return ownerIdcard;
    }
    public void setTelephone(Long telephone) 
    {
        this.telephone = telephone;
    }

    public Long getTelephone() 
    {
        return telephone;
    }
    public void setProfession(String profession) 
    {
        this.profession = profession;
    }

    public String getProfession() 
    {
        return profession;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("communityId", getCommunityId())
            .append("houseId", getHouseId())
            .append("ownerName", getOwnerName())
            .append("ownerPicture", getOwnerPicture())
            .append("ownerIdcard", getOwnerIdcard())
            .append("telephone", getTelephone())
            .append("profession", getProfession())
            .append("sex", getSex())
            .append("type", getType())
            .append("birthday", getBirthday())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
