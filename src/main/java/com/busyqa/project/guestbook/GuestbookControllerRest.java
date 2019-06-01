package com.busyqa.project.guestbook;

import com.busyqa.project.guestbook.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestbookControllerRest {
    @Autowired
    private GuestbookService guesbookService;

    //========
    @RequestMapping(method = RequestMethod.GET, value = "/messages")
    public List<Message> listAllAndSort() {

        return this.guesbookService.getMessageList();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/message")
//    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    List<Message> createJob(@RequestBody Message msg) {
        Message newMsg = this.guesbookService.postMessage(msg);
        return this.guesbookService.getMessageList();
    }
}
