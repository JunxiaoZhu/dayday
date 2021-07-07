package datatype;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author JunxiaoZhu
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap(new Comparator<String>() {   //自定义比较器
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);  //升序,默认升序
                //return o1.compareTo(o2);  //降序
            }
        });
        treeMap.put("A3","A33");
        treeMap.put("A1","A11");
        treeMap.put("A5","A55");
        treeMap.put("A2","A22");
        treeMap.put("A4","A44");
        //{A1=A11, A2=A22, A3=A33, A4=A44, A5=A55}
        System.out.println(treeMap);
    }

}
