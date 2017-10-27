import java.util.*;
import java.lang.StringBuilder;

class Principal{
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		Stack <String> pilha = new Stack<String>();
		String cadeia;
		String[][] tblSintatica = new String[10000][10000];
		
		
		// construindo tabela sintática
		tblSintatica['E']['+'] = null;
		tblSintatica['E']['-'] = null;
		tblSintatica['E']['*'] = null;
		tblSintatica['E']['/'] = null;
		tblSintatica['E']['i'] = "TS";
		tblSintatica['E']['n'] = "TS";
		tblSintatica['E']['('] = "TS";
		tblSintatica['E'][')'] = null;
		tblSintatica['E']['$'] = null;
		
		tblSintatica['T']['+'] = null;
		tblSintatica['T']['-'] = null;
		tblSintatica['T']['*'] = null;
		tblSintatica['T']['/'] = null;
		tblSintatica['T']['i'] = "FG";
		tblSintatica['T']['n'] = "FG";
		tblSintatica['T']['('] = "FG";
		tblSintatica['T'][')'] = null;
		tblSintatica['T']['$'] = null;
		
		tblSintatica['S']['+'] = "+TS";
		tblSintatica['S']['-'] = "+TS";
		tblSintatica['S']['*'] = null;
		tblSintatica['S']['/'] = null;
		tblSintatica['S']['i'] = null;
		tblSintatica['S']['n'] = null;
		tblSintatica['S']['('] = null;
		tblSintatica['S'][')'] = "|";
		tblSintatica['S']['$'] = "|";
		
		tblSintatica['G']['+'] = "|";
		tblSintatica['G']['-'] = "|";
		tblSintatica['G']['*'] = "*FG";
		tblSintatica['G']['/'] = "*FG";
		tblSintatica['G']['i'] = null;
		tblSintatica['G']['n'] = null;
		tblSintatica['G']['('] = null;
		tblSintatica['G'][')'] = "|";
		tblSintatica['G']['$'] = "|";
		
		tblSintatica['F']['+'] = null;
		tblSintatica['F']['-'] = null;
		tblSintatica['F']['*'] = null;
		tblSintatica['F']['/'] = null;
		tblSintatica['F']['i'] = "i";
		tblSintatica['F']['n'] = "n";
		tblSintatica['F']['('] = "(E)";
		tblSintatica['F'][')'] = null;
		tblSintatica['F']['$'] = null;
		
		
		/*
		tblSintatica['E']['a'] = "TX";
		tblSintatica['E']['b'] = "TX";
		tblSintatica['E']['+'] = null;
		tblSintatica['E']['$'] = null;
		
		tblSintatica['X']['a'] = null;
		tblSintatica['X']['b'] = null;
		tblSintatica['X']['+'] = "+E";
		tblSintatica['X']['$'] = "|";
		
		tblSintatica['T']['a'] = "a";
		tblSintatica['T']['b'] = "b";
		tblSintatica['T']['+'] = null;
		tblSintatica['T']['$'] = null;
		*/

		// lendo cadeia de caracteres.
		System.out.printf("Digite a Cadeia: "); 
			cadeia = sc.next() + "$";
		
		// inserindo 'Não terminal' inicial na pilha
		pilha.push("$");
		pilha.push("E");
		
			
		String valTopo=null, caractere=null, regra= null, printPilha = "$E";
		
		System.out.println("\n\nPILHA  : " + printPilha + "\nCADEIA : " + cadeia + "\nREGRA  : " + regra); 
		System.out.println("----------------------------------------------------");
							
		while(true){
			if(!pilha.empty()){
				valTopo = pilha.peek();
				caractere = String.valueOf(cadeia.charAt(0));
				if(valTopo.equals("|") && caractere.equals("$")) {
					pilha.pop(); printPilha = printPilha.substring(0, printPilha.length()-1);
				} else if(!(valTopo.equals(caractere))) {
					pilha.pop(); printPilha = printPilha.substring(0, printPilha.length()-1);
					int linha = valTopo.charAt(0);
					int coluna = caractere.charAt(0);
					try{
						regra = tblSintatica[linha][coluna];
						String aux = new StringBuilder(regra).reverse().toString(); // invertendo string e salvando na pilha.
						for(int i=0; i < aux.length(); i++){
							pilha.push(String.valueOf(aux.charAt(i))); printPilha += pilha.peek();
						}
					}catch(NullPointerException e){
						System.out.println("PILHA  : " + printPilha + "\nCADEIA : " + cadeia + "\nREGRA  : CADEIA INVALIDA");
						break; 
					}
				
				} else {
					pilha.pop(); printPilha = printPilha.substring(0, printPilha.length()-1);
					cadeia = cadeia.substring(1, cadeia.length());	// removendo primeiro caractere da cadeia.				
				}
			System.out.println("PILHA  : " + printPilha + "\nCADEIA : " + cadeia + "\nREGRA  : " + regra); 
			System.out.println("----------------------------------------------------");
		} else{
			System.out.println("PILHA  : " + printPilha + "\nCADEIA : " + cadeia + "\nREGRA  : SUCESSO"); 
			System.out.println("----------------------------------------------------");
			break;
		}
	}
			
	}
		
	}

