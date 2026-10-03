# SOSArduinoUNO

## Descripción

Sistema de señal SOS controlado mediante Arduino y Android vía Bluetooth. La aplicación Android se conecta a un Arduino mediante Bluetooth y permite activar/desactivar una señal SOS visual (LED/Foco) que parpadea en código Morse SOS (... --- ...).

## Características

- Conexión Bluetooth con Arduino
- Control ON/OFF mediante ToggleButton
- Envío de comandos al Arduino
- Recepción de datos desde Arduino
- Implementación con Hilos (Thread) para control asíncrono
- Uso de biblioteca BluJhr para comunicación Bluetooth
- Indicador visual de estado (Foco/ImageView)

## Tecnologías

- Java
- Android SDK
- Bluetooth
- BluJhr Library
- Threads (Hilos)
- ToggleButton

## Estructura del Proyecto

- MainActivity.java: Activity principal con lógica Bluetooth y control SOS
- Hilos.java: Clase Thread para manejo asíncrono de la señal SOS
- ctivity_main.xml: Layout con interfaz de control
- AndroidManifest.xml: Permisos Bluetooth

## Funcionamiento

1. Búsqueda y conexión a módulo Bluetooth emparejado (Arduino)
2. ToggleButton activa/desactiva el envío de señal SOS
3. Al activar, se inicia un hilo (Hilos) que controla el envío de comandos
4. Se envía señal al Arduino para activar el patrón SOS (... --- ...)
5. Indicador visual (ImageView) muestra el estado del foco/LED

## Comunicación Bluetooth

La aplicación se comunica con Arduino enviando comandos para controlar la señal SOS. Recibe respuesta del Arduino y la muestra en consola.

## Componentes Hardware Recomendados

- Arduino UNO
- Módulo Bluetooth HC-05/HC-06
- LED o dispositivo de señalización
- Resistencia adecuada

## Requisitos

- Android API 24+
- Dispositivo con Bluetooth
- Arduino configurado con módulo Bluetooth