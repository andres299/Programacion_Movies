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
    // Obtiene todas las entidades Keyword paginadas.
    public List<?> findAll(Pageable pageable) {
        return keywordRepo.findAll(pageable).getContent();
    }
    // Obtiene la primera palabra clave ordenada por ID de forma descendente.
    public Keyword findFirstByOrderByKeywordIdDesc() {
        return keywordRepo.findFirstByOrderByKeywordIdDesc();
    }
    // Guarda una nueva palabra clave.
    public void save(Keyword keyword) {
        keywordRepo.save(keyword);
    }
    // Elimina una palabra clave por su ID.
    public void deleteById(long entityId) {
        keywordRepo.deleteById(entityId);
    }
    // Cuenta la cantidad de palabras clave con un ID específico.
    public int countKeywordsByKeywordId(int entityId) {
        return keywordRepo.countKeywordsByKeywordId(entityId);
    }
    // Busca palabras clave cuyos nombres comienzan con la palabra clave proporcionada.
    public List<?> findByKeywordNameStartingWithIgnoreCase(String keyword, Pageable pageable) {
        return keywordRepo.findByKeywordNameStartingWithIgnoreCase(keyword,pageable);
    }
}
