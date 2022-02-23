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
import com.ruoyi.estate.domain.EstateBuilding;
import com.ruoyi.estate.service.IEstateBuildingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 楼栋Controller
 * 
 * @author ruoyi
 * @date 2022-01-03
 */
@RestController
@RequestMapping("/estate/building")
public class EstateBuildingController extends BaseController
{
    @Autowired
    private IEstateBuildingService estateBuildingService;

    /**
     * 查询楼栋列表
     */
    @PreAuthorize("@ss.hasPermi('estate:building:list')")
    @GetMapping("/list")
    public TableDataInfo list(EstateBuilding estateBuilding)
    {
        startPage();
        List<EstateBuilding> list = estateBuildingService.selectEstateBuildingList(estateBuilding);
        return getDataTable(list);
    }

    /**
     * 导出楼栋列表
     */
    @PreAuthorize("@ss.hasPermi('estate:building:export')")
    @Log(title = "楼栋", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EstateBuilding estateBuilding)
    {
        List<EstateBuilding> list = estateBuildingService.selectEstateBuildingList(estateBuilding);
        ExcelUtil<EstateBuilding> util = new ExcelUtil<EstateBuilding>(EstateBuilding.class);
        util.exportExcel(response, list, "楼栋数据");
    }

    /**
     * 获取楼栋详细信息
     */
    @PreAuthorize("@ss.hasPermi('estate:building:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(estateBuildingService.selectEstateBuildingById(id));
    }

    /**
     * 新增楼栋
     */
    @PreAuthorize("@ss.hasPermi('estate:building:add')")
    @Log(title = "楼栋", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EstateBuilding estateBuilding)
    {
        return toAjax(estateBuildingService.insertEstateBuilding(estateBuilding));
    }

    /**
     * 修改楼栋
     */
    @PreAuthorize("@ss.hasPermi('estate:building:edit')")
    @Log(title = "楼栋", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EstateBuilding estateBuilding)
    {
        return toAjax(estateBuildingService.updateEstateBuilding(estateBuilding));
    }

    /**
     * 删除楼栋
     */
    @PreAuthorize("@ss.hasPermi('estate:building:remove')")
    @Log(title = "楼栋", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(estateBuildingService.deleteEstateBuildingByIds(ids));
    }
}
