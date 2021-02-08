#

### O projeto está divido em Backend e Frontend, ambas partes trabalhando de forma isolada.

##Backend:
  - Java 8
  - SpringBoot 2.0.5
  - Gradle

##Usando Gradle para empacotar o backend:

Linux ou MacOs:

`cd ~/<SEU_DIRETORIO_PROJETOS>/sienge` 

`./gradlew bootJar` 

`java -jar build/libs/sienge-0.0.1-SNAPSHOT.jar` 

O Springboot usa o fatjar para empacotar as aplicações e usa o Tomcat embarcado. Sendo assim,
apenas execute o comando acima em seu servidor.

Caso deseje gerar um arquivo war, e fazer o deploy para o tomcat instalado em seu servidor,
é necessário realizar o comando abaixo:

`./gradlew bootWar` 

Logo após copie o arquivo war gerado, para o diretório webApps do tomcat no servidor


##Frontend:
  - HTML
  - CSS ( Materialize )
  - Javiscript (JQuery)
  - Nodejs/npm

Junto ao projeto no diretório src/main/resources/static está o frontend, para executá-lo, será necessário realizar
os passos abaixo:

`cd ~/<SEU_DIRETORIO_PROJETOS>/sienge/src/main/resources/static` 

Com o Node instalado. É preciso instalar o http-server para rodar o frontend.

Instalação via npm:

`npm install http-server -g`

Entre no diretório que se encontra arquivo e inicie o http-server

http-server -p 8000`

Com o Node instalado. É preciso instalar o http-server para rodar o frontend.
