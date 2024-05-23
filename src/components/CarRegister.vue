<template>
  <el-form  :model="form" :rules="rules" label-width="100px">
    <el-form-item label="车牌号" prop="licensePlate">
      <el-input v-model="form.VID"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm">注册 or 登录</el-button>
    </el-form-item>
  </el-form>
</template>

<script setup>
import { ref } from 'vue';
import { ElForm, ElFormItem, ElInput, ElButton } from 'element-plus';
import{
		register
	}from '../http/api.js';
import router from '../router/index.js';

const form = ref({
  vid: ''
});

const rules = ref({
  licensePlate: [
    { required: true, message: '请输入车牌号', trigger: 'blur' }
  ]
});

const submitForm = () => {
      register(form.value).then(response=>{
		  console.log(response);
		  router.push("/correspond");
	  }).catch(error=>{
			alert(error);
		});
};
</script>