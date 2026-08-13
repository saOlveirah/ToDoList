/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_1;

import java.util.Scanner;


public class ToDoList {
    
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);  
    
        String[] tarefas = new String[10];
        boolean[] concluidas = new boolean[10];
    
        int opcao = 0;
    
        while (opcao !=5) {
        System.out.println("Lista de tarefas");
        System.out.println("1- Adicionar tarefa");
        System.out.println("2- Listar Tarefa");
        System.out.println("3- Concluir tarefa");
        System.out.println("4- Excluir tarefa");
        System.out.println("5- Sair");
    
        System.out.println("Digite a opcao que voce quer: ");
        int escolha = scanner.nextInt();
        }
    }
}
