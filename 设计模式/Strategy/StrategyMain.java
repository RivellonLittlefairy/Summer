package Strategy;

import java.util.Arrays;

/*
一图胜千言，策略模式就是替换实现的算法或者策略
比如根据传入的用户描述接口，来决定进行怎样的折扣
比如sort函数，传入的是基本数据类型就进行快速排序
是引用类型就归并排序
 */
public class StrategyMain {
    public static void main(String[] args) {
        Arrays.sort(new String[]{"1","2"});
    }
}
