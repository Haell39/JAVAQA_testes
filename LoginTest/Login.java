package LoginTest;

public class Login {
    private String usuario;
    private String senha;

    // Getters e Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Método para verificar se o login é válido
    public boolean isLoginValido() {
        return usuario != null && !usuario.isEmpty() && senha != null && !senha.isEmpty();
    }

    // Método que verifica se a senha não tem mais de 8 caracteres
    public boolean isSenhaValida() {
        return senha != null && senha.length() <= 8;
    }
}

