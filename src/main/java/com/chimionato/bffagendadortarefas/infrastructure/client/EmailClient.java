package com.chimionato.bffagendadortarefas.infrastructure.client;

import com.chimionato.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.chimionato.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.chimionato.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.chimionato.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.chimionato.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.chimionato.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.chimionato.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.chimionato.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {
    void enviarEmail(@RequestBody TarefasDTOResponse dto);
 }
