package com.busyqa.guestbook;

import com.busyqa.course.pojo.City;
import com.busyqa.course.repo.CityRepositoryImpl;
import com.busyqa.course.service.CityDataService;
import com.busyqa.project.guestbook.GuestbookService;
import com.busyqa.project.guestbook.pojo.Message;
import com.busyqa.project.guestbook.repo.MessageRepository;
import com.busyqa.project.pictureupload.StorageService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Ignore
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class GuestbookDataServiceUnitTest {

    @Mock
    private MessageRepository messageRepository;
    @InjectMocks
    private GuestbookService guestbookService;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPostMessage() {

        // Create a city
        Message aMockCity = new Message("James", "james.busyqa@gmail.com", "I like Summer");
        when(messageRepository.save(any(Message.class))).thenReturn(aMockCity);

        // Save the city, but it will be intercepted by Mokito
        Message newMsg = guestbookService.postMessage(new Message());

        // Verify the save
        assertEquals("James", newMsg.getUserName());

    }
}
