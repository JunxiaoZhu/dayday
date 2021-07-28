package day_day.datatype;

import java.util.*;

/**
 * @author JunxiaoZhu
 */
public class TreeMapTest {

    public static void main(String[] args) {
        /*TreeMap treeMap = new TreeMap(new Comparator<String>() {   //自定义比较器
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);  //升序,默认升序
                //return o1.compareTo(o2);  //降序
            }
        });*/
        TreeMap<String,String> treeMap = new TreeMap<String,String>((o1,o2) -> o2.compareTo(o1));
        treeMap.put("A3","A33");
        treeMap.put("A1","A11");
        treeMap.put("A5","A55");
        treeMap.put("A2","A22");
        treeMap.put("A4","A44");
        //{A1=A11, A2=A22, A3=A33, A4=A44, A5=A55}
        System.out.println(treeMap);

        Map map = new HashMap();
        //map.entrySet().iterator();
        Set set = map.entrySet();
        set.iterator();


        List list = new ArrayList();
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Collections.sort(list,(String o1,String o2) -> o1.compareTo(o2));

    }


    public void show(String o){

    }

}
