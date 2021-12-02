package com.evoluum.resources.response;

import java.time.LocalTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProntoAtendimentoInfantilResponse {

    private LocalTime horario;
}
