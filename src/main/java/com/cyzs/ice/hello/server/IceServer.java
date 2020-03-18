package com.cyzs.ice.hello.server;

import com.cyzs.ice.hello.server.impl.HelloImpl;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

/**
 * @Description:
 * @Author xh
 * @create 2020-03-18 14:47
 */
public class IceServer {

    public static void main(String[] args) {

        // 通信器
        Communicator ic = null;
        // 初始化这个通信器
        ic = Util.initialize(args);
        //创建ice适配器,将服务调用地址和服务映射起来 "HelloServiceAdapter"是适配器名, "default -p 1888"是服务调用的地址
        ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints("HelloServiceAdapter","default -p 8888");
        // 将服务的具体实现类servant交给这个适配器
        com.zeroc.Ice.Object servant = new HelloImpl();
        // "HelloIce"--服务接口在ice中注册名,转成唯一标识identity
        Identity id = Util.stringToIdentity("HelloIce");
        //
        adapter.add(servant, id);
        // 激活这个适配器
        adapter.activate();
    }
}
