package application;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities.enums.Nivel_Trabalhador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.print("Informe o nome do departamento: ");
            String nomeDepartamento = sc.nextLine();
            System.out.println("Infome os dados do trabalhador ");
            System.out.print("Nome: ");
            String nomeTrabalhador = sc.nextLine();
            System.out.print("Informe o nivel do trabalhador: ");
            String nivelTrabalhador = sc.nextLine();
            System.out.print("Informe o salario base: ");
            double salarioBase = sc.nextDouble();
            Trabalhador trabalhador = new Trabalhador(nomeTrabalhador,Nivel_Trabalhador.valueOf(nivelTrabalhador),salarioBase,new  Departamento(nomeDepartamento));


            System.out.print("Quantos contratos tem o trabalhador : ");
            int n = sc.nextInt();

            for(int i=1 ; i <= n ; i ++){
                System.out.println("Informe os dados do # " + i + " Contrato ");
                System.out.print("Data DD/MM/YYYY : ");
                Date dataContrato = sdf.parse(sc.next());
                System.out.print("Informe o valor ganho por hora: ");
                double valorHora = sc.nextDouble();
                System.out.print("Informe a duração em horas:");
                int horasContrato = sc.nextInt();

                HoraContrato contrato = new HoraContrato(dataContrato,valorHora,horasContrato);
                trabalhador.addContrato(contrato);
            }

            System.out.println();
        System.out.print("Informe o mes e o ano para calcular o salario MM/YYYY: ");
        String mesEano = sc.next();
        int mes = Integer.parseInt(mesEano.substring(0,2));
        int ano = Integer.parseInt(mesEano.substring(3));
        System.out.println("Nome: "+ trabalhador.getNome());
        System.out.println("Departamento : " + trabalhador.getDepartamento().getNome());
        System.out.println("Renda ganha pelo trabalhador: " + mesEano + " : " + String.format("%.2f" ,trabalhador.renda(ano,mes)));


               sc.close();
        }
    }
