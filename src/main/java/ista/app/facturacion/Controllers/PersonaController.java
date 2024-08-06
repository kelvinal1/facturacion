package ista.app.facturacion.Controllers;

import ista.app.facturacion.Models.ItemFacturaModel;
import ista.app.facturacion.Models.PersonaModel;
import ista.app.facturacion.Repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("api/Persona")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @PostMapping("save")
    public PersonaModel postFactura(@RequestBody PersonaModel clasificacion) {
        return personaRepository.save(clasificacion);
    }

    @GetMapping("/get-all")
    private List<PersonaModel> getAllFacturas() {
        return personaRepository.findAll();
    }

    @GetMapping("/get-by-id/{id}")
    private ResponseEntity<PersonaModel> getById(@PathVariable long id) {
        PersonaModel  list = personaRepository.findById(id).get();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get-by-dni/{dni}")
    private ResponseEntity<PersonaModel> getPerssonaByDni(@PathVariable String dni) {
        PersonaModel  list = personaRepository.findAllByDni(dni);
        if(list!= null) return ResponseEntity.ok(list);
        return  ResponseEntity.ok(null);
    }
    @GetMapping("/get-by-names/{names}")
    private ResponseEntity<PersonaModel> getPerssonaByNames(@PathVariable String names) {
        PersonaModel  list = personaRepository.findAllByNombre(names);
        if(list!= null) return ResponseEntity.ok(list);
        return  ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete-by-id/{id}")
    private  ResponseEntity<Boolean> deleteById(@PathVariable long id) {
        personaRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @PutMapping("update")
    public PersonaModel update(@RequestBody PersonaModel clasificacion) {
        return personaRepository.save(clasificacion);
    }
}
