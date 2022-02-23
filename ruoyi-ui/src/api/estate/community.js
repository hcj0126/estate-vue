import request from '@/utils/request'

// 查询小区列表
export function listCommunity(query) {
  return request({
    url: '/estate/community/list',
    method: 'get',
    params: query
  })
}

// 查询小区详细
export function getCommunity(communityId) {
  return request({
    url: '/estate/community/' + communityId,
    method: 'get'
  })
}

// 新增小区
export function addCommunity(data) {
  return request({
    url: '/estate/community',
    method: 'post',
    data: data
  })
}

// 修改小区
export function updateCommunity(data) {
  return request({
    url: '/estate/community',
    method: 'put',
    data: data
  })
}

// 删除小区
export function delCommunity(communityId) {
  return request({
    url: '/estate/community/' + communityId,
    method: 'delete'
  })
}

// 导出小区
export function exportCommunity(query) {
  return request({
    url: '/estate/community/export',
    method: 'get',
    params: query
  })
}