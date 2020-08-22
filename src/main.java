import java.util.ArrayList;
import java.util.List;

/*
*               杨辉三角
* 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
*输入：5
 输出： [
             [1],
            [1,1],
           [1,2,1],
          [1,3,3,1],
         [1,4,6,4,1]
        ]
* */
public class main {
    //杨辉三角特点：1.第一行固定，就是一个1
    // 2.第二行也固定，两个1
    //3.第i行，收尾元素都固定是1
    //4.第i行有i个元素，
    //5.对于第i行来说，第j列的值等于i-1行的j-1列，加上i-1行的j列的值
    public List<List<Integer>>generate(int numRows){
        if (numRows <= 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1){
            return result;
        }
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2){
            return result;
        }
        for (int row = 3; row <= numRows ; row++) {
            //如果想得到row行情况，就得知道row-1行内容，而这里row-1-1是因为数组里面下标从0开始的
            //所以row-1行对应到ArrayList里面就是row-1-1下标
            List<Integer> prevLine = result.get(row-1-1);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            //下面循环是进行列值的计算，从第i行开始 第一个数和最后一个数 都是1，所以col从第2列开始
            for (int col = 2; col < row; col++) {
                //因为列也对应的是一个ArrayList，所以col-1列对应的下标就是col-1-1列
                //col列对应的就是col-1列
                int curNum = prevLine.get(col - 1 - 1) + prevLine.get(col - 1);
                curLine.add(curNum);
            }
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
