import request from '@/utils/request'

// 查询车辆管理列表
export function listCar(query) {
  return request({
    url: '/estate/car/list',
    method: 'get',
    params: query
  })
}

// 查询车辆管理详细
export function getCar(id) {
  return request({
    url: '/estate/car/' + id,
    method: 'get'
  })
}

// 新增车辆管理
export function addCar(data) {
  return request({
    url: '/estate/car',
    method: 'post',
    data: data
  })
}

// 修改车辆管理
export function updateCar(data) {
  return request({
    url: '/estate/car',
    method: 'put',
    data: data
  })
}

// 删除车辆管理
export function delCar(id) {
  return request({
    url: '/estate/car/' + id,
    method: 'delete'
  })
}

// 导出车辆管理
export function exportCar(query) {
  return request({
    url: '/estate/car/export',
    method: 'get',
    params: query
  })
}