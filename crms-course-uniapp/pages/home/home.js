// pages/home/home.js
Page({
    data: {
        courses: [],
        searchResult: [],
        categories: [],
        selectedCategory: null
    },
    onLoad() {
        this.getCategories(); // 页面加载时只获取类别数据
    },
    getCategories: function() {
        wx.request({
            url: 'http://127.0.0.1:5000/api/course_categories',
            method: 'GET',
            success: (res) => {
                this.setData({
                    categories: res.data
                });
            },
            fail: (err) => {
                wx.showToast({
                    title: '获取分类失败',
                    icon: 'none'
                });
            }
        });
    },
    getCourses: function(category) {
        const data = category ? { category_id: category.id } : {}; // 确保传递正确的参数
        console.log('Fetching courses with category_id:', data.category_id); // 调试信息
        wx.request({
            url: 'http://127.0.0.1:5000/api/courses',
            method: 'GET',
            data: data,
            success: (res) => {
                console.log('Courses fetched successfully:', res.data); // 调试信息
                this.setData({
                    courses: res.data
                });
            },
            fail: (err) => {
                console.error('Failed to fetch courses:', err); // 调试信息
                wx.showToast({
                    title: '获取课程失败',
                    icon: 'none'
                });
            }
        });
    },
    createOrder(event) {
        const course = event.currentTarget.dataset.course;
        const userId = this.getUserId(); // 假设你有一个方法来获取当前用户的ID

        wx.request({
            url: '/api/orders',
            method: 'POST',
            data: {
                user_id: userId,
                course_id: course.id,
                amount: course.price
            },
            success: (res) => {
                if (res.statusCode === 200) {
                    // 处理成功响应
                    console.log('订单创建成功:', res.data);
                    this.setData({
                        paymentInfo: res.data.payment_info // 假设后端返回的支付信息在 payment_info 字段中
                    });
                    // 可以在这里调用支付接口
                    this.processPayment(res.data.payment_info);
                } else {
                    // 处理错误响应
                    console.error('订单创建失败:', res.data);
                    this.setData({
                        orderCancelInfo: '订单创建失败'
                    });
                }
            },
            fail: (err) => {
                console.error('请求失败:', err);
                this.setData({
                    orderCancelInfo: '请求失败'
                });
            }
        });
    },
    processPayment(paymentInfo) {
        // 假设这里调用微信支付接口
        wx.requestPayment({
            timeStamp: paymentInfo.timeStamp,
            nonceStr: paymentInfo.nonceStr,
            package: paymentInfo.package,
            signType: paymentInfo.signType,
            paySign: paymentInfo.paySign,
            success: (res) => {
                console.log('支付成功:', res);
                this.setData({
                    paymentInfo: '支付成功'
                });
            },
            fail: (err) => {
                console.error('支付失败:', err);
                this.cancelOrder();
            }
        });
    },

    cancelOrder() {
        const orderId = this.data.paymentInfo.order_id; // 假设订单ID在 paymentInfo 中

        wx.request({
            url: `/api/orders/${orderId}/cancel`,
            method: 'POST',
            success: (res) => {
                if (res.statusCode === 200) {
                    console.log('订单取消成功:', res.data);
                    this.setData({
                        paymentInfo: null,
                        orderCancelInfo: '订单已取消'
                    });
                } else {
                    console.error('订单取消失败:', res.data);
                    this.setData({
                        orderCancelInfo: '订单取消失败'
                    });
                }
            },
            fail: (err) => {
                console.error('请求失败:', err);
                this.setData({
                    orderCancelInfo: '请求失败'
                });
            }
        });
    },
    getUserId() {
        // 实现获取用户ID的逻辑
        // 例如，从缓存中获取用户ID
        return wx.getStorageSync('userId');
    },

    handleSearch: function(e) {
        // 搜索逻辑不变
    },
    filterCourses: function(e) {
        const category = e.currentTarget.dataset.category;
        console.log('Selected category:', category); // 调试信息
        if (category && category.id) {
            this.setData({
                selectedCategory: category,
                courses: [] // 清空课程数据
            });
            this.getCourses(category); // 获取选中类别的课程数据
        } else {
            console.error('Invalid category object:', course); // 调试信息
        }
    },
    goToCourseDetails: function(e) {
        const course = e.currentTarget.dataset.course;
        console.log('Navigating to course details:', course); // 调试信息
        if (typeof course === 'object' && course !== null && course.category_id) {
            wx.navigateTo({
                url: `/pages/courseDetail/courseDetail?courseId=${course.category_id}`
            });
        } else {
            console.error('Invalid course object:', course); // 调试信息
            wx.showToast({
                title: '课程数据无效，请重试',
                icon: 'none'
            });
        }
    },
    downloadCourse: function(e) {
        const course = e.currentTarget.dataset.course;
        console.log('Downloading course:', course); // 调试信息
        if (course && course.download_link) {
            wx.downloadFile({
                url: course.download_link,
                success: (res) => {
                    if (res.statusCode === 200) {
                        wx.showToast({
                            title: '下载成功',
                            icon: 'success'
                        });
                        // 可以在这里添加保存文件的逻辑
                    } else {
                        wx.showToast({
                            title: '下载失败',
                            icon: 'none'
                        });
                    }
                },
                fail: (err) => {
                    console.error('Failed to download course:', err); // 调试信息
                    wx.showToast({
                        title: '下载失败',
                        icon: 'none'
                    });
                }
            });
        } else {
            console.error('Invalid course object:', course); // 调试信息
        }
    }
});