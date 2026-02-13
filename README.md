# ♕ BYU CS 240 Chess

This project demonstrates mastery of proper software design, client/server architecture, networking using HTTP and WebSocket, database persistence, unit testing, serialization, and security.

## 10k Architecture Overview

The application implements a multiplayer chess server and a command line chess client.

[![Sequence Diagram](10k-architecture.png)]
https://sequencediagram.org/index.html?presentationMode=readOnly#initialData=IYYwLg9gTgBAwgGwJYFMB2YBQAHYUxIhK4YwDKKUAbpTngUSWDABLBoAmCtu+hx7ZhWqEUdPo0EwAIsDDAAgiBAoAzqswc5wAEbBVKGBx2ZM6MFACeq3ETQBzGAAYAdAE5M9qBACu2GADEaMBUljAASij2SKoWckgQaIEA7gAWSGBiiKikALQAfOSUNFAAXDAA2gAKAPJkACoAujAA9D4GUAA6aADeAETtlMEAtih9pX0wfQA0U7jqydAc45MzUyjDwEgIK1MAvpjCJTAFrOxclOX9g1AjYxNTs33zqotQyw9rfRtbO58HbE43FgpyOonKUCiMUyUAAFJForFKJEAI4+NRgACUh2KohOhVk8iUKnU5XsKDAAFUOrCbndsYTFMo1Kp8UYdKUAGJITgwamURkwHRhOnAUaYRnElknUG4lTlNA+BAIHEiFRsyXM0kgSFyFD8uE3RkM7RS9Rs4ylBQcDh8jqM1VUPGnTUk1SlHUoPUKHxgVKw4C+1LGiWmrWs06W622n1+h1g9W5U6Ai5lCJQpFQSKqJVYFPAmWFI6XGDXDp3SblVZPQN++oQADW6ErU32jsohfgyHM5QATE4nN0y0MxWMYFXHlNa6l6020C3Vgd0BxTF5fP4AtB2OSYAAZCDRJIBNIZLLdvJF4ol6p1JqtAzqBJoIei0azF5vDgHYsgwr5kvDrco67F8H5LCBALnAWspqig5QIAePKwvuh6ouisTYgmhgumGbpkhSBq0uWo4mkS4YWhyMDcryBqCsKMCvmIrrSkml6weUtHaI6zoErhLLlJ63pBkRI6jKRTJuhR5TRjAsbBlxzHmqxRTsTAirKtxibJlBJYoTy2a5pg-4gjBJRXAMxGjCBNZBrOzb-O2JmFNkPYwP2g69BZon3NWU62Y29mLqYy6rt4fiBF4KDoHuB6+Mwx7pJkmAuReKlmZU0gAKK7pl9SZc0LQPqoT7dNOdloI5bLGeUZUBRVxlslh8Gxb6yEtWAaEYphcrYbxZF4TA5JgHJAb+XO4lmhGhSWlRPIxkGdFhLVc6hv1LGmeCskLVxWEanxpJGCg3CZCNy3oBN5GRpR0hHRShhyYtMBnRVikRht8pqUqKq7cp1UxfYcUGQgeY6U5aUAd+V5gylYB9gOQ5LpwoXroEkK2ru0IwAA4qOrIJaeyXnswpnXljuUFfYo6lWN6CVdpQIls9Rmg41PXwdCOOjKosLdbBe1rQdQ2nTTaAXZJV3lFjFJbXG2hCktIurRJ61sU6H0PTtPX88rgsUgoyqc2oPNK5NUnY9LhsaK9rFNfAEDKig4BPgAPIbjL5Jp2H06m5QY7EltAyDDNgz+5QVP0lOjAAktI1lTCemQGhWnxPDoCCgA2SfASnUyRygABy2eLo0dOnDDcMeT03QwFMcCpNKlvjJU1c16WLet7no4x9Z7et30Cf6pZPlTL3Nd9GnGdZ1ZKej53oyF9Pqy93s0wt403SIyunhhRu2A+FA2DcPAuqZNjo4pIlZ45MTqvXrUDQU1TwQi0OecLygkPUB23vAjVIuln0N+Rc2wNXenBGAglMiG1hHAE+KBDadQwp7bWk18LDWEs9MWLFpqUSlswDW8h5ZPUVq9TstsCHAGQThAW7oIFwOgW7bQWClI4OkjaM+owHSkOUrbdS30eqsT+rAr0UDRyB2ZsHG2UNzJ527g5H8rFy5uXhp5WRscHIhW3ijAIlgjoIWSDAAAUhAHkHDDABAniABshNr6sy-mmaolI7wtDztTOsdUhyH2ALoqAcB7bQFmGoz+xwf6M3-v0LxPi-EISgCsAA6iwKOeUWgACFdwKDgAAaS+GopuABGXsABmAALJBYOdi1bgIAFYmLQAwsRKA0RdSoX1HWtChYYJFswqa7JyjUXmrLQh9EmbcLAdJba8gWkyH2u0ik0C1HdLNv0sxj01Em0umMlZms+bULaeUPwWhRGjFhIw+QiyJZ8mwIcwwpzKGjNVptPhVDQlpmMTyBBahDKgJJmmHowTv5lyJlcTeyNwoBC8N4rsXpYDAGwIfQg8REgXwJjDCp14so5TygVYwdM-yg2BRI1MFTNogG4HgBQcLkAgERWgGBZKsyNPQliKZr0BL0sIuc1hMhbqn04pM+5aVHlfRZTMtl0LoGct6dy46NzRxcJmWQtmn0NI-VaagiB9KRqSpmjdGVMt5L8oVTwpVTyfovPKIgaFFL4XUoIIkbM2BEgGEJdBH5BKfydiUX8swSMgA

## Modules

The application has three modules.

- **Client**: The command line program used to play a game of chess over the network.
- **Server**: The command line program that listens for network requests from the client and manages users and games.
- **Shared**: Code that is used by both the client and the server. This includes the rules of chess and tracking the state of a game.

## Starter Code

As you create your chess application you will move through specific phases of development. This starts with implementing the moves of chess and finishes with sending game moves over the network between your client and server. You will start each phase by copying course provided [starter-code](starter-code/) for that phase into the source code of the project. Do not copy a phases' starter code before you are ready to begin work on that phase.

## IntelliJ Support

Open the project directory in IntelliJ in order to develop, run, and debug your code using an IDE.

## Maven Support

You can use the following commands to build, test, package, and run your code.

| Command                    | Description                                     |
| -------------------------- | ----------------------------------------------- |
| `mvn compile`              | Builds the code                                 |
| `mvn package`              | Run the tests and build an Uber jar file        |
| `mvn package -DskipTests`  | Build an Uber jar file                          |
| `mvn install`              | Installs the packages into the local repository |
| `mvn test`                 | Run all the tests                               |
| `mvn -pl shared test`      | Run all the shared tests                        |
| `mvn -pl client exec:java` | Build and run the client `Main`                 |
| `mvn -pl server exec:java` | Build and run the server `Main`                 |

These commands are configured by the `pom.xml` (Project Object Model) files. There is a POM file in the root of the project, and one in each of the modules. The root POM defines any global dependencies and references the module POM files.

## Running the program using Java

Once you have compiled your project into an uber jar, you can execute it with the following command.

```sh
java -jar client/target/client-jar-with-dependencies.jar

♕ 240 Chess Client: chess.ChessPiece@7852e922
```
