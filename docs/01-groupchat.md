# Workshop B: Groepschat

Rolgebaseerd prompten is een populaire prompttechniek, waar we in deze workshop 
de mogelijkheden van gaan verkennen. 

Deze opdracht richt zich op:

- Werken met gespreksgeschiedenis en gedeeld geheugen
- Werken met verschillende persona's
- Het versterken van je prompt engineering skills: het schrijven van de instructies 
voor de AI zelf

## Opdracht

Bouw een groepschat-systeem gebouwd op LLM's. Het programma mag gebruik maken 
van een command line interface, de focus ligt op het implementeren van een 
gesprek tussen verschillende persona's en een gebruiker. 

Je maakt voor deze opdracht gebruik van tenminste twee LLM's. Beide moeten 
een eigen systeembericht krijgen om ze een duidelijke persona te geven. 

Implementeer het systeem zo dat de gebruiker eerst een bericht stuurt en vervolgens 
een reactie krijgt op hetzelfde bericht van twee verschillende persona's. Probeer 
te zorgen dat de persona's ook bewust zijn van elkaars berichten.

Gesuggereerde aanpak:

1. Zorg dat je eerst de [project setup-stappen](02-project-setup.md) hebt uitgevoerd.
2. Implementeer eerst een chatbot vergelijkbaar met de eerste demo, `OllamaDemoConnection`.
3. Zorg nu dat je chatbot de gespreksgeschiedenis onthoudt. Hiervoor kun je kijken naar
`OllamaDemoLocalMessageHistory` en `OllamaDemoChatMemory`.
4. Bedenk het eerste karakter/de eerste rol die je aan de groepschat wil toevoegen. 
Schrijf systeeminstructies voor de LLM vanuit deze rol. Hiervoor kun je inspiratie opdoen 
uit [systeemprompts van grote aanbieders](https://github.com/0xeb/TheBigPromptLibrary/blob/main/SystemPrompts/) 
en [agent instructies](https://github.com/0xeb/TheBigPromptLibrary/tree/main/CustomInstructions/ChatGPT).
5. Bedenk welke LLM-temperatuur goed aansluit bij je eerste karakter en stel deze in 
bij het aanmaken van het ChatModel. (Zie `OllamaDemoModelParameters`).
6. Stuur verschillende soorten prompts naar je karakter om te zien hoe deze reageert.
7. Doorloop stap 4-6 nogmaals om tenminste één extra karakter toe te voegen. 
8. Bouw nu een systeem waarin eerst de gebruiker een prompt stuurt, die beantwoord wordt 
door beide karakters.
9. Geef ze de instructie om ook op elkaar te reageren (in de systeemprompt). Je kunt nu 
testen of het geheugen goed is ingesteld aan de interactie tussen de LLM's.

## Tips

- Houd de berichten van de groepsgenoten kort om de gebruiker niet te overweldigen. Dit is ook sneller en makkelijker 
met testen.
- Bedenk goed welke informatie er gedeeld moet worden tussen de deelnemers van het 
gesprek.
- Ontwikkel persona's waar je een goed contrast tussen kunt zien: denk aan optimist en pessimist, 
developer, designer en projectmanager, of andere interessante combinaties.
- In dit geval kan een hogere temperatuur bij sommige persona's goed van pas komen.

## Algemene tips

Algemene tips voor deze workshop vind je bij [stap 3: Agentic systeem bouwen](03-building-your-agent.md).