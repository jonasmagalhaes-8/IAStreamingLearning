package machinelearning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import machinelearning.Model.GeneroModel;
import machinelearning.Model.MidiaModel;
import machinelearning.Model.UsuarioModel;

public class MachineLearning {
    
    private static List<GeneroModel> listaGeneros = new ArrayList<>();
    private static List<MidiaModel> listaMidias = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        inicializaListaGeneros();
        inicializaAcervoConteudo();
        UsuarioModel usuarioCadastrado = cadastraUsuario();
        assistirConteudo(usuarioCadastrado, usuarioCadastrado.getSugestoesConteudo());
    }

     private static void inicializaListaGeneros() {
        listaGeneros.add(new GeneroModel("Comédia"));
        listaGeneros.add(new GeneroModel("Ação"));
        listaGeneros.add(new GeneroModel("Drama"));
        listaGeneros.add(new GeneroModel("Terror"));
        listaGeneros.add(new GeneroModel("Suspense"));
    }
    
    private static void inicializaAcervoConteudo() {
        

        String[] titulosComedia = {
                "Superbad", "Missão Madrinha de Casamento", "Se Beber, Não Case!", "Anchorman: A Lenda de Ron Burgundy", "O Grande Hotel Budapeste",
                "Débi & Lóide: Dois Idiotas em Apuros", "Curtindo a Vida Adoidado", "A Princesa Prometida", "Napoleon Dynamite", "Isto é Spinal Tap",
                "Feitiço do Tempo", "Os Caça-Fantasmas", "Apertem os Cintos... O Piloto Sumiu", "Clube dos Pilantras", "Todo Mundo Quase Morto",
                "O Grande Lebowski", "Fargo", "O Virgem de 40 Anos", "Jovens, Loucos e Rebeldes", "Zoolander"
        };

        String[] titulosAcao = {
                "Duro de Matar", "John Wick", "Mad Max: Estrada da Fúria", "O Cavaleiro das Trevas", "Missão: Impossível",
                "Gladiador", "Matrix", "Pantera Negra", "A Origem", "Vingadores: Ultimato",
                "O Exterminador do Futuro 2: O Julgamento Final", "Kill Bill: Volume 1", "Velocidade", "007 - Um Novo Dia para Morrer", "Identidade Bourne",
                "Indiana Jones e Os Caçadores da Arca Perdida", "Rambo: Programado para Matar", "Top Gun: Ases Indomáveis", "Coração Valente", "O Exterminador do Futuro"
        };

        String[] titulosDrama = {
                "Um Sonho de Liberdade", "O Poderoso Chefão", "A Lista de Schindler", "Forrest Gump", "A Rede Social",
                "The Crown", "Breaking Bad", "The Wire", "Família Soprano", "O Gambito da Rainha",
                "Uma Mente Brilhante", "À Procura da Felicidade", "À Espera de Um Milagre", "Beleza Americana", "O Pianista",
                "O Poderoso Chefão: Parte II", "Os Infiltrados", "Um Sonho Possível", "Gênio Indomável", "O Regresso"
        };

        String[] titulosTerror = {
                "O Exorcista", "Psicose", "Corra!", "A Hora do Pesadelo", "Invocação do Mal",
                "Hereditário", "Atividade Paranormal", "O Iluminado", "It: A Coisa", "Halloween",
                "Babadook", "Um Lugar Silencioso", "Nós", "A Bruxa", "Projeto Blair Witch",
                "Poltergeist", "Pânico", "Sobrenatural", "Cabana do Inferno", "O Sexto Sentido"
        };

        String[] titulosSuspense = {
                "Garota Exemplar", "O Silêncio dos Inocentes", "Seven: Os Sete Crimes Capitais", "Amnésia", "Ilha do Medo",
                "Os Suspeitos", "Os Infiltrados", "A Garota com a Tatuagem de Dragão", "Onde os Fracos Não Têm Vez", "Zodíaco",
                "Clube da Luta", "Os Suspeitos", "Fogo Contra Fogo", "O Grande Truque", "Os Sete Samurais",
                "Bastardos Inglórios", "O Silêncio", "Os Outros", "O Sexto Sentido", "Oldboy"
        };

        for (int i = 0; i < 20; i++) {
            listaMidias.add(new MidiaModel(titulosComedia[i], new GeneroModel("Comédia")));
            listaMidias.add(new MidiaModel(titulosAcao[i], new GeneroModel("Ação")));
            listaMidias.add(new MidiaModel(titulosDrama[i], new GeneroModel("Drama")));
            listaMidias.add(new MidiaModel(titulosTerror[i], new GeneroModel("Terror")));
            listaMidias.add(new MidiaModel(titulosSuspense[i], new GeneroModel("Suspense")));
        }
    }

    private static UsuarioModel cadastraUsuario() {
        UsuarioModel usuario = new UsuarioModel();
        
        System.out.print("Informe seu nome: ");
        usuario.setNome(sc.next());
                
        List<GeneroModel> listaGenerosSelecao = new ArrayList<>();
        
        listaGenerosSelecao.addAll(listaGeneros);
        
        System.out.println("Vamos conhecer seus interesses, escolha até 3 gêneros:");
        
        System.out.println("Informe o nº do que voce gosta de assistir");
        
        int i, tamanhoLista;
                
        int selecao;

        do {
             for (i = 0, tamanhoLista = listaGenerosSelecao.size(); i < tamanhoLista; i++) {
                 System.out.println(i+1 + " - " + listaGenerosSelecao.get(i).getNome());
             }
             
             System.out.println("(digite 0 para encerrar a seleção)");

             selecao = sc.nextInt();
             System.out.flush();  
             if(selecao>i) {
                 System.out.println("Gênero informado inválido!");
             }
             else {
                 if(selecao!=0) {
                     GeneroModel generoSelecionado = listaGenerosSelecao.get(selecao-1);
                     listaGenerosSelecao.remove(selecao-1);
                     usuario.getGenerosFavoritos().add(generoSelecionado);
                     usuario.getSugestoesConteudo().addAll(procuraConteudoPorGenero(generoSelecionado));
                 }
             }
        }while(selecao!=0 && tamanhoLista!=1 && usuario.getGenerosFavoritos().size()<3);
        
        return usuario;
    }
    
    private static List<MidiaModel> procuraConteudoPorGenero(GeneroModel genero) {
        List<MidiaModel> midiasGenero = new ArrayList<>();
        for (MidiaModel midia : listaMidias) {
            if (midia.getGenero().getNome().equals(genero.getNome())) {
                midiasGenero.add(midia);
            }
        }
        return midiasGenero;
    }

    private static void assistirConteudo(UsuarioModel usuarioLogado, List<MidiaModel> listaFilmes) {
        int i, tamanhoLista;
                
        int selecao;

        for (i = 0, tamanhoLista = listaFilmes.size(); i < tamanhoLista; i++) {
            System.out.println(i+1 + " - " + listaFilmes.get(i).getTitulo());
        }
        
        System.out.print("Informe o nº do filme que quer assistir ou 0 para mostrar mais filmes:");

        selecao = sc.nextInt();
        if(selecao>i) {
            System.out.println("Filme informado inválido!");
        }
        else {
                if(selecao==0) {
                    assistirConteudo(usuarioLogado, listaMidias);
                }
                else {
                    System.out.println("Play no filme!");
                    
                    MidiaModel midiaAssistida = listaFilmes.get(selecao-1);
                    
                    usuarioLogado.getHistoricoConteudo().add(midiaAssistida); 
                                  
                    boolean generoNaoFavorito = true;
                        
                    for(GeneroModel genero: usuarioLogado.getGenerosFavoritos()) {
                        if(genero.getNome().equals(midiaAssistida.getGenero().getNome())) {
                            generoNaoFavorito = false;
                            break;
                        }
                    }
                    
                    if(generoNaoFavorito) {
                            usuarioLogado.getGenerosFavoritos().add(midiaAssistida.getGenero());
                            usuarioLogado.getSugestoesConteudo().clear();
                            for(GeneroModel genero: usuarioLogado.getGenerosFavoritos()) {
                                usuarioLogado.getSugestoesConteudo().addAll(procuraConteudoPorGenero(genero));
                            }
                    }

                    if(usuarioLogado.getGenerosFavoritos().size()>3) {
                        usuarioLogado.getSugestoesConteudo().clear();
                        usuarioLogado.getGenerosFavoritos().clear();
                        int tamanhoHistorico = usuarioLogado.getHistoricoConteudo().size();
                        int index = Math.max(tamanhoHistorico - 3, 0);
                            
                        for (i = tamanhoHistorico - 1; i >= index; i--) {
                            usuarioLogado.getGenerosFavoritos().add(usuarioLogado.getHistoricoConteudo().get(i).getGenero());
                            usuarioLogado.getSugestoesConteudo().addAll(procuraConteudoPorGenero(usuarioLogado.getHistoricoConteudo().get(i).getGenero()));
                        }
                    }
                    assistirConteudo(usuarioLogado, usuarioLogado.getSugestoesConteudo());
                }
        }
    }
}
