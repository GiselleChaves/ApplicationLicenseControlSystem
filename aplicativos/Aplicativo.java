package aplicativos;

import clientes.Cliente;

public class Aplicativo {
  private int codigo;
  private String nome;
  private double valorMensalAssinatura;
  private String so;
  private int contAplicativos;

  private double totalFaturamentoAndroid;
  private double totalFaturamentoIOS;

  public Aplicativo(int codigo, String nome, double valorMensalAssinatura, String so){
    this.codigo = codigo;
    this.nome = nome;
    this.valorMensalAssinatura = valorMensalAssinatura;
    this.so = so;

    if(so.equals("android")){
      totalFaturamentoAndroid += getValorMensalAssinatura();
    }
    else if(so.equals("ios")){
      totalFaturamentoIOS += getValorMensalAssinatura();
    }
    this.contAplicativos = 0;
  }

  public double getTotalFaturamentoAndroid() {
    return totalFaturamentoAndroid;
  }

  public double getTotalFaturamentoIOS() {
    return totalFaturamentoIOS;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSo() {
    return so;
  }

  public void setSo(String so) {
    this.so = so;
  }

  public double getValorMensalAssinatura() {
    return valorMensalAssinatura;
  }

  public void setValorMensalAssinatura(double valorMensalAssinatura) {
    this.valorMensalAssinatura = valorMensalAssinatura;
  }

  public int getContAplicativos() {
    return contAplicativos;
  }

  public void setContAplicativos(int contAplicativos) {
    this.contAplicativos = contAplicativos;
  }

  public String toLineFile() {
      return codigo + "," + nome + "," + valorMensalAssinatura + "," + so ;
  }

  public static Aplicativo fromLineFile(String line) {
    String[] tokens = line.split(",");
    
    int codigo = Integer.parseInt(tokens[0]);
    String nome = tokens[1];
    double valorMensalAssinatura = Double.parseDouble(tokens[2]);
    String so = tokens[3];

    return new Aplicativo(codigo, nome, valorMensalAssinatura, so);
  }
}