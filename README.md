### TM's Fence

<h3> Credits for building this application or rather a copy/paste source :-) </h3>

<ul> IAM implementation: <a>https://www.keycloak.org/ </a> </ul>

<ul> <h4> Authorisation Server: </h4>
    <li>Source : <a>https://github.com/Baeldung/spring-security-oauth/tree/master/oauth-jwt </a> </li>
    <li>Article: <a>https://www.baeldung.com/postman-keycloak-endpoints</a> and <a>https://www.baeldung.com/spring-security-oauth-jwt </a> </li>
    <li>Credits: <a>https://www.baeldung.com/ </a> </li>
</ul>
<ul> <h4>Rest Resource server: </h4>
    <li> Article: <a>https://medium.com/@bcarunmail/securing-rest-api-using-keycloak-and-spring-oauth2-6ddf3a1efcc2 </a> </li>
    <li> Source <a>https://github.com/bcarun/spring-oauth2-keycloak-connector</a></li>
    <li> Credits: <a>https://medium.com/@bcarunmail </a></li>
</ul>

<ul> <h4> Instructions for running and configuring this application </h4>

<li> This application will work on PostgreSQL as that's the recommended DB by KeyCloak <a>https://www.keycloak.org/ </a></li>
<li>Get PostgreSQL image from docker hub URL <a>https://hub.docker.com/_/postgres</a> </li>
<li> Run the following docker commands
    <ol>docker pull postgres</ol>
    <ol>docker create network fencenw</ol>
    <ol>docker run --name postgres -dp 5454:5432 -e POSTGRES_PASSWORD=fencepwd -e POSTGRES_USER=fenceuser -e POSTGRES_DB=fence2kc --network fencenw --network-alias fencepostgres -v postgres_volume:/var/lib/postgresql postgres</ol>
</li>
<li> Generate jks token with password. Link - <a>https://dzone.com/articles/creating-self-signed-certificate</a></li>
<li> Refer to main/resources/fence-realm-setup/setup.txt for key generation and passwords</li>
<li> Create new realm and map the jks file from above step with password in key providers java-key-store </li>
<li> export the new realm and place it in the main/resources/new-relam-file.json </li>
<li> Update the passwords in the realm file from stars to the actual keystore password</li>
<li> Update database details in application.yml along with admin user,password for portal and realm file</li>
<li> And finally spring-boot:run -Dspring-boot.run.profiles=dev -X -f pom.xml </li>
<li> Public key generation for clients -  <li>
