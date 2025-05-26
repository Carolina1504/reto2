package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormSteps {

    WebDriver driver;

    @Given("el usuario abre la página del formulario")
    public void el_usuario_abre_la_página_del_formulario() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://64.227.54.255/Softesting/Frontend/Caso1.html");
    }

    @Given("el usuario ingresa {string} en el campo nombre")
    public void el_usuario_ingresa_en_el_campo_nombre(String nombre) {
        WebElement campoNombre = driver.findElement(By.id("nombre"));
        campoNombre.clear();
        campoNombre.sendKeys(nombre);
    }

    @Given("ingresa {string} en el campo correo")
    public void ingresa_en_el_campo_correo(String correo) {
        WebElement campoCorreo = driver.findElement(By.id("email"));
        campoCorreo.clear();
        campoCorreo.sendKeys(correo);
    }

    @Given("el usuario escribe {string} en el campo mensaje")
    public void el_usuario_escribe_en_el_campo_mensaje(String mensaje) {
        WebElement campoMensaje = driver.findElement(By.id("mensaje"));
        campoMensaje.clear();
        campoMensaje.sendKeys(mensaje);
    }

    @Given("acepta los términos y condiciones")
    public void acepta_los_términos_y_condiciones() {
        WebElement checkbox = driver.findElement(By.id("terminos"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @Given("no selecciona la casilla de términos y condiciones")
    public void no_selecciona_la_casilla_de_términos_y_condiciones() {
        WebElement checkbox = driver.findElement(By.id("terminos"));
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @When("el usuario hace clic en el botón {string}")
    public void el_usuario_hace_clic_en_el_boton(String textoBoton) {
        WebElement boton = driver.findElement(By.xpath("//button[text()='" + textoBoton + "']"));
        boton.click();
    }

    @Then("el formulario se procesa y se muestra una alerta de éxito")
    public void el_formulario_se_procesa_y_se_muestra_una_alerta_de_exito() {
        Alert alert = driver.switchTo().alert();
        String mensaje = alert.getText();
        Assert.assertTrue(mensaje.toLowerCase().contains("éxito") || mensaje.toLowerCase().contains("exito"));
        alert.accept();
        driver.quit();
    }

    @Then("se debe mostrar un mensaje de advertencia sobre los términos")
    public void se_debe_mostrar_un_mensaje_de_advertencia_sobre_los_términos() {
        Alert alert = driver.switchTo().alert();
        String mensaje = alert.getText();
        Assert.assertTrue(mensaje.toLowerCase().contains("términos") || mensaje.toLowerCase().contains("terminos"));
        alert.accept();
        driver.quit();
    }
}