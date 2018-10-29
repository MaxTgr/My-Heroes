# My-Heroes
Projeto enviado por [Dog Hero](https://www.doghero.com.br/)

## Escolhas do projeto:
- Java : Java foi escolhido apenas pela disponibilidade de documentação, tanto de bibliotecas externas como algumas partes da documentação oficial, no entanto, kotlin pode ser substituído facilmente se for realmente necessário
- Json parse : Foi utilizado o Gson, não só por estar disponível no projeto como por ser um dos parsers mais rápidos e escaláveis.
- Estrutura : Foi escolhida a estrutura padrão dos guidelines do android, models, fragments, etc... (explicado abaixo)
- Linguagem: A linguagem padrão do projeto é Ingles, seguindo os guidelines do android para nomeclatura, mas o sistema tem uma tradução para aparelhos com a linguagem principal em português do brasil.

## Estrutura deste projeto:
```
app/src/main
├── res
│  ├── layout
│  │  └── activity_main.xml [parent of the fragments contains: Bottom navigation]
│  │  └── fragment_blank.xml [simple "blank" fragment, used for placeholding]
│  │  └── fragment_hero.xml [main view for this project, contains: Lists that will be holding the "hero" cards]
│  │  └── hero_list_item.xml ["hero" card, container for all the data from the api]
│  └── menu
│     └── [items for the Bottom navigation]
├── java/br/com/doghero/dhproject
│  ├── MainActivity.java [parent activity used for handling the fragment loading]
│  ├── MyHeroes.java [data processing from the api]
│  ├── model
│  │  └── Hero.java + HeroUser.java [Classes for mapping Gson results]
│  └── images
│  │  └── ImageHelper.java [Image loading using Picasso]
│  └── api
│     └── ApiAnswer.java [Class for calling the api (connection not implemented)]
│  └── fragments
│     └── [Folders and classes for each Fragment, including the view class and any other class that belongs to it, like adapters]
└──
```
