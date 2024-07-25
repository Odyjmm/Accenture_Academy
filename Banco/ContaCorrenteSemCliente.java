package Banco;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ContaCorrenteSemCliente {
    private int numero;
    private String nome;
    private double saldo;
    private Date data;
    private List<String> extrato;
    
    public ContaCorrenteSemCliente() {}
    
    public ContaCorrenteSemCliente(int numero, String nome, double saldo, Date data, List<String> extrato) {
        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
        this.data = data;
        this.extrato = extrato;
    }

    public List<String> getExtrato() {
        return extrato;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setExtrato(List<String> extrato) {
        this.extrato = extrato;
    }

    public void depositar(double valor) {
        if (valor <= 0) System.out.println("Operação Invalida");
        
        double saldoAntigo = saldo;
        double saldoNovo = saldo + valor;
        this.setSaldo(saldoNovo);

        extrato.add("Operação realizada às " + java.time.LocalDateTime.now() + " do dia " + LocalDate.now().getDayOfWeek().name() + " adicionando " + valor +
            " reais ao saldo anterior de " + saldoAntigo + ". O novo saldo é: " + saldoNovo);
    }

    public void sacar(double valor) {
        if (valor <= 0 || valor > saldo) System.out.println("Operação Invalida");

        double saldoAntigo = saldo;
        double saldoNovo = saldo - valor;
        this.setSaldo(saldoNovo);

        extrato.add("Operação realizada às " + java.time.LocalDateTime.now() + " do dia " + LocalDate.now().getDayOfWeek().name() + " retirando " + valor +
            " reais do saldo anterior de " + saldoAntigo + ". O novo saldo é: " + saldoNovo);
    }

    public String ExibirExtrato() {
        return extrato.toString();
    }

    public void Transferir (double valor, ContaCorrenteSemCliente contaDestino) {
        if (valor <= 0 || valor > saldo) System.out.println("Operação Invalida");

        double saldoAntigo = saldo;
        double saldoNovo = saldo - valor;
        this.setSaldo(saldoNovo);

        contaDestino.depositar(valor);

        extrato.add("Operação realizada às " + java.time.LocalDateTime.now() + " do dia " + LocalDate.now().getDayOfWeek().name() + " transferindo " + valor +
            " reais para " + contaDestino.getNome()  + ", do saldo anterior de " + saldoAntigo + ". O novo saldo é: " + saldoNovo);
    }
}