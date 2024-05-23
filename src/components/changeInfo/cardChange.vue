<template>
  <div>
    <h2>密码修改</h2>
    <!-- 密码修改表单 -->
    <form @submit.prevent="changePassword">
      <div>
        <label for="oldPassword">旧生物样本：</label>
        <input type="password" id="oldPassword" v-model="oldPassword">
      </div>
      <div>
        <label for="newPassword">新生物样本：</label>
        <input type="password" id="newPassword" v-model="newPassword">
      </div>
      <button type="submit">提交</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      oldPassword: '',
      newPassword: ''
    };
  },
  methods: {
    changePassword() {
      // 处理密码修改逻辑
    }
  }
}
</script>