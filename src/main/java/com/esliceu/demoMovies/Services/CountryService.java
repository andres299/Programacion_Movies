package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Country;
import com.esliceu.demoMovies.Repositorys.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepo countryRepo;

    // Obtiene todas las entidades Country paginadas.
    public List<?> findAll(Pageable pageable) {
        return countryRepo.findAll(pageable).getContent();
    }
    //Guardar un nuevo país.
    public void save(Country country) {
        countryRepo.save(country);
    }
    // Eliminar un país por su ID.
    public void deleteById(long entityId) {
        countryRepo.deleteById(entityId);
    }
    // Cuenta la cantidad de países con un ID específico.
    public int countCountriesByCountryId(int entityId) {
        return countryRepo.countCountriesByCountryId(entityId);
    }
    // Busca países cuyos nombres comienzan con el keyword proporcionado.
    public List<?> findByCountryNameStartingWithIgnoreCase(String keyword, Pageable pageable) {
        return countryRepo.findByCountryNameStartingWithIgnoreCase(keyword,pageable);
    }
    // Obtiene una lista paginada de todos los países.
    public List<Country> getAllCountrys(int page) {
        Pageable pageable = PageRequest.of(page,10);
        return countryRepo.findAll(pageable).getContent();
    }
}
