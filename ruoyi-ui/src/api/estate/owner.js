import request from '@/utils/request'

// 查询人员管理列表
export function listOwner(query) {
  return request({
    url: '/estate/owner/list',
    method: 'get',
    params: query
  })
}

// 查询人员管理详细
export function getOwner(id) {
  return request({
    url: '/estate/owner/' + id,
    method: 'get'
  })
}

// 新增人员管理
export function addOwner(data) {
  return request({
    url: '/estate/owner',
    method: 'post',
    data: data
  })
}

// 修改人员管理
export function updateOwner(data) {
  return request({
    url: '/estate/owner',
    method: 'put',
    data: data
  })
}

// 删除人员管理
export function delOwner(id) {
  return request({
    url: '/estate/owner/' + id,
    method: 'delete'
  })
}

// 导出人员管理
export function exportOwner(query) {
  return request({
    url: '/estate/owner/export',
    method: 'get',
    params: query
  })
}