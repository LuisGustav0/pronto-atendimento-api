package com.evoluum.resources;

import com.evoluum.resources.response.ProntoAtendimentoAdultoResponse;
import com.evoluum.services.prontoatendimento.adulto.ProntoAtendimentoAdultoService;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProntoAtendimentoAdultoResource {

    private final ProntoAtendimentoAdultoService service;

    @GetMapping("/relogio-adulto")
    public ResponseEntity<ProntoAtendimentoAdultoResponse> call() {
        try {
            final LocalTime horario = service.call();

            ProntoAtendimentoAdultoResponse response = ProntoAtendimentoAdultoResponse.builder()
                                                                                      .horario(horario)
                                                                                      .build();

            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
