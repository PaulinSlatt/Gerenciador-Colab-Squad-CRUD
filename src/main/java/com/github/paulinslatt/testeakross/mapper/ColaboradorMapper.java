package com.github.paulinslatt.testeakross.mapper;

import com.github.paulinslatt.testeakross.dto.ColaboradorDTO;
import com.github.paulinslatt.testeakross.entity.ColaboradorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ColaboradorMapper {

    ColaboradorEntity toEntity(ColaboradorDTO dto);

    @Mapping(target = "squad.colaboradores", ignore = true)
    ColaboradorDTO toDto(ColaboradorEntity entity);

    @Named("toDtoSemSquad")
    @Mapping(target = "squad", ignore = true)
    ColaboradorDTO toDtoSemSquad(ColaboradorEntity entity);

}
