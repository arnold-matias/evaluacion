package objets;

import org.openqa.selenium.By;

public class EbayObj {

    public By logoEbay;
    public By lblBuscar;
    public By btnBuscar;
    public By txtProducto;
    public By checMarca;
    public By txtMarca;
    public By checTalla;
    public By txtTotalResultado;
    public By txtOrdenAscendente;
    public By txtNombreProductos;
    public String txtNombreProducto;
    public String txtPrecioProducto;
    public By txtOrdenDescendente;
    public By btnOrdenarPor;

    private String IMG_LOGO;
    private String LBL_BUSCAR;
    private String BTN_BUSCAR;
    private String TXT_PRODUCTO;
    private String CHK_MARCA;
    private String TXT_MARCA;
    private String CHK_TALLA;
    private String TXT_TOTAL_RESULTADOS;
    private String TXT_ORDEN_ASCENDENTE;
    private String TXT_NOMBRE_PRODUCTOS;
    private String TXT_ORDEN_DESCENDENTE;
    private String BTN_ORDENAR_POR;

    public EbayObj(){
        setObjetos();
    }

    private void setObjetos(){
        IMG_LOGO = "//*[@id=\"gh-la\"]";
        LBL_BUSCAR= "gh-ac";
        BTN_BUSCAR = "gh-btn";
        TXT_PRODUCTO = "//*[@id=\"mainContent\"]/div[1]/div/div[2]/div/div[1]/h1/span[2]";
        CHK_MARCA = "//input[@aria-label='PUMA']";
        TXT_MARCA ="//*[@id=\"srp-river-results-query_answer1-w0-x-carousel-items\"]/ul/li[1]/div/a/div";
        CHK_TALLA = "//input[@aria-label='10']";
        TXT_TOTAL_RESULTADOS = "//*[@id=\"mainContent\"]/div[1]/div/div[2]/div/div[1]/h1/span[1]";
        TXT_ORDEN_ASCENDENTE = "//*[@id=\"w7\"]/div/div/ul/li[4]/a";
        TXT_NOMBRE_PRODUCTOS = "//*[@id=\"srp-river-results-listing1\"]/div/div[2]/a/h3";
        txtNombreProducto = "//*[@id=\"srp-river-results-listing@label\"]/div/div[2]/a/h3";
        txtPrecioProducto = "//*[@id=\"srp-river-results-listing@label\"]/div/div[2]/div[3]/div[1]/span";
        TXT_ORDEN_DESCENDENTE = "//*[@id=\"w7\"]/div/div/ul/li[5]/a";
        BTN_ORDENAR_POR = "//*[@id=\"w7\"]/button/div/div";

        logoEbay = By.xpath(IMG_LOGO);
        lblBuscar = By.id(LBL_BUSCAR);
        btnBuscar = By.id(BTN_BUSCAR);
        txtProducto = By.xpath(TXT_PRODUCTO);
        checMarca = By.xpath(CHK_MARCA);
        txtMarca = By.xpath(TXT_MARCA);
        checTalla = By.xpath(CHK_TALLA);
        txtTotalResultado = By.xpath(TXT_TOTAL_RESULTADOS);
        txtOrdenAscendente = By.xpath(TXT_ORDEN_ASCENDENTE);
        txtNombreProductos = By.xpath(TXT_NOMBRE_PRODUCTOS);
        txtOrdenDescendente = By.xpath(TXT_ORDEN_DESCENDENTE);
        btnOrdenarPor = By.xpath(BTN_ORDENAR_POR);
    }

}
