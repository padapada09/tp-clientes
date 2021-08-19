package nube.tp.clientes.services;

import nube.tp.clientes.domains.Cliente;
import nube.tp.clientes.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getClientes(Integer id, String cuit, String razonSocial, Integer obraId, String username) {
        if (cuit != null) return clienteRepository.findByCuit(cuit);
        if (razonSocial != null) return clienteRepository.findByRazonSocial(razonSocial);
		if (obraId != null) return clienteRepository.findByObraId(obraId);
		if (id != null) {
			Optional<Cliente> result = clienteRepository.findById(id);
			if (result.isPresent()) return Arrays.asList(result.get());
			else return Arrays.asList();
		}
		if (username != null) return clienteRepository.findByUsername(username);
		return clienteRepository.findAll();
    }

	public Cliente agregarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
    }

	public String deleteCliente(Integer clienteId) {
		clienteRepository.deleteById(clienteId);
		return "Cliente eliminado de manera exitosa.";
    }

	public Cliente updateCliente(Cliente cliente) {
		Cliente clienteToUpdate = clienteRepository.findById(cliente.id).get();
		if (cliente.cuit != null) clienteToUpdate.cuit = cliente.cuit;
		if (cliente.mail != null) clienteToUpdate.mail = cliente.mail;
		if (cliente.razonSocial != null) clienteToUpdate.razonSocial = cliente.razonSocial;
		if (cliente.habilitadoOnline != null) clienteToUpdate.habilitadoOnline = cliente.habilitadoOnline;
		if (cliente.maxCuentaCorriente != null) clienteToUpdate.maxCuentaCorriente = cliente.maxCuentaCorriente;
		return clienteRepository.save(clienteToUpdate);
    }
}
