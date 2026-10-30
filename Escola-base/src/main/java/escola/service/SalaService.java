
package escola.service;

import escola.model.Sala;
import escola.repository.SalaRepository;
import java.util.List;

@Service
public class SalaService {
private final SalaRepository repo;

public SalaService(SalaRepository repo) {
this.repo = repo;
}

public Sala cadastrar(Sala s) {
if (repo.existsByCodigo(s.getCodigo()))
throw erro(HttpStatus.CONFLICT, "Codigo duplicado");
s.setReservada(false);
return repo.save(s);
}

public List<Sala> listar() {
return repo.findAll();
}

public Sala buscar(Long id) {
return repo.findById(id).orElseThrow(
() -> erro(HttpStatus.NOT_FOUND, "Sala nao encontrada"));
}

public Sala reservar(Long id) {
Sala s = buscar(id);
if (s.isReservada())
throw erro(HttpStatus.CONFLICT, "Ja reservada");
s.setReservada(true);
return repo.save(s);
}

public Sala liberar(Long id) {
Sala s = buscar(id);
if (!s.isReservada())
throw erro(HttpStatus.CONFLICT, "Ja esta livre");
s.setReservada(false);
return repo.save(s);
}

public void excluir(Long id) {
Sala s = buscar(id);
if (s.isReservada())
throw erro(HttpStatus.CONFLICT, "Sala reservada");
repo.delete(s);
}


}