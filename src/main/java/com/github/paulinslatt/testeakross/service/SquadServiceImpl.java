package com.github.paulinslatt.testeakross.service;

import com.github.paulinslatt.testeakross.dto.SquadDTO;
import com.github.paulinslatt.testeakross.entity.ColaboradorEntity;
import com.github.paulinslatt.testeakross.entity.SquadEntity;
import com.github.paulinslatt.testeakross.mapper.SquadMapper;
import com.github.paulinslatt.testeakross.repository.ColaboradorRepository;
import com.github.paulinslatt.testeakross.repository.SquadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SquadServiceImpl implements SquadService {

    private final SquadRepository squadRepository;
    private final ColaboradorRepository colaboradorRepository;

    private final SquadMapper mapper;

    @Override
    public SquadDTO salvar(SquadDTO dto) {
        SquadEntity squad = mapper.toEntity(dto);
        squadRepository.save(squad);
        return mapper.toDto(squad);

    }

    @Override
    public List<SquadDTO> listarTodos() {
        List<SquadEntity> squads = squadRepository.findAll();
        return squads.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public SquadDTO consultarPorId(Long id) {
        Optional<SquadEntity> optionalSquad = squadRepository.findById(id);
        return optionalSquad.map(mapper::toDto).orElse(null);
    }

    @Override
    public SquadDTO adicionarColaborador(Long idColaborador, Long idSquad) {
        Optional<SquadEntity> optionalSquad = squadRepository.findById(idSquad);
        if (optionalSquad.isPresent()) {
            Optional<ColaboradorEntity> optionalColaborador = colaboradorRepository.findById(idColaborador);
            if (optionalColaborador.isPresent()) {
                SquadEntity squad = optionalSquad.get();
                squad.getColaboradores().add(optionalColaborador.get());
                ColaboradorEntity colaborador = optionalColaborador.get();
                colaborador.setSquad(squad);
                squadRepository.save(squad);

                return mapper.toDto(squad);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Colaborador não encontrado.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Squad não encontrada.");
        }
    }

}
