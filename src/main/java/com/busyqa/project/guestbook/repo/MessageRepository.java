package com.busyqa.project.guestbook.repo;

import com.busyqa.project.guestbook.pojo.Message;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends PagingAndSortingRepository<Message, Integer> {

}

