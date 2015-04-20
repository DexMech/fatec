package control;

import java.io.IOException;

public interface CRUD {

	public void gravar() throws IOException;
	public void deletar(String nome) throws IOException;
	public void atualizar(String nome) throws IOException;
	public void ler() throws IOException;
}
