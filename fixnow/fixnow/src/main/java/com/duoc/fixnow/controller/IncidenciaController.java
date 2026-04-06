package com.duoc.fixnow.controller;

import com.duoc.fixnow.service.IncidenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RestController
@RequestMapping("/api/v1/incidencias")
// Quizas son private
// quiza los try catch son aca y no en el repository
public class IncidenciaController {
    public IncidenciaService incidenciaService = new IncidenciaService();
    @GetMapping
    @RequestMapping("/todos")
    public ResponseEntity<?> listarTodos(){
        return ResponseEntity.ok(incidenciaService.getLista());
    }
    @PostMapping
    @RequestMapping("/agregarIncidente")
    public ResponseEntity<?> agregarIncidente(
            @PathVariable Integer id, String titulo,
            @PathVariable String descripcion,
            @PathVariable String estado,
            @PathVariable String prioridad,
            @PathVariable String usuarioReportante,
            @PathVariable Date fechaRegistro){
        incidenciaService.setIncidencia(id,titulo, descripcion,estado,prioridad,usuarioReportante, fechaRegistro);
        return ResponseEntity.ok(incidenciaService);
    }
}
