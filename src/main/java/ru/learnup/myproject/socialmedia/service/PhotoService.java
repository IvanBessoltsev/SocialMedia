package ru.learnup.myproject.socialmedia.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.myproject.socialmedia.entity.Photo;
import ru.learnup.myproject.socialmedia.repository.PhotoRepository;

import java.util.List;

@Service
public class PhotoService {
    private PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }


    public List<Photo> findAllByImageContaining(String fi) {
        List<Photo> list = photoRepository.findAllByImageContaining(fi);
        return list;
    }




}
