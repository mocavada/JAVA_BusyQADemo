package com.busyqa.project.guestbook;

import com.busyqa.project.guestbook.pojo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Controller
public class GuestbookController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GuestbookService guesbookService;

    //========
    @GetMapping("guestbook.html")
    public String getMessageList(Map<String, Object> model) {
        guesbookService.getMessageList();
        model.put("messageList", guesbookService.getMessageList());

        return "project/guestbook";
    }

    @PostMapping("guestbook.html")
    public String msgSubmit(Message message, Map<String, Object> model) {
        guesbookService.postMessage(message);



        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        model.put("messageList", guesbookService.getMessageList());
//        Stream.of(guesbookService.getMessageList()).forEach(System.out::println);

        return "project/guestbook";
    }
}

