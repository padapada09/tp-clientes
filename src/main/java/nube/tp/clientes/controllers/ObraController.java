package nube.tp.clientes.controllers;

import nube.tp.clientes.domains.Obra;
import nube.tp.clientes.domains.TipoObra;
import nube.tp.clientes.services.ObraService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/obras")
public class ObraController {

	@Autowired
	ObraService obraService;

	@PostMapping("/{clienteId}")
    public ResponseEntity<Obra> crear(@RequestBody Obra obra, @PathVariable Integer clienteId) {
		return new ResponseEntity<>(obraService.agregarObra(obra, clienteId), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Obra>> getObras(
		@RequestParam(required = false) Integer id,
		@RequestParam(required = false) TipoObra tipoObra,
		@RequestParam(required = false) Integer clienteId
	){
        return new ResponseEntity<>(obraService.getObras(id,tipoObra,clienteId), HttpStatus.OK);
    }

	@PutMapping()
    public ResponseEntity<Obra> updateObra(@RequestBody Obra obra){
        return new ResponseEntity<>(obraService.updateObra(obra), HttpStatus.OK);
    }

	@DeleteMapping("/{obraId}")
    public ResponseEntity<String> deleteObra(@PathVariable Integer obraId){
        return new ResponseEntity<>(obraService.deleteObra(obraId), HttpStatus.OK);
    }
}