<template>
			<el-scrollbar>
				<el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
					<el-menu-item index="1">
						<router-link to="/correspond"><el-icon>
								<document />
							</el-icon><span>密钥通信</span></router-link>
					</el-menu-item>
					<el-menu-item index="2">
						<router-link to="/sessionKeys"><el-icon><icon-menu/></el-icon><span>会话密钥列表</span></router-link>
					</el-menu-item>
					<el-sub-menu index="3">
						<template #title>
							<el-icon>
								<location />
							</el-icon>
							<span>认证要素修改</span>
						</template>
						<el-sub-menu index="1-1">
							<router-link to="/password-change"><el-menu-item
									index="1-3-1">密码修改</el-menu-item></router-link>
							<el-menu-item index="1-3-2"><router-link
									to="/bio-change">生物信息修改</router-link></el-menu-item>
							<el-menu-item index="1-3-3"><router-link
									to="/card-change">智能卡撤销</router-link></el-menu-item>
						</el-sub-menu>
					</el-sub-menu>
				</el-menu>
			</el-scrollbar>
</template>

<script lang="ts" setup>
	import {
		Document,
		Menu as IconMenu,
		Location,
		Setting,
	} from '@element-plus/icons-vue'
	const handleOpen = (key : string, keyPath : string[]) => {
		console.log(key, keyPath)
	}
	const handleClose = (key : string, keyPath : string[]) => {
		console.log(key, keyPath)
	}
</script>