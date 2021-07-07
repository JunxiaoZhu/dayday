package datatype;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *         实现LRU算法
 * @author JunxiaoZhu
 */
public class NewLinedHashMap<K,V> extends LinkedHashMap<K,V> {

    private static final Integer sizeMax = 5;

    @Override
    public  boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > sizeMax;
    }

    /**
     * 第一个参数：初始容量，默认16
     * 第二个参数：加载因子，默认0.75f
     * 第三个参数：是否按照使用次数排序，使用越多排名越靠后，次数相同，刚刚使用的更靠后
     */
    NewLinedHashMap(int i,float fl,boolean bool){
        super(i,fl,bool);
    }

}
