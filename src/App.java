public class App {
    public static void main(String[] args) throws Exception {
        
        Catalogo catalogo = new Catalogo();
        catalogo.cadastraAppNoCatalogo(new Aplicativo(1, "Calculadora", "Android", 2.99));
        catalogo.cadastraAppNoCatalogo(new Aplicativo(2, "Calculadora", "IOS", 4.99));
        catalogo.cadastraAppNoCatalogo(new Aplicativo(3, "AppCozinhando", "Android", 5.99));
        catalogo.cadastraAppNoCatalogo(new Aplicativo(4, "AppCozinhando", "IOS", 7.99));
        catalogo.cadastraAppNoCatalogo(new Aplicativo(5, "Encontre sua Localização", "Android", 4.75));
        catalogo.cadastraAppNoCatalogo(new Aplicativo(6, "Encontre sua Localização", "IOS", 6.57));
        Assinatura assinatura = new Assinatura("123", "1", "0356798451", "01", "2023", "01", "2024");
        
        catalogo.mostraNomeAplicativos();
        
        System.out.println(catalogo.mostraFaturamentoAndroid());

    }
}
