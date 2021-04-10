package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.views.InputView;
import nextstep.ladder.views.ResultView;

public class LadderGameController {
    private final static String ALL_RESULT = "all";

    public void start(){
        Players players = Players.from(InputView.playerNames());
        Results results = Results.from(InputView.gameResults());
        Ladder ladder = Ladder.of(players.countOfPlayers(), InputView.maxLadderLength());

        LadderResults ladderResults = LadderResults.of(ladder, results);
        GameResult gameResult = GameResult.of(ladderResults, players);

        ResultView.showLadder(gameResult);
        showPlayerResults(gameResult);
    }

    private void showPlayerResults(GameResult gameResult) {
        String name = InputView.choosePlayerResult();
        while(!isAllResult(name)) {
            ResultView.showPlayerResult(gameResult, name);
            name = InputView.choosePlayerResult();
        }
        ResultView.showAllResults(gameResult);
    }

    private boolean isAllResult(String value) {
        return value.equals(ALL_RESULT);
    }
}
