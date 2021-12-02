package com.evoluum.resources;

import com.evoluum.resources.response.ProntoAtendimentoInfantilResponse;
import com.evoluum.services.prontoatendimento.infantil.ProntoAtendimentoInfantilService;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProntoAtendimentoInfantilResource {

    private final ProntoAtendimentoInfantilService service;

    @GetMapping("/relogio-infantil")
    public ResponseEntity<ProntoAtendimentoInfantilResponse> call() {
        try {
            final LocalTime horario = this.service.call();

            ProntoAtendimentoInfantilResponse response = ProntoAtendimentoInfantilResponse.builder()
                                                                                          .horario(horario)
                                                                                          .build();

            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
