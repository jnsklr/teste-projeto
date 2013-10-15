package manager;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entityTeste.Pessoa;
import facade.PessoaFacade;

@ManagedBean(name = "pessoa")
@SessionScoped
public class PessoaManager extends AbstractManager<Pessoa> implements
		Serializable {

	public PessoaManager() {
		super(new PessoaFacade(), new Pessoa());
	}

	private static final long serialVersionUID = 1L;

	public List<Pessoa> getList() {
		return findAll();
	}

	public String enviar() {
		return "sucesso";
	}

	public String salvar() {
		create();
		return "sucesso";
	}
}
