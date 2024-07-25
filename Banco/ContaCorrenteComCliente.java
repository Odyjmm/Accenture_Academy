package Banco;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ContaCorrenteComCliente {
    private int numero;
    private Cliente cliente;
    private double saldo;
    private Date data;
    private List<String> extrato;
    
    public ContaCorrenteComCliente() {}
    
    public ContaCorrenteComCliente(int numero, Cliente cliente, double saldo, Date data, List<String> extrato) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = saldo;
        this.data = data;
        this.extrato = extrato;
    }

    public List<String> getExtrato() {
        return extrato;
    }

    public void setExtrato(List<String> extrato) {
        this.extrato = extrato;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
            " reais ao saldo anterior de " + saldoAntigo + ". O novo saldo é: " + saldoNovo);
    }

    public String ExibirExtrato() {
        return extrato.toString();
    }

    public void Transferir (double valor, ContaCorrenteComCliente contaDestino) {
        if (valor <= 0 || valor > saldo) System.out.println("Operação Invalida");

        double saldoAntigo = saldo;
        double saldoNovo = saldo - valor;
        this.setSaldo(saldoNovo);

        contaDestino.depositar(valor);

        extrato.add("Operação realizada às " + java.time.LocalDateTime.now() + " do dia " + LocalDate.now().getDayOfWeek().name() + " transferindo " + valor +
            " reais para " + contaDestino.getCliente().getNome() + " " + contaDestino.getCliente().getSobrenome()  +
            ", do saldo anterior de " + saldoAntigo + ". O novo saldo é: " + saldoNovo);
    }
}