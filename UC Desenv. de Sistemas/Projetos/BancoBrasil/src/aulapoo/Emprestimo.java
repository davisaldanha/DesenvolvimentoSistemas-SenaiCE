package aulapoo;


//Classe Empréstimo
public class Emprestimo {
    
    //Atributos da classe Empréstimo
    private int numero;
    private double valor;
    private int qtParcelas;
    private double juros;
    
    //Métodos de acesso get e set
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtParcelas() {
        return qtParcelas;
    }

    public void setQtParcelas(int qtParcelas) {
        this.qtParcelas = qtParcelas;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }
    
    //método para retornar o valor total a ser pago do empréstimo. Aqui já será aplicado o juros.
    public double valorTotal(){
        return this.valor*Math.pow((1+(this.juros/100)),this.qtParcelas);
    }
    
    //método que retorna as informações do empréstimo
    @Override
    public String toString(){
        return String.format("Nº do Empréstimo: %d\nValor solicitado: R$%.2f"
                + "\nQuantidade de parcelas: %d\nValor total: R$%.2f", this.numero, this.valor, this.qtParcelas, this.valorTotal());
    }
    
    //método que retorna as parcelas mensais a serem pagas pelo cliente
    public void parcelas(){
       String meses[] = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
       
       
        for(int i=0;i<this.qtParcelas;i++){
            System.out.println(meses[i] + " - R$" + (this.valorTotal()/this.qtParcelas));
        }
    }
}
