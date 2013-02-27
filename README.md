Notebook de maratones de programaci�n
======================================

Hecho por [Miguel Vilá][https://twitter.com/_miguel_v]

Descripción: Este es un documento en LaTex con algoritmos y algunos teoremas útiles
para competencias de programación de la ACM. Incluye algunos algoritmos comunes en 
pseudocódigo y algunas implementaciones en Java.

El Notebook está organizado a partir del archivo "Notebook.tex" desde el que se hace 
referencia a otros archivos donde se encuentra el contenido de cada una de las secciones.

Hace uso de los siguientes paquetes:
* algorithm2e
* multicol
* url
* amsmath
* amsthm
* amssymb
* graphicx
* listings
* fancyvrb
* multirow

Se definen nuevos comandos como:

* "seccion": sirve para definir una nueva sección del documento y tiene dos parámetros: 
el nombre de la sección y la ruta del archivo que describe la sección.

* "algoritmo": sirve para decribir un algoritmo en el formato de la libreria 
algorithm2e y que tiene un parámetro: la ruta de un archivo que por convención 
empieza por "al-".

* "imagen": sirve para incluir f�cilmente imágenes y toma dos parámetros: el ancho y
la ruta de la imágen.

Una versión compilada se encuentra en el archivo "Notebook.pdf".

Este trabajo se encuentra bajo una Licencia Creative Commons Atribución-NoComercial 2.5 Colombia.