# AppSpinner

## Descripción

Aplicación Android sencilla que demuestra el uso del componente Spinner (lista desplegable). Al seleccionar un elemento, muestra un Toast con el elemento seleccionado.

## Características

- Uso de Spinner
- Mensajes Toast al seleccionar elemento
- Listener para eventos de selección

## Tecnologías

- Java
- Android SDK
- Spinner
- Toast

## Estructura del Proyecto

- MainActivity.java: Activity principal con configuración del Spinner
- ctivity_main.xml: Layout con Spinner
- es/values/strings.xml: Contiene opciones del Spinner
- es/layout/: Layouts incluyendo spinner_item.xml

## Funcionamiento

Se define un Spinner en el layout. En MainActivity se configura un OnItemSelectedListener que muestra un Toast con el texto del ítem seleccionado al cambiar la selección.

## Requisitos

- Android API 24+