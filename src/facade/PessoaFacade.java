package facade;

import entityTeste.Pessoa;

/**
 * 
 * @author jonas
 */

public class PessoaFacade extends AbstractFacade<Pessoa> {

	public PessoaFacade() {
		super(Pessoa.class);
		setPersistenceUnit("entityTeste");
	}

}
