package com.github.paulinslatt.testeakross.repository;

import com.github.paulinslatt.testeakross.entity.SquadEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadRepository extends JpaRepository<SquadEntity, Long> {

    Page<SquadEntity> findByNome(String nome, Pageable pageable);

}
