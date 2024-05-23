<template>
	<div class="center-block">
  <el-form :model="form" :rules="rules" label-width="100px" size="small">
    <el-form-item label="手机号码" prop="phone">
      <el-input v-model="form.username"></el-input>
    </el-form-item>
    <el-form-item label="生物信息" prop="bio">
      <el-input v-model="form.bio"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input type="password" v-model="form.password"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm">登录</el-button>
    </el-form-item>
	<el-tag type="primary"><router-link to="/user-register">用户注册</router-link></el-tag>
  </el-form>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { ElForm, ElFormItem, ElInput, ElButton } from 'element-plus';
import { useRouter } from 'vue-router';
	import{
		login
	}from '../http/api.js';
import { reactive } from 'vue';

// 全局状态管理
const state = reactive({
  isLoggedIn: true
});
const router = useRouter();
const form = ref({
  username: '',
  bio: '',
  password: ''
});

const rules = ref({
  phone: [
    { required: true, message: '请输入手机号码', trigger: 'blur' },
    { pattern: /^1[3-9]\d{9}$/, message: '手机号码格式不正确', trigger: 'blur' }
  ],
  bio: [
    { required: true, message: '请输入生物信息', trigger: 'blur' }
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    { min: 6, message: '密码长度不能少于6位', trigger: 'blur' }
  ]
});
function goToRegister() {
  router.push('/register')
};
const submitForm = () => {
   state.isLoggedIn=true;
   login(form.value).then(response=>{
   	console.log(response);
   	router.push('/correspond');
   }).catch(error=>{
   	alert(error);
   });
   
   }
 // const submitForm = () => {
	//  state.isLoggedIn=true;
	//  router.push('/correspond');
	//  };
</script>
<style>
	.center-block {
	  width: 300px; /* 设置表单的宽度 */
	  margin: 0 auto; /* 居中对齐 */
	  padding: 20px; /* 设置表单的内边距 */
	}
</style>