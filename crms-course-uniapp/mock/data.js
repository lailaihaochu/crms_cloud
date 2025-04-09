const mockCourses = [
    {
        id: 1,
        title: '小学全阶段语数英',
        description: '小学全阶段语文 + 数学 + 英语电子档资料（不含网课）',
        price: 199.00,
        updatedCount: 41,
        fileUrl: 'https://aliyun.com/path/to/material1',
        coverImage: 'https://dummyimage.com/250x150/000/fff&text=Course+1',
        evaluations: [
            { id: 1, content: '这套资料很实用！' },
            { id: 2, content: '讲解清晰，孩子很喜欢。' }
        ],
        outline: [
            { id: 1, title: '语文第一单元', locked: false, studyCount: 10 },
            { id: 2, title: '数学第二单元', locked: true, studyCount: 0 }
        ],
        category: '1年',
        downloadLink: 'https://mock - download - link.com/course1'
    },
    {
        id: 2,
        title: '小学数学通用',
        description: '小学数学通用学习资料',
        price: 88.00,
        updatedCount: 18,
        fileUrl: 'https://aliyun.com/path/to/material2',
        coverImage: 'https://dummyimage.com/250x150/000/fff&text=Course+2',
        evaluations: [],
        outline: [
            { id: 1, title: '加法运算', locked: false, studyCount: 5 },
            { id: 2, title: '乘法口诀', locked: true, studyCount: 0 }
        ],
        category: '1年',
        downloadLink: 'https://mock - download - link.com/course2'
    }
];

const mockOrders = [
    {
        id: 1,
        user: { id: 1, name: '姜昆明', avatar: 'https://example.com/avatar1' },
        course: { id: 1, title: '小学全阶段语数英' },
        status: '已支付'
    }
];

const mockUser = {
    id: 1,
    name: '姜昆明',
    avatar: 'https://example.com/avatar1'
};

module.exports = {
    mockCourses,
    mockOrders,
    mockUser
};