# Aplicacion de ejemplo 4 - Android

Esta fue una aplicacion a modo de prueba para poner en practica todo lo aprendido en las 3 aplicaciones de ejemplo anteriores, esta 
involucra persistencia de datos, manejo de distintas vistas, fragmentos, list view y actividades al mismo tiempo

<img src="https://github.com/PabloHidalgoB/example4-android/blob/master/app/src/main/res/screenshots/main.png" data-canonical-src="https://github.com/PabloHidalgoB/example4-android/blob/master/app/src/main/res/screenshots/main.png" width="auto" height="400" />

Como se puede apreciar en esta imagen, esta aplicacion esta bloqueada para que unicamente pueda ser utilizada con el smartphone o tablet 
de manera horizontal, de la misma forma se agrego un toolbar personalizado del cual hablaremos acerca de el mas tarde

A simple vista uno pensaria que hay solo 2 fragments en este activity, pero hay uno tercero escondido, el cual reemplaza a la grilla de 
botones, el cual se visualiza de esta forma

<img src="https://github.com/PabloHidalgoB/example4-android/blob/master/app/src/main/res/screenshots/fragment.png" data-canonical-src="https://github.com/PabloHidalgoB/example4-android/blob/master/app/src/main/res/screenshots/fragment.png" width="auto" height="400" />

Los botones a cada lado del fragment se encargan de cambiar el anidado para hacer aparecer la grilla de botones o el patito de hule, este 
es una imagen de tipo boton el cual al presionar, reproduce el sonido caracteristico que de lo que se esta mostrando, mientras que en la 
grilla de botones, presionando el primer boton, se dirije hacia la segunda actividad llamada ListerActivity donde se tiene la siguiente 
vista

<img src="https://github.com/PabloHidalgoB/example4-android/blob/master/app/src/main/res/screenshots/activity2_scroll.png" data-canonical-src="https://github.com/PabloHidalgoB/example4-android/blob/master/app/src/main/res/screenshots/activity2_scroll.png" width="auto" height="400" />

En esta actividad se hace uso de otros fragments los cuales contienen la informacion de la actividad ListerActivity mientras que otro 
fragment despliega una variedad de frases separadas y desplegadas gracias a un Adapter el cual separa cada frase, les otorga un index y 
las muestra de forma ordenada en el Fragment de ListView, al seleccionar una se hace uso de funciones de tipo JSON para entregar los 
datos de ListerActivity (title y description) mas la frase seleccionada a una nueva actividad que se encarga de desplegarlas, llamada DetailsActivity

<img src="https://github.com/PabloHidalgoB/example4-android/blob/master/app/src/main/res/screenshots/activity3.png" data-canonical-src="https://github.com/PabloHidalgoB/example4-android/blob/master/app/src/main/res/screenshots/activity3.png" width="auto" height="400" />

En esta actividad se rescatan los datos enviados desde el Fragment que hizo el manejo de datos e invoco el DetailsActivity y son desplegados en pantalla como se puede apreciar en la imagen anterior

Habra notado que el toolbar ha estado reaccionando de manera activa conforme se avanza con los diferentes activites, por ejemplo, 
dependiendo de la actividad que uno se encuentra, el titulo de esta es mostrada a la mitad del toolbar, y en el caso de "Lister 
Activity" junto con "Details activity" estos poseen botones de navegacion, la flecha significa que esta ha de volver a la actividad 
anterior que la invoco, por ejemplo si uno se encuentra en "Details Activity" esta volveria a "Lister Activity" y despues a "Main 
Activity", mientras que haciendo click en la casa, automaticamente se devuelve a "Main Activity" sin importar en que activity uno se 
encuentre, como dato final, para salir del programa uno debe presionar el boton "Atras" del telefono 2 veces para evitar la salida por 
accidente
