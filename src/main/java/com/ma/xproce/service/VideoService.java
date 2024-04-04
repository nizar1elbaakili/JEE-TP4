package com.ma.xproce.service;

import com.ma.xproce.dao.entities.Video;
import com.ma.xproce.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class VideoService implements VideoManager {

    @Autowired
    VideoRepository videoRepository;
    @Override
    public Video addVideo(Video video) {
        try{
            return videoRepository.save(video);
        }catch(Exception exception)
        {
            System.out.println("Video Exist Already");
            return null;
        }
    }

    @Override
    public Boolean DeleteVideoById(Integer id) {
        videoRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean DeleteAllVideos() {
        videoRepository.deleteAll();
        return true;
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}
