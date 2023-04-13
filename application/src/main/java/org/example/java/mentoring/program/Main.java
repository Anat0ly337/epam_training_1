package org.example.java.mentoring.program;

import java.time.LocalDate;
import java.util.Optional;

import com.epam.bank.api.Bank;
import com.epam.jmp.bank.impl.BankImpl;
import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.BankCardType;
import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.User;
import com.epam.service.api.Service;
import com.epam.service.api.impl.ServiceImpl;

public class Main {
    public static void main(String[] args) {

        User user = new User("Joe", "Biden", LocalDate.of(1970,1,1));
        User user1 = new User("Barak", "Obama", LocalDate.of(1990,1,1));

        Bank bank = new BankImpl();
        Service service = new ServiceImpl();

        BankCard bankCard = bank.createBankCard(user, BankCardType.CREDIT);
        BankCard bankCard2 = bank.createBankCard(user, BankCardType.DEBIT);

        service.subscribe(bankCard);

        Optional<Subscription> subscription =  service.getSubscriptionByCardNumber(bankCard.getNumber());

        subscription.ifPresent(System.out::println);

        double averageAge = service.getAverageUsersAge();
        System.out.println("average age is " + averageAge);

        boolean isPayable = service.isPayableUser(user);
        System.out.println("user is payable " + isPayable);
    }
}