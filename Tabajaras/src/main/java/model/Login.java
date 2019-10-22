
package model;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
    private String user;
    private String senha;

    public Login(String user, String senha){
        this.user = user;
        this.senha = senha;
    }

    public Login(JTextField jUser, JPasswordField jSenha) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public String getUser() {
        return user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
}

