package LoginTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @Test
    void testLoginValido() {
        Login login = new Login();
        login.setUsuario("usuario");
        login.setSenha("senha123");
        assertTrue(login.isLoginValido());
    }

    @Test
    void testLoginInvalidoUsuarioVazio() {
        Login login = new Login();
        login.setUsuario("");
        login.setSenha("senha123");
        assertFalse(login.isLoginValido());
    }

    @Test
    void testLoginInvalidoSenhaVazia() {
        Login login = new Login();
        login.setUsuario("usuario");
        login.setSenha("");
        assertFalse(login.isLoginValido());
    }

    @Test
    void testSenhaValida() {
        Login login = new Login();
        login.setSenha("abc123");
        assertTrue(login.isSenhaValida());
    }

    @Test
    void testSenhaInvalida() {
        Login login = new Login();
        login.setSenha("123456789"); // 9 caracteres
        assertFalse(login.isSenhaValida());
    }
}
