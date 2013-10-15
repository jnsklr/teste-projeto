package manager;

import java.util.List;

import util.JSFUtil;
import facade.AbstractFacade;

public abstract class AbstractManager<T> {

	private AbstractFacade<T> facade = null;
	private T currentClass = null;

	public AbstractManager() {
	}
	
	public AbstractManager(AbstractFacade<T> facade, T currentClass) {
		this.facade = facade;
		setCurrentPessoa(currentClass);
	}

	public T getCurrentPessoa() {
		return currentClass;
	}

	public void setCurrentPessoa(T currentPessoa) {
		this.currentClass = currentPessoa;
	}

	public void edit() {
		try {
			facade.edit(getCurrentPessoa());
		} catch (Exception e) {
			JSFUtil.addErrorMessage("edit", e.getMessage());
		}
	}

	public void remove() {
		try {
			facade.remove(getCurrentPessoa());
		} catch (Exception e) {
			JSFUtil.addErrorMessage("remove", e.getMessage());
		}
	}

	public void create() {
		try {
			if (getCurrentPessoa() != null)
				facade.create(getCurrentPessoa());
		} catch (Exception e) {
			JSFUtil.addErrorMessage("create", e.getMessage());
		}
	}

	public List<T> findAll() {
		List<T> list = null;
		try {
			list = facade.findAll();
			JSFUtil.addInfoMessage("findAll", "Listou pessoas");
		} catch (Exception e) {
			JSFUtil.addErrorMessage("findAll", e.getMessage());
		}
		return list;
	}

	public T find(int id) {
		return facade.find(id);
	}

}
