public class Aplicativo {
  private int codigo;
  private String nome;
  private String so;
  private double valorMensalAssinatura;
  private int contAplicativos;
  
  public Aplicativo(int codigo, String nome, String so, double valorMensalAssinatura){
    this.codigo = codigo;
    this.nome = nome;
    this.valorMensalAssinatura = valorMensalAssinatura;
    this.so = so;
    this.contAplicativos = 0;
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
}
