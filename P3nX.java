import java.util.GregorianCalendar;
import java.util.Scanner;


public class P3nX{

  public static void main(String[] args) throws NenhumaCopiaEmprestadaEx, CopiaNaoDisponivelEx, LivroNaoCadastradoEx, UsuarioNaoCadastradoEx{
    
    Scanner entrada = new Scanner(System.in);
    int num, cad = 0, emp = 0, rel = 0;
    String linha;
    Biblioteca biblioteca = new Biblioteca();
    
    //inicio
    System.out.println("Bem vindo a sua nova biblioteca.");
    
    //menu de opcoes
    System.out.println("[Menu] Selecione o que deseja realizar:\n1.Cadastro\n2.Emprestimo\n3.Relatorio\n4.Fechar biblioteca");
    num = entrada.nextInt();
    while(num!= 4){
      switch(num){
      
        case 1: //cadastro
          System.out.println("[Cadastro] Selecione o que deseja realizar:\n1.Cadastrar usuarios\n2.Cadastrar livros");
          cad = entrada.nextInt();

          if(cad == 1){ //Cadastrar usuarios
            linha = entrada.nextLine();
            System.out.println("Insira o nome: ");
            String nome = entrada.nextLine();
            System.out.println("Insira o sobrenome: ");
            String sobreNome = entrada.nextLine();
            System.out.println("Insira a data de nascimento no formato dd mm aaaa: ");
            int dia = entrada.nextInt();
            int mes = entrada.nextInt();
            int ano = entrada.nextInt();
            GregorianCalendar data = new GregorianCalendar(ano, mes-1, dia);
            linha = entrada.nextLine();
            System.out.println("Insira o CPF: ");
            String cpf = entrada.nextLine();
            System.out.println("Insira o peso: ");
            float peso = entrada.nextFloat();
            System.out.println("Insira a altura: ");
            float altura = entrada.nextFloat();
            linha = entrada.nextLine();
            System.out.println("Insira o endereco: ");
            String endereco = entrada.nextLine();
            System.out.println("Insira o codigo de Usuario: ");
            int codigoUsuario = entrada.nextInt();
            Usuario u = new Usuario(nome, sobreNome, data, cpf, peso, altura, endereco, codigoUsuario);
            System.out.println(u.toString());
            biblioteca.cadastraUsuario(u.getCodigoUsuario(), u);
            System.out.println("Usuario cadastrado com sucesso.\n");
          }
          
          else if(cad == 2){ //Cadastrar livros
            linha = entrada.nextLine();
            System.out.println("Insira o titulo: ");
            String tituloLivro = entrada.nextLine();
            System.out.println("Insira o codigo: ");
            String codigoLivro = entrada.nextLine();
            System.out.println("Insira a categoria: ");
            String categoria = entrada.nextLine();
            System.out.println("Insira a quantidade de volumes: ");
            int quantidade = entrada.nextInt();
            System.out.println("Insira a quantidade de volumes emprestados atualmente: ");
            int emprestados = entrada.nextInt();
            Livro l = new Livro(codigoLivro, tituloLivro, categoria, quantidade, emprestados);
            biblioteca.cadastraLivro(l.getCodigoLivro(), l);
            System.out.println("Livro cadastrado  com sucesso.\n");
          }
          break;
          
        case 2: //emprestimo
          System.out.println("[Emprestimo] Selecione o que deseja realizar:\n1.Exibir o cadastro de Livros\n2.Solicitar um emprestimo\n3.Realizar uma devolucao");
          emp = entrada.nextInt();
          if(emp == 1){ //Exibir o cadastro de Livros 
            System.out.println(biblioteca.imprimeLivros() + "\n");
          }
          else if(emp == 2){ //Solicitar um emprestimo
            System.out.println("Insira o codigo do usuario solicitante: ");
            int codU = entrada.nextInt();
            linha = entrada.nextLine();
            System.out.println("Insira o codigo do livro a ser emprestado: ");
            String codL = entrada.nextLine();
            Usuario usuario = biblioteca.getUsuario(codU);
            Livro livro = biblioteca.getLivro(codL);
            
            biblioteca.emprestaLivro(usuario, livro);
            System.out.println("Emprestimo solicitado com sucesso.\n");
          }
          else if(emp == 3){//Realizar uma devolucao
            System.out.println("Insira o codigo do usuario solicitante: ");
            int codU = entrada.nextInt();
            linha = entrada.nextLine();
            System.out.println("Insira o codigo do livro a ser devolvido: ");
            String codL = entrada.nextLine();
            Usuario usuario = biblioteca.getUsuario(codU);
            Livro livro = biblioteca.getLivro(codL);
            
            biblioteca.devolveLivro(usuario, livro);
            System.out.println("Devolucao realizada com sucesso.\n");
          }
          break;
          
        case 3: //relatorio
          System.out.println("[Relatorio] Selecione o que deseja realizar:\n1.Listar o acervo de Livros\n2.Listar a agenda de usuarios\n3.Exibir detalhes de um livro especifico\n4.Exibir detalhes de um usuario especifico");
          rel = entrada.nextInt();
          if(rel == 1){ //Listar o acervo de Livros
            System.out.println("[Acervo de livros]");
            System.out.println(biblioteca.imprimeLivros());
          }
          else if(rel == 2){ //Listar a agenda de usuarios
            System.out.println("[Agenda de usuarios]");
            System.out.println(biblioteca.imprimeUsuarios());
          }
          else if(rel == 3){//Exibir detalhes de um livro especifico
            linha = entrada.nextLine();
            System.out.println("Insira o codigo do livro que deseja ver: ");
            String codL = entrada.nextLine();
            Livro livro = biblioteca.getLivro(codL);
            System.out.println(livro.toString());
          }
          else if(rel == 4){//Exibir detalhes de um usuario especifico
            System.out.println("Insira o codigo do usuario que deseja ver: ");
            int codU = entrada.nextInt();
            Usuario usuario = biblioteca.getUsuario(codU);
            System.out.println(usuario.toString());
          }
          break;
      }
      System.out.println("Selecione o que deseja realizar:\n1.Cadastro\n2.Emprestimo\n3.Relatorio\n4.Fechar biblioteca");
      num = entrada.nextInt();
    }
    
    //finalizar
    if(num==4){
      System.out.println("Biblioteca fechada. Volte sempre.");
    }
    
    entrada.close();
  }
  
}