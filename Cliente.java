import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private int numConta;
    private int senha;
    private double saldo;

    private List<String> extrato = new ArrayList<>();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Cliente(String nome, String cpf, String email, String telefone, int numConta, int senha, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.numConta = numConta;
        this.senha = senha;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<String> getExtrato() {
        return extrato;
    }

    public void setExtrato(List<String> extrato) {
        this.extrato = extrato;
    }

    public void depositar(double valor) {
        saldo += valor;
        String registro = "Depósito de R$ " + valor + " em " + LocalDateTime.now().format(formatter);
        extrato.add(registro);
        System.out.println("Depósito realizado com sucesso!");
    }

    public void saque(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            String registro = "Saque de R$ " + valor + " em " + LocalDateTime.now().format(formatter);
            extrato.add(registro);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para o saque.");
        }
    }

    public void verExtrato() {
        System.out.println("==== Extrato de Transações ====");
        if (extrato.isEmpty()) {
            System.out.println("Nenhuma transação realizada.");
        } else {
            for (String registro : extrato) {
                System.out.println(registro);
            }
        }
        System.out.println("===============================");
    }

    public void informacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Num Conta: " + numConta);
        System.out.println("Saldo: R$ " + saldo);
    }
}
