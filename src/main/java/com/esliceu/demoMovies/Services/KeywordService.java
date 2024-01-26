package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Keyword;
import com.esliceu.demoMovies.Repositorys.KeywordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService {
    @Autowired
    KeywordRepo keywordRepo;

    public List<?> findAll(Pageable pageable) {
        return keywordRepo.findAll(pageable).getContent();
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

    public int countKeywordsByKeywordId(int entityId) {
        return keywordRepo.countKeywordsByKeywordId(entityId);
    }
    public List<?> findByKeywordNameStartingWithIgnoreCase(String keyword) {
        return keywordRepo.findByKeywordNameStartingWithIgnoreCase(keyword);
    }
}
