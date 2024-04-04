package com.ma.xproce.web;

import com.ma.xproce.dao.entities.Creator;
import com.ma.xproce.dao.repositories.CreatorRepository;
import com.ma.xproce.service.CreatorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CreatorController {
    @Autowired
    CreatorManager creatorManager;
    @GetMapping(value = "/listAllCreators")
    public String listAllCreators(Model model)
    {
        List<Creator> creatorList = creatorManager.getAllCreators();
        model.addAttribute("creators",creatorList);
        return "Creator/listAllCreators";
    }
    @GetMapping(value = "/addCreator")
    public String addCreator(Model model)
    {

        return "Creator/addCreator";
    }
    @PostMapping(value = "/addCreator")
    public String addCreator(Model model ,
                             @RequestParam(name = "name")  String name,
                             @RequestParam(name = "email") String email)
    {

        Creator creator =new Creator();
        creator.setName(name);
        creator.setEmail(email);
        creatorManager.addCreator(creator);
        model.addAttribute("status","Creator Has been Added");
        return  "Creator/addCreator";
    }

}
