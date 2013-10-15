package manager;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entityTeste.Telefone;
import facade.TelefoneFacade;

@ManagedBean(name = "telefone")
@SessionScoped
public class TelefoneManager extends AbstractManager<Telefone> implements Serializable {

	public TelefoneManager() {
		super(new TelefoneFacade(), new Telefone());
	}

	private static final long serialVersionUID = 1L;

	public List<Telefone> getList(){
		return findAll();
	}
}
