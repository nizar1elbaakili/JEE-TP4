package com.ma.xproce;

import com.ma.xproce.dao.entities.Creator;
import com.ma.xproce.dao.entities.Video;
import com.ma.xproce.dao.repositories.CreatorRepository;
import com.ma.xproce.dao.repositories.VideoRepository;
import com.ma.xproce.service.CreatorManager;
import com.ma.xproce.service.CreatorService;
import com.ma.xproce.service.VideoManager;
import com.ma.xproce.service.VideoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner start(VideoManager videoManager, CreatorManager creatorManager)
    {
        return  (args -> {
            Creator creator = new Creator();
            creator.setName("KAYNE WEST");
            creator.setEmail("KAYNE@mail.com");

            Creator creator2 = new Creator();
            creator2.setName("Tame impala");
            creator2.setEmail("Tame@mail.com");

            Video vid1 = new Video();
            vid1.setName("Coldplay - Adventure Of A Lifetime (Official Video) 2");
            vid1.setDescription("Coldplay - Adventure Of A Lifetime (Official Video) ");
            vid1.setUrl("https://www.youtube.com/watch?v=QtXby3twMmI");
            vid1.setDatePublication(new Date());
            vid1.setCreator(creator);

            Video vid2 = new Video();
            vid2.setName("Can You Hear The Music ");
            vid2.setDescription("Oppenheimer Soundtrack ");
            vid2.setUrl("https://www.youtube.com/watch?v=YEbsbQtTvHs");
            vid2.setDatePublication(new Date());
            vid2.setCreator(creator);
            Collection<Video> vids = new ArrayList<Video>();
            vids.add(vid1);
            vids.add(vid2);
            creator.setVideos(vids);
            //
            creatorManager.addCreator(creator);
            creatorManager.addCreator(creator2);
            videoManager.addVideo(vid1);
            videoManager.addVideo(vid2);
        });
    }
}
