const { mockOrders, mockUser } = require('../../mock/data');

Page({
  data: {
    user: mockUser,
    learningMinutes: 0,
    orders: mockOrders
  },
  onLoad() {
    this.viewAllOrders();
  },
  syncWechatInfo() {
    console.log('模拟同步微信信息');
  },
  viewOrders(e) {
    const status = e.currentTarget.dataset.status;
    const filteredOrders = mockOrders.filter(order => order.status === status);
    this.setData({
      orders: filteredOrders
    });
  },
  viewAllOrders() {
    this.setData({
      orders: mockOrders
    });
  }
});