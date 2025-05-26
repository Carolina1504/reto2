# reto2

Automatización de pruebas para formulario web usando Selenium, Cucumber y Maven.

---

## Tecnologías y versiones utilizadas

- Java 11  
- Selenium 4.11.0  
- Cucumber 7.12.1  
- JUnit 4.13.2  
- WebDriverManager 5.4.1  
- Maven 3.8+  
- Guava 32.1.2-jre  

---

## ¿Qué hace que esta automatización sea una solución óptima?

- **Modularidad:** Uso de Page Object Model para mantener código limpio y reutilizable.  
- **Manejo automático de drivers:** WebDriverManager simplifica la configuración y evita incompatibilidades.  
- **Reportes con evidencia visual:** Capturas de pantalla en reportes HTML facilitan la revisión de resultados.  
- **Escenarios en Gherkin:** Facilita la colaboración entre técnicos y stakeholders no técnicos.  
- **Gestión con Maven:** Dependencias y ejecución centralizadas para un flujo ágil y reproducible.

---

## Casos de prueba diseñados (documentados en lenguaje Gherkin)

### Caso 1: Validar correo electrónico válido

```gherkin
Scenario: Ingresar correo con formato válido
Given El usuario está en el formulario
When Ingresa un correo válido "usuario@ejemplo.com"
Then El sistema acepta el correo sin error
