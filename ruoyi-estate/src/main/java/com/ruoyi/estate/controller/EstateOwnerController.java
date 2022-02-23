package com.ruoyi.estate.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.estate.domain.EstateOwner;
import com.ruoyi.estate.service.IEstateOwnerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人员管理Controller
 * 
 * @author ruoyi
 * @date 2022-01-04
 */
@RestController
@RequestMapping("/estate/owner")
public class EstateOwnerController extends BaseController
{
    @Autowired
    private IEstateOwnerService estateOwnerService;

    /**
     * 查询人员管理列表
     */
    @PreAuthorize("@ss.hasPermi('estate:owner:list')")
    @GetMapping("/list")
    public TableDataInfo list(EstateOwner estateOwner)
    {
        startPage();
        List<EstateOwner> list = estateOwnerService.selectEstateOwnerList(estateOwner);
        return getDataTable(list);
    }

    /**
     * 导出人员管理列表
     */
    @PreAuthorize("@ss.hasPermi('estate:owner:export')")
    @Log(title = "人员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EstateOwner estateOwner)
    {
        List<EstateOwner> list = estateOwnerService.selectEstateOwnerList(estateOwner);
        ExcelUtil<EstateOwner> util = new ExcelUtil<EstateOwner>(EstateOwner.class);
        util.exportExcel(response, list, "人员管理数据");
    }

    /**
     * 获取人员管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('estate:owner:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(estateOwnerService.selectEstateOwnerById(id));
    }

    /**
     * 新增人员管理
     */
    @PreAuthorize("@ss.hasPermi('estate:owner:add')")
    @Log(title = "人员管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EstateOwner estateOwner)
    {
        return toAjax(estateOwnerService.insertEstateOwner(estateOwner));
    }

    /**
     * 修改人员管理
     */
    @PreAuthorize("@ss.hasPermi('estate:owner:edit')")
    @Log(title = "人员管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EstateOwner estateOwner)
    {
        return toAjax(estateOwnerService.updateEstateOwner(estateOwner));
    }

    /**
     * 删除人员管理
     */
    @PreAuthorize("@ss.hasPermi('estate:owner:remove')")
    @Log(title = "人员管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(estateOwnerService.deleteEstateOwnerByIds(ids));
    }
}
