import request from '@/utils/request'

// 查询楼栋列表
export function listBuilding(query) {
  return request({
    url: '/estate/building/list',
    method: 'get',
    params: query
  })
}

// 查询楼栋详细
export function getBuilding(id) {
  return request({
    url: '/estate/building/' + id,
    method: 'get'
  })
}

// 新增楼栋
export function addBuilding(data) {
  return request({
    url: '/estate/building',
    method: 'post',
    data: data
  })
}

// 修改楼栋
export function updateBuilding(data) {
  return request({
    url: '/estate/building',
    method: 'put',
    data: data
  })
}

// 删除楼栋
export function delBuilding(id) {
  return request({
    url: '/estate/building/' + id,
    method: 'delete'
  })
}

// 导出楼栋
export function exportBuilding(query) {
  return request({
    url: '/estate/building/export',
    method: 'get',
    params: query
  })
}