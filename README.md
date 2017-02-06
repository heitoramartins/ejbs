# EJB	


Esse projeto tem como objetivo ser a API de lista de um estacionamento, 

O scripti MySql encontra-se ejbs\src\main\resources\ejb.sql


###### Sistemas:
- 2U - Sistema de Calculo de um estacionamento

##### Premissas
- Vamos usar uma marca, modelo e placa para saber deepois é retornado o valor a ser pago pelo cliente.
  a tabela de preço e a seguinte:
  quando for marca FORD o valor é 10;
  quando for GM e o modelo for BLAZER o valor é 20;
  quando a placa contem B e termina com 99 o valor é 1;
  demais marcas e modelos o valor é 5;


###### Web
- email
- ID vip
- ID do login unico (person ID ou account ID)

##### Recursos

 - /ejbs/services/calculo

#### Buscar listas de compras

###### Para quando for GM e o modelo for BLAZER o valor é 20 ou contem B e termina com 99 o valor é 1;
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

###### Para quando for marca FORD o valor é 10 ou contem B e termina com 99 o valor é 1
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
  "valor": 10
 }
]
```

###### Para as demais marcas e modelos o valor é 5 ou contem B e termina com 99 o valor é 1;
```shell
HTTP GET localhost:8080/ejbs/services/calculo?marca=GOL&modelo=WOLKSWAGEM&placa=GCB6354
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
