package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Keyword;
import com.esliceu.demoMovies.Repositorys.KeywordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService {
    @Autowired
    KeywordRepo keywordRepo;

    public List<?> findAll() {
        return keywordRepo.findAll();
    }

    public Keyword findFirstByOrderByKeywordIdDesc() {
        return keywordRepo.findFirstByOrderByKeywordIdDesc();
    }
    public void save(Keyword keyword) {
        keywordRepo.save(keyword);
    }

    public void deleteById(long entityId) {
        keywordRepo.deleteById(entityId);
    }

    public int ifEntitiExist(int entityId) {
        return keywordRepo.ifEntitiExist(entityId);
    }

    public List<?> findByKeywordNameStartingWithIgnoreCase(String keyword) {
        return keywordRepo.findByKeywordNameStartingWithIgnoreCase(keyword);
    }

}
