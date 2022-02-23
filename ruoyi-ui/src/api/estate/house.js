import request from '@/utils/request'

// 查询房产列表
export function listHouse(query) {
  return request({
    url: '/estate/house/list',
    method: 'get',
    params: query
  })
}

// 查询房产详细
export function getHouse(id) {
  return request({
    url: '/estate/house/' + id,
    method: 'get'
  })
}

// 新增房产
export function addHouse(data) {
  return request({
    url: '/estate/house',
    method: 'post',
    data: data
  })
}

// 修改房产
export function updateHouse(data) {
  return request({
    url: '/estate/house',
    method: 'put',
    data: data
  })
}

// 删除房产
export function delHouse(id) {
  return request({
    url: '/estate/house/' + id,
    method: 'delete'
  })
}

// 导出房产
export function exportHouse(query) {
  return request({
    url: '/estate/house/export',
    method: 'get',
    params: query
  })
}