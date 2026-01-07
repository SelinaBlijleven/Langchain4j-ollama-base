# Project Setup

Hier volgen de instructies voor het opstarten van het project.

## Base Project

Kloon het volgende project van GitHub:
`https://github.com/SelinaBlijleven/Langchain4j-ollama-base`

In het project vinden we alles wat we nodig hebben om te kunnen 
beginnen met bouwen, inclusief documentatie en demo-code.

Eventueel kun je ook een Spring starter-project gebruiken: 
[LangChain4J Spring Starterprojecten](https://github.com/langchain4j/langchain4j-spring)

## Dependencies

We hebben voor de opdracht de volgende dependencies nodig, die al zijn opgenomen
in de `pom.xml` van het startproject.

```
<dependency>
    <groupId>dev.langchain4j</groupId>
        <artifactId>langchain4j</artifactId>
        <version>1.8.0</version>
</dependency>

<dependency>
    <groupId>dev.langchain4j</groupId>
    <artifactId>langchain4j-ollama</artifactId>
    <version>1.8.0</version>
</dependency>

<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>2.0.13</version>
</dependency>
```

De eerste dependency is het framework dat we gaan gebruiken, de tweede
is de connector voor Ollama. Dit programma hebben we nodig
om lokaal met LLM's te werken. De derde dependency is om eventueel logging te implementeren.

## Ollama

[Ollama](https://ollama.com/) is een programma waarmee we lokaal LLM's kunnen
draaien. Hoewel er ook andere opties hiervoor beschikbaar zijn, gebruiken we
deze specifieke applicatie i.v.m. het gemak van integratie.

Instructies voor Ollama:

1. Download het programma
2. Download model `qwen3:4b` (deze wordt gebruikt in de demo-code en ondersteunt tools)
3. Ga naar de 'Settings' en maak Ollama beschikbaar voor lokale ontwikkeling

![Ollama instelling](ollama-network.png)

## Testen

Als alles gelukt is, kun je nu de demo's uitvoeren. Begin met 
`OllamaConnectionDemo.java` om de set-up te testen.

## Volgende stap

Nu is het tijd om je intelligente systeem te gaan bouwen! 
Je kunt hiervoor nog meer hulp en tips lezen in de 
[volgende stap](03-building-your-agent.md)