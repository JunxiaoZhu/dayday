package concurrent;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.stream.IntStream;

public class LockFreeStack<T> {

    static class Node<T> {

        Node<T> next;
        T value;

        public Node(T value){
            this.value = value;
            this.next = null;
        }
    }


    AtomicStampedReference<Node<T>> head;
    public LockFreeStack(){
        var headNode = new Node<T>(null);
        head = new AtomicStampedReference<>(headNode, 0);
    }

    public void push(T v){
        var newNode = new Node<T>(v);
        while(true) {
            int stamp = head.getStamp();
            Node<T> ref = head.getReference();
            newNode.next = ref;
            if(head.compareAndSet(ref, newNode, stamp, stamp+1)) {
                return;
            }
        }

    }

    public T pop(){
        while (true) {
            int stamp = head.getStamp();
            Node<T> ref = head.getReference();
            if(ref.next == null) {
                return null;
            }
            var next = ref.next;
            head.compareAndSet(ref, next, stamp, stamp+1);
            return ref.value;
        }
    }




    @Test
    public void testSingle(){

        var stack = new LockFreeStack<Integer>();

        for(int i = 0; i < 100; i++) {
            stack.push(i);
        }

        Integer j = null;
        Integer i = 99;
        while((j = stack.pop()) != null) {
            assertEquals(j+"", i-- +"");
        }
    }

    @Test
    public void testMultiThreads() throws InterruptedException {
        var stack = new LockFreeStack<Integer>();


        IntStream.range(0, 16)
                .mapToObj(i -> {
                    var t = new Thread(() -> {
                        for (int j = 0; j < 100; j++) {
                            stack.push(j);
                        }
                    });
                    t.start();
                    return t;
                })

                .forEach(t -> {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        Integer c = 0;
        while(stack.pop() != null) {
            c ++;
        }


        assertEquals(c+"", "1600");


    }

}
