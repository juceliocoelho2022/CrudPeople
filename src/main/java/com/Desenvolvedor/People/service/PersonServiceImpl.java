package com.Desenvolvedor.People.service;

import com.Desenvolvedor.People.dto.request.PersonRequestDTO;
import com.Desenvolvedor.People.dto.response.PersonResponseDTO;
import com.Desenvolvedor.People.entity.Person;
import com.Desenvolvedor.People.repository.PersonRepository;
import com.Desenvolvedor.People.util.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImpl implements  PersonService{

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;
    @Override
    public PersonResponseDTO findById(Long id) {

      return personMapper.toPersonDTO(returnPerson(id));
    }

    @Override
    public List<PersonResponseDTO> findAll() {

        return  personMapper.toPeopleDTO(personRepository.findAll());
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {

        Person person = personMapper.toPerson(personDTO);
        return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public PersonResponseDTO update(Long id, PersonRequestDTO personDTO ) {
        Person person = returnPerson(id);

          personMapper.updatePersonData(person, personDTO);

          return  personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public String delete(Long id) {

         personRepository.deleteById(id);
         return "Person id: " +id+ "deleted";

    }
    private Person returnPerson(Long id){
      return   personRepository.findById(id).orElseThrow(()-> new RuntimeException("Person wasn't fount on database"));

    }

}
