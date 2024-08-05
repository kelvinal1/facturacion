package ista.app.facturacion.Controllers;


import ista.app.facturacion.Models.TipoPagoModel;
import ista.app.facturacion.Models.UsuarioModel;
import ista.app.facturacion.Repositories.TipoPagoRepository;
import ista.app.facturacion.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("api/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("save")
    public UsuarioModel postClasificacion(@RequestBody UsuarioModel clasificacion) {
        return usuarioRepository.save(clasificacion);
    }

    @GetMapping("/get-all")
    private List<UsuarioModel> getAllClasificacion() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/get-by-id/{id}")
    private ResponseEntity<UsuarioModel> getById(@PathVariable long id) {
        UsuarioModel list = usuarioRepository.findById(id).get();
        return ResponseEntity.ok(list);
    }


    @GetMapping("/verify-exists/{nombre}/{clave}`")
    private ResponseEntity<Boolean> getById(@PathVariable String nombre, @PathVariable String clave) {
        UsuarioModel list = usuarioRepository.findByNombreUsuarioAndContrasenaUsuario(nombre,clave);
        if(list!=null) return ResponseEntity.ok(true);
        return ResponseEntity.ok(false);
    }
}
