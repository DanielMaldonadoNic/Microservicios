package org.aguzman.springcloud.mscv.usuarios.services;

import org.aguzman.springcloud.mscv.usuarios.models.entity.Usuario;
import org.aguzman.springcloud.mscv.usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Transactional(readOnly = true)
    @Override
    public List<Usuario> listar() {
        return (List<Usuario>) usuarioRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> porId(Long id) {
        return usuarioRepository.findById(id);
    }
    @Transactional
    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @Transactional
    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

}
