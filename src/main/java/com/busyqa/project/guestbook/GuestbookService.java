package com.busyqa.project.guestbook;

import com.busyqa.project.guestbook.pojo.Message;
import com.busyqa.project.guestbook.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestbookService {
    @Autowired
    private MessageRepository messageRepository;

    public GuestbookService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    //create
    public Message postMessage(Message message) {
        return this.messageRepository.save(message);
    }

    //Read
    public List<Message> getMessageList() {
        List<Message> list = new ArrayList<>();
        messageRepository.findAll(new Sort(Sort.Direction.DESC, "postDate")).forEach(list::add);

        return list;
    }
}
