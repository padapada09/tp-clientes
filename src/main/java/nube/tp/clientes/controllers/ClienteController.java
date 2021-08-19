package nube.tp.clientes.controllers;

import nube.tp.clientes.domains.Cliente;
import nube.tp.clientes.services.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

    @PostMapping()
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(clienteService.agregarCliente(cliente), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.updateCliente(cliente), HttpStatus.OK);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<String> eliminar(@PathVariable Integer clienteId) {   
        return new ResponseEntity<>(clienteService.deleteCliente(clienteId),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>> getCliente(
			@RequestParam(required = false) Integer id,
			@RequestParam(required = false) String username,
            @RequestParam(required = false) String cuit,
            @RequestParam(required = false) String razonSocial,
            @RequestParam(required = false) Integer obraCode
		){
        return new ResponseEntity<>(clienteService.getClientes(id, cuit, razonSocial, obraCode, username), HttpStatus.OK);
    }
}