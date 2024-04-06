package com.example.task.web.mapper;

import com.example.task.domain.Parties;
import com.example.task.web.dto.PartiesDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PartiesMapper {

    PartiesDto toDto(Parties parties);

    Parties toEntity(PartiesDto dto);

}
