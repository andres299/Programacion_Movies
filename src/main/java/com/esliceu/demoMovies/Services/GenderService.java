package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Gender;
import com.esliceu.demoMovies.Repositorys.GenderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {
    @Autowired
    GenderRepo genderRepo;

    public List<?> findAll(Pageable pageable) {
        return genderRepo.findAll(pageable).getContent();
    }

    public Gender findFirstByOrderByGenderIdDesc() {
        return genderRepo.findFirstByOrderByGenderIdDesc();
    }
    public void save(Gender gender) {
        genderRepo.save(gender);
    }

    public void deleteById(long entityId) {
        genderRepo.deleteById(entityId);
    }

    public int countGendersByGenderId(int entityId) {
        return genderRepo.countGendersByGenderId(entityId);
    }

    public List<?> findByGenderStartingWithIgnoreCase(String keyword, Pageable pageable) {
        return genderRepo.findByGenderStartingWithIgnoreCase(keyword,pageable);
    }
}
