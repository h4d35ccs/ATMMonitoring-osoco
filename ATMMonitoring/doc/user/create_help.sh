#!/bin/bash

# Script para generar la documentación de usuario como ayuda web y copiar
# los ficheros en las rutas correctas del proyecto

basepath=$(dirname $0)

langs=(es)
pages=(dashboard terminals)
for lang in ${langs[*]}
do
	for page in ${pages[*]}
	do
		# Generamos el fichero html
		rst2html --template="$basepath"/template.txt -o ISO-8859-1 "$basepath"/"$lang"/"$page".rst "$basepath"/"$lang"/"$page".html
		# Lo movemos a la carpeta del proyecto
		mv -f "$basepath"/"$lang"/"$page".html "$basepath"/../../src/main/webapp/resources/help/"$lang"/
	done

	# Copiamos las imágenes al proyecto
	cp -f "$basepath"/"$lang"/resources/help/"$lang"/images/* "$basepath"/../../src/main/webapp/resources/help/"$lang"/images/
done

echo "Help doc successfully created."
