package nube.tp.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nube.tp.clientes.domains.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
}
