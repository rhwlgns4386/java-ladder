package finalRefactor.controller;


import finalRefactor.domain.*;
import finalRefactor.view.InputView;
import finalRefactor.view.ResultView;

public class LadderGame {
    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    public void start() {
        String participants = inputView.inputParticipant();
        Persons persons = new Persons(participants);
        ExecutionResults executionResults = new ExecutionResults(inputView.inputExecutionResult());
        int height = inputView.inputHeight();

        resultView.printPerson(persons);
        Ladder lines = new Ladder(new Height(height), persons.personList().size());
        resultView.printLadder(lines);
        resultView.executionResultLine(executionResults);
        
        while (true) {
            String resultName = inputView.inputPerson();
            int personIndex = persons.getPersonIndex(new Person(resultName));
            checkInputAll(persons, executionResults.getExecutionResult(lines), resultName);
            resultView.printExecutionResult(executionResults.getExecutionResult(lines), personIndex);
        }
    }

    private void checkInputAll(Persons persons, ExecutionResults result, String resultName) {
        if (resultName.equals("all")) {
            resultView.printAllExecutionResult(result, persons);
            System.exit(0);
        }
    }
}
