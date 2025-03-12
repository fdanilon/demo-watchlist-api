package com.fabdanilo.demo_watchlist_api.repository;

import com.fabdanilo.demo_watchlist_api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
