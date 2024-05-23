<template>
	<el-text class="mx-1" type="primary">通信传输</el-text>
  <el-input v-model="input" style="width: 240px" placeholder="请输入传输内容" />
   <el-button type="primary" @click="send">发送</el-button>
    <el-table :data="tableData.message" style="width: 100%">
      <el-table-column prop="date" label="时间" width="180" />
      <el-table-column prop="content" label="内容" width="180" />
      <el-table-column prop="status" label="状态" />
    </el-table>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import { sendMessage , getMessage } from '../http/api.js';
const input = ref('');
const tableData = reactive({
	message:[]
});
const send= () => {
	const data={
		content:input.value,
		status:1
	};
     sendMessage(data).then(response=>{
		 console.log(response);
		 getMessage().then(re=>{
			 tableData.message=re.data;
			 console.log(tableData.message);
		 })
	 });
}
const formatDateTime = (dateTime) => {
  // 格式化日期时间
  return new Date(dateTime).toLocaleString();
};
</script>
