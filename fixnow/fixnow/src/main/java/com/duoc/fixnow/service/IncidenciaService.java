package com.duoc.fixnow.service;

import com.duoc.fixnow.model.Incidencia;
import com.duoc.fixnow.repository.IncidenciaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
// Quizas son private
public class IncidenciaService {
    public IncidenciaRepository incidenciaRepository = new IncidenciaRepository();
    public ResponseEntity<?> setIncidencia(Integer id,String titulo,
                                           String descripcion,
                                           String estado,
                                           String prioridad,
                                           String usuarioReportante,
                                           Date fechaRegistro)
    {return incidenciaRepository.agregarIncidencia(id,titulo,descripcion,estado,prioridad,usuarioReportante,fechaRegistro);}
    public ResponseEntity<?> getLista(){return incidenciaRepository.listarIncidencias();}
}
