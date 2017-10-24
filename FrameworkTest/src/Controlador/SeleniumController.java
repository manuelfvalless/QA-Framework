package Controlador;

import javafx.stage.PopupWindow;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SeleniumController {

    private WebDriver driver;
    private String baseUrl;
    Execution evidenciaEjecucion = new Execution();

    public Execution getEvidenciaEjecucion() {
        return evidenciaEjecucion;
    }

    public void setEvidenciaEjecucion(Execution evidenciaEjecucion) {
        this.evidenciaEjecucion = evidenciaEjecucion;
    }
    
    public void setUp(String rutaEvidencia) throws Exception {//Módulos
        evidenciaEjecucion.setPathOriginal(rutaEvidencia);
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Inovabiz\\Desktop\\QA\\drivers\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dlsclient\\Desktop\\Carpeta\\drivers\\drivers\\geckodriver.exe");
        //System.setProperty("phantomjs.binary.path", "C:\\Users\\Inovabiz\\Desktop\\QA\\drivers\\drivers\\phantomjs.exe");
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        //driver = new PhantomJSDriver();	
        //driver.manage().
        System.out.println("=== LEVANTANDO EL BROWSER ===");
        baseUrl = "http://cargaqa.dls.cl";
        System.out.println("define url");
        System.out.println("REDIRECCIONANDO....");
        driver.get(baseUrl);
        
    }

    public void setUpWeb(String rutaEvidencia) throws Exception { //Para asistencia en viajes
        evidenciaEjecucion.setPathOriginal(rutaEvidencia);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dlsclient\\Desktop\\Carpeta\\drivers\\drivers\\chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\Inovabiz\\Desktop\\QA\\drivers\\drivers\\geckodriver.exe");
        //System.setProperty("phantomjs.binary.path", "C:\\Users\\Inovabiz\\Desktop\\QA\\drivers\\drivers\\phantomjs.exe");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new PhantomJSDriver();	
        System.out.println("=== LEVANTANDO EL BROWSER ===");
        baseUrl = "http://emisionwebqa.cl"; 
        System.out.println("define url");
        System.out.println("REDIRECCIONANDO....");
        driver.get(baseUrl);
    }
    
    public void producto(String producto) throws Exception {               
        switch(producto){
            case "Todos":
                ProcesoPrincipal todos = new ProcesoPrincipal();
                evidenciaEjecucion.setPathOriginal(evidenciaEjecucion.getPathOriginal() + "\\Pruebas" + " " + evidenciaEjecucion.getFechaEjecucion().toString());
                System.out.println("Ruta: " + evidenciaEjecucion.getPathOriginal());
                todos.setEvidenciaEjecucion(evidenciaEjecucion);
                todos.setDriver(driver);
                todos.executeTest();
                //todos.executeTestEmisionWeb();
                break;
            case "Modificar despecho nómina":
                ProcesoPrincipal testDLS = new ProcesoPrincipal();
                evidenciaEjecucion.setPathOriginal(evidenciaEjecucion.getPathOriginal()+"\\Proceso DLS"+" "+evidenciaEjecucion.getFechaEjecucion().toString());
                System.out.println("Ruta: "+evidenciaEjecucion.getPathOriginal());
                testDLS.setEvidenciaEjecucion(evidenciaEjecucion);
                testDLS.setDriver(driver);
                testDLS.executeTest();    
                break;
            case "Redestinación agencia":
                ProcesoPrincipal testDLSContingente = new ProcesoPrincipal();
                evidenciaEjecucion.setPathOriginal(evidenciaEjecucion.getPathOriginal() + "\\Proceso DLS" + " " + evidenciaEjecucion.getFechaEjecucion().toString());
                System.out.println("Ruta: " + evidenciaEjecucion.getPathOriginal());
                testDLSContingente.setEvidenciaEjecucion(evidenciaEjecucion);
                testDLSContingente.setDriver(driver);
                testDLSContingente.executeTest();
                break;  
            /*case "Emision Web":
                ProcesoPrincipal emisionWeb = new ProcesoPrincipal();
                evidenciaEjecucion.setPathOriginal(evidenciaEjecucion.getPathOriginal() + "\\Emision Web" + " " + evidenciaEjecucion.getFechaEjecucion().toString());
                System.out.println("Ruta: " + evidenciaEjecucion.getPathOriginal());
                emisionWeb.setEvidenciaEjecucion(evidenciaEjecucion);
                emisionWeb.setDriver(driver);
                emisionWeb.executeTestEmisionWeb();
                break;*/
        }
    }//Ejecuta universo de pruebas.
    
    public void test(String nombreTest) throws Exception {        
        ProcesoPrincipal test = new ProcesoPrincipal();
        evidenciaEjecucion.setPathOriginal(evidenciaEjecucion.getPathOriginal()+"\\Test"+" "+evidenciaEjecucion.getFechaEjecucion().toString());
        System.out.println("Ruta: "+evidenciaEjecucion.getPathOriginal());
        test.setEvidenciaEjecucion(evidenciaEjecucion);
        test.setDriver(driver);
        test.executeTestByName(nombreTest);
       //test.testDescargaExcelJava();
    }//Ejecuta un test en específico.
}
