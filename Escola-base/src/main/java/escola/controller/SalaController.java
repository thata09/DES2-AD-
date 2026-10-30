package escola.salacontroller;

import escola.model.Sala;
import escola.service.SalaService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {
private final SalaService service;

public SalaController(SalaService service) {
this.service = service;
}

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Sala cadastrar(@Valid @RequestBody Sala s) {
return service.cadastrar(s);
}

@GetMapping
public List<Sala> listar() {
return service.listar();
}

@GetMapping("/{id}")
public Sala buscar(@PathVariable Long id) {
return service.buscar(id);
}

}


