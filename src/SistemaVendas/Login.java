package SistemaVendas;

import SistemaVendas.Autentificar;

public class Login implements Autentificar {

	String usuario = "admin";
	String senha = "123456";

	public boolean Logar(String usuario, String senha) {

		if (usuario.equals(this.usuario) && senha.equals(this.senha)) {
			System.out.println(" ACESSO LIBERADO ");

			return true;
		} else {
			System.out.println(" USU�RIO INV�LIDO");

			return false;
		}
	}
}
