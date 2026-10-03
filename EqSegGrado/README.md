# EqSegGrado

## Descripción

Calculadora de ecuaciones de segundo grado (ecuaciones cuadráticas) para Android. Resuelve ecuaciones de la forma ax² + bx + c = 0 utilizando la fórmula general.

## Características

- Cálculo de raíces mediante fórmula general
- Manejo de discriminante
- Interfaz simple e intuitiva
- Validación de entrada de coeficientes

## Tecnologías

- Java
- Android SDK
- Math API (sqrt)

## Estructura del Proyecto

- MainActivity.java: Activity con lógica para calcular ecuaciones cuadráticas
- ctivity_main.xml: Layout con campos para a, b, c y resultado

## Fórmula Utilizada

x = (-b ± √(b² - 4ac)) / (2a)

## Funcionamiento

1. Usuario ingresa los coeficientes a, b y c
2. Se calcula el discriminante (b² - 4ac)
3. Se obtienen las raíces x1 y x2
4. Se muestra el resultado en pantalla

## Requisitos

- Android API 24+