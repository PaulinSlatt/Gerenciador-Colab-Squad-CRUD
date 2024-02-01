package com.github.paulinslatt.testeakross.service;

import com.github.paulinslatt.testeakross.dto.ColaboradorDTO;
import com.github.paulinslatt.testeakross.entity.ColaboradorEntity;
import com.github.paulinslatt.testeakross.mapper.ColaboradorMapper;
import com.github.paulinslatt.testeakross.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {

    @Autowired
    private ColaboradorRepository repository;

    @Autowired
    private ColaboradorMapper mapper;

    @Override
    public ColaboradorDTO salvar(ColaboradorDTO dto) {
        ColaboradorEntity colaborador = mapper.toEntity(dto);
        repository.save(colaborador);
        return mapper.toDto(colaborador);
    }

    @Override
    public List<ColaboradorDTO> listarTodos() {
        List<ColaboradorEntity> colaboradores = repository.findAll();
        return colaboradores.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ColaboradorDTO consultarPorId(Long id) {
        Optional<ColaboradorEntity> optionalColaborador = repository.findById(id);
        return optionalColaborador.map(mapper::toDto).orElse(null);
    }

}

