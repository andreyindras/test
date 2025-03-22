package com.gestaolixoeletronico.terminal;

import com.gestaolixoeletronico.entities.PontoColeta;
import com.gestaolixoeletronico.entities.Usuario;
import com.gestaolixoeletronico.enums.TipoUsuario;
import com.gestaolixoeletronico.service.PontoColetaService;
import com.gestaolixoeletronico.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class TerminalApp implements CommandLineRunner {

    private final PontoColetaService pontoColetaService;
    private final UsuarioService usuarioService;

    @Autowired
    public TerminalApp(PontoColetaService pontoColetaService, UsuarioService usuarioService) {
        this.pontoColetaService = pontoColetaService;
        this.usuarioService = usuarioService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Listar todos os pontos de coleta");
            System.out.println("2 - Adicionar novo ponto de coleta");
            System.out.println("3 - Buscar pontos de coleta por usuário");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    listarTodosPontosColeta();
                    break;
                case 2:
                    adicionarNovoPontoColeta(scanner);
                    break;
                case 3:
                    buscarPontosColetaPorUsuario(scanner);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        System.out.println("Aplicação encerrada.");
    }

    private void listarTodosPontosColeta() {
        List<PontoColeta> pontosColeta = pontoColetaService.listarTodos();
        if (pontosColeta.isEmpty()) {
            System.out.println("Nenhum ponto de coleta encontrado.");
        } else {
            pontosColeta.forEach(ponto -> System.out.println(ponto.getName() + " - " + ponto.getEndereco()));
        }
    }

    private void adicionarNovoPontoColeta(Scanner scanner) {
        System.out.println("Digite o nome do ponto de coleta:");
        String nome = scanner.nextLine();

        System.out.println("Digite o endereço:");
        String endereco = scanner.nextLine();

        System.out.println("Digite o número:");
        String numero = scanner.nextLine();

        System.out.println("Digite o bairro:");
        String bairro = scanner.nextLine();

        System.out.println("Digite os dias de funcionamento:");
        String diasFuncionamento = scanner.nextLine();

        System.out.println("Digite o horário de abertura:");
        String horarioAbertura = scanner.nextLine();

        System.out.println("Digite o horário de fechamento:");
        String horarioFechamento = scanner.nextLine();

        System.out.println("Digite o ID do usuário responsável:");
        Long usuarioId = scanner.nextLong();
        scanner.nextLine(); // Consumir a nova linha

        Usuario usuario = usuarioService.buscarPorId(usuarioId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        PontoColeta pontoColeta = new PontoColeta(nome, endereco, numero, bairro, diasFuncionamento, horarioAbertura, horarioFechamento, usuario);
        pontoColetaService.salvar(pontoColeta);

        System.out.println("Ponto de coleta adicionado com sucesso!");
    }

    private void buscarPontosColetaPorUsuario(Scanner scanner) {
        System.out.println("Digite o ID do usuário:");
        Long usuarioId = scanner.nextLong();
        scanner.nextLine(); // Consumir a nova linha

        List<PontoColeta> pontosColeta = pontoColetaService.buscarPorUsuario(usuarioId);
        if (pontosColeta.isEmpty()) {
            System.out.println("Nenhum ponto de coleta encontrado para este usuário.");
        } else {
            pontosColeta.forEach(ponto -> System.out.println(ponto.getName() + " - " + ponto.getEndereco()));
        }
    }
}