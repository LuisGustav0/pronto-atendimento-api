package com.evoluum.services.prontoatendimento;

import java.time.LocalTime;

public interface ProntoAtendimentoService {

    LocalTime call(final String id) throws Exception;
}
