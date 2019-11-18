package com.midilabs.dentech.api.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.midilabs.dentech.api.model.domain.TipoCategoria;

@Entity
@Table(name="categoria")
public class Categoria extends EntityBase {


	private static final long serialVersionUID = 1L;
	private String cate_nm_categoria;
	private TipoCategoria cate_in_tipo;
	
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cate_sq_id")
	public Long getId() {
		return super.getId();
	}

	public String getCate_nm_categoria() {
		return cate_nm_categoria;
	}

	public void setCate_nm_categoria(String cate_nm_categoria) {
		this.cate_nm_categoria = cate_nm_categoria;
	}

	public TipoCategoria getCate_in_tipo() {
		return cate_in_tipo;
	}

	public void setCate_in_tipo(TipoCategoria cate_in_tipo) {
		this.cate_in_tipo = cate_in_tipo;
	}
	
	
}
