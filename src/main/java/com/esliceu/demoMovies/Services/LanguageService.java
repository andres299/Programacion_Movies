package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Repositorys.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
    @Autowired
    LanguageRepo languageRepo;
}
