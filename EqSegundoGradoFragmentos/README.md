# EqSegundoGradoFragmentos

## Descripción

Versión mejorada de la calculadora de ecuaciones de segundo grado que utiliza Fragmentos para separar la lógica de la interfaz. Demuestra el uso de Fragments en Android.

## Características

- Implementación con Fragmentos
- Separación de responsabilidades (UI y lógica)
- Mismo cálculo que EqSegGrado pero con arquitectura basada en Fragments

## Tecnologías

- Java
- Android SDK
- Fragments

## Estructura del Proyecto

- MainActivity.java: Activity contenedora del Fragment
- MiFragmento.java: Fragment con la lógica de cálculo
- ctivity_main.xml: Layout principal con contenedor de Fragment
- ragment_mi.xml: Layout del Fragment con campos de entrada

## Funcionamiento

El cálculo de la ecuación cuadrática se realiza dentro del Fragment, mientras la Activity actúa como contenedor. Esto demuestra una mejor organización del código siguiendo patrones de arquitectura Android.

## Requisitos

- Android API 24+