import java.util.Random;

//Essa classe funciona como o backend e irá gerar a senha
public class PasswordGenerator {
    //character pools
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOLS = "!@$%¨¨&*()+{}`´^~:><*-/";

    //A classe random nos permite gerar um número aleatório que será usado para escolher os caracteres de forma aleatória
    private final Random random;

    //constructor
    public PasswordGenerator(){random = new Random();}

    //"Length" - comprimento da senha a ser gerada (obtido do usuário)
    //"includeUppercase and etc..." - considera se a senha deve incluir letras maiúsculas, minúsculas, etc... (obtido do usuário).
    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialSymbols){
        //we will use string builder over string for better efficiency
        StringBuilder passwordBuilder = new StringBuilder();

        //Armazenar caracteres válidos (estados de alternância)".
        String validCharacters = "";
        if(includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
        if(includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if(includeNumbers) validCharacters += NUMBERS;
        if (includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

        //Construir senha
        for (int i = 0; i < length; i++){
            //generate a random index
            int randomIndex = random.nextInt(validCharacters.length());

            //Pegar o caractere baseado no índice aleatório
            char randomChar = validCharacters.charAt(randomIndex);

            //"Armazenar caractere no construtor de senha."
            passwordBuilder.append(randomChar);

            //Para fazer isso, alcançamos o comprimento que o usuário nos forneceu.
        }

        //Retornar o resultado
        return passwordBuilder.toString();


    }
}
