package br.com.intersol.repository.helper.imovel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.intersol.model.Imovel;
import br.com.intersol.repository.filter.ImovelFilter;

public class ImoveisImpl implements ImoveisQueries {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public Page<Imovel> filtrar(ImovelFilter filtro, Pageable pageable) {
		
		@SuppressWarnings("deprecation")
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Imovel.class);
		
		criteria.addOrder(Order.asc("proprietario.codigo"));
		
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;
		
		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);
		
		adicionarFiltro(filtro, criteria);
		
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}

	private Long total(ImovelFilter filtro) {
		@SuppressWarnings("deprecation")
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Imovel.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		
		return (Long) criteria.uniqueResult();
	}
	
	private void adicionarFiltro(ImovelFilter filtro, Criteria criteria) {
		if(filtro != null) {
			if(filtro.getProprietario() != null) {
				criteria.add(Restrictions.eq("proprietario.codigo", filtro.getProprietario().getCodigo()));
			}
			
			if(!StringUtils.isEmpty(filtro.getLogradouro())) {
				criteria.add(Restrictions.ilike("endereco.logradouro", filtro.getLogradouro(), MatchMode.ANYWHERE));
			}
			
			if(!StringUtils.isEmpty(filtro.getNumero())) {
				criteria.add(Restrictions.ilike("endereco.numero", filtro.getNumero(), MatchMode.ANYWHERE));
			}
			
			if(!StringUtils.isEmpty(filtro.getBairro())) {
				criteria.add(Restrictions.ilike("endereco.bairro", filtro.getBairro(), MatchMode.ANYWHERE));
			}
		}
	}
}