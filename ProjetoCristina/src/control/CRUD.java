package control;

import java.io.IOException;

public interface CRUD {

	public void gravar() throws IOException;
	public void deletar() throws IOException;
	public void atualizar() throws IOException;
	public void ler() throws IOException;
}
