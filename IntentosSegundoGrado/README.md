# IntentosSegundoGrado

## Descripción

Calculadora de ecuaciones de segundo grado que utiliza Intent y Bundle para pasar datos entre dos Activities. Demuestra la comunicación entre Activities en Android.

## Características

- Paso de datos entre Activities usando Intent y Bundle
- Separación entre formulario y resultado
- Navegación entre Activities

## Tecnologías

- Java
- Android SDK
- Intent
- Bundle

## Estructura del Proyecto

- MainActivity.java: Activity para ingresar coeficientes a, b, c
- SegundaActivity.java: Activity para mostrar el resultado del cálculo
- ctivity_main.xml: Layout con formulario de entrada
- ctivity_segunda.xml: Layout para mostrar resultados

## Funcionamiento

1. En MainActivity, el usuario ingresa los coeficientes a, b, c
2. Al presionar calcular, se crea un Intent y se empaquetan los datos en un Bundle
3. Se inicia SegundaActivity
4. SegundaActivity recibe los datos, calcula las raíces y las muestra

## Requisitos

- Android API 24+