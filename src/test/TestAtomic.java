package test;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhaoxq
 * @ClassName TestAtomicInteger
 * @description:
 * @date 2024年02月29日
 */

public class TestAtomic {

    /**
     * CAS操作，比较和修改（compare and swap)，返回值是比较结果，布尔类型，比较成功时修改值。是基于硬件指令的原子操作。
     * java里面Unsafe类下的compareAndSet方法就是CAS操作，这个方法是一个本地方法，底层的C++代码中用是汇编指令cpmxchg，源于硬件指令
     * java里面的Atomic包下的Atomic开头的类都封装了操作是compareAndSet方法，这个方法就是调用Unsafe类下的同名方法，
     * Atomic包下面的包都是原子操作的类。
     */
    @Test
    public void test1(){
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(1);
        System.out.println(atomicInteger);
        System.out.println(atomicInteger.compareAndSet(1, 500) + " " + atomicInteger);
        System.out.println(atomicInteger.compareAndSet(1, 500) + " " + atomicInteger);
    }

    static class User{
        String name;
        int age;
        public User(){}
        public User(String name,int age){
            this.name = name;
            this.age = age;
        }
    }

    /**
     * 包装类
     */
    @Test
    public void test2(){
        User user = new User("11", 11);
        User user2 = new User("12", 12);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(user);
        System.out.println(atomicReference.get().name);
        System.out.println(atomicReference.compareAndSet(user, user2) + " " + atomicReference.get().name);
        System.out.println(atomicReference.compareAndSet(user, user2) + " " + atomicReference.get().name);
    }

    /**
     * CAS 实现自旋锁
     */
    public static class SpinLockDemo {
        AtomicReference<Thread> atomicReference = new AtomicReference<>();

        public void lock() {
            Thread thread = Thread.currentThread();
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            while (!atomicReference.compareAndSet(null, thread)) {

            }
        }

        public void unlock() {
            Thread thread = Thread.currentThread();
            atomicReference.compareAndSet(thread, null);
            System.out.println(Thread.currentThread().getName() + "\t" + "---task over , unlock ...");
        }

        public static void main(String[] args) {
            SpinLockDemo spinLockDemo = new SpinLockDemo();
            new Thread(() -> {
                spinLockDemo.lock();
                try {
                    TimeUnit.MILLISECONDS.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                spinLockDemo.unlock();
            }, "A").start();

            new Thread(() -> {
                spinLockDemo.lock();

                spinLockDemo.unlock();
            }, "B").start();

        }
    }

}
