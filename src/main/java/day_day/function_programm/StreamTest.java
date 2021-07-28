package day_day.function_programm;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *         流处理
 * @author JunxiaoZhu
 */
public class StreamTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("ydaiq");
        list.add("欧阳娜娜");
        list.add("高圆圆");
        list.add("张三丰");
        list.add("张无忌");
        list.add("张阳");



        list.stream().map(o->o.toString()).filter(o->o.length() >= 3).distinct().collect(Collectors.toList());

        //使用Stream流的方式进行筛选
        //筛选以"张"开头的名字
        list.stream().filter(name -> name.startsWith("张"))
                //筛选长度为 3 的名字
                .filter(name -> name.length() == 3)
                .sorted()    //排序
                .distinct()   //去重
                //使用Stream流提供的 forEach 方法来输出
                .forEach(name-> System.out.println(name));

    }

}
