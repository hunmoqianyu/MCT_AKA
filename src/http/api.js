import request from './request'

// 用户登录
export function login(data) {
  return request({
    url: '/login',
    method: 'post',
    data
  })
}
//用户注册
export function register(data) {
  return request({
    url: '/vehicle/register',
    method: 'post',
    data
  })
}
//用户注册
export function sendMessage(data) {
  return request({
    url: '/user/send',
    method: 'post',
    data
  })
}

export function getMessage() {
  return request({
    url: '/user/get_message',
    method: 'get',
  })
}
