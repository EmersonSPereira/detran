# DETRAN

API REST que simula serviços do detran.

## Getting Started

Para iniciar o desenvolvimento siga as instruções seguintes.

### Pré-requisitos

* [Github](https://github.com/)
* [Java SE Development Kit 8](https://www.oracle.com/)
* [Maven 3.x](https://maven.apache.org/)
* [Wildfly 14](https://wildfly.org/news/2018/08/30/WildFly14-Final-Released/)
* [PostgreSQL](https://www.postgresql.org/download/)

### Instalação

Após instalar todos os pré-requisitos necessários, execute os próximos passos para conseguir disponibilizar a aplicação no seu ambiente local de desenvolvimento.

```sh
# Clone o repositório do projeto
$ git clone https://github.com/EmersonSPereira/detran.git
# Navegue até a pasta root da aplicação
$ cd ctis-hackathon
# Instale todas as dependências
$ mvn clean install
```
## Executando a Aplicação

Importe o projeto em uma IDE de suas preferência.

> **importante:** Para o desenvolvimento do projeto base utilizei o Eclipse.

Agora build a aplicação na sua IDE.

```sh
# Maven goals
$  clean install
```

Após isso, instale os adapters necessários para configuração do novo servidor de aplicação Wildfly 14 em sua IDE. 

> **importante:** Para a IDE Eclipse, o JBoss Tools será necessário. Link para download: https://tools.jboss.org/downloads/

Agora, configure um novo servidor referenciado a pasta onde o Wildfly 14 foi baixado.

Acrescente a configuração de DataSource abaixo no arquivo **standalone.xml** do seu servidor.

```xml
 <datasource jta="true" jndi-name="java:jboss/datasources/DetranDS" pool-name="DetranDS" enabled="true" use-java-context="true">
                    <connection-url>jdbc:postgresql://localhost:5432/detran</connection-url>
                    <driver>postgres</driver>
                    <transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
                    <pool>
                        <min-pool-size>10</min-pool-size>
                        <max-pool-size>100</max-pool-size>
                        <prefill>true</prefill>
                    </pool>
                    <security>
                        <user-name>SEU_USUARIO_POSTGRES</user-name>
                        <password>SUA_SENHA_POSTGRES</password>
                    </security>
                    <statement>
                        <prepared-statement-cache-size>32</prepared-statement-cache-size>
                        <share-prepared-statements>true</share-prepared-statements>
                    </statement>
                </datasource>
```

> **importante:** Crie um DataBase e o Schema no postgres, ambos chamado "detran"

Após concluir a configuração do servidor, coloque o **detran-ear** como o artefato que será feito o deploy e incie o server.

> **importante:** O contexto da aplicação é **/detran-backend/api/v1/**.

## Swagger UI

Para acessar o Swagger UI, abra o seguinte link no seu navegador: http://localhost:8080/detran-backend/doc/index.htm

## Constrúido com

* [Maven](https://maven.apache.org/) - Gerenciador de dependências

## Autor Projeto Base

* **Alysson Tiago S. Cordeiro** - *Arquiteto de Software*

## Autor API

* **Emerson Sousa Pereira** - *Desenvolvedor de Software*