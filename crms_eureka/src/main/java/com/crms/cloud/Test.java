package com.crms.cloud;

import java.util.Arrays;

public class Test {
    public int sumIndex(int[] nums){
        //找到从某一下标开始左边和右边的数字和是相等的
        //算法中心拓展

        //思路从最中间开始，向左移位 或者向右移位
        //0、计算中间位基数偶数/ 偶数+1 基数直接拿出
        int center=nums.length/2;
        //1、中间向左
        int leftSum=0;
        for (int i=0;i<center;i++){
            leftSum+=nums[i];
        }
        int rightSum=0;
        for (int i=center;i<nums.length;i++){
            rightSum+=nums[i];
        }
        //2、左右俩边相等
        if(leftSum==rightSum){
            return center;
        }else if(leftSum>rightSum){
            center=center-1;
        }else {
            center=center+1;
        }
        //3、如果左边和大于右边
        //4、左大于右
        return 0;
    }
    public int pivotIndex(int[] nums,int [] numsCom) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        int xiabiaoNum=-1;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                xiabiaoNum= i;
            }
            sum += nums[i];
        }
        System.out.println("nums xiabiao ,"+xiabiaoNum);
        int xiabiaoNumCom=-1;
        int totalCom=Arrays.stream(numsCom).sum();
        int sumCom=0;
        for (int i = 0; i < numsCom.length; ++i) {
            if (2 * sumCom + numsCom[i] == totalCom) {
                xiabiaoNumCom= i;
            }
            sumCom += numsCom[i];
        }
        System.out.println("numsCom xiabiao ,"+xiabiaoNumCom);

        if(nums[xiabiaoNum]>numsCom[xiabiaoNumCom]){
            return xiabiaoNum;
        }else{
            return xiabiaoNumCom;
        }
    }

    public static void main(String[] args) {
        Test test=new Test();
        int[] nums=new int[]{2,-2,-3,3};
        int[] numCom=new int[]{0,0,4,-4};
        System.out.println(test.pivotIndex(nums,numCom));

    }
}
