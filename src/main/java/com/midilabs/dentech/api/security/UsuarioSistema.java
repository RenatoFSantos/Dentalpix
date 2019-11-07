package com.midilabs.dentech.api.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.midilabs.dentech.api.model.vo.Usuario;

public class UsuarioSistema extends User {


	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getUsua_ds_senha(), authorities);
		System.out.println("Entrei na classe UsuarioSistema com Usuario " + usuario);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
}
