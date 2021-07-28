package day_day.datatype;

import java.util.*;

/**
 *         利用Iterable实现随机序列产生器
 * @author JunxiaoZhu
 */
public class IteratorTest<T> implements Iterable<T> {

    private final List<T> listTy;


    public IteratorTest(List<T> list) {
        this.listTy = list;
    }

    public void show(){
        System.out.println(listTy);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public T next() {
                return listTy.get((int) (listTy.size() * Math.random()));
            }
        };
    }

    public static void main(String[] args) {
        List<String> listTy = new ArrayList<>();
        listTy.add("A1");
        listTy.add("A2");
        listTy.add("A3");
        Object[] objects = listTy.toArray();
        String[] strings = listTy.toArray(String[]::new);
        /**
         * 输出：
         * A1
         * A2
         * A3
         */
        listTy.forEach(o -> System.out.println(o));
        listTy.forEach(o -> System.out.println(o));
        //listTy.stream().map()
        /*var ty = new IteratorTest(listTy);
        for(var ok : ty){
            System.out.println(ok);
        }*/
    }

}
