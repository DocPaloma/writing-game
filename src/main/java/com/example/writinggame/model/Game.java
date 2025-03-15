package com.example.writinggame.model;

/**
 * Creation of Level class to do a simple level management
 * @author Alejandro Medina
 * @version 0.0.1
 */
public class Game {
    /**
     * The ID or number of a level
     * @serialField
     */
    private int levelId;
    /**
     * The difficulty of a level
     * @serialField
     */
    private String difficulty;
    /**
     * The word to be written
     * @serialField
     */
    public String word;

    private int levelsStreak;

    private int maxStreak;

    private int chances;

    /**
     * Creator method for a level.
     * @param
     */
    public Game() {
        levelId = 1;
        setDifficulty();
        chooseWord();
    }

    /**
     * Method that gets a level ID
     * @return the ID of a level
     */
    public int getLevelId() {
        return levelId;
    }

    /**
     * Method that gets a level difficulty
     * @return the difficulty of a level
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Method that sets the difficulty of a level based on the level id
     */
    public void setDifficulty() {
        if (levelId >= 1 && levelId <= 10) {
            difficulty = "easy";
        }
        else if (levelId >= 11 && levelId <= 20) {
            difficulty = "medium";
        }
        else if (levelId >= 21) {
            difficulty = "hard";
        }
    }

    /**
     * Method that sets the Word to write
     */
    public void chooseWord () {

        if (difficulty == "easy"){
            String easyWords[]={"casa", "sol", "luz", "agua", "pan",
                    "flor", "luna", "gato", "perro", "rojo",
                    "verde", "azul", "nube", "vino", "hola",
                    "mano", "dedo", "ratón", "llave", "frío"};
            int randomNumber = (int) (Math.random() * easyWords.length);
            word = easyWords[randomNumber];

        }

        else if (difficulty == "hard"){
            String hardWords[]={"hipopótamo", "extraordinario", "melancolía", "biblioteca", "murciélago",
                    "refrigerador", "desenlace", "alucinante", "intransigente", "disyuntiva",
                    "otorrinolaringólogo", "circunstancial", "desconocido", "transatlántico", "conmemorativo",
                    "necesidad", "anfitrión", "subterráneo", "capicúa", "equinoccio",
                    "paralelogramo", "transeúnte", "orquídea", "espectro", "catastrófico",
                    "metamorfosis", "dodecaedro", "extraoficial", "inconmensurable", "quimérico",
                    "efervescente", "triciclo", "constitucional", "fragmentación", "palindrómico",
                    "fascinante", "interrogante", "imprescindible", "incongruente", "contundente"};
            int randomNumber = (int) (Math.random() * hardWords.length);
            word = hardWords[randomNumber];

        }

        else {
            String mediumWords[] = {"ventana", "escuela", "montaña", "brazalete", "paraguas",
                    "jirafa", "elefante", "cuchillo", "pizarra", "playa",
                    "silla", "zapatos", "comida", "relámpago", "estación",
                    "tijeras", "carnaval", "astronauta", "barco", "cartel",
                    "frontera", "música", "bicicleta", "mariposa", "espejo",
                    "librería", "pintura", "semáforo", "jirón", "desfile"};
            int randomNumber = (int) (Math.random() * mediumWords.length);
            word = mediumWords[randomNumber];

        }
    }

    public String getWord() {
        return word;
    }

    /**
     * Method that increases the level
     */
    public void increaseLevelId() {
        this.levelId = levelId + 1;
    }

    public void setLevelsStreak(Boolean a){
        if (a==true){
            levelsStreak = levelsStreak + 1;
            if(levelsStreak>maxStreak){
                levelsStreak = maxStreak;
            }
        }
        else {
            levelsStreak = 0;
        }

    }


    public void reduceChances() {
        chances = chances - 1;
    }

    public int getChances() {
        return chances;
    }


}
