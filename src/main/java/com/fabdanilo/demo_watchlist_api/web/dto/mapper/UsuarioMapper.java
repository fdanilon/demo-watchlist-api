package com.fabdanilo.demo_watchlist_api.web.dto.mapper;

import com.fabdanilo.demo_watchlist_api.entity.Usuario;
import com.fabdanilo.demo_watchlist_api.web.dto.UsuarioCreateDto;
import com.fabdanilo.demo_watchlist_api.web.dto.UsuarioResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioCreateDto createDto){
        return new ModelMapper().map(createDto, Usuario.class);
    }

    public static UsuarioResponseDto toDto(Usuario usuario){
//        PropertyMap<Usuario, UsuarioRespondeDto> props = new PropertyMap<Usuario, UsuarioRespondeDto>() {
//            @Override
//            protected void configure() {
//                map().set
//            }
//        };
          ModelMapper mapper = new ModelMapper();
//        mapper.addMappings(props);
          return mapper.map(usuario, UsuarioResponseDto.class);

    }

    public static List<UsuarioResponseDto> toListDto(List<Usuario> usuarios){
        return usuarios.stream().map(user -> toDto(user)).collect(Collectors.toList());

    }
}
