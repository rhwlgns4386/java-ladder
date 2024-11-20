package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.dto.CommaSeparatedResult;

public class OutputView {

    private static final String EMPTY = "     ";
    private static final String LINE = "-----";
    private static final String HORIZONTAL_LINE = "|";

    public static void rendering(CommaSeparatedResult names, Ladder ladder, CommaSeparatedResult results) {
        System.out.println("실행결과");
        renderName(names);
        renderLadder(ladder);
        renderResult(results);
    }

    private static void renderName(CommaSeparatedResult commaSeparatedResult) {
        for (String name : commaSeparatedResult.getValuesByString()) {
            System.out.printf(" ".repeat(6 - name.length()) + name);
        }
        System.out.println();
    }

    private static void renderLadder(Ladder ladder) {
        for (Lines lines : ladder.getLines()) {
            System.out.print(EMPTY);
            System.out.print(HORIZONTAL_LINE);
            renderLine(lines);
            System.out.println();
        }
    }

    private static void renderResult(CommaSeparatedResult commaSeparatedResult) {
        for (String result : commaSeparatedResult.getValuesByString()) {
            System.out.printf(" " + result + " ".repeat(5 - result.length()));
        }
        System.out.println();
    }

    private static void renderLine(Lines lines) {
        for (Boolean point : lines.getLines()) {
            System.out.print(pointFormat(point));
            System.out.print(HORIZONTAL_LINE);
        }
    }

    private static String pointFormat(Boolean line) {
        if (line) {
            return LINE;
        }
        return EMPTY;
    }
}
