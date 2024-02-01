package com.github.paulinslatt.testeakross.service;

import com.github.paulinslatt.testeakross.dto.SquadDTO;

import java.util.List;

public interface SquadService {

    SquadDTO salvar(SquadDTO dto);

    List<SquadDTO> listarTodos();

    SquadDTO consultarPorId(Long id);

    SquadDTO adicionarColaborador(Long idColaborador, Long idSquad);

}


