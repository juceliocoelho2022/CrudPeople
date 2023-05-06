package com.Desenvolvedor.People.dto.response;

import com.Desenvolvedor.People.entity.Person;
import lombok.Getter;

@Getter
public class PersonResponseDTO {
    private Long id;

    private String name;

    private String cpf;

    private Integer age;

   public PersonResponseDTO(Person person){
       this.id = person.getId();
       this.name = person.getName();
       this.cpf = person.getCpf();
       this.age = person.getAge();
   }

}
