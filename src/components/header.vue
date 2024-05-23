<template>
	    <div class="toolbar">
	      <el-dropdown>
	        <el-icon style="margin-right: 8px; margin-top: 1px">
	          <setting />
	        </el-icon>
	        <template #dropdown>
	          <el-dropdown-menu>
	            <el-dropdown-item>View</el-dropdown-item>
	            <el-dropdown-item>Add</el-dropdown-item>
	            <el-dropdown-item>Delete</el-dropdown-item>
	          </el-dropdown-menu>
	        </template>
	      </el-dropdown>
	      <el-button type='primary'>登出</el-button>
	    </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { Menu as IconMenu, Message, Setting } from '@element-plus/icons-vue'

const item = {
  date: '2016-05-02',
  name: 'Tom',
  address: 'No. 189, Grove St, Los Angeles',
}
const tableData = ref(Array.from({ length: 20 }).fill(item))
</script>

<style>
	.el-header {
	  position: relative;
	  background-color: var(--el-color-primary-light-7);
	  color: var(--el-text-color-primary);
	}
</style>