# AppCirculoBarra

## Descripción

Aplicación Android que combina Fragmentos y dibujo en Canvas. Presenta un control SeekBar para modificar el tamaño de figuras dibujadas en un lienzo dentro de un Fragment.

## Características

- Uso de Fragmentos
- Dibujo personalizado con Canvas
- Control interactivo mediante SeekBar
- Comunicación entre Activity y Fragment

## Tecnologías

- Java
- Android SDK
- Fragments
- Canvas
- SeekBar

## Estructura del Proyecto

- MainActivity.java: Activity principal que contiene el Fragment
- MiFragmento.java: Fragment que muestra el lienzo personalizado
- Lienzo.java: View personalizada para dibujo
- ctivity_main.xml: Layout principal con FrameLayout para Fragment
- ragment_mifragmento.xml: Layout del Fragment

## Funcionamiento

La aplicación muestra un SeekBar que permite ajustar el tamaño de una figura dibujada en Canvas. El dibujo se realiza dentro del Fragment mediante una clase personalizada Lienzo que extiende View.

## Requisitos

- Android API 24+