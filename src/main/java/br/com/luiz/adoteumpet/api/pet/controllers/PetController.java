package br.com.luiz.adoteumpet.api.pet.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luiz.adoteumpet.api.pet.dtos.PetResponse;
import br.com.luiz.adoteumpet.api.pet.mappers.PetMapper;
import br.com.luiz.adoteumpet.core.models.Pet;
import br.com.luiz.adoteumpet.core.repositories.PetRepository;

@RestController
public class PetController {
    
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;
    
    @GetMapping("/api/pets")
    public List<PetResponse> findAll(){
        var pets = petRepository.findAll();
        var petResponse = new ArrayList<PetResponse>();
        for (Pet pet : pets){
            petResponse.add(petMapper.toResponse(pet));
        }
        return petResponse;
    }
}
