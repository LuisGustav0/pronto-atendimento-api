package com.evoluum.services.prontoatendimento.infantil;

import com.evoluum.services.prontoatendimento.ProntoAtendimentoService;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProntoAtendimentoInfantilServiceImpl implements ProntoAtendimentoInfantilService {

    private final ProntoAtendimentoService service;

    @Value("${unimed.infantil}")
    private String id;

    @Override
    public LocalTime call() throws Exception {
        return this.service.call(id);
    }
}
