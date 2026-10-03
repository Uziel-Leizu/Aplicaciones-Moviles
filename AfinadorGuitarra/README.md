# AfinadorGuitarra

## Descripción

Aplicación Android que funciona como afinador de guitarra. Permite al usuario reproducir las notas de las diferentes cuerdas de la guitarra (E, A, D, G, B, E) mediante el uso de archivos de audio.

## Características

- Reproducción de sonidos de cuerdas de guitarra
- Interfaz con botones para cada cuerda
- Visualización del nombre de la cuerda en reproducción
- Manejo del ciclo de vida del MediaPlayer (pause, stop)

## Tecnologías

- Java
- Android SDK
- MediaPlayer API

## Estructura del Proyecto

- MainActivity.java: Activity principal con lógica para reproducción de audio
- ctivity_main.xml: Diseño con botones y TextView
- es/raw/: Archivos de audio para cada cuerda (.ogg)
- es/drawable/: Imágenes (incluye diagrama de guitarra)
- es/values/strings.xml: Recursos de cadenas

## Funcionalidad

La aplicación presenta botones para las 6 cuerdas de la guitarra (E1, A1, D1, G1, B1, E2). Al presionar un botón, se reproduce el archivo de audio correspondiente y se actualiza el TextView con el mensaje "Reproduciendo [cuerda]".

## Archivos de Audio

- cuerdae2.ogg, cuerdaa1.ogg, cuerdad1.ogg, cuerdag1.ogg, cuerdab1.ogg, cuerdae1.ogg

## Requisitos

- Android API 24+
- Altavoz o auriculares para escuchar las notas