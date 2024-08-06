package ista.app.facturacion.Controllers;

import ista.app.facturacion.Models.ClasificacionModel;
import ista.app.facturacion.Models.ItemFacturaModel;
import ista.app.facturacion.Models.RolModel;
import ista.app.facturacion.Repositories.ClasificacionRepository;
import ista.app.facturacion.Repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("api/Rol")
public class RolController {


    @Autowired
    private RolRepository rolRepository;

    @PostMapping("save")
    public RolModel postClasificacion(@RequestBody RolModel clasificacion) {
        return rolRepository.save(clasificacion);
    }

    @GetMapping("/get-all")
    private List<RolModel> getAllClasificacion() {
        return rolRepository.findAll();
    }

    @GetMapping("/get-by-id/{id}")
    private ResponseEntity<RolModel> getById(@PathVariable long id) {
        RolModel list = rolRepository.findById(id).get();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get-by-rol/{rol}")
    private ResponseEntity<Boolean> getById(@PathVariable String rol) {
        RolModel list = rolRepository.findByNombreRol(rol);
        if(list!=null) return ResponseEntity.ok(true);
        return ResponseEntity.ok(false);
    }

    @GetMapping("/get-by-state/{state}")
    private ResponseEntity<Boolean> getById(@PathVariable Boolean state) {
        RolModel list = rolRepository.findByEstado(state);
        if(list!=null) return ResponseEntity.ok(true);
        return ResponseEntity.ok(false);
    }

    @DeleteMapping("/delete-by-id/{id}")
    private  ResponseEntity<Boolean> deleteById(@PathVariable long id) {
        rolRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @PutMapping("update")
    public RolModel update(@RequestBody RolModel clasificacion) {
        return rolRepository.save(clasificacion);
    }
}
