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
import com.ruoyi.estate.domain.EstateCar;
import com.ruoyi.estate.service.IEstateCarService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆管理Controller
 * 
 * @author ruoyi
 * @date 2022-01-04
 */
@RestController
@RequestMapping("/estate/car")
public class EstateCarController extends BaseController
{
    @Autowired
    private IEstateCarService estateCarService;

    /**
     * 查询车辆管理列表
     */
    @PreAuthorize("@ss.hasPermi('estate:car:list')")
    @GetMapping("/list")
    public TableDataInfo list(EstateCar estateCar)
    {
        startPage();
        List<EstateCar> list = estateCarService.selectEstateCarList(estateCar);
        return getDataTable(list);
    }

    /**
     * 导出车辆管理列表
     */
    @PreAuthorize("@ss.hasPermi('estate:car:export')")
    @Log(title = "车辆管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EstateCar estateCar)
    {
        List<EstateCar> list = estateCarService.selectEstateCarList(estateCar);
        ExcelUtil<EstateCar> util = new ExcelUtil<EstateCar>(EstateCar.class);
        util.exportExcel(response, list, "车辆管理数据");
    }

    /**
     * 获取车辆管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('estate:car:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(estateCarService.selectEstateCarById(id));
    }

    /**
     * 新增车辆管理
     */
    @PreAuthorize("@ss.hasPermi('estate:car:add')")
    @Log(title = "车辆管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EstateCar estateCar)
    {
        return toAjax(estateCarService.insertEstateCar(estateCar));
    }

    /**
     * 修改车辆管理
     */
    @PreAuthorize("@ss.hasPermi('estate:car:edit')")
    @Log(title = "车辆管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EstateCar estateCar)
    {
        return toAjax(estateCarService.updateEstateCar(estateCar));
    }

    /**
     * 删除车辆管理
     */
    @PreAuthorize("@ss.hasPermi('estate:car:remove')")
    @Log(title = "车辆管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(estateCarService.deleteEstateCarByIds(ids));
    }
}
