package com.momo.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author momo
 * @create 2020-03-02 下午 18:05
 */
public class RandomRule_MO extends AbstractLoadBalancerRule {

    /**
     * total = 0  当 total == 5以后，我们指针才能往下走
     * index = 0 当前掉外提供服务的服务器地址
     * 分析: 我们 5次，但是微服务只有8001 8002 8003    [私有变量不会牵扯到线程安全问题]
     *
     * 因为Java运行时数据区，虚拟机栈或者本地方法栈（执行方法所在的内存区域）是线程私有的，
     * 每个线程都有自己的虚拟机栈存储区和本地方法栈，所以线程在执行方法时，方法内部的变量不会牵扯到共享这一原则。
     * 只有共享内存才会牵扯到非线程安全问题，实例变量在堆内存
     */
    //总共被调用的次数,目前要求每台被调用5次
    private int total = 0;
    //当前提供服务的机器号
    private int currentIndex = 0;

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            //活着的对外提供服务的机器
            List<Server> upList = lb.getReachableServers();
            //获取所有机器
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }
            //随机获取的机器下标
            //int index = chooseRandomInt(serverCount);
            //根据下标返回对应的机器
            //server = upList.get(index);

            if (total<5){
                server = upList.get(currentIndex);
                total++;
            }else {
                total = 0;
                currentIndex++;
//                server = upList.get(currentIndex);
                if(currentIndex >= upList.size()){
                    currentIndex = 0;
                }
            }


            if (server == null) {
                //暂停当前线程，主动让出自己的CPU时间
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }


            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        //多线程下 生成的随机数  ThreadLocalRandom.current().nextInt(3)
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}