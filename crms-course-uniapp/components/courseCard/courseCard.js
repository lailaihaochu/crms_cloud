Component({
  properties: {
    course: {
      type: Object,
      value: {}
    }
  },
  methods: {
    goToCourseDetail() {
      console.log('跳转到课程详情页');
      wx.navigateTo({
        url: `/pages/courseDetail/courseDetail?id=${this.data.course.id}`
      });
    }
  }
});