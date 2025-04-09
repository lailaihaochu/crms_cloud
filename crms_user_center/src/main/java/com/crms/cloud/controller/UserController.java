package com.crms.cloud.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

@RestController
public class UserController {

    public void test(){
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10, 20,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        ForkJoinPool forkJoinPool=new ForkJoinPool();
        forkJoinPool.execute(()->{

        });
    }

    public static void main(String[] args) {
        longestPalindrome("bb");

    }

    //无重复最长串
    public void noRepeatPalindrome(){
        String s="abcdefalkong";
        Set<String> set=new HashSet<String>();
        int left=0;
        int right=0;
        String[] xs=s.split("");
        int length=0;
        int maxLength=0;
        while (right<xs.length){
            if(!set.contains(xs[right])){
                set.add(xs[right]);
                length++;
                maxLength=Math.max(length,maxLength);
                right++;
            }else{
                while (set.contains(xs[right])){
                    set.remove(xs[left]);
                    left++;
                    length--;
                }
                set.add(xs[right]);
                length++;
                right++;
            }
        }
        System.out.println(length);
    }

    //最长回文串
    public static String longestPalindrome(String s) {
        if(s==null||"".equals(s)){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        int maxLength=0;
        int start=0;
        int end=0;
        String[] xs=s.split("");
        for (int i =0;i<xs.length;i++){
            int left=i;
            int right=i+1;
            while (left>=0&&right<xs.length&&xs[right].equals(xs[left])){
                left--;
                right++;
            }

            if(right-left>maxLength){
                maxLength=right-left-1;
                start=i-(maxLength-1)/2;
                end=i+maxLength/2;
            }
        }
        if(maxLength==0){
            return xs[0];
        }

        System.out.println(s.substring(start,end+1));
        return null;
    }

}
