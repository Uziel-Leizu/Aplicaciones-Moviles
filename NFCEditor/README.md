# NFCEditor

## Descripción

Aplicación Android para leer y escribir etiquetas NFC (Near Field Communication). Permite escribir URLs en etiquetas NFC y leer contenido de etiquetas detectadas.

## Características

- Escritura de URLs en etiquetas NFC
- Lectura de etiquetas NFC
- Soporte para formatos NDEF
- Diálogos de confirmación para escritura/lectura
- Modo foreground dispatch para lectura continua

## Tecnologías

- Java
- Android SDK
- NFC API
- NDEF (NFC Data Exchange Format)

## Estructura del Proyecto

- MainActivity.java: Activity principal con lógica NFC
- ctivity_main.xml: Layout con campo URL y botón de escritura
- AndroidManifest.xml: Requiere permisos y características NFC

## Funcionamiento

1. El usuario ingresa una URL y presiona "Write URL"
2. Se muestra un diálogo indicándole que acerque la etiqueta NFC
3. Al acercar la etiqueta, se escribe la URL en formato NDEF Record (URI)
4. La aplicación también detecta y lee etiquetas NFC cuando están en rango

## Permisos Requeridos

- NFC: ndroid.permission.NFC

## Notas

Requiere un dispositivo Android con hardware NFC habilitado.

## Requisitos

- Android API 24+
- Dispositivo con NFC