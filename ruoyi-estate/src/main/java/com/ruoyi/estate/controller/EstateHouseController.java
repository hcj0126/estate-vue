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
import com.ruoyi.estate.domain.EstateHouse;
import com.ruoyi.estate.service.IEstateHouseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房产Controller
 * 
 * @author ruoyi
 * @date 2022-01-03
 */
@RestController
@RequestMapping("/estate/house")
public class EstateHouseController extends BaseController
{
    @Autowired
    private IEstateHouseService estateHouseService;

    /**
     * 查询房产列表
     */
    @PreAuthorize("@ss.hasPermi('estate:house:list')")
    @GetMapping("/list")
    public TableDataInfo list(EstateHouse estateHouse)
    {
        startPage();
        List<EstateHouse> list = estateHouseService.selectEstateHouseList(estateHouse);
        return getDataTable(list);
    }

    /**
     * 导出房产列表
     */
    @PreAuthorize("@ss.hasPermi('estate:house:export')")
    @Log(title = "房产", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EstateHouse estateHouse)
    {
        List<EstateHouse> list = estateHouseService.selectEstateHouseList(estateHouse);
        ExcelUtil<EstateHouse> util = new ExcelUtil<EstateHouse>(EstateHouse.class);
        util.exportExcel(response, list, "房产数据");
    }

    /**
     * 获取房产详细信息
     */
    @PreAuthorize("@ss.hasPermi('estate:house:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(estateHouseService.selectEstateHouseById(id));
    }

    /**
     * 新增房产
     */
    @PreAuthorize("@ss.hasPermi('estate:house:add')")
    @Log(title = "房产", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EstateHouse estateHouse)
    {
        return toAjax(estateHouseService.insertEstateHouse(estateHouse));
    }

    /**
     * 修改房产
     */
    @PreAuthorize("@ss.hasPermi('estate:house:edit')")
    @Log(title = "房产", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EstateHouse estateHouse)
    {
        return toAjax(estateHouseService.updateEstateHouse(estateHouse));
    }

    /**
     * 删除房产
     */
    @PreAuthorize("@ss.hasPermi('estate:house:remove')")
    @Log(title = "房产", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(estateHouseService.deleteEstateHouseByIds(ids));
    }
}
