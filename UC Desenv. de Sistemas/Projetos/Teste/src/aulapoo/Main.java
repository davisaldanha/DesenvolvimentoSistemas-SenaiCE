package aulapoo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double valor;
        int opcao = -1;
        
        //Criando os objetos do tipo Conta, Cliente e Emprestimo
        Conta conta1 = new Conta();
        Cliente cliente1 = new Cliente();
        Emprestimo[] emprestimoArray = new Emprestimo[1];
        
                
        
        System.out.println("Seja Bem-Vindo ao Banco Brasil!");
        System.out.print("Digite o seu nome: ");
        cliente1.setNome(scan.next());
        System.out.print("\nDigite o seu CPF [Apenas números]:");
        cliente1.setCpf(scan.next());
        
        //Atribuindo o objeto cliente1 a conta1
        conta1.setUsuario(cliente1);
        
        System.out.print("\nInforme o número da conta: ");        
        conta1.setNumero(scan.nextInt());
        
        while(opcao!=6){
            System.out.printf("Bem Vindo %s ao Banco Brasil\n", conta1.getUsuario().getNome());
            System.out.println(".......M E N U.......");
            System.out.println("1- Despositar");
            System.out.println("2- Sacar");
            System.out.println("3- Exibir Informações");
            System.out.println("4- Transferir");
            System.out.println("5- Empréstimo");
            System.out.println("6- Sair");
            System.out.print("--> ");
            opcao = scan.nextInt();

            switch(opcao){
                case 1: 
                    System.out.print("Digite o valor para deposito: ");
                    valor = scan.nextDouble();
                    conta1.depositar(valor);
                    break;
                case 2:
                    System.out.print("Digite o valor para saque: ");
                    valor = scan.nextDouble();
                    conta1.sacar(valor);
                    break;
                case 3:
                    System.out.println(conta1.toString());
                    break;
                case 4:
                    
                    break;
                case 5:
                    System.out.println("-------EMPRÉSTIMO BANCO BRASIL-------");
                    System.out.println("1- Contratar");
                    System.out.println("2- Visualizar");
                    System.out.print("--> ");
                    opcao = scan.nextInt();
                    
                    switch(opcao){
                        case 1:                            
                            System.out.printf("Quantos empréstimos a contratar:");
                            int qtdVetor = scan.nextInt();

                            if(qtdVetor > 3)
                                System.out.println("Quantidade indisponível!");
                            else{
                                emprestimoArray = new Emprestimo[qtdVetor];

                                for(int i=0;i<qtdVetor;i++){
                                    Emprestimo emprestimoObjeto = new Emprestimo();
                                    emprestimoObjeto.setNumero(i+1);

                                    System.out.printf("Valor do empréstimo: R$");
                                    emprestimoObjeto.setValor(scan.nextDouble());

                                    System.out.printf("\nQuantidade de parcelas:");
                                    emprestimoObjeto.setQtParcelas(scan.nextInt());

                                    System.out.printf("\nInforme o juros: ");
                                    emprestimoObjeto.setJuros(scan.nextDouble());

                                    emprestimoArray[i] = emprestimoObjeto;                        
                                }                    
                            }
                            break;
                        case 2:
                            for(int i=0;i<emprestimoArray.length;i++){
                                System.out.println(emprestimoArray[i].toString());
                            }
                            break;
                    }                                  
                    break;
                case 6: System.out.println("Até breve!");break;
                default: System.out.println("Opcao Inválida");
            }
        }        
    }
    
}
