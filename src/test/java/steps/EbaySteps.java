package steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.mail.EmailException;
import org.testng.Assert;
import pages.EbayPage;

public class EbaySteps {
    private EbayPage ebayPage = null;

    @Before
    public void beforeScenario1(Scenario scenario) throws Exception {
        ebayPage = new EbayPage();
        ebayPage.initDriver(scenario);
    }
    @After
    public void afterScenario(Scenario scenario) throws Exception{
        if(scenario.isFailed()) {
            ebayPage.takeScreenshot(scenario);
        }
        ebayPage.closeDriver();
        ebayPage = null;
    }

    @Given("se encuentra abierto la página de Ebay")
    public void se_encuentra_abierto_la_página_de_Ebay() {
        Assert.assertTrue(ebayPage.validarLogoEbay(), "No esta abierta la página de Ebay");
    }
    @When("ingreso {string} en el campo de busqueda")
    public void ingreso_en_el_campo_de_busqueda(String producto) {
        ebayPage.ingresarProducto(producto);
    }

    @When("hago clic en el botón Buscar")
    public void hago_clic_en_el_botón_Buscar() {
        ebayPage.clicBuscar();
    }

    @Then("se muestra la etiqueta {string} como resultado de la busqueda")
    public void se_muestra_la_etiqueta_como_resultado_de_la_busqueda(String producto) {
        Assert.assertTrue(ebayPage.validarEtiquetaProducto(producto),"No se muestra el resultado de la busqueda");
    }

    @When("selecciono marca {string} para filtrar los resultados")
    public void selecciono_marca_para_filtrar_los_resultados(String marca) {
        ebayPage.seleccionarMarca(marca);
    }

    @Then("se muestra la etiqueta {string} como resultado")
    public void se_muestra_la_etiqueta_como_resultado(String marca) {
       Assert.assertTrue(ebayPage.validarEtiquetaMarca(marca),"No se muestra el filtro por producto");
    }

    @When("selecciono talla {string} para filtrar los resultados")
    public void selecciono_talla_para_filtrar_los_resultados(String talla) {
        ebayPage.seleccionarTalla(talla);
    }

    @Then("se muestra el total de resultados")
    public void se_muestra_el_total_de_resultados() {
        ebayPage.imprimirTotalResultados();
    }

    @When("ordeno por precio ascendente")
    public void ordeno_por_precio_ascendente() {
        ebayPage.clicOrdenAscendente();
    }

    @Then( "se ordena el resultado e imprimo los {int} primeros productos" )
    public void seOrdenaElResultadoEImprimoLosPrimerosProductos(int cant) {
        ebayPage.obtenerProductosPrecios(cant);
    }

    @Then("imprimo los productos por nombre ascendente")
    public void imprimo_los_productos_por_nombre_ascendente() {
        ebayPage.ordenarProductos();
    }

    @Then("imprimo los productos por precio descendente")
    public void imprimo_los_productos_por_precio_descendente() {
        ebayPage.OrdenPorPrecioAscendente();
    }

    @Then("envio reporte por correo")
    public void envio_reporte_por_correo() throws EmailException {
        ebayPage.EnviarInforme();
    }


}
