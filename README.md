
# pokemon-api-soap
Nuevo repositorio para el servicio soap de pokemon
#Para validar el se darrollo se puede realizar de las siguientes maneras:
Se descarga el proyecto con el siguiente comando
git clone -b task_01/initiatePokemon https://github.com/mikehoyos/pokemon-api-soap.git
#Considerar que este servicio soap requere de java temurin:17-jdk
Al correr el proyecto y verificar que se haya desplegado sin errores 
se debe de ingresar desde la herramienta de SOAP:
Se debe de crear un nuevo proyecto SOAP e ingresar la siguiente dirección
http://localhost:8080/ws/pokemon.wsdl
Se muestran los siguientes métodos:
    * Ability
    * BaseExperience
    * HeldItems
    * Id
    * LocarAreaEncounters
    * Name
Los cuales solicitan parámetros como nombre de algun pokemon o id.

#Para validar desde docker desktop:
Se descarga el proyecto y dentro de la misma carpeta del proyecto se ejecuta los siguientes comandos:
    -->    docker build -t pokemonapp .
    -->    docker run -p 8080:8080 pokemonapp
http://localhost:8080/ws/pokemon.wsdl
Se muestran los siguientes métodos:
    * Ability
    * BaseExperience
    * HeldItems
    * Id
    * LocarAreaEncounters
    * Name
Los cuales solicitan parámetros como nombre de algun pokemon o id.

    
