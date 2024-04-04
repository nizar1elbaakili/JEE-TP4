package com.ma.xproce.service;

import com.ma.xproce.dao.entities.Video;

import java.util.Collection;
import java.util.List;

public interface VideoManager {
    public Video addVideo(Video video);
    public Boolean DeleteVideoById(Integer id);
    public Boolean DeleteAllVideos();
    public List<Video> getAllVideos();
}

