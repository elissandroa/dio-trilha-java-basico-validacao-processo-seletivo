package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

	public static void main(String[] args) {
		System.out.println("Processo Seletivo");
		String[] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
		
		for(String candidato: candidatos) {
			entrandoEmContato(candidato);
		}
		
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando) {
				tentativasRealizadas++;
			} else {
				System.out.println("CONTATO REALIZADO COM SUCESSO !");
			}
		}while(continuarTentando && tentativasRealizadas < 3);
		
		if (atendeu) {
			System.out.println("CONSEGUIMOS CONTATO COM "+ candidato + " NA " + tentativasRealizadas + " TENTATIVA");
		} else {
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MÁXIMO DE TENTATIVAS FORAM "+ tentativasRealizadas);
		}
	}
	
	
	static boolean atender() {
		return new Random().nextInt(3) == 1;
	}
	
	
	
	static void imprimirSelecionados() {
		String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA"};
		System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");
		for(int indice = 0; indice < candidatos.length; indice++) {
			System.out.println("O candidato de n°: "+ (indice+1) + " é: "+ candidatos[indice]);
		}
	}
	
	static void selecaoCandidatos() {
		String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"};
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			
						
			System.out.println("O candidato: "+ candidato + " Solicitou este valor de salário: R$"+String.format("%.2f",salarioPretendido));
			if(salarioBase >= salarioPretendido) {
				System.out.println("O candidato: "+ candidato + " foi selecionado para a vaga");
				candidatosSelecionados++;
			}
			candidatoAtual++;
			
		}
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800,2200);
	}
	
	
	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		String msg = (salarioBase > salarioPretendido) ? "LIGAR PARA O CANDIDATO" 
					: (salarioBase  == salarioPretendido) ? "LIGAR PARA O CANDIDADO COM CONTRA PROPOSTA" 
					: "AGUARDANDO O RESULTADO DOS DEMAIS CANDIDADOS";
		
		System.out.println(msg);
	}

}
