# ZeroMilesPiedmont

## Descrizione

ZeroMilesPiedmont permette alle aziende di vendere prodotti online e agli utenti (consumer) di acquistare tali prodotti. L'architettura dell'applicazione è basata su un'architettura a microservizi, utilizzando Spring Boot e Kubernetes per il backend e Vue 3 per il frontend.

## Architettura Backend

### Microservizi con Spring Boot

Il backend dell'applicazione è composto dai seguenti microservizi sviluppati con Spring Boot:

- **API Gateway**: Gestisce le richieste degli utenti, indirizzandole ai microservizi appropriati.
- **Discovery Service (Eureka)**: Fornisce il servizio di registrazione e scoperta per i microservizi.
- **Shop Service**: Gestisce i prodotti e gli ordini. Invia un messaggio di avvenuto ordine al Notification Service tramite RabbitMQ.
- **Company Service**: Gestisce le informazioni delle aziende.
- **User Service**: Gestisce le informazioni degli utenti (consumer).
- **Notification Service**: Riceve i messaggi dal Shop Service e gestisce le notifiche agli utenti.

### Comunicazione Asincrona con RabbitMQ

- **RabbitMQ**: Utilizzato come message broker per facilitare la comunicazione asincrona tra i microservizi. Quando un ordine viene effettuato, il Shop Service invia un messaggio al Notification Service tramite RabbitMQ.

### Database con MongoDB

- **MongoDB**: Utilizzato come database per tutti i microservizi, scelto per la sua flessibilità e scalabilità.

### Deployment su Kubernetes

Tutti i microservizi sono implementati e distribuiti su un cluster Kubernetes, garantendo alta disponibilità e scalabilità. Kubernetes gestisce il deployment, la scalabilità e la gestione dei container Docker che eseguono i microservizi.

## Architettura Frontend

Il frontend è sviluppato con **Vue 3** e utilizza **Pinia** come state manager per la gestione dello stato dell'applicazione. L'interfaccia utente è progettata per essere intuitiva e reattiva, offrendo una piacevole esperienza utente.

## Autenticazione

L'autenticazione dei consumer avviene tramite l'API di Google, consentendo agli utenti di accedere facilmente utilizzando i propri account Google.

## Requisiti

- **Backend**: Docker, Minikube
- **Frontend**: Node.js, Vue 3, Pinia, Bootstrap5

## Installazione e Avvio

### Backend

1. Clonare il repository del backend.
    ```sh
    git clone https://github.com/Giuliaqqrd/ZeroMilesPiedmont
    cd ZeroMilesPiedmont
    ```

2. Deployare i microservizi su Kubernetes.
    ```sh
    kubectl apply -f k8s/
    ```

### Frontend

1. Clonare il repository del frontend.
    ```sh
    git clone https://github.com/Giuliaqqrd/ZMPFrontend
    cd ZMPFrontend
    ```

2. Installare le dipendenze.
    ```sh
    npm install
    ```

3. Avviare l'applicazione.
    ```sh
    npm run serve
    ```
---

Grazie per aver scelto ZeroMilesPiedmont! Speriamo che vi offra un'esperienza di shopping online piacevole. Se avete domande o feedback, non esitate a contattarci.

