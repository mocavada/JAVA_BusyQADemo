package com.busyqa.guestbook;

import com.busyqa.course.pojo.City;
import com.busyqa.course.repo.CityRepositoryImpl;
import com.busyqa.project.guestbook.pojo.Message;
import com.busyqa.project.guestbook.repo.MessageRepository;
import com.busyqa.project.pictureupload.StorageService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Ignore
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class GuestbookRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MessageRepository messageRepository;

    @MockBean
    StorageService storageService;

    @Test
    public void testFindByID() {

        // Create a city
        Message msg = new Message("James", "james.busyqa@gmail.com", "I like Summer");

        // save test data
        Message savedMsg = entityManager.persist(msg);

        // cityRepositoryImpl.save(city);

        // Find an inserted record
        Message foundMsg = messageRepository.findById(savedMsg.getId()).get();

        assertThat(msg.getUserName(), is(equalTo("James")));

        messageRepository.delete(foundMsg);
    }

}
