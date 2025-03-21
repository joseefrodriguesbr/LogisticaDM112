package br.inatel.dm112.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.dm112.model.entities.PedidoEntity;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer>
{
	@Transactional(readOnly = true)
	List<PedidoEntity> findByCPF(String cpf);

	List<PedidoEntity> findByStatus(int status);
}
