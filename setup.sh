#Logearse como root con sudo su antes de ejecutar el script

#Crear directorios
echo "Creando directorios..."
mkdir /opt/jdk
mkdir /opt/maven
mkdir /opt/spring-boot-cli

#Links de descarga
jdk_link="https://download.oracle.com/java/17/latest/"
jdk_file="jdk-17_linux-x64_bin.tar.gz"

maven_link="https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/"
maven_file="apache-maven-3.9.6-bin.tar.gz"

#https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started.installing.cli
spring_boot_cli_link="https://repo.maven.apache.org/maven2/org/springframework/boot/spring-boot-cli/3.2.5/"
spring_boot_cli_file="spring-boot-cli-3.2.5-bin.tar.gz"

#Descargar archivos
echo "Descargando archivos..."
wget ${jdk_link}${jdk_file}
wget ${maven_link}${maven_file}
wget ${spring_boot_cli_link}${spring_boot_cli_file}

#Descomprimir archivos
echo "Descomprimiendo archivos..."
tar -zxf $jdk_file -C /opt/jdk
tar -zxf $maven_file -C /opt/maven
tar -zxf $spring_boot_cli_file -C /opt/spring-boot-cli

#Eliminar archivos comprimidos
echo "Eliminando archivos comprimidos..."
rm $jdk_file
rm $maven_file
rm $spring_boot_cli_file

#Configurar variables de entorno
echo "RECUERDA CONFIGURAR LAS VARIABLES DE ENTORNO"
