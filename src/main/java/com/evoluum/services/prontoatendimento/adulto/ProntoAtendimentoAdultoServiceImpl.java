package com.evoluum.services.prontoatendimento.adulto;

import com.evoluum.services.prontoatendimento.ProntoAtendimentoService;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProntoAtendimentoAdultoServiceImpl implements ProntoAtendimentoAdultoService {

    private final ProntoAtendimentoService service;

    @Value("${unimed.adulto}")
    private String id;

    @Override
    public LocalTime call() throws Exception {
        return this.service.call(id);
    }
}
