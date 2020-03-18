package com.cyzs.ice.hello.server.impl;

import com.cyzs.ice.hello.server.autogenerate.Hello;
import com.zeroc.Ice.Current;

import java.util.Date;

/**
 * @Description:
 * @Author xh
 * @create 2020-03-18 15:12
 */
public class HelloImpl implements Hello {
    @Override
    public String SayHello(String username, Current current) {
        return username + new Date().toString();
    }
}
