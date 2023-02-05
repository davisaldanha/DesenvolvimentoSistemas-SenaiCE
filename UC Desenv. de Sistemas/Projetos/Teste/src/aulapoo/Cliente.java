
package aulapoo;

public class Cliente {
    private String nome;
    private String cpf;
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    //Sobrescrevendo método toString() da classe Object
    @Override
    public String toString(){
        return String.format("Nome: %s | CPF: %s", this.nome, this.cpf);
        
    }
    
}
