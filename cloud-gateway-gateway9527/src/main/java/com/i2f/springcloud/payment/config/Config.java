package com.i2f.springcloud.payment.config;

import cn.hutool.extra.template.engine.beetl.BeetlUtil;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/26 15:30
 */
@Configuration
public class Config {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_route_atguigu", r -> r.path("guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 10};
        int[] num = getNum(nums);
        System.out.print("[");
        for (int i = 0; i < num.length; i++) {
            if(i==0){
                System.out.print(num[i]);
            }else {
                System.out.print(","+num[i]);
            }
        }
        System.out.println("]");
    }

    public static int[] getNum(int[] candidates) {
        for (int i = 0; i < candidates.length; i++) {
            if (i == 0) {
                continue;
            }
            candidates[i] = candidates[i] + candidates[i - 1];
        }
        return candidates;
    }


}
    /*
    * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 

提示：

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500
通过次数201,080提交次数279,575

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
