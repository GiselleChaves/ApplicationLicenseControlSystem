public class App {
    public static void main(String[] args) throws Exception {
        
        CatalogoAplicativo catalogoApp = new CatalogoAplicativo();
        catalogoApp.cadastraAppNoCatalogo(new Aplicativo(1, "Calculadora", "android", 2.99));
        catalogoApp.cadastraAppNoCatalogo(new Aplicativo(2, "Calculadora", "ios", 4.99));
        catalogoApp.cadastraAppNoCatalogo(new Aplicativo(3, "AppCozinhando", "android", 5.99));
        catalogoApp.cadastraAppNoCatalogo(new Aplicativo(4, "AppCozinhando", "ios", 7.99));
        catalogoApp.cadastraAppNoCatalogo(new Aplicativo(5, "Encontre sua Localização", "android", 4.75));
        catalogoApp.cadastraAppNoCatalogo(new Aplicativo(7, "Contação de Histórias", "android", 5.13));
        catalogoApp.cadastraAppNoCatalogo(new Aplicativo(6, "Encontre sua Localização", "ios", 6.57));
       
        catalogoApp.mostraNomeAplicativos();
        System.out.println(catalogoApp.getContAplicativos());

        System.out.println(catalogoApp.mostraFaturamentoAndroid());
        System.out.println(catalogoApp.mostraFaturamentoIOS());
        System.out.println(catalogoApp.alterarNomeAplicativo(1, "Calculator"));
        catalogoApp.mostraNomeAplicativos();

        Assinantes assinantes = new Assinantes();
        assinantes.adicionarAssinatura(new Assinatura("123", "1", "0356798451", "01", "2023"));
        assinantes.adicionarAssinatura(new Assinatura("124", "2", "5678954682", "08", "2022"));
        assinantes.adicionarAssinatura(new Assinatura("125", "7", "0356798451", "01", "2023"));
        
        
        

        Cliente c1 = new Cliente(10, "Maria Santos", "maria@email.com");
        Cliente c2 = new Cliente(11, "Joana Martins", "joana@email.com");
        Cliente c3 = new Cliente(12, "Paulo Correa", "paulo@email.com");
        Cliente c4 = new Cliente(13, "Carolina Filho", "Carolina@email.com");
    }
}
