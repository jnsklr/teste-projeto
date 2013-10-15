package facade;

import entityTeste.Telefone;

/**
 * 
 * @author jonas
 */
public class TelefoneFacade extends AbstractFacade<Telefone> {

	public TelefoneFacade() {
		super(Telefone.class);
		setPersistenceUnit("entityTeste");
	}

}
