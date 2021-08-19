package nube.tp.clientes.services;

import nube.tp.clientes.domains.Cliente;
import nube.tp.clientes.domains.Obra;
import nube.tp.clientes.domains.TipoObra;
import nube.tp.clientes.repositories.ClienteRepository;
import nube.tp.clientes.repositories.ObraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ObraService {

    @Autowired
    ObraRepository obraRepository;

	@Autowired
    ClienteRepository clienteRepository;

    public List<Obra> getObras(Integer id, TipoObra tipoObra, Integer clienteId) {
		if (id != null) {
			Optional<Obra> result = obraRepository.findById(id);
			if (result.isPresent()) return Arrays.asList(result.get());
			else return Arrays.asList();
		}
        if (tipoObra != null) return obraRepository.findByTipoObra(tipoObra.name());
		if (clienteId != null) return obraRepository.findByClienteId(clienteId);
		return obraRepository.findAll();
    }

	public Obra agregarObra(Obra obra, Integer clienteId) {
		Cliente cliente = clienteRepository.findById(clienteId).get();
		cliente.obras.add(obra);
		cliente = clienteRepository.save(cliente);
		return cliente.obras.get(cliente.obras.size()-1);
    }

	public Obra updateObra(Obra obra) {
		Obra obraToUpdate = obraRepository.findById(obra.id).get();
		if (obra.descripcion != null) obraToUpdate.descripcion = obra.descripcion;
		if (obra.direccion != null) obraToUpdate.direccion = obra.direccion;
		if (obra.tipo != null) obraToUpdate.tipo = obra.tipo;
		if (obra.latitud != null) obraToUpdate.latitud = obra.latitud;
		if (obra.longitud != null) obraToUpdate.longitud = obra.longitud;
		if (obra.superficie != null) obraToUpdate.superficie = obra.superficie;
		return obraRepository.save(obraToUpdate);
    }

	public String deleteObra(Integer obraId) {
		obraRepository.deleteById(obraId);
		return "Obra eliminada exitosamente."; 
	}
}
