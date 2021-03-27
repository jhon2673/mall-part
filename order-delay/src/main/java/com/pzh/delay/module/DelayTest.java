package com.pzh.delay.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/13 15:56
 * @Version 1.0
 */
@RestController
@RequestMapping("/delay")
public class DelayTest {

    @Autowired
    private DelaySender delaySender;

    @RequestMapping("/send")
    public String send() {
        delaySender.send("delay message", 10000);

        return "send success!";
    }
}
