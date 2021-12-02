package com.evoluum.services.prontoatendimento;

import com.evoluum.exception.BusinessException;
import com.evoluum.utils.PageUtil;
import java.time.LocalTime;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProntoAtendimentoServiceImpl implements ProntoAtendimentoService {

    @Value("${unimed.url}")
    private String baseUrl;

    @Value("${unimed.path-acompanha-atendimento}")
    private String path;

    @Override
    public LocalTime call(String id) throws Exception {
        final String url = baseUrl.concat(path).concat(id);

        final Document document = PageUtil.getPage(url);

        final String evaluator = "span[id=lblRelogio] font[face=Times New Roman]";

        final Element elementRelogio = PageUtil.selectFirst(document, evaluator);

        if (elementRelogio == null)
            throw new BusinessException("Não encontrado");

        final String time = elementRelogio.html();

        return LocalTime.parse(time);
    }
}
