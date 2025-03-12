package com.fabdanilo.demo_watchlist_api.service;

import com.fabdanilo.demo_watchlist_api.entity.Usuario;
import com.fabdanilo.demo_watchlist_api.exception.EntityNotFoundException;
import com.fabdanilo.demo_watchlist_api.exception.PasswordInvalidException;
import com.fabdanilo.demo_watchlist_api.exception.UsernameUniqueViolationException;
import com.fabdanilo.demo_watchlist_api.repository.UsuarioRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        try{
            return usuarioRepository.save(usuario);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new UsernameUniqueViolationException(String.format("Username %s já cadastrado", usuario.getEmail()));
        }

    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuario id=%s não encontrado", id))
        );
    }

    @Transactional
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
        if(!novaSenha.equals(confirmaSenha)){
            throw new PasswordInvalidException("Nova senha não confere com a confirmação de senha");
        }
        Usuario user = buscarPorId(id);
        if(!user.getSenha().equals(senhaAtual)){
            throw new PasswordInvalidException("Sua senha não confere");
        }

        user.setSenha(novaSenha);

        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscartodos() {

        return usuarioRepository.findAll();
    }
}