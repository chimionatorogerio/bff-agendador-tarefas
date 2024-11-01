package com.chimionato.bffagendadortarefas.business;

import com.chimionato.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.chimionato.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.chimionato.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.chimionato.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.chimionato.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.chimionato.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.chimionato.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.chimionato.bffagendadortarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioClient client;
    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO){
        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginDTORequest usuarioDTO){
        return client.login(usuarioDTO);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token){
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto){
        return client.atualizDadoUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token){
        return client.atualizaTelefone(dto, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto){
        return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto){
        return client.cadastraTelefone(dto, token);
    }





}
