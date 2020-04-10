package ladder.model.dto;

import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.LadderGameExecutionInfo;
import ladder.model.LadderLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameConsoleResult {

    private final List<LadderPoleInfo> ladderPoleInfos;
    private final List<LadderLine> ladderLines;

    //Q1. unmodifiableList를 생성자에서 아예 쓰고 getter에서는 deepcopy만..?
    private LadderGameConsoleResult(final List<LadderPoleInfo> ladderPoleInfos, final List<LadderLine> ladderLines) {
        this.ladderPoleInfos = Collections.unmodifiableList(ladderPoleInfos);
        this.ladderLines = Collections.unmodifiableList(ladderLines);
    }

    public static LadderGameConsoleResult newInstance(final LadderGame ladderGame) {
        return newInstance(ladderGame.getLadderGameInfo(), ladderGame.getLadder());
    }

    public static LadderGameConsoleResult newInstance(final LadderGameExecutionInfo ladderGameInfo, final Ladder ladder) {
        List<LadderPoleInfo> ladderPoleInfos = IntStream.range(0, ladderGameInfo.count())
                .mapToObj(i -> LadderPoleInfo.newInstance(ladderGameInfo.getMember(i), ladderGameInfo.getOriginLadderGameReword(i)))
                .collect(Collectors.toList());

        return new LadderGameConsoleResult(ladderPoleInfos, ladder.getLines());
    }

    public List<LadderPoleInfo> getLadderPoleInfos() {
        return new ArrayList<>(ladderPoleInfos);
    }

    public List<LadderLine> getLadderLines() {
        return new ArrayList<>(ladderLines);
    }
}