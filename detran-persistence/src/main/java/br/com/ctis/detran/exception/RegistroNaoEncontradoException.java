package br.com.ctis.detran.exception;

import br.com.ctis.detran.mensagem.Mensagem;
import br.com.ctis.detran.mensagem.MensagemErro;

/**
 * Exceção para Registro não encontrado do tipo {@link RuntimeException}.
 *
 * @author felipe.n.sousa@ctis.com.br
 */
public class RegistroNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;

	private Mensagem mensagem;

	public RegistroNaoEncontradoException() {
		super();
	}

	public RegistroNaoEncontradoException(String message) {
		this.mensagem = new MensagemErro(message);
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

}
