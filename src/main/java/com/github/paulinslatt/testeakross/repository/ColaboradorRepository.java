package com.github.paulinslatt.testeakross.repository;

import com.github.paulinslatt.testeakross.entity.ColaboradorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<ColaboradorEntity, Long> {

    Page<ColaboradorEntity> findByNome(String nome, Pageable pageable);

}
