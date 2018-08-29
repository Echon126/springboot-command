package com.example.demo.thread.stampedlock;

import java.util.concurrent.locks.StampedLock;

/**
 * 读写锁的改进版本 StampedLock
 *
 */
public class StampedLockDemo {
    private double x,y;
    private final StampedLock sl = new StampedLock();


    private void move (double  deltaX,double deltaY){
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            //释放写锁
            sl.unlockWrite(stamp);
        }
    }

    public double distanceFromOrigin() { // A read-only method
        /**
         * tryOptimisticRead是一个乐观的读，使用这种锁的读不阻塞写
         * 每次读的时候得到一个当前的stamp值
         */
        long stamp = sl.tryOptimisticRead();
        double currentX = x, currentY = y;

        /**
         * validate()方法校验从调用tryOptimisticRead()之后有没有线程获得写锁，
         *     true:无写锁，state与stamp匹配
         *     false:有写锁，state与stamp不匹配，或者stamp=0（调用tryOptimisticRead()时已经被其他线程持有写锁）
         */
        if (!sl.validate(stamp)) {
            /**
             * 被写锁入侵需要使用悲观读锁重读，阻塞写锁（防止再次出现脏数据） 或者 等待写锁释放锁
             * 当然重读的时候还可以使用tryOptimisticRead，此时需要结合循环了，即类似CAS方式
             */
            stamp = sl.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                //释放读锁
                sl.unlockRead(stamp);
            }
        }
        return (currentX +  currentY);
    }
    public void moveIfAtOrigin(double newX, double newY) {
        // 以乐观读锁的方式开始，而不是悲观读锁
        long stamp = sl.readLock();
        try {
            while (x == 0.0 && y == 0.0) {
                /**
                 * 尝试转换成写锁
                 *     0：获得写锁失败
                 *     非0：获得写锁成功
                 */
                long ws = sl.tryConvertToWriteLock(stamp);
                //持有写锁
                if (ws != 0L) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                }
                //否则调用writeLock()直到获得写锁
                else {
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        } finally {
            //释放锁，可以是writeLock，也可是readLock
            sl.unlock(stamp);
        }
    }
}
