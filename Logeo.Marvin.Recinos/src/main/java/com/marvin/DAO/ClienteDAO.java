package com.marvin.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.marvin.modelo.TbUsuariop;

public class ClienteDAO {

	public List<TbUsuariop> LoginUsuario(TbUsuariop usu) {
		List<TbUsuariop> Usuario = new ArrayList();
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("Logeo.Marvin.Recinos");
		em = emf.createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			Usuario = em.createQuery("from TbUsuariop as u where u.usuario = '"+usu.getUsuario()+"' and u.contrasenia='"+usu.getContrasenia()+"'").getResultList();
			
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e+"Error");
		}
		
		
		return Usuario;
		
	}

}

