package com.chimionato.bffagendadortarefas.controller;

import com.chimionato.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.chimionato.bffagendadortarefas.infrastructure.security.SecurityConfig;
import com.chimionato.bffagendadortarefas.business.TarefaService;
import com.chimionato.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.chimionato.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "Cadastra tarefas de usuários")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {
    private final TarefaService tarefaService;



    @PostMapping
    @Operation(summary = "Gravar tarefas do usuário", description = "Gravar uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa gravada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> gravarTarefas(@RequestBody TarefasDTORequest dto,
                                                            @RequestHeader(value = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefaService.gravarTarefa(token, dto));
    }




    @GetMapping("/eventos")
    @Operation(summary = "Busca tarefas por período", description = "Busca tarefas cadastradas por período")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(value = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefaService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token));
    }



    @GetMapping
    @Operation(summary = "Busca tarefas por email", description = "Busca tarefas cadastradas por email")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscaTarefasPorEmail(@RequestHeader(value = "Authorization", required = false) String token){
        List<TarefasDTOResponse> tarefas = tarefaService.buscaTarefasPorEmail(token);
        return ResponseEntity.ok(tarefas);




    }

    @DeleteMapping
    @Operation(summary = "Deleta tarefa por id", description = "Deleta tarefa por id")
    @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id") String id,
                                                  @RequestHeader(value = "Authorization", required = false) String token){
        tarefaService.deletaTarefaPorId(id, token);
        return ResponseEntity.ok().build();
    }









    @PatchMapping
    @Operation(summary = "Altera status da notificação", description = "Altera status da notificação")
    @ApiResponse(responseCode = "200", description = "Status da notificação alterado com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                                      @RequestParam("id") String id,
                                                                      @RequestHeader(value = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefaService.alteraStatus(status, id, token));
    }




    @PutMapping
    @Operation(summary = "Altera dados da tarefa", description = "Altera dados da tarefa")
    @ApiResponse(responseCode = "200", description = "Dado(s) da tarefa alterado(s) com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> updateTarefas(@RequestBody TarefasDTORequest dto,
                                                            @RequestParam("id") String id,
                                                            @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefaService.updateTarefas(dto, id, token));
    }



}
