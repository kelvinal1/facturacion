package ista.app.facturacion.Controllers;

import ista.app.facturacion.Models.ClasificacionModel;
import ista.app.facturacion.Models.CompetenciaModel;
import ista.app.facturacion.Models.RolModel;
import ista.app.facturacion.Repositories.ClasificacionRepository;
import ista.app.facturacion.Repositories.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("api/Competencia")
public class CompetenciaController {
    @Autowired
    private CompetenciaRepository competenciaRepository;


    @PostMapping("save")
    public CompetenciaModel postCompetencia(@RequestBody CompetenciaModel clasificacion) {
        return competenciaRepository.save(clasificacion);
    }

    @GetMapping("/get-all")
    private List<CompetenciaModel> getAllCompetencias() {
        return competenciaRepository.findAll();
    }

    @GetMapping("/get-by-id/{id}")
    private ResponseEntity<CompetenciaModel> getById(@PathVariable long id) {
        CompetenciaModel list = competenciaRepository.findById(id).get();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get-by-competence/{competence}")
    private ResponseEntity<Boolean> getById(@PathVariable String competence) {
        CompetenciaModel list = competenciaRepository.findByNombre(competence);
        if(list!=null) return ResponseEntity.ok(true);
        return ResponseEntity.ok(false);
    }

    @DeleteMapping("/delete-by-id/{id}")
    private  ResponseEntity<Boolean> deleteById(@PathVariable long id) {
        competenciaRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @PutMapping("update")
    public CompetenciaModel update(@RequestBody CompetenciaModel clasificacion) {
        return competenciaRepository.save(clasificacion);
    }

}
