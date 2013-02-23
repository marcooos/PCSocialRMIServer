package br.com.pcsocial.servidor.servicoServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ExportException;

import br.com.pcsocial.servidor.servico.ApartamentoServ;
import br.com.pcsocial.servidor.servico.EmpresaServ;
import br.com.pcsocial.servidor.servico.PessoaServ;
import br.com.pcsocial.servidor.servicoImp.ApartamentoServImp;
import br.com.pcsocial.servidor.servicoImp.CanaisServImp;
import br.com.pcsocial.servidor.servicoImp.CidadeServImp;
import br.com.pcsocial.servidor.servicoImp.ClassesServImp;
import br.com.pcsocial.servidor.servicoImp.DemandaServImp;
import br.com.pcsocial.servidor.servicoImp.EmpresaServImp;
import br.com.pcsocial.servidor.servicoImp.EstadoServImp;
import br.com.pcsocial.servidor.servicoImp.HospedagemServImp;
import br.com.pcsocial.servidor.servicoImp.MercadoServImp;
import br.com.pcsocial.servidor.servicoImp.PaisServImp;
import br.com.pcsocial.servidor.servicoImp.PessoaServImp;
import br.com.pcsocial.servidor.servicoImp.ReceitaServImp;
import br.com.pcsocial.servidor.servicoImp.RestricoesServImp;
import br.com.pcsocial.servidor.servicoImp.TarifaServImp;
import br.com.pcsocial.servidor.servicoImp.TemporadaServImp;
import br.com.pcsocial.servidor.util.HibernateUtil;

public class ServicoServer {
	private PessoaServ p;
	private EmpresaServ es;
	private ApartamentoServ ap;
	private CidadeServImp cd;
	private DemandaServImp dm;
	private EstadoServImp et;
	private MercadoServImp ms;
	private PaisServImp ps;
	private ReceitaServImp rs;
	private TemporadaServImp ts;
	private CanaisServImp cn;
	private RestricoesServImp rss;
	private ClassesServImp cl;
	private TarifaServImp tr;
	private HospedagemServImp hs;
	private String mensagemRetorno;
	private int hashObjeto;

	public ServicoServer() {
	}

