Feature: Validar formulario de contacto

  Scenario: Enviar formulario correctamente
    Given el usuario abre la página del formulario
    And el usuario ingresa "Juan Perez" en el campo nombre
    And ingresa "juan@example.com" en el campo correo
    And el usuario escribe "Mensaje de prueba" en el campo mensaje
    And acepta los términos y condiciones
    When el usuario hace clic en el botón "Enviar"
    Then el formulario se procesa y se muestra una alerta de éxito

  Scenario: Enviar sin aceptar términos
    Given el usuario abre la página del formulario
    And el usuario ingresa "Ana Gomez" en el campo nombre
    And ingresa "ana@example.com" en el campo correo
    And el usuario escribe "Otro mensaje" en el campo mensaje
    And no selecciona la casilla de términos y condiciones
    When el usuario hace clic en el botón "Enviar"
    Then se debe mostrar un mensaje de advertencia sobre los términos