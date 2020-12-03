package com.ccf.leetcode.y2020.dec;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *  
 *
 * 提示：
 *
 * 2 <= n <= 1000
 */
public class CuttingRope {

    public int cuttingRope(int n) {

        if(n <= 3){
            return n-1;
        }
        //通过一系列的数学验证发现(我不会，哈哈)，均等的分成每一段的长度为3时，乘积最大
        int a = n % 3;
        int b = n / 3;
        if(a == 2){
            return (int)(remainder(b) * 2 % 1000000007);
        }else{
            //当a==1时提出一个3和1组成2*2
            //a==0和a==1合并到一起
            return (int)(remainder(b-1)*(a+3) % 1000000007);
        }

    }

    //大数循环求余数
    private long remainder(int b){
        long rem = 1;
        for(int i=1;i<=b;i++){
            rem = (rem * 3) % 1000000007;
        }
        return rem;
    }

    //大数快速幂求余数
    private long quickPow(long n) {
        long res = 1;
        long tt = 3;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= tt;
                res %= 1000000007;
            }
            tt *= tt;
            tt %= 1000000007;
            n /= 2;
        }
        return res;
    }
}
