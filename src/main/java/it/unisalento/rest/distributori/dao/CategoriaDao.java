package it.unisalento.rest.distributori.dao;

import java.util.List;

import it.unisalento.rest.distributori.domain.Categoria;

public interface CategoriaDao extends BaseDao<Categoria>{
	public List<Categoria> getAllCategorie();
}
