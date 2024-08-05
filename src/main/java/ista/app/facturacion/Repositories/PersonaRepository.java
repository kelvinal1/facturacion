package ista.app.facturacion.Repositories;

import ista.app.facturacion.Models.CompetenciaModel;
import ista.app.facturacion.Models.ItemFacturaModel;
import ista.app.facturacion.Models.PersonaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaModel,Long> {



    PersonaModel findAllByDni(String dni);
    PersonaModel findAllByNombre(String dni);

    /*
    @Query("SELECT u FROM persona u WHERE u.nombre like '%:valor%' or u.apellido like '%:valor%'")
    PersonaModel buscarPorNombreCompleto(String valor);
    */
}

