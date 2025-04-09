Component({
  data: {
    inputValue: ''
  },
  methods: {
    handleInput(e) {
      this.setData({
        inputValue: e.detail.value
      });
    },
    handleSearchButton() {
      this.triggerEvent('search', this.data.inputValue);
    }
  }
});