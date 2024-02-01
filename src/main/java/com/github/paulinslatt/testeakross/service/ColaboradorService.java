package com.github.paulinslatt.testeakross.service;

import com.github.paulinslatt.testeakross.dto.ColaboradorDTO;

import java.util.List;

public interface ColaboradorService {

    ColaboradorDTO salvar(ColaboradorDTO dto);

    List<ColaboradorDTO> listarTodos();

    ColaboradorDTO consultarPorId(Long id);

}


