Component({
  properties: {
    orders: {
      type: Array,
      value: []
    }
  },
  methods: {
    payOrder(e) {
      const orderId = e.currentTarget.dataset.orderId;
      console.log('模拟付款操作，订单 ID:', orderId);
      this.triggerEvent('orderUpdated');
    },
    confirmReceipt(e) {
      const orderId = e.currentTarget.dataset.orderId;
      console.log('模拟确认收货操作，订单 ID:', orderId);
      this.triggerEvent('orderUpdated');
    }
  }
});