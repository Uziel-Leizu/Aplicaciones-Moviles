# AppCanvas

## Descripción

Aplicación Android que utiliza el Canvas para dibujar y visualizar gráficas de las funciones trigonométricas seno y coseno. Permite observar la forma de onda de ambas funciones en un lienzo personalizado.

## Características

- Gráfica de función seno (color azul)
- Gráfica de función coseno (color rojo)
- Ejes cartesianos dibujados en el canvas
- Visualización personalizada mediante View personalizada
- Parámetros de amplitud y período configurables

## Tecnologías

- Java
- Android SDK
- Canvas API
- Custom View

## Estructura del Proyecto

- Lienzo.java: Clase personalizada que extiende View para dibujar las gráficas
- MainActivity.java: Activity principal que recibe parámetros y muestra el lienzo
- SegundaActivity.java: Segunda Activity de la aplicación
- ctivity_main.xml: Layout principal

## Funcionamiento

La clase Lienzo extiende View y sobrescribe onDraw(Canvas c). Utiliza Paint para definir estilos y colores, y Path para trazar las curvas. Para cada punto x se calcula y = sin(x/per) * (-amp) y y = cos(x/per) * (-amp) para dibujar las funciones.

## Elementos Visuales

- Fondo blanco
- Ejes coordenados (azules)
- Curva seno (azul)
- Curva coseno (rojo)
- Textos indicativos

## Requisitos

- Android API 24+