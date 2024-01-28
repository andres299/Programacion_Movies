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
    // Obtiene todas las entidades Gender paginadas.
    public List<?> findAll(Pageable pageable) {
        return genderRepo.findAll(pageable).getContent();
    }
    // Obtiene el primer género ordenado por ID de forma descendente.
    public Gender findFirstByOrderByGenderIdDesc() {
        return genderRepo.findFirstByOrderByGenderIdDesc();
    }
    // Guarda un nuevo género.
    public void save(Gender gender) {
        genderRepo.save(gender);
    }
    // Elimina un género por su ID.
    public void deleteById(long entityId) {
        genderRepo.deleteById(entityId);
    }
    // Cuenta la cantidad de géneros con un ID específico.
    public int countGendersByGenderId(int entityId) {
        return genderRepo.countGendersByGenderId(entityId);
    }
    // Busca géneros cuyos nombres comienzan con la palabra clave proporcionada.
    public List<?> findByGenderStartingWithIgnoreCase(String keyword, Pageable pageable) {
        return genderRepo.findByGenderStartingWithIgnoreCase(keyword,pageable);
    }
    // Obtiene un género por su ID.
    public Gender findByGenderId(int genre) {
        return genderRepo.findByGenderId(genre);
    }
}
