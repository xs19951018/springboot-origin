package com.my.springbootorigin.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class TestQueue {

    public static void main(String[] args) {
//        Queue queue = new LinkedBlockingQueue();

        List<Integer> ids = new ArrayList<Integer>() {{
            add(1);
        }};

        System.out.println(String.join(",", ids.stream().map(String::valueOf).collect(Collectors.toList())));

        Long i = 0L;
        System.out.println((0L == i));
    }

}
