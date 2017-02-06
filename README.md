# EJB	


Esse projeto tem como objetivo ser a API de lista de um estacionamento, 

- MySqL o scripti database encontra-se ejbs\src\main\resources\ejb.sql


###### Sistemas:
- EJB - Sistema de Calculo de um estacionamento

###### Tecnologias:
- Mysql - versão 5.1.6
- WildFly 10.1
- Maven bild empacotamento de packages
- EJB, JPA, Hibernate(provider), RESTEasy
- CDI 

##### Premissas
- Vamos usar como parametros, uma marca, modelo e placa do veiculo então será
  retornado o valor a ser pago pelo cliente.
  a tabela de preço é a seguinte:
  quando for marca FORD o valor é 10;
  quando for GM e o modelo for BLAZER o valor é 20;
  quando a placa contem B e termina com 99 o valor é 1;
  demais marcas e modelos o valor é 5;

##### Recursos

 - /ejbs/services/calculo

#### Buscar listas presumida

###### Para quando o veiculo for GM e o modelo for BLAZER o valor é 20 ou a placa contem B e termina com 99 o valor a ser pago será 1;
```shell
HTTP GET localhost:8080/ejbs/services/calculo?marca=BLAZER&modelo=GM&placa=KJU3265
```
```json
[
  {
  "id": 3,
  "marca": "BLAZER",
  "modelo": "GM",
  "placa": "KJU3265",
  "valor": 20
  }
]
```

###### Para quando o veiculo for marca FORD o valor é 10 ou a placa contem B e termina com 99 o valor a ser pago será 1;
```shell
HTTP GET localhost:8080/ejbs/services/calculo?marca=FOCUS&modelo=FORD&placa=KOI2365
```
```json
[
  {
  "id": 4,
  "marca": "FOCUS",
  "modelo": "FORD",
  "placa": "KOI2365",
  "valor": 10
 }
]
```

###### Para quando a placa contem B e termina com 99 o valor é 1;
```shell
HTTP GET localhost:8080/ejbs/services/calculo?marca=FOCUS&modelo=FORD&placa=NBK3299
```
```json
[
  {
  "id": 4,
  "marca": "FOCUS",
  "modelo": "FORD",
  "placa": "KOI2365",
  "valor": 1
 }
]
```

###### Para as demais marcas e modelos o valor é 5 ou a placa contem B e termina com 99 o valor a ser pago será 1;
```shell
HTTP GET localhost:8080/ejbs/services/calculo?marca=GOL&modelo=WOLKSWAGEM&placa=GCB6354
```
```json
[
  {
  "id": 4,
  "marca": "GOL",
  "modelo": "WOLKSWAGEM",
  "placa": "KOI2365",
  "valor": 5
 }
]
```


# Configurações JTA 
- 1. Copie o driver do MySQL para a pasta <JBOSS-HOME>/modules/com/mysql/main. Provavelmente não existirá a pasta mysql/main, portanto você deverá criá-la e efetuar a cópia.
- 2. Na mesma pasta crie o documento module.xml conforme o conteúdo abaixo:
```
```
<?xml version="1.0" encoding="UTF-8"?>

<module xmlns="urn:jboss:module:1.0" name="com.mysql">
  <resources>
    <resource-root path="mysql-connector-java-5.1.6.jar"/>
  </resources>
  <dependencies>
    <module name="javax.api"/>
  </dependencies>
</module>
```
- A pasta main deverá conter os seguintes arquivos:
module.xml
mysql-connector-java-5.1.6.jar

```
3. Edite o arquivo standalone.xml e acrescente a configuração do driver conforme mostrado abaixo
```
```
<drivers>
    <driver name="mysql" module="com.mysql">
        <xa-datasource-class>
            com.mysql.jdbc.jdbc2.optional.MysqlXADataSource
        </xa-datasource-class>
    </driver> 
</drivers>
```

```
4. No mesmo documento standalone.xml, adicione o datasource conforme exemplificado abaixo:
```
```
 <datasource
 jndi-name="java:/mydb" pool-name="my_pool"
 enabled="true" jta="true"
 use-java-context="true" use-ccm="true">
    <connection-url>
        jdbc:mysql://localhost:3306/mydb
    </connection-url>
    <driver>
        mysql
    </driver>
    <security>
        <user-name>
            root
        </user-name>
        <password>

      </password>
    </security>
    <statement>
        <prepared-statement-cache-size>
            100
        </prepared-statement-cache-size>
        <share-prepared-statements/>
    </statement>
 </datasource>
```