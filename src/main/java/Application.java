import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



    /*
       We're now using a database so we don't need to create dummy data.
    @Bean
    public CommandLineRunner createDummyData(GameService gameService) {
        return args -> {
            Game game1 = gameService.createGame();
            Game game2 = gameService.createGame();
            Game game3 = gameService.createGame();
            gameService.joinGame(new GameUser(game1.getId(), "bart"));
            gameService.joinGame(new GameUser(game1.getId(), "lisa"));
            gameService.joinGame(new GameUser(game2.getId(), "homer"));
        };
    }
    */
}

