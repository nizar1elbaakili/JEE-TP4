package com.ma.xproce.web;

import com.ma.xproce.dao.entities.Creator;
import com.ma.xproce.dao.entities.Video;
import com.ma.xproce.service.CreatorManager;
import com.ma.xproce.service.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class VideoController {
    @Autowired
    private VideoManager videoManager;
    @Autowired
    private CreatorManager creatorManager;
    @GetMapping(value = "/listAllVideos")
    public String listAllVideos(Model model)
    {
        List<Video> videos = videoManager.getAllVideos();
        model.addAttribute("listvideos",videos);
        model.addAttribute("title","List All Video 2");
        return "Video/listAllVideos";
    }
    @GetMapping(value = "/addVideo")
    public String AddVideo(Model model)
    {
        List<Creator> creators = creatorManager.getAllCreators();
        model.addAttribute("title","Add Video");
        model.addAttribute("creators",creators);
        return "Video/addVideo";
    }
    @PostMapping(value = "/addVideo")
    public String addVideo(Model model ,
                           @RequestParam(name = "name")         String name,
                           @RequestParam(name = "desc")         String descrption,
                           @RequestParam(name = "url")          String url,
                           @RequestParam(name = "creator_id")   String create_id
                           )
    {
        Video vid = new Video();
        vid.setName(name);
        vid.setDescription(descrption);
        vid.setUrl(url);
        vid.setDatePublication(new Date());
        Creator creator = (Creator) creatorManager.getCreatorById(Integer.parseInt(create_id));
        vid.setCreator(creator);
        System.out.println(vid.toString());
        videoManager.addVideo(vid);
        List<Creator> creators = creatorManager.getAllCreators();
        model.addAttribute("status","video added");
        model.addAttribute("creators",creators);
        return "Creator/addVideo";
    }
    @GetMapping(value = "/deleteVideo")
    public String deleteVideo(Model model)
    {
        List<Video> videos = videoManager.getAllVideos();
        model.addAttribute("listvideos",videos);
        model.addAttribute("title","Delete Video");
        return "Video/deleteVideo";
    }
    @PostMapping(value = "/deleteVideo")
    public String deleteVideoId(Model model)
    {
        return "Video/deleteVideo";
    }
}
