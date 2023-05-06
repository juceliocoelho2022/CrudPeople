package com.Desenvolvedor.People.service;

import com.Desenvolvedor.People.dto.request.PersonRequestDTO;
import com.Desenvolvedor.People.dto.response.PersonResponseDTO;

import java.util.List;

public interface PersonService {

    PersonResponseDTO findById(Long id);
        List<PersonResponseDTO> findAll();

        PersonResponseDTO register(PersonRequestDTO personDTO);

        PersonResponseDTO update( Long id, PersonRequestDTO personDTO);

        String delete(Long id);
}
