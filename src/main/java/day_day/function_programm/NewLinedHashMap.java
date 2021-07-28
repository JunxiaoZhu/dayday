package day_day.function_programm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *         实现LRU算法
 * @author JunxiaoZhu
 */
public class NewLinedHashMap<K,V> extends LinkedHashMap<K,V> {

    private static final Integer sizeMax = 5;

    /**
     * 第一种方式实现LRU
     * @param eldest
     * @return
     */
    @Override
    public  boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return false;                         //返回true的时候移除最久没有使用的元素
    }

    /**
     * 第一个参数：初始容量，默认16
     * 第二个参数：加载因子，默认0.75f
     * 第三个参数：是否按照使用次数排序，使用越多排名越靠后，次数相同，刚刚使用的更靠后
     */
    NewLinedHashMap(int i,float fl,boolean bool){
        super(i,fl,bool);
    }

    public static void main(String[] args) {
        NewLinedHashMap lru = new NewLinedHashMap(16,0.75f,true);
        lru.put("A1","1");
        lru.put("A2","2");
        lru.put("A3","3");
        lru.put("A4","4");
        lru.put("A5","5");
        lru.put("A6","6");
        System.out.println(lru);

    }

}
