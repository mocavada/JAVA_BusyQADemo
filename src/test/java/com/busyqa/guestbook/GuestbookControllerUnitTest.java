package com.busyqa.guestbook;

import com.busyqa.course.controller.RESTController;
import com.busyqa.course.service.BookDataService;
import com.busyqa.course.service.CityDataService;
import com.busyqa.project.guestbook.GuestbookService;
import com.busyqa.project.guestbook.pojo.Message;
import com.busyqa.project.pictureupload.StorageService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RESTController.class)
@Ignore
@SuppressWarnings("unchecked")
public class GuestbookControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CityDataService cityDataService;

    @MockBean
    GuestbookService guestbookService;

    @MockBean
    BookDataService bookDataService;

    @MockBean
    StorageService storageService;

    @InjectMocks
    RESTController mokeRESTController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddMessage() throws Exception {
        // setup mock Message returned the mock service component
        Message aMockMsg = new Message("James", "james.busyqa@gmail.com", "I like Summer");

        when(guestbookService.postMessage(any(Message.class)))
                .thenReturn(aMockMsg);

        // simulate the form bean that would POST from the web page
        Message aMsg = new Message("James", "james.busyqa@gmail.com", "I like Summer");

        String json = (new Gson()).toJson(aMsg, Message.class);

        // simulate the form submit (POST)
        mockMvc.perform(
                post("/message").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated())
                .andReturn();

//        mockMvc.perform(
//                post("/city/").contentType(MediaType.APPLICATION_JSON).content(json))
//                .andExpect(status().isCreated())
//                .andReturn();

    }

}
