package aulapoo;

//classe Conta
public class Conta {
    //Atributos da classe
    private int numero;
    private Cliente usuario;
    private double saldo;
    double limite = 1000;
    private Emprestimo[] emprestimo;
    
    //Construtor
    Conta(){}   
    
        
    //Métodos Getters e Setters
    public int getNumero(){
        return this.numero;
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public Cliente getUsuario(){
        return this.usuario;
    }
    
    public Emprestimo[] getEmprestimo(){
        return this.emprestimo;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    public void setUsuario(Cliente usuario){
        this.usuario = usuario;
    }

    public void setEmprestimo(Emprestimo[] emprestimo) {
        this.emprestimo = emprestimo;
    }
    
    //método para sacar um valor da conta
    void sacar(double quantidade){
        if(this.saldo>=quantidade){
            //Condição para avaliar se a quantidade é <= ao limite
            if(quantidade <= this.limite){
                this.saldo = this.saldo - quantidade;
                System.out.println("Saque concluído!");
            }
            else
                System.out.println("Limite ultrapassado!");
        }else{
            System.out.println("Valor indisponível!");
        }
    }
    
    //método para depositar um valor na conta
    public void depositar(double quantidade){
        this.saldo = this.saldo + quantidade;
        System.out.println("Deposito Finalizado!");
    }
    
    //método para visualizar informações da conta
    @Override
    public String toString(){
       return String.format("Nº da Conta: %d\n"
                            + usuario.toString()
                            + "\nSaldo: R$ %.2f", this.numero, this.saldo);
    } 

}
