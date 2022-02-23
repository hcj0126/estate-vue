<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="小区编码" prop="communityCode">
        <el-input
          v-model="queryParams.communityCode"
          placeholder="请输入小区编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="小区名称" prop="communityName">
        <el-input
          v-model="queryParams.communityName"
          placeholder="请输入小区名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开发商名称" prop="communityDeveloper">
        <el-input
          v-model="queryParams.communityDeveloper"
          placeholder="请输入开发商名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物业公司名称" prop="communityEstateCompany">
        <el-input
          v-model="queryParams.communityEstateCompany"
          placeholder="请输入物业公司名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_normal_disable"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['estate:community:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['estate:community:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['estate:community:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['estate:community:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="communityList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="小区编码" align="center" prop="communityCode" />
      <el-table-column label="小区名称" align="center" prop="communityName" />
      <el-table-column label="坐落地址" align="center" prop="communityAddress" />
      <el-table-column label="占地面积" align="center" prop="communityArea" />
      <el-table-column label="总栋数" align="center" prop="communityTotalBuildings" />
      <el-table-column label="总户数" align="center" prop="communityTotalHouseholds" />
      <el-table-column label="绿化率" align="center" prop="communityGreeningRate" />
      <el-table-column label="开发商名称" align="center" prop="communityDeveloper" />
      <el-table-column label="物业公司名称" align="center" prop="communityEstateCompany" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
		  <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['estate:community:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['estate:community:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改小区对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="小区编码" prop="communityCode">
          <el-input v-model="form.communityCode" placeholder="请输入小区编码" />
        </el-form-item>
        <el-form-item label="小区名称" prop="communityName">
          <el-input v-model="form.communityName" placeholder="请输入小区名称" />
        </el-form-item>
        <el-form-item label="坐落地址" prop="communityAddress">
          <el-input v-model="form.communityAddress" placeholder="请输入坐落地址" />
        </el-form-item>
        <el-form-item label="占地面积" prop="communityArea">
          <el-input v-model="form.communityArea" placeholder="请输入占地面积" />
        </el-form-item>
        <el-form-item label="总栋数" prop="communityTotalBuildings">
          <el-input v-model="form.communityTotalBuildings" placeholder="请输入总栋数" />
        </el-form-item>
        <el-form-item label="总户数" prop="communityTotalHouseholds">
          <el-input v-model="form.communityTotalHouseholds" placeholder="请输入总户数" />
        </el-form-item>
        <el-form-item label="绿化率" prop="communityGreeningRate">
          <el-input v-model="form.communityGreeningRate" placeholder="请输入绿化率" />
        </el-form-item>
        <el-form-item label="开发商名称" prop="communityDeveloper">
          <el-input v-model="form.communityDeveloper" placeholder="请输入开发商名称" />
        </el-form-item>
        <el-form-item label="物业公司名称" prop="communityEstateCompany">
          <el-input v-model="form.communityEstateCompany" placeholder="请输入物业公司名称" />
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_normal_disable"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCommunity, getCommunity, delCommunity, addCommunity, updateCommunity } from "@/api/estate/community";

export default {
  name: "Community",
  dicts: ['sys_normal_disable'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 小区表格数据
      communityList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        communityCode: null,
        communityName: null,
        communityAddress: null,
        communityArea: null,
        communityTotalBuildings: null,
        communityTotalHouseholds: null,
        communityGreeningRate: null,
        communityDeveloper: null,
        communityEstateCompany: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        communityCode: [
          { required: true, message: "小区编码不能为空", trigger: "blur" }
        ],
        communityName: [
          { required: true, message: "小区名称不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询小区列表 */
    getList() {
      this.loading = true;
      listCommunity(this.queryParams).then(response => {
        this.communityList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        communityCode: null,
        communityName: null,
        communityAddress: null,
        communityArea: null,
        communityTotalBuildings: null,
        communityTotalHouseholds: null,
        communityGreeningRate: null,
        communityDeveloper: null,
        communityEstateCompany: null,
        status: "0",
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.communityId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加小区";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const communityId = row.communityId || this.ids
      getCommunity(communityId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改小区";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.communityId != null) {
            updateCommunity(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCommunity(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const communityIds = row.communityId || this.ids;
      this.$modal.confirm('是否确认删除小区编号为"' + communityIds + '"的数据项？').then(function() {
        return delCommunity(communityIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('estate/community/export', {
        ...this.queryParams
      }, `community_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
