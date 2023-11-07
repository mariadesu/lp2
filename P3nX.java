import java.util.GregorianCalendar;
import java.util.Scanner;

import excps.*;


public class P3nX{


  public static Scanner entrada = new Scanner(System.in);
  public static Biblioteca biblioteca = new Biblioteca();
  public static String linha;

  public static void main(String[] args) throws NenhumaCopiaEmprestadaEx, CopiaNaoDisponivelEx, LivroNaoCadastradoEx, UsuarioNaoCadastradoEx{
    adicionaRandom();
    int num, cad = 0, emp = 0, rel = 0;
    
    //inicio
    System.out.println("Bem vindo a sua nova biblioteca.");
    
    //menu de opcoes
    System.out.println("[Menu] Selecione o que deseja realizar:\n1.Cadastro\n2.Emprestimo\n3.Relatorio\n4.Fechar biblioteca");
    num = entrada.nextInt();

    while(num!= 4){
      switch(num){
        
        //1.cadastro
        case 1:
          System.out.println("[Cadastro] Selecione o que deseja realizar:\n1.Cadastrar usuarios\n2.Cadastrar livros");
          cad = entrada.nextInt();

          if(cad == 1){ //Cadastrar usuarios
            cadastraUsu();
          }
          
          else if(cad == 2){ //Cadastrar livros
            cadastraLivro();
          }
          break;
        
        //2. emprestimo
        case 2:
          System.out.println("[Emprestimo] Selecione o que deseja realizar:\n1.Exibir o cadastro de Livros\n2.Solicitar um emprestimo\n3.Realizar uma devolucao");
          emp = entrada.nextInt();
          if(emp == 1){ //Exibir o cadastro de Livros 
            exibeLivros();
          }
          else if(emp == 2){ //Solicitar um emprestimo
            emprestimo();
          }
          else if(emp == 3){//Realizar uma devolucao
            devolucao();
          }
          break;
          
        case 3: //relatorio
          System.out.println("[Relatorio] Selecione o que deseja realizar:\n1.Listar o acervo de Livros\n2.Listar a agenda de usuarios\n3.Exibir detalhes de um livro especifico\n4.Exibir detalhes de um usuario especifico");
          rel = entrada.nextInt();

          if(rel == 1){ //Listar o acervo de Livros
            listaLivros();
          }
          else if(rel == 2){ //Listar a agenda de usuarios
            listaUsuarios();
          }
          else if(rel == 3){//Exibir detalhes de um livro especifico
            exibeLivro();
          }
          else if(rel == 4){//Exibir detalhes de um usuario especifico
            exibeUsu();
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

  //metodos

  //1. Cadastro
  //cadastrar usuario
  static void cadastraUsu(){
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
    System.out.println("\n" + u.toString() + "\n");
    biblioteca.cadastraUsuario(u.getCodigoUsuario(), u);
    System.out.println("Usuario cadastrado com sucesso.\n");
  }

  //cadastrar livro
  static void cadastraLivro(){
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
    System.out.println("\nLivro cadastrado  com sucesso.\n");
  }

  //2. Emprestimo
  // exibir os livros cadastrados
  static void exibeLivros(){
    System.out.println(biblioteca.imprimeLivros());
  }

  // solicitar um emprestimo
  static void emprestimo() throws CopiaNaoDisponivelEx, LivroNaoCadastradoEx, UsuarioNaoCadastradoEx{
    System.out.println("Insira o codigo do usuario solicitante: ");
    int codU = entrada.nextInt();
    linha = entrada.nextLine();
    System.out.println("Insira o codigo do livro a ser emprestado: ");
    String codL = entrada.nextLine();
    Usuario usuario = biblioteca.getUsuario(codU);
    Livro livro = biblioteca.getLivro(codL);
            
    biblioteca.emprestaLivro(usuario, livro);
    System.out.println("\nEmprestimo solicitado com sucesso.\n");
  }

  //realizar uma devolucao
  static void devolucao() throws NenhumaCopiaEmprestadaEx, LivroNaoCadastradoEx, UsuarioNaoCadastradoEx{
    System.out.println("Insira o codigo do usuario solicitante: ");
    int codU = entrada.nextInt();
    linha = entrada.nextLine();
    System.out.println("Insira o codigo do livro a ser devolvido: ");
    String codL = entrada.nextLine();
    Usuario usuario = biblioteca.getUsuario(codU);
    Livro livro = biblioteca.getLivro(codL);
            
    biblioteca.devolveLivro(usuario, livro);
    System.out.println("\nDevolucao realizada com sucesso.\n");
  }

  //3. Relatorio
  //Listar o acervo de Livros
  static void listaLivros(){
    System.out.println("\n[Acervo de livros]");
    System.out.println(biblioteca.imprimeLivros());
  }
  
  //Listar a agenda de usuarios
  static void listaUsuarios(){
    System.out.println("\n[Agenda de usuarios]");
    System.out.println(biblioteca.imprimeUsuarios());
  }
  
  //Exibir detalhes de um livro especifico
  static void exibeLivro() throws LivroNaoCadastradoEx{
    linha = entrada.nextLine();
    System.out.println("\nInsira o codigo do livro que deseja ver: ");
    String codL = entrada.nextLine();
    Livro livro = biblioteca.getLivro(codL);
    System.out.println("\n" + livro.toString() + "\n");
  }
  
  //Exibir detalhes de um usuario especifico
  static void exibeUsu() throws UsuarioNaoCadastradoEx{
    System.out.println("\nInsira o codigo do usuario que deseja ver: ");
    int codU = entrada.nextInt();
    Usuario usuario = biblioteca.getUsuario(codU);
    System.out.println("\n" + usuario.toString() + "\n");
  }

  //adiciona na biblioteca 1 usuario, 2 livros e realiza emprestimos
  static void adicionaRandom() throws CopiaNaoDisponivelEx, NenhumaCopiaEmprestadaEx {
    GregorianCalendar date = new GregorianCalendar(1999, 10, 5);
    Usuario w = new Usuario("Carlos", "Gomes", date, "123.456.789-01", 90f, 1.82f, "Maracana 123", 2);
    biblioteca.cadastraUsuario(w.getCodigoUsuario(), w);

    Livro i = new Livro("2", "Senhor dos Aneis", "Aventura", 2, 1);
    biblioteca.cadastraLivro(i.getCodigoLivro(), i);

    Livro j = new Livro("3", "Fazendo meu Filme", "Romance", 4, 0);
    biblioteca.cadastraLivro(j.getCodigoLivro(), j);

    biblioteca.emprestaLivro(w, i);
    biblioteca.devolveLivro(w, i);
    biblioteca.emprestaLivro(w, j);
  }

}