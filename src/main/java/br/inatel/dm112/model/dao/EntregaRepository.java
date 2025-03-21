package br.inatel.dm112.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.inatel.dm112.model.entities.EntregaEntity;

@Repository
public interface EntregaRepository extends JpaRepository<EntregaEntity, Integer>
{
}
