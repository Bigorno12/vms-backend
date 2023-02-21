package com.pacdesign.service.mapper;

import com.pacdesign.persistence.entity.Person;
import com.pacdesign.service.dto.PersonDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person mapToEntity(PersonDto personDto);

    @InheritInverseConfiguration
    PersonDto mapToDto(Person person);
}
