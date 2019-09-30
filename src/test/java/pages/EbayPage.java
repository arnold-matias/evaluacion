package pages;

import core.Driver;
import io.cucumber.core.api.Scenario;
import objets.EbayObj;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

public class EbayPage extends BasePage {
    private EbayObj ebayObj = null;

    NotificationEmail notificacion = new NotificationEmail();
    PrintStream fichero = new PrintStream(new File("D:/fichero.txt"));
    public EbayPage() throws FileNotFoundException {
        ebayObj = new EbayObj();
    }

    public void initDriver(Scenario scenario) throws Exception{
        driver = new Driver();
    }
    public void takeScreenshot(Scenario scenario) throws IOException {
        if(driver!=null)
            driver.takeScreenShot(scenario);
    }
    public void closeDriver() {
        driver.tearDown();
    }

    public boolean validarLogoEbay(){
        return driver.elementIsPresent(ebayObj.logoEbay);
    }

    public void ingresarProducto(String producto){
        driver.sendKeys(producto,ebayObj.lblBuscar);
    }

    public void clicBuscar(){
        driver.click(ebayObj.btnBuscar);
    }

    public boolean validarEtiquetaProducto(String producto){
        driver.waitForElement(ebayObj.txtProducto);
        String prod = driver.getVisibleText(ebayObj.txtProducto);

        return (producto.equals(prod))?true:false;
    }

    public void seleccionarMarca(String marca){
        driver.click(ebayObj.checMarca);
    }

    public boolean validarEtiquetaMarca(String marca) {
        driver.waitForElement(ebayObj.txtMarca);
        String marcaProducto = driver.getVisibleText(ebayObj.txtMarca);
        String marcaproducto = marcaProducto.substring(0,4);
        return (marcaproducto.equals(marca))?true:false;
    }

    public void seleccionarTalla(String talla){
        driver.click(ebayObj.checTalla);
    }

    public void imprimirTotalResultados(){
         String totalProducto = driver.getVisibleText(ebayObj.txtTotalResultado);
        System.out.println("=====================================");
        System.setOut(fichero);
        System.out.println("En total son "+totalProducto+" productos");
    }

    public void clicOrdenAscendente(){
        driver.moverMouse(ebayObj.btnOrdenarPor);
        driver.sleep(2);
        driver.click(ebayObj.txtOrdenAscendente);
    }


    private String getEtiqueta(String xpath, String value) {
        return xpath.replace("@label", value);
    }

    public void obtenerProductosPrecios(int cant){
        driver.waitForElement(ebayObj.txtNombreProductos);
        for (int i =1;i<=cant;++i){
           String num= Integer.toString(i);
           String nombres = getEtiqueta(ebayObj.txtNombreProducto,num);
           String precios = getEtiqueta(ebayObj.txtPrecioProducto,num);
            String nombreProducto= driver.getVisibleText(By.xpath(nombres));
           String precioProducto = driver.getVisibleText(By.xpath(precios));
            System.out.println("Producto "+num+": "+nombreProducto+" precio "+precioProducto);
        }
    }

    public void ordenarProductos(){
        OrdenPorNombre();
    }

    public void clicOrdenDescendente(){
        driver.moverMouse(ebayObj.btnOrdenarPor);
        driver.sleep(2);
        driver.click(ebayObj.txtOrdenDescendente);
    }
    public void OrdenPorNombre() {
        int cant=5;
        int e=0;
        String[] productos = new String[cant];
        for (int i =1;i<=cant;++i) {
            String num = Integer.toString(i);
            String nombres = getEtiqueta(ebayObj.txtNombreProducto, num);
            String prueba = "n" + i;
            prueba = driver.getVisibleText(By.xpath(nombres));
            productos[e] = prueba;
            e++;
        }
            Arrays.sort(productos);

            System.out.println("\nProductos ordenados alfabeticamente");
            for (String producto : productos) {
                System.setOut(fichero);
                System.out.println(producto);
            }
        }
    public void OrdenPorPrecioAscendente() {
        int cant=5;
        int can=5;
        int e=0;
        double pp=0;
        String[] productos = new String[cant];
        String [] precios = new String[can];
        for (int i =1;i<=cant;++i) {
            String num = Integer.toString(i);
            String nombres = getEtiqueta(ebayObj.txtNombreProducto, num);
            String valor1 = driver.getVisibleText(By.xpath(nombres));
            String montos = getEtiqueta(ebayObj.txtPrecioProducto,num);
            String valor2 = driver.getVisibleText(By.xpath(montos));
          //  String p = valor2.replaceAll("[^0-9]", "");
            String totales = valor2+" "+valor1;
            productos[e] = valor1;
            precios[e] = totales;
            e++;
        }
        Arrays.sort(precios, Collections.reverseOrder());

        System.out.println("\nProductos ordenados por precio descendente");
        for (String precio : precios) {
            System.setOut(fichero);
            System.out.println(precio);
        }
    }
    public void EnviarInforme() throws EmailException {
        notificacion.EnviarCorreo();
    }
}
