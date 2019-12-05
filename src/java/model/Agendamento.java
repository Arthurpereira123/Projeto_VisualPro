package model;
public class Agendamento {
    private String hora;
    private String data;
    private String funcionario;
    private String cliente;
    private int agendamento;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(int agendamento) {
        this.agendamento = agendamento;
    }
}