	public boolean startAplicationServer() {
		try {
			HibernateUtil.getSessionFactory();
			p = new PessoaServImp();
			es = new EmpresaServImp();
			ap = new ApartamentoServImp();
			cd = new CidadeServImp();
			dm = new DemandaServImp();
			et = new EstadoServImp();
			ms = new MercadoServImp();
			ps = new PaisServImp();
			rs = new ReceitaServImp();
			ts = new TemporadaServImp();
			cn = new CanaisServImp();
			rss = new RestricoesServImp();
			cl = new ClassesServImp();
			tr = new TarifaServImp();
			hs = new HospedagemServImp();
			// Runtime.getRuntime().exec("rmiregistry 1099");
			LocateRegistry.createRegistry(1099);
			setHashObjeto(p.hashCode());
			setHashObjeto(es.hashCode());
			setHashObjeto(ap.hashCode());
			setHashObjeto(cd.hashCode());
			setHashObjeto(dm.hashCode());
			setHashObjeto(et.hashCode());
			setHashObjeto(ms.hashCode());
			setHashObjeto(ps.hashCode());
			setHashObjeto(rs.hashCode());
			setHashObjeto(ts.hashCode());
			setHashObjeto(cn.hashCode());
			setHashObjeto(rss.hashCode());
			setHashObjeto(cl.hashCode());
			setHashObjeto(tr.hashCode());
			setHashObjeto(hs.hashCode());
			Naming.rebind("rmi://localhost:1099/PessoaService", p);
			Naming.rebind("rmi://localhost:1099/EmpresaService", es);
			Naming.rebind("rmi://localhost:1099/ApartamentoService", ap);
			Naming.rebind("rmi://localhost:1099/CidadeService", cd);
			Naming.rebind("rmi://localhost:1099/DemandaService", dm);
			Naming.rebind("rmi://localhost:1099/EstadoService", et);
			Naming.rebind("rmi://localhost:1099/MercadoService", ms);
			Naming.rebind("rmi://localhost:1099/PaisService", ps);
			Naming.rebind("rmi://localhost:1099/ReceitaService", rs);
			Naming.rebind("rmi://localhost:1099/TemporadaService", ts);
			Naming.rebind("rmi://localhost:1099/CanaisService", cn);
			Naming.rebind("rmi://localhost:1099/RestricoesService", rss);
			Naming.rebind("rmi://localhost:1099/ClassesService", cl);
			Naming.rebind("rmi://localhost:1099/TarifaService", tr);
			Naming.rebind("rmi://localhost:1099/HospedagemService", hs);
			setMensagemRetorno("Servidor foi iniciado");
		} catch (ExportException e) {
			try {
				Naming.rebind("rmi://localhost:1099/PessoaService", p);
				Naming.rebind("rmi://localhost:1099/EmpresaService", es);
				Naming.rebind("rmi://localhost:1099/ApartamentoService", ap);
				Naming.rebind("rmi://localhost:1099/CidadeService", cd);
				Naming.rebind("rmi://localhost:1099/DemandaService", dm);
				Naming.rebind("rmi://localhost:1099/EstadoService", et);
				Naming.rebind("rmi://localhost:1099/MercadoService", ms);
				Naming.rebind("rmi://localhost:1099/PaisService", ps);
				Naming.rebind("rmi://localhost:1099/ReceitaService", rs);
				Naming.rebind("rmi://localhost:1099/TemporadaService", ts);
				Naming.rebind("rmi://localhost:1099/CanaisService", cn);
				Naming.rebind("rmi://localhost:1099/RestricoesService", rss);
				Naming.rebind("rmi://localhost:1099/ClassesService", cl);
				Naming.rebind("rmi://localhost:1099/TarifaService", tr);
				Naming.rebind("rmi://localhost:1099/HospedagemService", hs);
			} catch (RemoteException e1) {
				setMensagemRetorno(("Trouble: " + e1));
			} catch (MalformedURLException e1) {
				setMensagemRetorno(("Trouble: " + e1));
			}
			setMensagemRetorno("Servidor foi reiniciado");
		} catch (Exception e) {
			p = null;
			es = null;
			ap = null;
			cd = null;
			dm = null;
			et = null;
			ms = null;
			ps = null;
			rs = null;
			ts = null;
			cn = null;
			rss= null;
			cl = null;
			tr = null;
			hs = null;
			setMensagemRetorno(("Trouble: " + e));
		}
		return true;
	}

	public boolean stopAplicationServer() {
		try {
			Naming.unbind("rmi://localhost:1099/PessoaService");
			Naming.unbind("rmi://localhost:1099/EmpresaService");
			Naming.unbind("rmi://localhost:1099/ApartamentoService");
			Naming.unbind("rmi://localhost:1099/CidadeService");
			Naming.unbind("rmi://localhost:1099/DemandaService");
			Naming.unbind("rmi://localhost:1099/EstadoService");
			Naming.unbind("rmi://localhost:1099/MercadoService");
			Naming.unbind("rmi://localhost:1099/PaisService");
			Naming.unbind("rmi://localhost:1099/ReceitaService");
			Naming.unbind("rmi://localhost:1099/TemporadaService");
			Naming.unbind("rmi://localhost:1099/CanaisService");
			Naming.unbind("rmi://localhost:1099/RestricoesService");
			Naming.unbind("rmi://localhost:1099/ClassesService");
			Naming.unbind("rmi://localhost:1099/TarifaService");
			Naming.unbind("rmi://localhost:1099/HospedagemService");
			setMensagemRetorno("Servidor foi parado.");
			p = null;
			es = null;
			ap = null;
			cd = null;
			dm = null;
			et = null;
			ms = null;
			ps = null;
			rs = null;
			ts = null;
			cn = null;
			rss= null;
			cl = null;
			tr = null;
			return true;
		} catch (NotBoundException e) {
			setMensagemRetorno(("Servidor j‡ est‡ parado"));
			return false;
		} catch (Exception e) {
			setMensagemRetorno(("Trouble: " + e));
			return false;
		}
	}

	public void setMensagemRetorno(String mensagemRetorno) {
		this.mensagemRetorno = mensagemRetorno;
	}

	public String getMensagemRetorno() {
		return mensagemRetorno;
	}

	public void setHashObjeto(int hashObjeto) {
		this.hashObjeto = hashObjeto;
	}

	public int getHashObjeto() {
		return hashObjeto;
	}

}
