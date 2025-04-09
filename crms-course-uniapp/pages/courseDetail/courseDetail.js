// pages/courseDetail/courseDetail.js
Page({
    data: {
        course: {},
        downloadLinks: []
    },
    onLoad(options) {
        const courseId = options.courseId;
        this.getCourseDetails(courseId);
    },
    getCourseDetails: function(courseId) {
        wx.request({
            url: `http://127.0.0.1:5000/api/courses?category_id=${courseId}`,
            method: 'GET',
            success: (res) => {
                console.log('Course details fetched successfully:', res.data); // 调试信息
                this.setData({
                    course: res.data[0],
                    downloadLinks: res.data[0].download_link.split(',')
                });
            },
            fail: (err) => {
                console.error('Failed to fetch course details:', err); // 调试信息
                wx.showToast({
                    title: '获取课程详情失败',
                    icon: 'none'
                });
            }
        });
    },
    purchaseCourse: function() {
        wx.showToast({
            title: '购买成功',
            icon: 'success'
        });
        // 添加实际的购买逻辑
    }
});