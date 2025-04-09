Page({
  data: {
    errorMessage: ''
  },
  wechatLogin() {
    wx.login({
      success: async (res) => {
        if (res.code) {
          try {
            // 模拟发送 code 到后端进行登录处理，这里使用 wx.request 模拟请求
            const response = await new Promise((resolve, reject) => {
              wx.request({
                url: 'https://your-backend-url.com/api/users/wechat-login', // 替换为实际后端接口地址
                method: 'POST',
                data: {
                  code: res.code
                },
                success: resolve,
                fail: reject
              });
            });
            const data = response.data;
            // 假设后端返回用户信息，这里简单模拟存储用户 ID 和跳转
            wx.setStorageSync('userId', data.userId);
            wx.switchTab({
              url: '/pages/home/home'
            });
          } catch (error) {
            this.setData({
              errorMessage: '登录失败，请稍后再试'
            });
          }
        } else {
          this.setData({
            errorMessage: '登录失败，无法获取登录凭证'
          });
        }
      },
      fail: () => {
        this.setData({
          errorMessage: '登录失败，调用 wx.login 接口出错'
        });
      }
    });
  }
});