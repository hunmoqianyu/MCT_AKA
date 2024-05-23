<template>
	<div class="center-block">
		<el-form :model="form" :rules="rules" label-width="100px" size="small">
			<el-form-item label="手机号码" prop="phone">
				<el-input v-model="form.username"></el-input>
			</el-form-item>
			<el-form-item label="密码" prop="password">
				<el-input type="password" v-model="form.password"></el-input>
			</el-form-item>
			<el-form-item label="生物信息" prop="bio">
				<el-input v-model="form.bio"></el-input>
			</el-form-item>
			<el-form-item label="车牌号" prop="licensePlate">
				<el-input v-model="form.vid"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="submitForm">注册</el-button>
			</el-form-item>
			<el-tag type="primary"><router-link to="/">用户登录</router-link></el-tag>
		</el-form>
		</div>
</template>

<script setup>
	import { useRouter } from 'vue-router';
	import {
		ref,reactive
	} from 'vue';
	import{
		register
	}from '../http/api.js';
	import {
		ElForm,
		ElFormItem,
		ElInput,
		ElButton
	} from 'element-plus';
	const form = ref({
		username: '',
		password: '',
		bio: '',
		vid: ''
	});

	const rules = ref({
		phone: [{
				required: true,
				message: '请输入手机号码',
				trigger: 'blur'
			},
			{
				pattern: /^1[3-9]\d{9}$/,
				message: '手机号码格式不正确',
				trigger: 'blur'
			}
		],
		password: [{
				required: true,
				message: '请输入密码',
				trigger: 'blur'
			},
			{
				min: 6,
				message: '密码长度不能少于6位',
				trigger: 'blur'
			}
		],
		bio: [{
			required: true,
			message: '请输入生物信息',
			trigger: 'blur'
		}],
		licensePlate: [{
			required: true,
			message: '请输入车牌号',
			trigger: 'blur'
		}]
	});

	const submitForm = () => {
		register(form.value).then(response=>{
			console.log(response);
			useRouter().push('/login');
		}).catch(error=>{
			alert(error);
		});
	};
</script>
<style>
	.center-block {
		width: 300px;
		/* 设置表单的宽度 */
		margin: 0 auto;
		/* 居中对齐 */
		padding: 20px;
		/* 设置表单的内边距 */
	}
</style>