package com.example.demo.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author admin
 * @date 2018-9-10 16:04
 */
public class CacheUtils {
    private static  int threadCount = 4;
    private long maximumSize = 100000;
    private long expireAfterAccess = 8;

    private LoadingCache<String, Object> cache;

    public CacheUtils() {
        this.cache = CacheBuilder.newBuilder().maximumSize(maximumSize).expireAfterWrite(expireAfterAccess, TimeUnit.HOURS)
                .build(new CacheLoaderData());
    }

    private class CacheLoaderData extends CacheLoader<String, Object> {
        @Override
        public Object load(String key) throws Exception {
            System.out.println("加载数据--------");
            return createExpensiveGraph(key);
        }

        //TODO 该方法可以根据业务逻辑进行自定义
        private Object createExpensiveGraph(String key) {
            System.out.println("load into cache!" + "key" + key);
            //TODO 实际项目中此处可实现数据库数据查询操作
            //TODO 1.根据key查询如缓存中存在数据，则从缓存中读取数据，否则从数据库中查询数据并进行缓存
            return "hello " + key + "!";
        }
    }


    public Object getCache(String key) throws ExecutionException {
        return cache.get(key);
    }

    public void putCache(String key, Object obj) {
        cache.put(key, obj);
    }

    public static void main(String[] args) throws ExecutionException {
        CacheUtils cacheUtils = new CacheUtils();
        Executor executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i <threadCount;i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < 200; i++) {
                            System.out.println(Thread.currentThread().getName() + "----" + cacheUtils.getCache("1"));
                            //TimeUnit.SECONDS.sleep(1);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }

}
