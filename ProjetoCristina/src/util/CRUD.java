package util;

/**
 * @author Arthur Gomes
 * @version 1.x
 * 
 * <ul><h3>Versões</h3>
 * 		<li>1.0 - Criação da interface</li>
 * 		<li>1.1 - Mudança em alguns métodos</li>
 * </ul>*/

import java.io.IOException;

public interface CRUD {

	/**
	 * Interface responsável por garantir que os controles realizem todos os 
	 * métodos do CRUD
	 */
	
	public void gravar(String fileName) throws IOException;
	public void deletar(String parametro, String fileName) throws IOException;
	public void atualizar(String parametro, String[] novoConteudo, String fileName) throws IOException;
	public String[] ler(String fileName, String identificador) throws IOException;
}
