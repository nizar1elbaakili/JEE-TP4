package com.ma.xproce.service;

import com.ma.xproce.dao.entities.Creator;

import java.util.List;

public interface CreatorManager {
    public Creator addCreator(Creator creator);
    public boolean deleteCreatorById(Integer id);
    public boolean deleteAllCreators();
    public List<Creator> getAllCreators();
    public Creator getCreatorById(Integer id);
}
