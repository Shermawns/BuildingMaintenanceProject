BuildingMaintenance / Sistema de manutenção predial

Descrição:

  Inspirado pela empresa na qual tenho o imenso prazer de fazer parte, a Trilogo, desenvolvi um clone de sua plataforma de sistema de manutenção predial. O projeto foi criado com Java e Spring Boot, utilizando PostgreSQL como banco de dados. Seu objetivo é otimizar o gerenciamento de manutenções prediais, permitindo que as lojas criem tickets para solicitar serviços.
  Cada ticket contém informações como o ID da loja, título da demanda, descrição do problema e o tipo de serviço necessário (como, por exemplo, energia, ar condicionado, forro, vazamento, entre outros). Após a criação, apenas os Triloggers (funcionários da empresa de manutenção predial) têm a permissão para editar os tickets.
  Os Triloggers são responsáveis por atribuir um número ao ticket, selecionar o Trilogger encarregado de acompanhar a demanda, indicar o prestador que executará o serviço, estabelecer o prazo de retorno do prestador e corrigir quaisquer erros nas informações do serviço. Além disso, podem atualizar o status do ticket (que pode ser "aberto", "em execução", "executado" ou "cancelado") e definir sua prioridade (variando entre "baixa", "média", "alta" ou "emergencial").Tecnologias Utilizadas

Descrição do Diagrama UML

Minha Jornada com o Projeto e o Diagrama UML

Este diagrama UML representa a culminação de um longo processo de desenvolvimento e refino deste projeto, que comecei em dezembro do ano passado. Ele foi concebido para expressar de forma clara e objetiva a estrutura e o funcionamento do sistema BuildingMaintenance.

Ao longo do desenvolvimento, enfrentei diversos desafios, o que me levou a revisar e refazer algumas partes do projeto. Cada iteração foi essencial para melhorar minha compreensão dos requisitos, ajustar funcionalidades e criar um modelo que fosse funcional e bem estruturado.

Depois de muitas horas de dedicação, cheguei a este protótipo final de UML. Ele sintetiza a essência do sistema, refletindo tanto o aprendizado técnico quanto o cuidado em alinhar as funcionalidades às necessidades reais de um sistema de manutenção predial eficiente. Este modelo serviu como guia central para o desenvolvimento do projeto, conectando todas as ideias e funcionalidades de forma 

![image](https://github.com/user-attachments/assets/1b6d3a61-fddb-4438-9871-8b82e3744d00)
    
    
    User: Classe base para usuários, que pode se especializar em:
        Store (Lojas que criam tickets de manutenção),
        Provider (Provedores que realizam os serviços),
        Trilogger (Funcionários que gerenciam os tickets e serviços).

    Ticket: Entidade central que representa as demandas de manutenção. Cada ticket contém informações como título, descrição, tipo de serviço, prazo, prioridade e status.

    Enums: Definem os valores específicos para os campos:
        BuildingType: Tipos de serviços (energia, ar condicionado, vazamentos, etc.).
        TicketStatus: Status do ticket (aberto, em execução, executado, cancelado).
        RolePriority: Prioridade do ticket (baixa, média, alta).


Tecnologias Utilizadas

  Java 21: A linguagem de programação principal utilizada no desenvolvimento do projeto.
  Spring Boot 3.4.1: Framework utilizado para facilitar o desenvolvimento de aplicações Java, com configuração automática e criação de componentes.
  Spring Data JPA: Facilita a interação com o banco de dados utilizando o padrão JPA para persistência de dados.
  Spring Boot Validation: Biblioteca usada para validar entradas em APIs REST.
  Spring Boot DevTools: Ferramenta para melhorar o ciclo de desenvolvimento, incluindo reinicialização automática e outras facilidades.
  Springdoc OpenAPI: Utilizado para gerar a documentação da API de forma interativa com Swagger.
  PostgreSQL: Banco de dados relacional utilizado para armazenar as informações.
  Flyway: Ferramenta de migração de banco de dados que permite versionamento e controle de mudanças nas estruturas do banco de dados.
  Lombok: Biblioteca que reduz o código boilerplate, gerando automaticamente getters, setters, construtores, entre outros.
  JUnit 5: Framework para testes automatizados da aplicação.

Como Rodar

    Clone o repositório:

git clone https://github.com/seurepositorio/BuildingMaintenance.git

Entre na pasta do projeto:

    cd BuildingMaintenance

    Configure o banco de dados PostgreSQL no arquivo application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/buildingmaintenance
spring.datasource.username=usuario
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update

    Execute o projeto com Maven ou sua IDE de preferência:

./mvnw spring-boot:run

Acesse a documentação da API no Swagger UI:

http://localhost:8080/swagger-ui/index.html
