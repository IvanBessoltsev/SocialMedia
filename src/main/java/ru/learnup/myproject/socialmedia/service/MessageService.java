package ru.learnup.myproject.socialmedia.service;


import org.springframework.stereotype.Service;
import ru.learnup.myproject.socialmedia.entity.Message;
import ru.learnup.myproject.socialmedia.repository.MessageRepository;

import java.util.List;
@Service
public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> findAllByMessageContaining(String fi) {
        List<Message> list = messageRepository.findAllByMessageContaining(fi);
        return list;
    }
}
