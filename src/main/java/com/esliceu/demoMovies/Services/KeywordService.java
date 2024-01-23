package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Repositorys.KeywordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeywordService {
    @Autowired
    KeywordRepo keywordRepo;
}
