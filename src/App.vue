<script setup>
	import store from './store/store.js';
	import mynav from './components/myNav.vue';
	import myheader from './components/header.vue';
</script>
<template>
	<el-container >
		<el-aside width="200px" v-show="$route.path!='/'"><mynav/></el-aside>
		<el-container >
			<el-header style="text-align: right; font-size: 12px" v-show="$route.path!='/'"><myheader/></el-header>
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
	.flex-container {
	  display: flex; /* 设置为 Flexbox 布局 */
	  flex-direction: column; /* 垂直方向排列子元素 */
	}
</style>