package com.chimionato.bffagendadortarefas.business;

import com.chimionato.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.chimionato.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailClient emailClient;
    public void enviaEmail(TarefasDTOResponse dto){
        emailClient.enviarEmail(dto);
    }
}
