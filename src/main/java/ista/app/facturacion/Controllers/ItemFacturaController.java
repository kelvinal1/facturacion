package ista.app.facturacion.Controllers;

import ista.app.facturacion.Models.FacturaModel;
import ista.app.facturacion.Models.ItemFacturaModel;
import ista.app.facturacion.Repositories.FacturaRepository;
import ista.app.facturacion.Repositories.ItemFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("api/ItemFactura")
public class ItemFacturaController {
    @Autowired
    private ItemFacturaRepository itemFacturaRepository;


    @PostMapping("save")
    public ItemFacturaModel postFactura(@RequestBody ItemFacturaModel clasificacion) {
        return itemFacturaRepository.save(clasificacion);
    }

    @GetMapping("/get-all")
    private List<ItemFacturaModel> getAllFacturas() {
        return itemFacturaRepository.findAll();
    }

    @GetMapping("/get-by-id/{id}")
    private ResponseEntity<ItemFacturaModel> getById(@PathVariable long id) {
        ItemFacturaModel  list = itemFacturaRepository.findById(id).get();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/delete-by-id/{id}")
    private  ResponseEntity<Boolean> deleteById(@PathVariable long id) {
        itemFacturaRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @PutMapping("update")
    public ItemFacturaModel update(@RequestBody ItemFacturaModel clasificacion) {
        return itemFacturaRepository.save(clasificacion);
    }


}
