#!/bin/bash

# Script para generar la documentación de desarrollador empleando Sphinx
# a partir de los comentarios de JavaDoc

basepath=$(dirname $0)
cd "$basepath"
javasphinx-apidoc -o temp ../../src
cp -R temp/com source/
rm -Rf temp
make html
echo "Developer doc successfully created."
