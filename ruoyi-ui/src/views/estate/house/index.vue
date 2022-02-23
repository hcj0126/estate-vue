<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="小区名称" prop="communityName">
        <el-input
          v-model="queryParams.communityName"
          placeholder="请输入所属小区名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="栋数名称" prop="buildingName">
        <el-input
          v-model="queryParams.buildingName"
          placeholder="请输入所属栋数名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="房产名称" prop="houseName">
        <el-input
          v-model="queryParams.houseName"
          placeholder="请输入房产名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="户主" prop="ownerName">
        <el-input
          v-model="queryParams.ownerName"
          placeholder="请输入户主"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系方式" prop="telephone">
        <el-input
          v-model="queryParams.telephone"
          placeholder="请输入联系方式"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="房间数" prop="roomNum">
        <el-input
          v-model="queryParams.roomNum"
          placeholder="请输入房间数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单元" prop="unit">
        <el-input
          v-model="queryParams.unit"
          placeholder="请输入单元"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="楼层" prop="floor">
        <el-input
          v-model="queryParams.floor"
          placeholder="请输入楼层"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入住时间" prop="liveTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.liveTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择入住时间">
        </el-date-picker>
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
          v-hasPermi="['estate:house:add']"
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
          v-hasPermi="['estate:house:edit']"
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
          v-hasPermi="['estate:house:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['estate:house:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="houseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="房屋ID" align="center" prop="id" />
      <el-table-column label="小区名称" align="center" prop="communityName" />
      <el-table-column label="栋数名称" align="center" prop="buildingName" />
      <el-table-column label="房产名称" align="center" prop="houseName" />
      <el-table-column label="户主" align="center" prop="ownerName" />
      <el-table-column label="联系方式" align="center" prop="telephone" />
      <el-table-column label="房间数" align="center" prop="roomNum" />
      <el-table-column label="单元" align="center" prop="unit" />
      <el-table-column label="楼层" align="center" prop="floor" />
      <el-table-column label="描述" align="center" prop="description" />
      <el-table-column label="入住时间" align="center" prop="liveTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.liveTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['estate:house:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['estate:house:remove']"
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

    <!-- 添加或修改房产对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="小区名称" prop="communityName">
          <el-input v-model="form.communityName" placeholder="请输入所属小区名称" />
        </el-form-item>
        <el-form-item label="栋数名称" prop="buildingName">
          <el-input v-model="form.buildingName" placeholder="请输入所属栋数名称" />
        </el-form-item>
        <el-form-item label="房产名称" prop="houseName">
          <el-input v-model="form.houseName" placeholder="请输入房产名称" />
        </el-form-item>
        <el-form-item label="户主" prop="ownerName">
          <el-input v-model="form.ownerName" placeholder="请输入户主" />
        </el-form-item>
        <el-form-item label="联系方式" prop="telephone">
          <el-input v-model="form.telephone" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="房间数" prop="roomNum">
          <el-input v-model="form.roomNum" placeholder="请输入房间数" />
        </el-form-item>
        <el-form-item label="单元" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入单元" />
        </el-form-item>
        <el-form-item label="楼层" prop="floor">
          <el-input v-model="form.floor" placeholder="请输入楼层" />
        </el-form-item>
        <el-form-item label="描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="入住时间" prop="liveTime">
          <el-date-picker clearable size="small"
            v-model="form.liveTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择入住时间">
          </el-date-picker>
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
import { listHouse, getHouse, delHouse, addHouse, updateHouse } from "@/api/estate/house";

export default {
  name: "House",
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
      // 房产表格数据
      houseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        communityName: null,
        buildingName: null,
        houseName: null,
        ownerName: null,
        telephone: null,
        roomNum: null,
        unit: null,
        floor: null,
        description: null,
        liveTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        liveTime: [
          { required: true, message: "入住时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询房产列表 */
    getList() {
      this.loading = true;
      listHouse(this.queryParams).then(response => {
        this.houseList = response.rows;
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
        id: null,
        communityName: null,
        buildingName: null,
        houseName: null,
        ownerName: null,
        telephone: null,
        roomNum: null,
        unit: null,
        floor: null,
        description: null,
        liveTime: null,
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加房产";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getHouse(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改房产";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateHouse(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addHouse(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除房产编号为"' + ids + '"的数据项？').then(function() {
        return delHouse(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('estate/house/export', {
        ...this.queryParams
      }, `house_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
