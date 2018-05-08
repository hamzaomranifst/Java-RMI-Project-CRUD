

echo "Compiling Java source files ..."
javac -classpath lib/gson-2.7.jar:./ src/server/*.java


echo "Geneteting Stbus and Skeles for Remote Objects ..."
cd src/server/
rmic -v1.1  FabricImpl
rmic -v1.1  InstitutionCatalogCRUDImpl
rmic -v1.1  InstitutionCatalogCreatorImpl

echo "Moving .class files to Web Server ..."
cp `ls -1 *.class | grep -v DynamicServer.class` ../client/
mv `ls -1 *.class | grep -v DynamicServer.class` /var/www/html/codebase/

echo "The server is ready to be lunched"