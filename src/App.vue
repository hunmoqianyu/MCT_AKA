<script setup>
	// This starter template is using Vue 3 <script setup> SFCs
	// Check out https://v3.vuejs.org/api/sfc-script-setup.html#sfc-script-setup
	import store from './store/store.js';
	import mynav from './components/myNav.vue';
	import myheader from './components/header.vue';
</script>
<template>
	<el-container >
		<el-aside width="200px" v-show="$route.path!='/'&&$route.path!='/user-register'"><mynav/></el-aside>
		<el-container class="mycontainer">
		<el-header style="text-align: right; font-size: 12px"  v-show="$route.path!='/'&&$route.path!='/user-register'">
		<myheader/>
		</el-header>
		<el-main><router-view></router-view></el-main>
		</el-container>
	</el-container>
</template>
<style>
	#app {
		font-family: Avenir, Helvetica, Arial, sans-serif;
		-webkit-font-smoothing: antialiased;
		-moz-osx-font-smoothing: grayscale;
		text-align: center;
		color: #2c3e50;
		margin-top: 60px;
	}
	.el-main {
	  padding: 0;
	}
</style>