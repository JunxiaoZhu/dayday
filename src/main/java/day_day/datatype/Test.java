package day_day.datatype;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 *         测试类
 * @author JunxiaoZhu
 */
public class Test {

    public static void main(String[] args) {
        Stream<String> integerStream = Stream.of("111", "222", "333");
        integerStream.map(o -> Integer.parseInt(o))
                .reduce(new BinaryOperator<Integer>(){
                    @Override
                    public Integer apply(Integer o, Integer o2) {
                        if(o>o2){
                            return o;
                        }else{
                            return o2;
                        }
                    }
                }).stream().forEach(System.out::println);

    }

}
