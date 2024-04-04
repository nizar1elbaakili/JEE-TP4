package com.ma.xproce.dao.repositories;

import com.ma.xproce.dao.entities.Creator;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<Creator,Integer> {
    public Creator findCreatorById(Integer id);
}
