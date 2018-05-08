
echo "Compiling Java source files ..."
javac -classpath src/client/ src/client/*.java

echo "Moving .class files to Web Server ..."
cd src/client/
cp StaticClient*.class /var/www/html/codebase/
rm StaticClient.class

echo "The server is ready to be lunched"