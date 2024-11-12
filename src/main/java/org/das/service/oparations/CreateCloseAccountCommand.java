package org.das.service.oparations;

import org.das.service.AccountService;
import org.das.utils.ConsoleOperationType;
import org.das.validate.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.UUID;
@Component
public class CreateCloseAccountCommand implements OperationCommand {
    private final UserValidation userValidation;
    private final AccountService accountService;

    @Autowired
    public CreateCloseAccountCommand(UserValidation userValidation, AccountService accountService) {
        this.userValidation = userValidation;
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account ID to close: ");
        String accountId = scanner.nextLine();
        userValidation.userLoginCorrect(accountId);
        accountService.close(UUID.fromString(accountId));
        System.out.println("Account with ID " + accountId + " has been closed.");
    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_CLOSE;
    }
}
