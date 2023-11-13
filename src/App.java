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
        
        
        //Assinatura assinatura = new Assinatura("123", "1", "0356798451", "01", "2023", "01", "2024");
        
        
        catalogoApp.mostraNomeAplicativos();
        System.out.println(catalogoApp.getContAplicativos());

        System.out.println(catalogoApp.mostraFaturamentoAndroid());
        System.out.println(catalogoApp.mostraFaturamentoIOS());
        //catalogo.alterarNomeAplicativo(a -> a.getCodigo()==1, a -> a.setNome("Novo Nome"));
    }
}
