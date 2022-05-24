package ru.learnup.myproject.socialmedia.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.myproject.socialmedia.entity.News;
import ru.learnup.myproject.socialmedia.repository.NewsRepository;

import java.util.List;

@Service
public class NewsService {
    private NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> showAllNews() {
        List<News> news = newsRepository.findAll();
        return news;

    }

    public List<News> findAllByNewsContains(String fi) {
        List<News> list = newsRepository.findAllByNewsContains(fi);
        return list;
    }


}
