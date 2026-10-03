# ServoMotorAndroid

## Descripción

Aplicación Android para controlar servomotores mediante Bluetooth. Se comunica con un módulo Bluetooth conectado a un Arduino para controlar el ángulo de uno o varios servomotores usando SeekBars.

## Características

- Conexión Bluetooth a dispositivos emparejados
- Control de servo motor mediante SeekBar (Izquierdo y Derecho)
- Búsqueda y selección de dispositivos Bluetooth
- Comunicación bidireccional con Arduino
- Interfaz en modo landscape (paisaje)
- Biblioteca BluJhr para manejo de Bluetooth

## Tecnologías

- Java
- Android SDK
- Bluetooth
- BluJhr Library (com.ingenieriajhr.blujhr)
- SeekBar

## Estructura del Proyecto

- MainActivity.java: Activity con lógica de conexión Bluetooth y control
- ctivity_main.xml: Layout con lista de dispositivos y controles de servo
- AndroidManifest.xml: Permisos Bluetooth

## Funcionamiento

1. La aplicación escanea dispositivos Bluetooth emparejados
2. Usuario selecciona el módulo Bluetooth (HC-05/HC-06) conectado al Arduino
3. Al conectar exitosamente, se muestra la interfaz de control
4. SeekBars permiten ajustar el ángulo del servo (0-180° aproximadamente)
5. Al mover el SeekBar, se envía un comando vía Bluetooth: "R" + valor o "L" + valor
6. Al soltar el control, el servo retorna a posición 90°

## Comunicación

- Comandos enviados: R[valor]\n (servo derecho), L[valor]\n (servo izquierdo)
- Valor entre 0 y 180 grados

## Requisitos

- Android API 24+
- Dispositivo con Bluetooth
- Módulo Bluetooth HC-05/HC-06 conectado a Arduino con servo motor
- Biblioteca BluJhr en dependencias