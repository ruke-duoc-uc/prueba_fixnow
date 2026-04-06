package com.duoc.fixnow.repository;

import com.duoc.fixnow.model.Incidencia;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class IncidenciaRepository {
    public List<Incidencia> listaIncidencias;
    // Metodos Get
    public ResponseEntity<?> listarIncidencias() {
        try {
            return ResponseEntity.ok(listaIncidencias);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar los incidentes");
        }
    }

    // Agregar excepcion por id nulo
    public ResponseEntity<?> buscarIncidenciaPorId(Integer id){
        try{
            for(Incidencia incidencia : listaIncidencias)
                if (incidencia.getId().equals(id)){
                    return ResponseEntity.ok(incidencia.getClass());
                }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener el incidente");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe una incidencia con la id ingresada");
    }
    public ResponseEntity<?> buscarPorEstado(String estado){
        try{
            ArrayList<Incidencia> listaEstado = new ArrayList<>();
            for (Incidencia incidencia : listaIncidencias){
                if (incidencia.getEstado().equals(estado)){
                    listaEstado.add(incidencia);
                }
            }
            return ResponseEntity.ok(listaEstado);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los incidentes");
        }
    }

    // Posteo
    // Optimizar adecuadamente el codigo despues
    public ResponseEntity<?> agregarIncidencia (Integer id,String titulo,
    String descripcion,
    String estado,
    String prioridad,
    String usuarioReportante,
    Date fechaRegistro){
        try {
            Incidencia incidencia = new Incidencia();
            // Quitar id cuando escale automaticamente
            incidencia.setId(id);
            incidencia.setTitulo(titulo);
            incidencia.setDescripcion(descripcion);
            incidencia.setEstado(estado);
            incidencia.setPrioridad(prioridad);
            incidencia.setUsuarioReportante(usuarioReportante);
            incidencia.setFechaRegistro(fechaRegistro);
            return ResponseEntity.ok(incidencia);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar el incidente");
        }
    }

    //  Actualizacion


    //Eliminacion
    // Es muy probable que el codigo este malo
    public ResponseEntity<?> eliminarIncidente(Integer id){
        try{
            for (Incidencia incidencia : listaIncidencias){
                if (incidencia.getId().equals(id)){
                    return ResponseEntity.ok("Se elimino el incidente correctamente");
                }
            }
            return ResponseEntity.ok("Se elimino el incidente correctamente");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar el incidente");
        }
    }
}

