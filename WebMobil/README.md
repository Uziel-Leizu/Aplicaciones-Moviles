# WebMobil

## Descripción

Navegador web básico para Android desarrollado con WebView. Permite navegar por internet, ir hacia atrás, hacia adelante, ir a una URL específica o regresar a la página de inicio (Google).

## Características

- Navegación web básica con WebView
- Botones: Atrás (Back), Inicio (Home), Adelante (Forward), Ir (Go)
- Barra de direcciones editable
- JavaScript habilitado
- Zoom integrado
- Viewport adaptable
- Cliente WebView personalizado para control de navegación

## Tecnologías

- Java
- Android SDK
- WebView API
- WebSettings
- WebViewClient

## Estructura del Proyecto

- MainActivity.java: Activity con WebView y controles de navegación
- Cliente.java: Clase interna extendiendo WebViewClient para manejar eventos
- ctivity_main.xml: Layout con EditText, botones y WebView
- AndroidManifest.xml: Permiso de Internet

## Funcionamiento

- **Atrás**: Navega a la página anterior en el historial
- **Inicio**: Carga la URL predeterminada (https://www.google.com/)
- **Adelante**: Navega a la siguiente página en el historial
- **Ir**: Carga la URL ingresada en el EditText

## Configuraciones WebView

- JavaScript habilitado (setJavaScriptEnabled(true))
- Controles de zoom (setBuiltInZoomControls(true))
- Viewport ancho (setUseWideViewPort(true))
- WebViewClient personalizado para evitar apertura en navegador externo

## Permisos

- ndroid.permission.INTERNET: Necesario para navegación web

## Requisitos

- Android API 24+
- Conexión a internet