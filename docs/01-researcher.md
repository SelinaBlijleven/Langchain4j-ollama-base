# De Onderzoeker

Retrieval-Augmented Generation speelt een enorme rol in het voorkomen 
van hallucinaties en het produceren van output die te controleren is.

We kunnen informatie uit allerlei bronnen halen: het internet, uit interne 
documenten of zelfs uit een geheugen. Daarnaast hebben veel onderzoekers 
een planningsfase: hierbij kunnen ze de prompt verder analyseren om bijvoorbeeld 
vast te stellen wat een goed actieplan zou zijn.

Deze opdracht richt zich op:

- Het programmeren van tools met behulp van gestructureerde output
- Retrieval-augmented generation
- Het proces van redeneren en onderzoeken

Deze versie van de opdracht biedt het meeste uitdaging.

## Opdracht

In deze vorm van de opdracht heb je tenminste één LLM nodig, al kunnen extra 
agents in de vorm van bijvoorbeeld samenvatters en planners ook van pas komen. 

Implementeer Retrieval-Augmented Generation op het internet (via een zoekmachine API/lib), 
interne documenten (kun je ook laten genereren). Een intern geheugen kan handig zijn, 
maar uitgebreidere kennisbanken zijn in dit geval praktischer.

Gesuggereerde aanpak:

1. Zorg dat je eerst de [project setup-stappen](02-project-setup.md) hebt uitgevoerd.
2. Implementeer eerst een chatbot vergelijkbaar met de eerste demo, `OllamaDemoConnection`.
3. Zorg nu dat je chatbot de gespreksgeschiedenis onthoudt. Hiervoor kun je kijken naar
   `OllamaDemoLocalMessageHistory` en `OllamaDemoChatMemory`.
4. Schrijf een systeemprompt voor een LLM die antwoord kan geven op basis van opgevraagde 
interne/externe informatie. Hiervoor kun je inspiratie opdoen 
uit [systeemprompts van grote aanbieders](https://github.com/0xeb/TheBigPromptLibrary/blob/main/SystemPrompts/) 
en [agent instructies](https://github.com/0xeb/TheBigPromptLibrary/tree/main/CustomInstructions/ChatGPT).
5. Bedenk welke LLM-temperatuur goed aansluit bij je eerste karakter en stel deze in
   bij het aanmaken van het ChatModel. (Zie `OllamaDemoModelParameters`).
6. Lees interne of externe documenten in een EmbeddingStore. Je mag hiervoor uiteraard 
`OllamaDemoRAG` en `EmbeddingStoreBuilder`.
7. Test je onderzoeker met vragen die in je documenten voorkomen, of juist over 
een heel ander onderwerp gaan.

Breid je onderzoeker verder uit naar wens. Bijvoorbeeld met extra tools, 
gestructureerde output, een extra LLM die het antwoord evalueert, 
een "dieper nadenken"-modus of wat je verder interessant vindt!

## Tips

- Kies één vorm van RAG om hier niet te veel tijd aan kwijt te zijn.
- Gebruik een LLM met gestructureerde output om zoekopdrachten te schrijven.
- Probeer een reasoning trace voor jezelf bij te houden, om te controleren of je 
agent de juiste stappen neemt om tot een antwoord te komen.
- Voor de grootste uitdaging implementeer je een router agent, die bepaalt welke
tools en/of modellen aangeroepen moeten worden.

## Algemene tips

Algemene tips voor deze workshop vind je bij [stap 3: Agentic systeem bouwen](03-building-your-agent.md).