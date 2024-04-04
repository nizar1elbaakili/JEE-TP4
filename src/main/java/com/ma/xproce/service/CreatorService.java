package com.ma.xproce.service;

import com.ma.xproce.dao.entities.Creator;
import com.ma.xproce.dao.repositories.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreatorService implements CreatorManager{

    @Autowired
    CreatorRepository creatorRepository;
    @Override
    public Creator addCreator(Creator creator) {
        return creatorRepository.save(creator);
    }

    @Override
    public boolean deleteCreatorById(Integer id) {
        creatorRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteAllCreators() {
        creatorRepository.deleteAll();
        return true;
    }

    @Override
    public List<Creator> getAllCreators() {
        return creatorRepository.findAll();
    }

    @Override
    public Creator getCreatorById(Integer id) {
       return  creatorRepository.getReferenceById(id);

    }
}
