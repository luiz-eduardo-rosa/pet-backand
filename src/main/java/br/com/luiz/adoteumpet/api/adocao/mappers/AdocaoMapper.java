package br.com.luiz.adoteumpet.api.adocao.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.luiz.adoteumpet.api.adocao.dtos.AdocaoRequest;
import br.com.luiz.adoteumpet.api.adocao.dtos.AdocaoResponse;
import br.com.luiz.adoteumpet.api.pet.mappers.PetMapper;
import br.com.luiz.adoteumpet.core.models.Adocao;
import br.com.luiz.adoteumpet.core.repositories.PetRepository;

@Component
public class AdocaoMapper {
    
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;
    
    public Adocao toModel(AdocaoRequest adocaoRequest) {
        var adocao = new Adocao();
        adocao.setEmail(adocaoRequest.getEmail());    
        adocao.setValor(adocaoRequest.getValor());
        adocao.setPet(petRepository.findbyIdOrElseThrow(adocaoRequest.getPetId()));
        return adocao;
    } 

    public AdocaoResponse toResponse(Adocao adocao) {
        var adocaoResponse = new AdocaoResponse();
        adocaoResponse.setId(adocao.getId());
        adocaoResponse.setEmail(adocao.getEmail());
        adocaoResponse.setValor(adocao.getValor());
        adocaoResponse.setPet(petMapper.toResponse(adocao.getPet()));
        return adocaoResponse;
    }

}
