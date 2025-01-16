<body>

<h1>🚧 BuildingMaintenance</h1>
<h2>🛠️ Sistema de Manutenção Predial</h2>

<p>Inspirado pela empresa na qual tenho o imenso prazer de fazer parte, a <strong>Trílogo</strong>, desenvolvi um clone de sua plataforma de sistema de manutenção predial. O objetivo do projeto é <strong>otimizar o gerenciamento de manutenções prediais</strong>, permitindo que lojas criem tickets para solicitar serviços de forma simples e eficiente.</p>

<p>O projeto foi desenvolvido com <strong>Java</strong> e <strong>Spring Boot</strong>, utilizando <strong>PostgreSQL</strong> como banco de dados, e inclui funcionalidades completas de gerenciamento de tickets de manutenção.</p>

<hr>

<h2>✨ Funcionalidades</h2>
<ul>
    <li>🏢 <strong>Lojas</strong> podem criar tickets contendo:
        <ul>
            <li>ID da loja, título da demanda, descrição do problema, tipo de serviço (energia, ar condicionado, vazamento, entre outros).</li>
        </ul>
    </li>
    <li>👷 Apenas <strong>Triloggers</strong> (funcionários) podem editar os tickets, atribuindo:
        <ul>
            <li>Número ao ticket, responsável pela demanda, provedor para execução do serviço, prazo de retorno, entre outros.</li>
        </ul>
    </li>
    <li>⚙️ <strong>Triloggers</strong> também podem:
        <ul>
            <li>Atualizar o status do ticket (Aberto, Em execução, Executado, Cancelado).</li>
            <li>Definir a prioridade do ticket (Baixa, Média, Alta ou Emergencial).</li>
        </ul>
    </li>
</ul>

<hr>

<h2>📊 Descrição do Diagrama UML</h2>
<p>Este diagrama UML foi o resultado de um longo processo de desenvolvimento e refino, iniciado em dezembro do ano passado. Ele sintetiza a estrutura do sistema <strong>BuildingMaintenance</strong> e foi fundamental para conectar todas as ideias e funcionalidades.</p>

<h3>📂 Estrutura Representada no Diagrama</h3>


<img src="https://github.com/user-attachments/assets/1b6d3a61-fddb-4438-9871-8b82e3744d00" alt="Diagrama UML">


<ul>
    <li><strong>User</strong>: Classe base que pode se especializar em:
        <ul>
            <li><strong>Store</strong>: Lojas que criam tickets.</li>
            <li><strong>Provider</strong>: Provedores que executam os serviços.</li>
            <li><strong>Trilogger</strong>: Funcionários que gerenciam os tickets.</li>
        </ul>
    </li>
    <li><strong>Ticket</strong>: Entidade principal contendo informações como título, descrição, tipo de serviço, prazo, prioridade e status.</li>
    <li><strong>Enums</strong>:
        <ul>
            <li><strong>BuildingType</strong>: Define os tipos de serviços (Energia, Ar condicionado, Vazamento, etc.).</li>
            <li><strong>TicketStatus</strong>: Define o status do ticket (Aberto, Em execução, Executado, Cancelado).</li>
            <li><strong>RolePriority</strong>: Define a prioridade (Baixa, Média, Alta, Emergencial).</li>
        </ul>
    </li>
</ul>

<hr>

<h2>🚀 Tecnologias Utilizadas</h2>
<ul>
    <li>☕ <strong>Java 21</strong>: Linguagem principal do projeto.</li>
    <li>🌱 <strong>Spring Boot 3.4.1</strong>: Framework para desenvolvimento rápido de aplicações.</li>
    <li>📂 <strong>Spring Data JPA</strong>: Persistência de dados com JPA.</li>
    <li>🔒 <strong>Spring Boot Validation</strong>: Validação de entradas em APIs REST.</li>
    <li>⚡ <strong>Spring Boot DevTools</strong>: Melhorias no ciclo de desenvolvimento.</li>
    <li>📜 <strong>Springdoc OpenAPI</strong>: Documentação interativa com Swagger.</li>
    <li>🐘 <strong>PostgreSQL</strong>: Banco de dados relacional.</li>
    <li>🛠️ <strong>Flyway</strong>: Controle de versão e migração do banco de dados.</li>
    <li>✨ <strong>Lombok</strong>: Redução de código boilerplate.</li>
    <li>✅ <strong>JUnit 5</strong>: Framework de testes automatizados.</li>
</ul>

<hr>

<h2>📖 Como Rodar o Projeto</h2>
<h3>1. Clone o repositório:</h3>
<pre>
git clone https://github.com/seurepositorio/BuildingMaintenance.git
</pre>

<h3>2. Entre na pasta do projeto:</h3>
<pre>
cd BuildingMaintenance
</pre>

<h3>3. Configure o banco de dados PostgreSQL:</h3>
<pre>
spring.datasource.url=jdbc:postgresql://localhost:5432/buildingmaintenance
spring.datasource.username=usuario
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
</pre>

<h3>4. Execute o projeto com Maven ou sua IDE de preferência:</h3>
<pre>
./mvnw spring-boot:run
</pre>

<h3>5. Acesse a documentação da API no Swagger UI:</h3>
<p><a href="http://localhost:8080/swagger-ui/index.html" target="_blank">http://localhost:8080/swagger-ui/index.html</a></p>

</body>
</html>
