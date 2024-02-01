package com.github.paulinslatt.testeakross.mapper;

import com.github.paulinslatt.testeakross.dto.SquadDTO;
import com.github.paulinslatt.testeakross.entity.SquadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, uses = ColaboradorMapper.class)
public interface SquadMapper {

    SquadEntity toEntity(SquadDTO dto);

    @Mapping(target = "colaboradores", qualifiedByName = "toDtoSemSquad")
    SquadDTO toDto(SquadEntity entity);

}
