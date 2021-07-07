package datatype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *         利用Iterator实现随机序列产生器
 * @author JunxiaoZhu
 */
public class IteratorTest implements Iterator {

    private List<String> listTy = new ArrayList<>();

    IteratorTest(List<String> list){
        listTy = list;
    }

    //还有没有下一个
    @Override
    public boolean hasNext() {
        return true;
    }

    //下一个
    @Override
    public String next() {
        return listTy.get((int)(listTy.size()*Math.random()));
    }


    public static void main(String[] args) {
        List<String> listTy = new ArrayList<>();
        listTy.toArray(new String[]{"A1","A2","A3"});
        IteratorTest ty = new IteratorTest(listTy);
        while (ty.hasNext()){
            String next = ty.next();
            System.out.println(next);
        }
    }



}
