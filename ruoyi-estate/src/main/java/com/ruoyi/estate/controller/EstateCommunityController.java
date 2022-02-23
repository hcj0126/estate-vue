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
import com.ruoyi.estate.domain.EstateCommunity;
import com.ruoyi.estate.service.IEstateCommunityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小区Controller
 * 
 * @author ruoyi
 * @date 2021-12-18
 */
@RestController
@RequestMapping("/estate/community")
public class EstateCommunityController extends BaseController
{
    @Autowired
    private IEstateCommunityService estateCommunityService;

    /**
     * 查询小区列表
     */
    @PreAuthorize("@ss.hasPermi('estate:community:list')")
    @GetMapping("/list")
    public TableDataInfo list(EstateCommunity estateCommunity)
    {
        startPage();
        List<EstateCommunity> list = estateCommunityService.selectEstateCommunityList(estateCommunity);
        return getDataTable(list);
    }

    /**
     * 导出小区列表
     */
    @PreAuthorize("@ss.hasPermi('estate:community:export')")
    @Log(title = "小区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EstateCommunity estateCommunity)
    {
        List<EstateCommunity> list = estateCommunityService.selectEstateCommunityList(estateCommunity);
        ExcelUtil<EstateCommunity> util = new ExcelUtil<EstateCommunity>(EstateCommunity.class);
        util.exportExcel(response, list, "小区数据");
    }

    /**
     * 获取小区详细信息
     */
    @PreAuthorize("@ss.hasPermi('estate:community:query')")
    @GetMapping(value = "/{communityId}")
    public AjaxResult getInfo(@PathVariable("communityId") Long communityId)
    {
        return AjaxResult.success(estateCommunityService.selectEstateCommunityByCommunityId(communityId));
    }

    /**
     * 新增小区
     */
    @PreAuthorize("@ss.hasPermi('estate:community:add')")
    @Log(title = "小区", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EstateCommunity estateCommunity)
    {
        return toAjax(estateCommunityService.insertEstateCommunity(estateCommunity));
    }

    /**
     * 修改小区
     */
    @PreAuthorize("@ss.hasPermi('estate:community:edit')")
    @Log(title = "小区", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EstateCommunity estateCommunity)
    {
        return toAjax(estateCommunityService.updateEstateCommunity(estateCommunity));
    }

    /**
     * 删除小区
     */
    @PreAuthorize("@ss.hasPermi('estate:community:remove')")
    @Log(title = "小区", businessType = BusinessType.DELETE)
	@DeleteMapping("/{communityIds}")
    public AjaxResult remove(@PathVariable Long[] communityIds)
    {
        return toAjax(estateCommunityService.deleteEstateCommunityByCommunityIds(communityIds));
    }
}
