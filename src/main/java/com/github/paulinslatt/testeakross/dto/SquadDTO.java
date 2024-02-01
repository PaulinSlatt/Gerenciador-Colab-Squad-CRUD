package com.github.paulinslatt.testeakross.dto;

import java.util.List;

public record SquadDTO(Long id, String nome, List<ColaboradorDTO> colaboradores) {

}
