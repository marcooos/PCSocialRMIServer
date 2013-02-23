package br.com.pcsocial.servidor.util;

import br.com.pcsocial.servidor.modelo.Apartamento;
import br.com.pcsocial.servidor.modelo.Canais;
import br.com.pcsocial.servidor.modelo.Cidade;
import br.com.pcsocial.servidor.modelo.Classes;
import br.com.pcsocial.servidor.modelo.Demanda;
import br.com.pcsocial.servidor.modelo.DetHospedagem;
import br.com.pcsocial.servidor.modelo.Empresa;
import br.com.pcsocial.servidor.modelo.Estado;
import br.com.pcsocial.servidor.modelo.Hospedagem;
import br.com.pcsocial.servidor.modelo.Mercado;
import br.com.pcsocial.servidor.modelo.Pais;
import br.com.pcsocial.servidor.modelo.Pessoa;
import br.com.pcsocial.servidor.modelo.Receita;
import br.com.pcsocial.servidor.modelo.ReceitaHospedagem;
import br.com.pcsocial.servidor.modelo.Restricoes;
import br.com.pcsocial.servidor.modelo.Tarifa;
import br.com.pcsocial.servidor.modelo.Temporada;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author José Alexandre
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }
    

    public static void main(String args[]) {
        getSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create the SessionFactory from standard (hibernate.cfg.xml)
                // config file.
                AnnotationConfiguration ac = new AnnotationConfiguration();
                ac.addAnnotatedClass(Pessoa.class)
                .addAnnotatedClass(Empresa.class)
                .addAnnotatedClass(Cidade.class)
                .addAnnotatedClass(Estado.class)
                .addAnnotatedClass(Pais.class)
                .addAnnotatedClass(Apartamento.class)
                .addAnnotatedClass(Mercado.class)
                .addAnnotatedClass(Demanda.class)
                .addAnnotatedClass(Receita.class)
                .addAnnotatedClass(Temporada.class)
                .addAnnotatedClass(Canais.class)
                .addAnnotatedClass(Restricoes.class)
                .addAnnotatedClass(Classes.class)
                .addAnnotatedClass(Tarifa.class)
                .addAnnotatedClass(Hospedagem.class)
                .addAnnotatedClass(DetHospedagem.class)
                .addAnnotatedClass(ReceitaHospedagem.class);
                sessionFactory = ac.configure().buildSessionFactory();
            } catch (Throwable ex) {
                // Log the exception.
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
            return sessionFactory;
        } else {
            return sessionFactory;
        }
    }
}